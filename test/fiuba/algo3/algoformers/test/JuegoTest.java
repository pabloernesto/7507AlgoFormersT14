package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;

import java.util.List;

public class JuegoTest
{
    Juego juego;
    Tablero tablero;
    
    @Before
    public void setUp()
    {
        juego = new Juego();
        tablero = Tablero.getInstance();
    }
    
    @After
    public void tearDown()
    {
        Tablero.reiniciarTablero();
    }
    
    @Test
    public void testAlgoFormersEnemigosComienzanEnfrentadosEnEltablero(){
    	juego.crearJugadores("Nombre1", "Nombre2");
		juego.inicializar();
		Jugador jugador1 = juego.jugadorActual();
		List<AlgoFormer> equipo1 = jugador1.getListaAlgoformers();
		AlgoFormer algoformer1 = equipo1.get(0);
		
		Jugador jugador2 = juego.jugadorInactivo();
		List<AlgoFormer> equipo2 = jugador2.getListaAlgoformers();
		AlgoFormer algoformer2 = equipo2.get(0);
		
		int alturaMedia = tablero.altura() / 2;
		int ancho = tablero.ancho();
		
		assertTrue(new Posicion(1, alturaMedia).equals(tablero.getPosicionAlgoformer(algoformer1)));
		
		assertTrue(new Posicion(ancho, alturaMedia).equals(tablero.getPosicionAlgoformer(algoformer2)));
		
		assertEquals(39, tablero.distancia(algoformer1, algoformer2));
	}
    
	@Test
    public void testAlgoFormersDeUnEquipoComienzanJuntos()
    {
		juego.crearJugadores("Nombre1", "Nombre2");
        juego.inicializar();
        
        Jugador jugador = juego.jugadorActual();
        List<AlgoFormer> equipo = jugador.getListaAlgoformers();
        
        assertEquals(1,
            tablero.distancia(equipo.get(0), equipo.get(1)));
        
        assertEquals(1,
        	tablero.distancia(equipo.get(1), equipo.get(2)));
        
        assertEquals(2,
            tablero.distancia(equipo.get(0), equipo.get(2)));
    }	
}