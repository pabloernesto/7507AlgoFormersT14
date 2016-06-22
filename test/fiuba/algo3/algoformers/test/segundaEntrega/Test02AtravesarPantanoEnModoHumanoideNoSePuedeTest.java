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
	public void test01AOptimusNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		optimus = autobotFactory.crearOptimusPrime();
		assertTrue(optimus.getMovimientosRestantes() > 0);
		optimus.entrarACelda(celda);
		assertTrue(optimus.getMovimientosRestantes() == 0);
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		assertTrue(optimus.getMovimientosRestantes() == 0);
		optimus.entrarACelda(otraCelda);
	}
	
	@Test
	public void test01BOptimusPuedeAtravesarPantanoSiSeTransforma(){
		optimus = autobotFactory.crearOptimusPrime();
		assertTrue(optimus.getMovimientosRestantes() > 0);
		optimus.entrarACelda(celda);
		assertTrue(optimus.getMovimientosRestantes() == 0);
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		optimus.transformarse();
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		assertTrue(optimus.getMovimientosRestantes() > 0);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test02ABumblebeeNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		bumblebee = autobotFactory.crearBumblebee();
		assertTrue(bumblebee.getMovimientosRestantes() > 0);
		bumblebee.entrarACelda(celda);
		assertTrue(bumblebee.getMovimientosRestantes() == 0);
		bumblebee.entrarACelda(otraCelda);
	}
	
	@Test
	public void test02BBumblebeePuedeAtravesarPantanoSiSeTransforma(){
		bumblebee = autobotFactory.crearBumblebee();
		assertTrue(bumblebee.getMovimientosRestantes() > 0);
		bumblebee.entrarACelda(celda);
		assertTrue(bumblebee.getMovimientosRestantes() == 0);
		bumblebee.finalizarTurno();
		bumblebee.iniciarTurno();
		bumblebee.transformarse();
		bumblebee.finalizarTurno();
		bumblebee.iniciarTurno();
		assertTrue(bumblebee.getMovimientosRestantes() > 0);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test03ARatchetNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		ratchet = autobotFactory.crearRatchet();
		assertTrue(ratchet.getMovimientosRestantes() > 0);
		ratchet.entrarACelda(celda);
		assertTrue(ratchet.getMovimientosRestantes() == 0);
		ratchet.entrarACelda(otraCelda);
	}
	
	@Test
	public void test03BRatchetPuedeAtravesarPantanoSiSeTransforma(){
		ratchet = autobotFactory.crearRatchet();
		assertTrue(ratchet.getMovimientosRestantes() > 0);
		ratchet.entrarACelda(celda);
		assertTrue(ratchet.getMovimientosRestantes() == 0);
		ratchet.finalizarTurno();
		ratchet.iniciarTurno();
		ratchet.transformarse();
		ratchet.finalizarTurno();
		ratchet.iniciarTurno();
		assertTrue(ratchet.getMovimientosRestantes() > 0);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test04AMegatronNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		megatron = decepticonFactory.crearMegatron();
		assertTrue(megatron.getMovimientosRestantes() > 0);
		megatron.entrarACelda(celda);
		assertTrue(megatron.getMovimientosRestantes() == 0);
		megatron.entrarACelda(otraCelda);
	}
	
	@Test
	public void test04BMegatronPuedeAtravesarPantanoSiSeTransforma(){
		megatron = decepticonFactory.crearMegatron();
		assertTrue(megatron.getMovimientosRestantes() > 0);
		megatron.entrarACelda(celda);
		assertTrue(megatron.getMovimientosRestantes() == 0);
		megatron.finalizarTurno();
		megatron.iniciarTurno();
		megatron.transformarse();
		megatron.finalizarTurno();
		megatron.iniciarTurno();
		assertTrue(megatron.getMovimientosRestantes() > 0);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test05ABonecrusherNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		assertTrue(bonecrusher.getMovimientosRestantes() > 0);
		bonecrusher.entrarACelda(celda);
		assertTrue(bonecrusher.getMovimientosRestantes() == 0);
		bonecrusher.entrarACelda(otraCelda);
	}
	
	@Test
	public void test05BBonecrusherPuedeAtravesarPantanoSiSeTransforma(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		assertTrue(bonecrusher.getMovimientosRestantes() > 0);
		bonecrusher.entrarACelda(celda);
		assertTrue(bonecrusher.getMovimientosRestantes() == 0);
		bonecrusher.finalizarTurno();
		bonecrusher.iniciarTurno();
		bonecrusher.transformarse();
		bonecrusher.finalizarTurno();
		bonecrusher.iniciarTurno();
		assertTrue(bonecrusher.getMovimientosRestantes() > 0);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test06AFrenzyNoPuedeAtravesarPantanoEnModoHumanoideLanzaExcepcion(){
		frenzy = decepticonFactory.crearFrenzy();
		assertTrue(frenzy.getMovimientosRestantes() > 0);
		frenzy.entrarACelda(celda);
		assertTrue(frenzy.getMovimientosRestantes() == 0);
		frenzy.entrarACelda(otraCelda);
	}
	
	@Test
	public void test06BFrenzyPuedeAtravesarPantanoSiSeTransforma(){
		frenzy = decepticonFactory.crearFrenzy();
		assertTrue(frenzy.getMovimientosRestantes() > 0);
		frenzy.entrarACelda(celda);
		assertTrue(frenzy.getMovimientosRestantes() == 0);
		frenzy.finalizarTurno();
		frenzy.iniciarTurno();
		frenzy.transformarse();
		frenzy.finalizarTurno();
		frenzy.iniciarTurno();
		assertTrue(frenzy.getMovimientosRestantes() > 0);
	}
}
