package fiuba.algo3.algoformers.test.segundaEntrega;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.NebulosaDeAndromeda;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieAerea;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieTerrestre;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class AtravesarNebulosaEnModoHumanoideYTerrestreNoCausaProblemasTest {
	private Celda celda;
	private Celda unaCelda;
	private Celda otraCelda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer optimus;
	private AlgoFormer bumblebee;
	private AlgoFormer bonecrusher;
	private AlgoFormer frenzy;
	
	private SuperficieTerrestre rocosa = new Rocosa();
	private SuperficieAerea nebulosa = new NebulosaDeAndromeda();
	
	@Before
	public void setUp(){
		celda = new Celda(rocosa, nebulosa);
		unaCelda = new Celda(rocosa, nebulosa);
		otraCelda = new Celda(rocosa, nebulosa);
	}
	
	@Test
	public void test01OptimusAtravesarNebulosaEnModoHumanoideYTerrestreNoCausaProblemas(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.entrarACelda(celda);
		optimus.entrarACelda(otraCelda);
		
		optimus.transformarse();
		optimus.entrarACelda(unaCelda);
	}
	
	@Test
	public void test02BumblebleeAtravesarNebulosaEnModoHumanoideYTerrestreNoCausaProblemas(){
		bumblebee = autobotFactory.crearBumblebee();
		bumblebee.entrarACelda(celda);
		bumblebee.entrarACelda(otraCelda);
		
		bumblebee.transformarse();
		bumblebee.entrarACelda(unaCelda);
	}
	
	@Test
	public void test03BonecrusherAtravesarNebulosaEnModoHumanoideYTerrestreNoCausaProblemas(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		bonecrusher.entrarACelda(celda);
		bonecrusher.reiniciarMovimientosRestantes();
		bonecrusher.entrarACelda(otraCelda);
		
		bonecrusher.transformarse();
		bonecrusher.entrarACelda(unaCelda);
	}
	
	@Test
	public void test04FrenzyAtravesarNebulosaEnModoHumanoideYTerrestreNoCausaProblemas(){
		frenzy = decepticonFactory.crearFrenzy();
		frenzy.entrarACelda(celda);
		frenzy.entrarACelda(otraCelda);
		
		frenzy.transformarse();
		frenzy.entrarACelda(unaCelda);
	}
}
