package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Espinas;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieAerea;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieTerrestre;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class AtravesarEspinasEnModoHumanoideYTerrestresRestaVidaTest {

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
	
	
	private SuperficieAerea nubes = new Nube();
	private SuperficieTerrestre espinas = new Espinas();
	
	@Before
	public void setUp(){
		celda = new Celda(espinas, nubes);
		otraCelda = new Celda(espinas, nubes);
	}
	
	@Test
	public void test01OptimusAtravesarEspinasEnModoHumaoideYTerrestreRestaVida(){
		optimus = autobotFactory.crearOptimusPrime();
		int vida = optimus.getVida();
		optimus.entrarACelda(celda);
		int nuevaVida = optimus.getVida();
		assertEquals(nuevaVida, vida  * 95 / 100);
		optimus.transformarse();
		optimus.entrarACelda(otraCelda);
		assertEquals(optimus.getVida(), nuevaVida * 95 / 100);
	}

	@Test
	public void test02BumblebeeAtravesarEspinasEnModoHumanoideYTerrestreRestaVida(){
		bumblebee = autobotFactory.crearBumblebee();
		int vida = bumblebee.getVida();
		bumblebee.entrarACelda(celda);
		int nuevaVida = bumblebee.getVida();
		assertEquals(nuevaVida, vida  * 95 / 100);
		bumblebee.transformarse();
		bumblebee.entrarACelda(otraCelda);
		assertEquals(bumblebee.getVida(), nuevaVida * 95 / 100);
	}
	
	@Test
	public void test03BonecrusherAtravesarEspinasEnModoHumanoideYTerrestreRestaVida(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		int vida = bonecrusher.getVida();
		bonecrusher.entrarACelda(celda);
		int nuevaVida = bonecrusher.getVida();
		assertEquals(nuevaVida, vida * 95 / 100 );
		bonecrusher.transformarse();
		bonecrusher.entrarACelda(otraCelda);
		assertEquals(bonecrusher.getVida(), nuevaVida * 95 / 100);
	}
	
	@Test
	public void test04FrenzyAtravesarEspinasEnModoHumanoideYTerrestreRestaVida(){
		frenzy = decepticonFactory.crearFrenzy();
		int vida = frenzy.getVida();
		frenzy.entrarACelda(celda);
		int nuevaVida = frenzy.getVida();
		assertEquals(nuevaVida, vida  * 95 / 100);
		frenzy.transformarse();
		frenzy.entrarACelda(otraCelda);
		assertEquals(frenzy.getVida(), nuevaVida * 95 / 100);
	}
	
	@Test
	public void test05RatchetAtravesarEspinasEnModoHumanoideRestaVida(){
		ratchet = autobotFactory.crearRatchet();
		int vida = ratchet.getVida();
		ratchet.entrarACelda(celda);
		int nuevaVida = ratchet.getVida();
		assertEquals(nuevaVida, vida * 95 / 100);
		ratchet.reiniciarMovimientosRestantes();
		ratchet.entrarACelda(otraCelda);
		assertEquals(ratchet.getVida(), nuevaVida * 95 / 100);
	}
	
	@Test
	public void test06MegatronAtravesarEspinasEnModoHumanoideRestaVida(){
		megatron = decepticonFactory.crearMegatron();
		int vida = megatron.getVida();
		megatron.entrarACelda(celda);
		int nuevaVida = megatron.getVida();
		assertEquals(nuevaVida, vida * 95 / 100);
		megatron.reiniciarMovimientosRestantes();
		megatron.entrarACelda(otraCelda);
		assertEquals(megatron.getVida(), nuevaVida * 95 / 100);
	}
}