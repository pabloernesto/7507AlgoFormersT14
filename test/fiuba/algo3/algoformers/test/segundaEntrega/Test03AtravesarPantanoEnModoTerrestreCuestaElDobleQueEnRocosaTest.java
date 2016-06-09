package fiuba.algo3.algoformers.test.segundaEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Pantano;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieAerea;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieTerrestre;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class Test03AtravesarPantanoEnModoTerrestreCuestaElDobleQueEnRocosaTest {
	
	private Celda celda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer optimus;
	private AlgoFormer bumblebee;

	private AlgoFormer bonecrusher;
	private AlgoFormer frenzy;
	
	private SuperficieAerea nubes = new Nube();
	private SuperficieTerrestre pantano = new Pantano();
	
	@Before
	public void setUp(){
		celda = new Celda(pantano, nubes);
	}
	
	
	@Test
	public void test01OptimusAtravesarPantanoEnModoTerrestreCuestaElDobleQueEnRocosa(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		int movimientos = optimus.getMovimientosRestantes();
		optimus.entrarACelda(celda);
		assertEquals(movimientos - 2, optimus.getMovimientosRestantes());
	}
	
	@Test
	public void test02BumblebeeAtravesarPantanoEnModoTerrestreCuestaElDobleQueEnRocosa(){
		bumblebee = autobotFactory.crearBumblebee();
		bumblebee.transformarse();
		int movimientos = bumblebee.getMovimientosRestantes();
		bumblebee.entrarACelda(celda);
		assertEquals(movimientos - 2, bumblebee.getMovimientosRestantes());
	}
	
	@Test
	public void test03BonecrusherAtravesarPantanoEnModoTerrestreCuestaElDobleQueEnRocosa(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		bonecrusher.transformarse();
		int movimientos = bonecrusher.getMovimientosRestantes();
		bonecrusher.entrarACelda(celda);
		assertEquals(movimientos - 2, bonecrusher.getMovimientosRestantes());
	}
	
	@Test
	public void test04FrenzyAtravesarPantanoEnModoTerrestreCuestaElDobleQueEnRocosa(){
		frenzy = decepticonFactory.crearFrenzy();
		frenzy.transformarse();
		int movimientos = frenzy.getMovimientosRestantes();
		frenzy.entrarACelda(celda);
		assertEquals(movimientos - 2, frenzy.getMovimientosRestantes());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
