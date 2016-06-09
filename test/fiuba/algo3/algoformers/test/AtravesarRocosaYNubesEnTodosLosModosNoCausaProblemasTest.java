package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;

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

public class AtravesarRocosaYNubesEnTodosLosModosNoCausaProblemasTest {

	private Celda celda;
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
	}
	
	@Test
	public void test01OptimusAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		optimus = autobotFactory.crearOptimusPrime();
		int movimientos = optimus.getMovimientosRestantes();
		optimus.entrarACelda(celda);
		assertEquals(movimientos - 1, optimus.getMovimientosRestantes());
	}
	
	@Test
	public void test02OptimusAtravesarRocosaEnModoTerrestreNoCausaProblemas(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		int movimientos = optimus.getMovimientosRestantes();
		optimus.entrarACelda(celda);
		assertEquals(movimientos - 1, optimus.getMovimientosRestantes());
	}
	
	@Test
	public void test03BumblebeeAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		bumblebee = autobotFactory.crearBumblebee();
		int movimientos = bumblebee.getMovimientosRestantes();
		bumblebee.entrarACelda(celda);
		assertEquals(movimientos - 1, bumblebee.getMovimientosRestantes());
	}
	
	@Test
	public void test04BumblebeeAtravesarRocosaEnModoTerrestreNoCausaProblemas(){
		bumblebee = autobotFactory.crearBumblebee();
		bumblebee.transformarse();
		int movimientos = bumblebee.getMovimientosRestantes();
		bumblebee.entrarACelda(celda);
		assertEquals(movimientos - 1, bumblebee.getMovimientosRestantes());
	}
	
	@Test
	public void test05RatchetAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		ratchet = autobotFactory.crearRatchet();
		int movimientos = ratchet.getMovimientosRestantes();
		ratchet.entrarACelda(celda);
		assertEquals(movimientos - 1, ratchet.getMovimientosRestantes());
	}
	
	@Test
	public void test06RatchetAtravesarRocosaEnModoAereoNoCausaProblemas(){
		ratchet = autobotFactory.crearRatchet();
		ratchet.transformarse();
		int movimientos = ratchet.getMovimientosRestantes();
		ratchet.entrarACelda(celda);
		assertEquals(movimientos - 1, ratchet.getMovimientosRestantes());
	}
	
	@Test
	public void test07MegatronAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		megatron = decepticonFactory.crearMegatron();
		int movimientos = megatron.getMovimientosRestantes();
		megatron.entrarACelda(celda);
		assertEquals(movimientos - 1, megatron.getMovimientosRestantes());
	}
	
	@Test
	public void test08MegatronAtravesarRocosaEnModoAereoNoCausaProblemas(){
		megatron = decepticonFactory.crearMegatron();
		megatron.transformarse();
		int movimientos = megatron.getMovimientosRestantes();
		megatron.entrarACelda(celda);
		assertEquals(movimientos - 1, megatron.getMovimientosRestantes());
	}
	
	@Test
	public void test09BonecrusherAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		int movimientos = bonecrusher.getMovimientosRestantes();
		bonecrusher.entrarACelda(celda);
		assertEquals(movimientos - 1, bonecrusher.getMovimientosRestantes());
	}
	
	@Test
	public void test10BonecrusherAtravesarRocosaEnModoTerrestreNoCausaProblemas(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		bonecrusher.transformarse();
		int movimientos = bonecrusher.getMovimientosRestantes();
		bonecrusher.entrarACelda(celda);
		assertEquals(movimientos - 1, bonecrusher.getMovimientosRestantes());
	}
	
	@Test
	public void test11FrenzyAtravesarRocosaEnModoHumanoideNoCausaProblemas(){
		frenzy = decepticonFactory.crearFrenzy();
		int movimientos = frenzy.getMovimientosRestantes();
		frenzy.entrarACelda(celda);
		assertEquals(movimientos - 1, frenzy.getMovimientosRestantes());
	}
	
	@Test
	public void test12FrenzyAtravesarRocosaEnModoTerrestreNoCausaProblemas(){
		frenzy = decepticonFactory.crearFrenzy();
		frenzy.transformarse();
		int movimientos = frenzy.getMovimientosRestantes();
		frenzy.entrarACelda(celda);
		assertEquals(movimientos - 1, frenzy.getMovimientosRestantes());
	}
}