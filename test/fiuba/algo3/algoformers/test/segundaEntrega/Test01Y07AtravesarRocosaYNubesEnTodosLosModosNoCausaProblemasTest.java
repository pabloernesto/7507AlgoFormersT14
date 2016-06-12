package fiuba.algo3.algoformers.test.segundaEntrega;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieAerea;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieTerrestre;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class Test01Y07AtravesarRocosaYNubesEnTodosLosModosNoCausaProblemasTest {

	private Celda celda;
	private Celda otraCelda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer optimus;
	private AlgoFormer ratchet;
	private AlgoFormer bumblebee;

	private AlgoFormer megatron;
	private AlgoFormer bonecrusher;
	private AlgoFormer frenzy;
	
	private SuperficieTerrestre rocosa = new Rocosa();
	private SuperficieAerea nubes = new Nube();


	@Before
	public void setUp(){
		celda = new Celda(rocosa, nubes);
		otraCelda = new Celda(rocosa, nubes);
	}
	
	@Test
	public void test01OptimusAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		optimus = autobotFactory.crearOptimusPrime();
		AlgoFormer optimus2 = autobotFactory.crearOptimusPrime();
		int movimientos = optimus.getMovimientosRestantes();
		optimus.entrarACelda(celda);
		assertTrue(optimus.atributosSonIguales(optimus2));
		assertEquals(movimientos - 1, optimus.getMovimientosRestantes());
	}
	
	@Test
	public void test02OptimusAtravesarRocosaEnModoTerrestreNoCausaProblemas(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		AlgoFormer optimus2 = autobotFactory.crearOptimusPrime();
		optimus2.transformarse();
		int movimientos = optimus.getMovimientosRestantes();
		optimus.entrarACelda(celda);
		assertTrue(optimus.atributosSonIguales(optimus2));
		assertEquals(movimientos - 1, optimus.getMovimientosRestantes());
	}
	
	@Test
	public void test03BumblebeeAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		bumblebee = autobotFactory.crearBumblebee();
		AlgoFormer bumblebee2 = autobotFactory.crearBumblebee();
		int movimientos = bumblebee.getMovimientosRestantes();
		bumblebee.entrarACelda(celda);
		assertTrue(bumblebee.atributosSonIguales(bumblebee2));
		assertEquals(movimientos - 1, bumblebee.getMovimientosRestantes());
	}
	
	@Test
	public void test04BumblebeeAtravesarRocosaEnModoTerrestreNoCausaProblemas(){
		bumblebee = autobotFactory.crearBumblebee();
		bumblebee.transformarse();
		AlgoFormer bumblebee2 = autobotFactory.crearBumblebee();
		bumblebee2.transformarse();
		int movimientos = bumblebee.getMovimientosRestantes();
		bumblebee.entrarACelda(celda);
		assertTrue(bumblebee.atributosSonIguales(bumblebee2));
		assertEquals(movimientos - 1, bumblebee.getMovimientosRestantes());
	}
	
	@Test
	public void test05RatchetAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		ratchet = autobotFactory.crearRatchet();
		AlgoFormer ratchet2 = autobotFactory.crearRatchet();
		int movimientos = ratchet.getMovimientosRestantes();
		assertEquals(1, movimientos);
		ratchet.entrarACelda(celda);
		assertTrue(ratchet.atributosSonIguales(ratchet2));
		assertEquals(movimientos - 1, ratchet.getMovimientosRestantes());
	}
	
	@Test
	public void test06RatchetAtravesarRocosaEnModoAereoNoCausaProblemas(){
		ratchet = autobotFactory.crearRatchet();
		ratchet.transformarse();
		AlgoFormer ratchet2 = autobotFactory.crearRatchet();
		ratchet2.transformarse();
		int movimientos = ratchet.getMovimientosRestantes();
		ratchet.entrarACelda(celda);
		assertTrue(ratchet.atributosSonIguales(ratchet2));
		assertEquals(movimientos - 1, ratchet.getMovimientosRestantes());
		ratchet.entrarACelda(otraCelda);
	}
	
	@Test
	public void test07MegatronAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		megatron = decepticonFactory.crearMegatron();
		AlgoFormer megatron2 = decepticonFactory.crearMegatron();
		int movimientos = megatron.getMovimientosRestantes();
		assertEquals(1, movimientos);
		megatron.entrarACelda(celda);
		assertTrue(megatron.atributosSonIguales(megatron2));
		assertEquals(movimientos - 1, megatron.getMovimientosRestantes());
	}
	
	@Test
	public void test08MegatronAtravesarRocosaEnModoAereoNoCausaProblemas(){
		megatron = decepticonFactory.crearMegatron();
		megatron.transformarse();
		AlgoFormer megatron2 = decepticonFactory.crearMegatron();
		megatron2.transformarse();
		int movimientos = megatron.getMovimientosRestantes();
		megatron.entrarACelda(celda);
		assertTrue(megatron.atributosSonIguales(megatron2));
		assertEquals(movimientos - 1, megatron.getMovimientosRestantes());
	}
	
	@Test
	public void test09BonecrusherAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		AlgoFormer bonecrusher2 = decepticonFactory.crearBonecrusher();
		int movimientos = bonecrusher.getMovimientosRestantes();
		assertEquals(1, movimientos);
		bonecrusher.entrarACelda(celda);
		assertTrue(bonecrusher.atributosSonIguales(bonecrusher2));
		assertEquals(movimientos - 1, bonecrusher.getMovimientosRestantes());
	}
	
	@Test
	public void test10BonecrusherAtravesarRocosaEnModoTerrestreNoCausaProblemas(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		bonecrusher.transformarse();
		AlgoFormer bonecrusher2 = decepticonFactory.crearBonecrusher();
		bonecrusher2.transformarse();
		int movimientos = bonecrusher.getMovimientosRestantes();
		bonecrusher.entrarACelda(celda);
		assertTrue(bonecrusher.atributosSonIguales(bonecrusher2));
		assertEquals(movimientos - 1, bonecrusher.getMovimientosRestantes());
	}
	
	@Test
	public void test11FrenzyAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		frenzy = decepticonFactory.crearFrenzy();
		AlgoFormer frenzy2 = decepticonFactory.crearFrenzy();
		int movimientos = frenzy.getMovimientosRestantes();
		frenzy.entrarACelda(celda);
		assertTrue(frenzy.atributosSonIguales(frenzy2));
		assertEquals(movimientos - 1, frenzy.getMovimientosRestantes());
	}
	
	@Test
	public void test12FrenzyAtravesarRocosaEnModoTerrestreNoCausaProblemas(){
		frenzy = decepticonFactory.crearFrenzy();
		frenzy.transformarse();
		AlgoFormer frenzy2 = decepticonFactory.crearFrenzy();
		frenzy2.transformarse();
		int movimientos = frenzy.getMovimientosRestantes();
		frenzy.entrarACelda(celda);
		assertTrue(frenzy.atributosSonIguales(frenzy2));
		assertEquals(movimientos - 1, frenzy.getMovimientosRestantes());
	}
}