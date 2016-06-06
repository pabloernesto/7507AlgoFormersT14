package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

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
    
	@Test
    public void testAlgoFormersDeUnEquipoComienzanJuntos()
    {
        juego.inicializar();
        
        Jugador jugador = juego.jugadorActual();
        List<AlgoFormer> equipo = jugador.getListaAlgoformers();
        
        assertEquals(1,
            tablero.distanciaEntreAlgoformers(
                equipo.get(0),
                equipo.get(1)
            )
        );
        
        assertEquals(1,
            tablero.distanciaEntreAlgoformers(
                equipo.get(0),
                equipo.get(1)
            )
        );
    }
}

