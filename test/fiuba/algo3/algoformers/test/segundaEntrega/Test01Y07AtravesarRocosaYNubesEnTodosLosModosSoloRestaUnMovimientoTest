package fiuba.algo3.algoformers.test.segundaEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

public class Test01Y07AtravesarRocosaYNubesEnTodosLosModosSoloRestaUnMovimientoTest {

	private Celda celda;
	private Celda otraCelda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer optimus;
	private AlgoFormer optimus2;
	private AlgoFormer ratchet;
	private AlgoFormer ratchet2;
	private AlgoFormer bumblebee;
	private AlgoFormer bumblebee2;

	private AlgoFormer megatron;
	private AlgoFormer megatron2;
	private AlgoFormer bonecrusher;
	private AlgoFormer bonecrusher2;
	private AlgoFormer frenzy;
	private AlgoFormer frenzy2;
	
	private SuperficieTerrestre rocosa = new Rocosa();
	private SuperficieAerea nubes = new Nube();


	@Before
	public void setUp(){
		celda = new Celda(rocosa, nubes);
		otraCelda = new Celda(rocosa, nubes);
	}
	
	@Test
	public void test01OptimusAtravesarRocosaEnModoHumanoideSoloRestaUnMovimiento(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus2 = autobotFactory.crearOptimusPrime();
		
		optimus.entrarACelda(celda);
		assertTrue(optimus.atributosSonIguales(optimus2));
		assertEquals(optimus2.getMovimientosRestantes() - 1, optimus.getMovimientosRestantes());
	}
	
	@Test
	public void test02OptimusAtravesarRocosaEnModoTerrestreSoloRestaUnMovimiento(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		optimus2 = autobotFactory.crearOptimusPrime();
		optimus2.transformarse();
		
		optimus.entrarACelda(celda);
		assertTrue(optimus.atributosSonIguales(optimus2));
		assertEquals(optimus2.getMovimientosRestantes() - 1, optimus.getMovimientosRestantes());
	}
	
	@Test
	public void test03BumblebeeAtravesarRocosaEnModoHumanoideSoloRestaUnMovimiento(){
		bumblebee = autobotFactory.crearBumblebee();
		bumblebee2 = autobotFactory.crearBumblebee();
		
		bumblebee.entrarACelda(celda);
		assertTrue(bumblebee.atributosSonIguales(bumblebee2));
		assertEquals(bumblebee2.getMovimientosRestantes() - 1, bumblebee.getMovimientosRestantes());
	}
	
	@Test
	public void test04BumblebeeAtravesarRocosaEnModoTerrestreSoloRestaUnMovimiento(){
		bumblebee = autobotFactory.crearBumblebee();
		bumblebee.transformarse();
		bumblebee2 = autobotFactory.crearBumblebee();
		bumblebee2.transformarse();
		
		bumblebee.entrarACelda(celda);
		assertTrue(bumblebee.atributosSonIguales(bumblebee2));
		assertEquals(bumblebee2.getMovimientosRestantes() - 1, bumblebee.getMovimientosRestantes());
	}
	
	@Test
	public void test05RatchetAtravesarRocosaEnModoHumanoideSoloRestaUnMovimiento(){
		ratchet = autobotFactory.crearRatchet();
		ratchet2 = autobotFactory.crearRatchet();
		
		ratchet.entrarACelda(celda);
		assertTrue(ratchet.atributosSonIguales(ratchet2));
		assertEquals(ratchet2.getMovimientosRestantes() -1, ratchet.getMovimientosRestantes());
	}
	
	@Test
	public void test06RatchetAtravesarRocosaEnModoAereoSoloRestaUnMovimiento(){
		ratchet = autobotFactory.crearRatchet();
		ratchet.transformarse();
		ratchet2 = autobotFactory.crearRatchet();
		ratchet2.transformarse();
		
		ratchet.entrarACelda(celda);
		assertTrue(ratchet.atributosSonIguales(ratchet2));
		assertEquals(ratchet2.getMovimientosRestantes() -1, ratchet.getMovimientosRestantes());
		ratchet.entrarACelda(otraCelda);
	}
	
	@Test
	public void test07MegatronAtravesarRocosaEnModoHumanoideSoloRestaUnMovimiento(){
		megatron = decepticonFactory.crearMegatron();
		megatron2 = decepticonFactory.crearMegatron();
		
		megatron.entrarACelda(celda);
		assertTrue(megatron.atributosSonIguales(megatron2));
		assertEquals(megatron2.getMovimientosRestantes() - 1, megatron.getMovimientosRestantes());
	}
	
	@Test
	public void test08MegatronAtravesarRocosaEnModoAereoSoloRestaUnMovimiento(){
		megatron = decepticonFactory.crearMegatron();
		megatron.transformarse();
		megatron2 = decepticonFactory.crearMegatron();
		megatron2.transformarse();
		
		megatron.entrarACelda(celda);
		assertTrue(megatron.atributosSonIguales(megatron2));
		assertEquals(megatron2.getMovimientosRestantes() - 1, megatron.getMovimientosRestantes());
	}
	
	@Test
	public void test09BonecrusherAtravesarRocosaEnModoHumanoideSoloRestaUnMovimiento(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		bonecrusher2 = decepticonFactory.crearBonecrusher();
		
		bonecrusher.entrarACelda(celda);
		assertTrue(bonecrusher.atributosSonIguales(bonecrusher2));
		assertEquals(bonecrusher2.getMovimientosRestantes() - 1, bonecrusher.getMovimientosRestantes());
	}
	
	@Test
	public void test10BonecrusherAtravesarRocosaEnModoTerrestreSoloRestaUnMovimiento(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		bonecrusher.transformarse();
		bonecrusher2 = decepticonFactory.crearBonecrusher();
		bonecrusher2.transformarse();
		
		bonecrusher.entrarACelda(celda);
		assertTrue(bonecrusher.atributosSonIguales(bonecrusher2));
		assertEquals(bonecrusher2.getMovimientosRestantes() - 1, bonecrusher.getMovimientosRestantes());
	}
	
	@Test
	public void test11FrenzyAtravesarRocosaEnModoHumanoideSoloRestaUnMovimiento(){
		frenzy = decepticonFactory.crearFrenzy();
		frenzy2 = decepticonFactory.crearFrenzy();
		
		frenzy.entrarACelda(celda);
		assertTrue(frenzy.atributosSonIguales(frenzy2));
		assertEquals(frenzy2.getMovimientosRestantes() - 1, frenzy.getMovimientosRestantes());
	}
	
	@Test
	public void test12FrenzyAtravesarRocosaEnModoTerrestreSoloRestaUnMovimiento(){
		frenzy = decepticonFactory.crearFrenzy();
		frenzy.transformarse();
		frenzy2 = decepticonFactory.crearFrenzy();
		frenzy2.transformarse();
		
		frenzy.entrarACelda(celda);
		assertTrue(frenzy.atributosSonIguales(frenzy2));
		assertEquals(frenzy2.getMovimientosRestantes() - 1, frenzy.getMovimientosRestantes());
	}
}
