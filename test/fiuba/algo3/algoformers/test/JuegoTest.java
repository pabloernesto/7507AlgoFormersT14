package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
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
        juego.crearJugadores("Nombre1", "Nombre2");
    }
    
    @After
    public void tearDown()
    {
        Tablero.reiniciarTablero();
    }
    
    @Test
    public void testAlgoFormersEnemigosComienzanEnfrentadosEnEltablero(){
		juego.inicializar();
		Tablero tablero = Tablero.getInstance();
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
        juego.inicializar();
        Tablero tablero = Tablero.getInstance();
        
        Jugador jugador = juego.jugadorActual();
        List<AlgoFormer> equipo = jugador.getListaAlgoformers();
        
        assertEquals(1,
            tablero.distancia(equipo.get(0), equipo.get(1)));
        
        assertEquals(1,
        	tablero.distancia(equipo.get(1), equipo.get(2)));
        
        assertEquals(2,
            tablero.distancia(equipo.get(0), equipo.get(2)));
    }
	
	@Test
	public void testJuegoTerminaSiSeCapturaLaChispa(){
		juego.inicializarSinAleatoridad();
		assertFalse(juego.hayGanador());
		Jugador jugador = juego.jugadorActual();
		AlgoFormer algoformer = jugador.getListaAlgoformers().get(0);
		Tablero tablero = Tablero.getInstance();
		Posicion posicionAlgoformer = tablero.getPosicionAlgoformer(algoformer);
		Posicion posicionChispa = posicionAlgoformer.sumarMovimiento(Movimiento.DERECHA);
		tablero.colocarChispaSuprema(posicionChispa);
		algoformer.moverse(Movimiento.DERECHA);
		assertTrue(juego.hayGanador());
	}
	
	@Test
	public void testJuegoTerminaSiSeEliminaUnEquipo(){
		juego.inicializar();
		assertFalse(juego.hayGanador());
		Jugador jugador = juego.jugadorActual();
		for (AlgoFormer algoformer : jugador.getListaAlgoformers())
			algoformer.setVida(0);
		juego.limpiarMuertos();
		juego.chequearGanadorPorMuertes();
		assertTrue(juego.hayGanador());
	}
	
	@Test
	public void testLimpiarMuertosBorraALosAlgoformersMuertos(){
		juego.inicializar();
		Jugador jugador = juego.jugadorActual();
		int vivos = jugador.getListaAlgoformers().size();
		jugador.getListaAlgoformers().get(0).setVida(0);
		juego.limpiarMuertos();
		assertEquals(vivos - 1, jugador.getListaAlgoformers().size());
	}
}