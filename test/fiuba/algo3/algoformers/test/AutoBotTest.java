package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;

public class AutoBotTest {
	
	private FormaHumanoide humanoide = new FormaHumanoide(1, 2, 3);
	private FormaAlterna alterna = new FormaAerea(3, 2, 1);
	private AutoBot autobot;
	private Celda celda;
	private Rocosa rocosa = new Rocosa();
	private Nube nube = new Nube();
	
	@Before
	public void setUp(){
		autobot = new AutoBot("autobot", 10, humanoide, alterna);
		celda = new Celda(new Rocosa(), new Nube());
	}
	
	@Test
	public void testAlgoformerSePuedeTransformarEnAmbosSentidosYCambiaElComportamiento(){
		assertEquals(1, autobot.getAtaque()); //Se que el ataque es 1 porque lo declare arriba
		autobot.transformarse();
		assertEquals(3, autobot.getAtaque());
		autobot.transformarse();
		assertEquals(1, autobot.getAtaque());
	}
	
	@Test
	public void testEntrarACeldaReduceLaCantidadDeMovimientosRestantesEnModoHumanoide(){
		int movimientosRestantesAntes = autobot.getMovimientosRestantes();
		autobot.entrarACelda(celda);
		assertTrue(movimientosRestantesAntes > autobot.getMovimientosRestantes());
	}
	
	@Test
	public void testEntrarACeldaReduceLaCantidadDeMovimientosRestantesEnModoAlterno(){
		autobot.transformarse();
		int movimientosRestantesAntes = autobot.getMovimientosRestantes();
		autobot.entrarACelda(celda);
		assertTrue(movimientosRestantesAntes > autobot.getMovimientosRestantes());
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void testNoSePuedeMoverMasQueLaCantidadDeCeldasIndicadasPorLaVelocidadEnModoHumanoide(){
		for (int i = 0 ; i < autobot.getVelocidad() + 1 ; i++)
			autobot.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void testNoSePuedeMoverMasQueLaCantidadDeCeldasIndicadasPorLaVelocidadEnModoAlterno(){
		autobot.transformarse();
		for (int i = 0 ; i < autobot.getVelocidad() + 1 ; i++)
			autobot.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testAutoBotSePuedeMoverLaCantidadDeCasillerosIndicadaPorSuVelocidadEnModoHumanoide(){
		for (int i = 0 ; i < autobot.getVelocidad() ; i++)
			autobot.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testAutoBotSePuedeMoverLaCantidadDeCasillerosIndicadaPorSuVelocidadEnModoAlterno(){
		autobot.transformarse();
		for (int i = 0 ; i < autobot.getVelocidad() ; i++)
			autobot.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testReinicarMovimientosRestantesLosReiniciaEnModoHumanoide(){
		int movimientos = autobot.getMovimientosRestantes();
		autobot.entrarACelda(celda);
		assertTrue(movimientos > autobot.getMovimientosRestantes());
		autobot.reiniciarMovimientosRestantes();
		assertTrue(movimientos == autobot.getMovimientosRestantes());
	}
	
	@Test
	public void testReinicarMovimientosRestantesLosReiniciaEnModoAlterno(){
		autobot.transformarse();
		int movimientos = autobot.getMovimientosRestantes();
		autobot.entrarACelda(celda);
		assertTrue(movimientos > autobot.getMovimientosRestantes());
		autobot.reiniciarMovimientosRestantes();
		assertTrue(movimientos == autobot.getMovimientosRestantes());
	}
}