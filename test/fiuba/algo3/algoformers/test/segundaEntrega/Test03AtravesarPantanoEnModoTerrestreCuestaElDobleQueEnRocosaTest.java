package fiuba.algo3.algoformers.test.segundaEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	private AlgoFormer optimus2;
	private AlgoFormer bumblebee;
	private AlgoFormer bumblebee2;

	private AlgoFormer bonecrusher;
	private AlgoFormer bonecrusher2;
	private AlgoFormer frenzy;
	private AlgoFormer frenzy2;
	
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
		optimus2 = autobotFactory.crearOptimusPrime();
		optimus2.transformarse();
		
		optimus.entrarACelda(celda);

		assertTrue(optimus.atributosSonIguales(optimus2));
		assertEquals(optimus2.getMovimientosRestantes() - 2, optimus.getMovimientosRestantes());
	}
	
	@Test
	public void test02BumblebeeAtravesarPantanoEnModoTerrestreCuestaElDobleQueEnRocosa(){
		bumblebee = autobotFactory.crearBumblebee();
		bumblebee.transformarse();
		bumblebee2 = autobotFactory.crearBumblebee();
		bumblebee2.transformarse();
		
		bumblebee.entrarACelda(celda);
		
		assertTrue(bumblebee.atributosSonIguales(bumblebee2));
		assertEquals(bumblebee2.getMovimientosRestantes() - 2, bumblebee.getMovimientosRestantes());
	}
	
	@Test
	public void test03BonecrusherAtravesarPantanoEnModoTerrestreCuestaElDobleQueEnRocosa(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		bonecrusher.transformarse();
		bonecrusher2 = decepticonFactory.crearBonecrusher();
		bonecrusher2.transformarse();
		
		bonecrusher.entrarACelda(celda);
		
		assertTrue(bonecrusher.atributosSonIguales(bonecrusher2));
		assertEquals(bonecrusher2.getMovimientosRestantes() - 2, bonecrusher.getMovimientosRestantes());
	}
	
	@Test
	public void test04FrenzyAtravesarPantanoEnModoTerrestreCuestaElDobleQueEnRocosa(){
		frenzy = decepticonFactory.crearFrenzy();
		frenzy.transformarse();
		frenzy2 = decepticonFactory.crearFrenzy();
		frenzy2.transformarse();
		
		frenzy.entrarACelda(celda);
		
		assertTrue(frenzy.atributosSonIguales(frenzy2));
		assertEquals(frenzy2.getMovimientosRestantes() - 2, frenzy.getMovimientosRestantes());
	}
}
