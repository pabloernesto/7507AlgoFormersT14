package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;
import fiuba.algo3.algoformers.factories.BonusNuloFactory;

public class ControlDeTurnosTest
{
	Juego juego = new Juego();
	
	@Before
	public void setUp()
	{
		Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
		Tablero.setGeneradorDeBonus(new BonusNuloFactory());
		juego.inicializar();
	}
	
	@After
	public void tearDown(){
		Tablero.reiniciarTablero();
	}
	
	@Test
	public void testMoverJugadorActualNoCausaExcepcion()
	{
	    AlgoFormer algoformer = juego.jugadorActual().getListaAlgoformers().get(0);
	    juego.jugadorActual().elegirAlgoFormer(algoformer.getNombre());
	    
	    juego.jugadorActual().mover(Movimiento.DERECHA);
	}

	@Test(expected = RuntimeException.class)
	public void testMoverJugadorInactivoCausaExcepcion()
	{
	    AlgoFormer algoformer = juego.jugadorInactivo().getListaAlgoformers().get(0);
	    juego.jugadorInactivo().elegirAlgoFormer(algoformer.getNombre());
	    
	    juego.jugadorInactivo().mover(Movimiento.IZQUIERDA);
	}

	@Test
	public void testTerminarTurnoCambiaJugadorActual()
	{
	    Jugador jugadorInicial = juego.jugadorActual();
	    
	    jugadorInicial.terminarTurno();
	    Jugador jugadorFinal = juego.jugadorActual();
	    
	    assertNotSame(jugadorInicial, jugadorFinal);
	}
}

