package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.excepciones.CombinadoNoPuedeTransformarseException;
import fiuba.algo3.algoformers.factories.AutoBotFactory;

public class SuperionTest {

	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private AutoBot optimus = autobotFactory.crearOptimusPrime();
	private AutoBot bumblebee = autobotFactory.crearBumblebee();
	private AutoBot ratchet = autobotFactory.crearRatchet();
	private List<AlgoFormer> autobots = new ArrayList<AlgoFormer>();
	
	private AlgoFormer superion;
	private Celda celda;
	private Rocosa rocosa = new Rocosa();
	private Nube nube = new Nube();
	
	@Before
	public void setUp(){
		autobots.add(optimus);
		autobots.add(bumblebee);
		autobots.add(ratchet);
		superion = autobotFactory.crearCombinado(autobots);
		celda = new Celda(new Rocosa(), new Nube());
	}
	
	@After
	public void tearDown(){
		autobots.clear();
	}
	
	@Test(expected=CombinadoNoPuedeTransformarseException.class)
	public void testSuperionNoPuedeTransformarseYLanzaExcepcion(){
		superion.transformarse();
	}
	
	@Test
	public void testEntrarACeldaReduceLaCantidadDeMovimientosRestantes(){
		int movimientosRestantesAntes = superion.getMovimientosRestantes();
		superion.entrarACelda(celda);
		assertTrue(movimientosRestantesAntes > superion.getMovimientosRestantes());
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void testNoSePuedeMoverMasQueLaCantidadDeCeldasIndicadasPorLaVelocidad(){
		for (int i = 0 ; i < superion.getVelocidad() + 1 ; i++)
			superion.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testAutoBotSePuedeMoverLaCantidadDeCasillerosIndicadaPorSuVelocidad(){
		for (int i = 0 ; i < superion.getVelocidad() ; i++)
			superion.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testReinicarMovimientosRestantesLosReinicia(){
		int movimientos = superion.getMovimientosRestantes();
		superion.entrarACelda(celda);
		assertTrue(movimientos > superion.getMovimientosRestantes());
		superion.reiniciarMovimientosRestantes();
		assertTrue(movimientos == superion.getMovimientosRestantes());
	}
	
	@Test
	public void testDevolverIntegrantesLanzaExcepcion(){
		assertEquals(superion.devolverIntegrantes(), autobots);
	}
	
	@Test
	public void testVidaDeSuperionEsSumatoriaDeSusIntegrantes(){
		int vidaIntegrantes = 0;
		for (AlgoFormer algoformer : autobots)
			vidaIntegrantes += algoformer.getVida();
		assertEquals(vidaIntegrantes, superion.getVida());
	}
}
