package fiuba.algo3.algoformers.test.segundaEntrega;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Pantano;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieAerea;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieTerrestre;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class Test02AtravesarPantanoEnModoHumanoideNoSePuedeTest {

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
	private SuperficieTerrestre pantano = new Pantano();
	
	@Before
	public void setUp(){
		celda = new Celda(pantano, nubes);
		otraCelda = new Celda(rocosa, nubes);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test01OptimusNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		optimus = autobotFactory.crearOptimusPrime();
		assertTrue(optimus.getMovimientosRestantes() > 0);
		optimus.entrarACelda(celda);
		assertTrue(optimus.getMovimientosRestantes() == 0);
		optimus.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test02BumblebeeNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		bumblebee = autobotFactory.crearBumblebee();
		assertTrue(bumblebee.getMovimientosRestantes() > 0);
		bumblebee.entrarACelda(celda);
		assertTrue(bumblebee.getMovimientosRestantes() == 0);
		bumblebee.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test03RatchetNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		ratchet = autobotFactory.crearRatchet();
		assertTrue(ratchet.getMovimientosRestantes() > 0);
		ratchet.entrarACelda(celda);
		assertTrue(ratchet.getMovimientosRestantes() == 0);
		ratchet.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test04MegatronNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		megatron = decepticonFactory.crearMegatron();
		assertTrue(megatron.getMovimientosRestantes() > 0);
		megatron.entrarACelda(celda);
		assertTrue(megatron.getMovimientosRestantes() == 0);
		megatron.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test05BonecrusherNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		assertTrue(bonecrusher.getMovimientosRestantes() > 0);
		bonecrusher.entrarACelda(celda);
		assertTrue(bonecrusher.getMovimientosRestantes() == 0);
		bonecrusher.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test06FrenzyNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		frenzy = decepticonFactory.crearFrenzy();
		assertTrue(frenzy.getMovimientosRestantes() > 0);
		frenzy.entrarACelda(celda);
		assertTrue(frenzy.getMovimientosRestantes() == 0);
		frenzy.entrarACelda(otraCelda);
	}
}
