package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.excepciones.CombinadoNoPuedeTransformarseException;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class MenasorTest {

	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	private Decepticon megatron = decepticonFactory.crearMegatron();
	private Decepticon bonecrusher = decepticonFactory.crearBonecrusher();
	private Decepticon frenzy = decepticonFactory.crearFrenzy();
	private List<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();
	
	private AlgoFormer menasor;
	private Celda celda;
	private Rocosa rocosa = new Rocosa();
	private Nube nube = new Nube();
	
	@Before
	public void setUp(){
		decepticons.add(megatron);
		decepticons.add(bonecrusher);
		decepticons.add(frenzy);
		menasor = decepticonFactory.crearCombinado(decepticons);
		celda = new Celda(new Rocosa(), new Nube());
	}
	
	@After
	public void tearDown(){
		decepticons.clear();
	}
	
	@Test(expected=CombinadoNoPuedeTransformarseException.class)
	public void testSuperionNoPuedeTransformarseYLanzaExcepcion(){
		menasor.transformarse();
	}
	
	@Test
	public void testEntrarACeldaReduceLaCantidadDeMovimientosRestantes(){
		int movimientosRestantesAntes = menasor.getMovimientosRestantes();
		menasor.entrarACelda(celda);
		assertTrue(movimientosRestantesAntes > menasor.getMovimientosRestantes());
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void testNoSePuedeMoverMasQueLaCantidadDeCeldasIndicadasPorLaVelocidad(){
		for (int i = 0 ; i < menasor.getVelocidad() + 1 ; i++)
			menasor.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testAutoBotSePuedeMoverLaCantidadDeCasillerosIndicadaPorSuVelocidad(){
		for (int i = 0 ; i < menasor.getVelocidad() ; i++)
			menasor.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testReinicarMovimientosRestantesLosReinicia(){
		int movimientos = menasor.getMovimientosRestantes();
		menasor.entrarACelda(celda);
		assertTrue(movimientos > menasor.getMovimientosRestantes());
		menasor.reiniciarMovimientosRestantes();
		assertTrue(movimientos == menasor.getMovimientosRestantes());
	}
	
	@Test
	public void testDevolverIntegrantesLanzaExcepcion(){
		assertEquals(menasor.devolverIntegrantes(), decepticons);
	}
	
	@Test
	public void testVidaDeSuperionEsSumatoriaDeSusIntegrantes(){
		int vidaIntegrantes = 0;
		for (AlgoFormer algoformer : decepticons)
			vidaIntegrantes += algoformer.getVida();
		assertEquals(vidaIntegrantes, menasor.getVida());
	}
}
