package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieAerea;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieTerrestre;
import fiuba.algo3.algoformers.escenario.superficies.TormentaPsionica;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class AtravesarTormentaEnModoHumanoideYTerrestresNoCausaProblemasTest {


	private Celda celda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer optimus;
	private AlgoFormer bumblebee;
	private AlgoFormer bonecrusher;
	private AlgoFormer frenzy;
	
	private SuperficieTerrestre rocosa = new Rocosa();
	private SuperficieAerea tormenta = new TormentaPsionica();
	
	@Before
	public void setUp(){
		celda = new Celda(rocosa, tormenta);
	}
	
	@Test
	public void test01OptimusAtravesarTormentaEnModoHumanoideYTerrestreNoCausaProblemas(){
		optimus = autobotFactory.crearOptimusPrime();
		int ataqueAnterior = optimus.getAtaque();
		optimus.entrarACelda(celda);
		assertEquals(ataqueAnterior , optimus.getAtaque());
		
		optimus.transformarse();
		ataqueAnterior = optimus.getAtaque();
		celda = new Celda(rocosa, tormenta);
		optimus.entrarACelda(celda);
		assertEquals(ataqueAnterior , optimus.getAtaque());
	}
	
	@Test
	public void test02BumblebleeAtravesarTormentaEnModoHumanoideYTerrestreNoCausaProblemas(){
		bumblebee = autobotFactory.crearBumblebee();
		int ataqueAnterior = bumblebee.getAtaque();
		bumblebee.entrarACelda(celda);
		assertEquals(ataqueAnterior , bumblebee.getAtaque());
		
		bumblebee.transformarse();
		ataqueAnterior = bumblebee.getAtaque();
		celda = new Celda(rocosa, tormenta);
		bumblebee.entrarACelda(celda);
		assertEquals(ataqueAnterior , bumblebee.getAtaque());
	}
	
	@Test
	public void test03BonecrusherAtravesarTormentaEnModoHumanoideYTerrestreNoCausaProblemas(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		int ataqueAnterior = bonecrusher.getAtaque();
		bonecrusher.entrarACelda(celda);
		assertEquals(ataqueAnterior , bonecrusher.getAtaque());
		
		bonecrusher.transformarse();
		ataqueAnterior = bonecrusher.getAtaque();
		celda = new Celda(rocosa, tormenta);
		bonecrusher.entrarACelda(celda);
		assertEquals(ataqueAnterior , bonecrusher.getAtaque());
	}
	
	@Test
	public void test04FrenzyAtravesarTormentaEnModoHumanoideYTerrestreNoCausaProblemas(){
		frenzy = decepticonFactory.crearFrenzy();
		int ataqueAnterior = frenzy.getAtaque();
		frenzy.entrarACelda(celda);
		assertEquals(ataqueAnterior , frenzy.getAtaque());
		
		frenzy.transformarse();
		ataqueAnterior = frenzy.getAtaque();
		celda = new Celda(rocosa, tormenta);
		frenzy.entrarACelda(celda);
		assertEquals(ataqueAnterior , frenzy.getAtaque());
	}
}