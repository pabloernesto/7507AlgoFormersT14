package fiuba.algo3.algoformers.test;

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

public class AtravesarPantanoEnModoHumanoideNoSePuedeTest {

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
	public void test01OptimusNoPuedeAtravesarPantanoEnModoHumanoide(){
		optimus = autobotFactory.crearOptimusPrime();celda = new Celda(pantano, nubes);
		assertTrue(optimus.getMovimientosRestantes() > 0);
		optimus.entrarACelda(celda);
		optimus.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test02BumblebeeNoPuedeAtravesarPantanoEnModoHumanoide(){
		bumblebee = autobotFactory.crearBumblebee();
		assertTrue(bumblebee.getMovimientosRestantes() > 0);
		bumblebee.entrarACelda(celda);
		bumblebee.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test03RatchetNoPuedeAtravesarPantanoEnModoHumanoide(){
		ratchet = autobotFactory.crearRatchet();
		assertTrue(ratchet.getMovimientosRestantes() > 0);
		ratchet.entrarACelda(celda);
		ratchet.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test04MegatronNoPuedeAtravesarPantanoEnModoHumanoide(){
		megatron = decepticonFactory.crearMegatron();
		assertTrue(megatron.getMovimientosRestantes() > 0);
		megatron.entrarACelda(celda);
		megatron.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test05BonecrusherNoPuedeAtravesarPantanoEnModoHumanoide(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		assertTrue(bonecrusher.getMovimientosRestantes() > 0);
		bonecrusher.entrarACelda(celda);
		bonecrusher.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test06FrenzyNoPuedeAtravesarPantanoEnModoHumanoide(){
		frenzy = decepticonFactory.crearFrenzy();
		assertTrue(frenzy.getMovimientosRestantes() > 0);
		frenzy.entrarACelda(celda);
		frenzy.entrarACelda(otraCelda);
	}
}