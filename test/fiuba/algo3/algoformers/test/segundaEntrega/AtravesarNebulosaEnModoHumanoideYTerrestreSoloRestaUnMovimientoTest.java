package fiuba.algo3.algoformers.test.segundaEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

public class AtravesarNebulosaEnModoHumanoideYTerrestreSoloRestaUnMovimientoTest {
	private Celda celda;
	private Celda unaCelda;
	private Celda otraCelda;
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
	
	private SuperficieTerrestre rocosa = new Rocosa();
	private SuperficieAerea nebulosa = new NebulosaDeAndromeda();
	
	@Before
	public void setUp(){
		celda = new Celda(rocosa, nebulosa);
		unaCelda = new Celda(rocosa, nebulosa);
		otraCelda = new Celda(rocosa, nebulosa);
	}
	
	@Test
	public void test01OptimusAtravesarNebulosaEnModoHumanoideYTerrestreSoloRestaUnMovimiento(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus2 = autobotFactory.crearOptimusPrime();

		optimus.entrarACelda(celda);
		assertTrue(optimus.atributosSonIguales(optimus2));
		assertEquals(optimus2.getMovimientosRestantes() -1 , optimus.getMovimientosRestantes());

		
		optimus.entrarACelda(otraCelda);
		assertTrue(optimus.atributosSonIguales(optimus2));
		assertEquals(optimus2.getMovimientosRestantes() -2 , optimus.getMovimientosRestantes());

		optimus.transformarse();
		optimus2.transformarse();
		
		assertTrue(optimus.atributosSonIguales(optimus2));
		optimus.entrarACelda(unaCelda);
		assertTrue(optimus.atributosSonIguales(optimus2));
		assertEquals(optimus2.getMovimientosRestantes() -1 , optimus.getMovimientosRestantes());


	}
	
	@Test
	public void test02BumblebleeAtravesarNebulosaEnModoHumanoideYTerrestreSoloRestaUnMovimiento(){
		bumblebee = autobotFactory.crearBumblebee();
		bumblebee2 = autobotFactory.crearBumblebee();

		bumblebee.entrarACelda(celda);
		assertTrue(bumblebee.atributosSonIguales(bumblebee2));
		assertEquals(bumblebee2.getMovimientosRestantes() -1 , bumblebee.getMovimientosRestantes());

		bumblebee.entrarACelda(otraCelda);
		assertTrue(bumblebee.atributosSonIguales(bumblebee2));
		assertEquals(bumblebee2.getMovimientosRestantes() -2 , bumblebee.getMovimientosRestantes());
		
		bumblebee.transformarse();
		bumblebee2.transformarse();	
		
		assertTrue(bumblebee.atributosSonIguales(bumblebee2));
		bumblebee.entrarACelda(unaCelda);
		assertTrue(bumblebee.atributosSonIguales(bumblebee2));
		assertEquals(bumblebee2.getMovimientosRestantes() -1 , bumblebee.getMovimientosRestantes());
	}
	
	@Test
	public void test03BonecrusherAtravesarNebulosaEnModoHumanoideYTerrestreSoloRestaUnMovimiento(){
		bonecrusher = decepticonFactory.crearBonecrusher();
		bonecrusher2 = decepticonFactory.crearBonecrusher();

		bonecrusher.entrarACelda(celda);
		assertTrue(bonecrusher.atributosSonIguales(bonecrusher2));
		assertEquals(bonecrusher2.getMovimientosRestantes() -1 , bonecrusher.getMovimientosRestantes());

		bonecrusher.reiniciarMovimientosRestantes();
		bonecrusher.entrarACelda(otraCelda);
		assertTrue(bonecrusher.atributosSonIguales(bonecrusher2));
		assertEquals(bonecrusher2.getMovimientosRestantes() -1 , bonecrusher.getMovimientosRestantes());

		
		bonecrusher.transformarse();
		bonecrusher2.transformarse();
		
		assertTrue(bonecrusher.atributosSonIguales(bonecrusher2));
		bonecrusher.entrarACelda(unaCelda);
		assertTrue(bonecrusher.atributosSonIguales(bonecrusher2));
		assertEquals(bonecrusher2.getMovimientosRestantes() -1 , bonecrusher.getMovimientosRestantes());

	}
	
	@Test
	public void test04FrenzyAtravesarNebulosaEnModoHumanoideYTerrestreSoloRestaUnMovimiento(){
		frenzy = decepticonFactory.crearFrenzy();
		frenzy2 = decepticonFactory.crearFrenzy();

		frenzy.entrarACelda(celda);
		assertTrue(frenzy.atributosSonIguales(frenzy2));
		assertEquals(frenzy2.getMovimientosRestantes() -1 , frenzy.getMovimientosRestantes());

		frenzy.entrarACelda(otraCelda);
		assertTrue(frenzy.atributosSonIguales(frenzy2));
		assertEquals(frenzy2.getMovimientosRestantes() -2 , frenzy.getMovimientosRestantes());

		
		frenzy.transformarse();
		frenzy2.transformarse();
		
		assertTrue(frenzy.atributosSonIguales(frenzy2));
		frenzy.entrarACelda(unaCelda);
		assertTrue(frenzy.atributosSonIguales(frenzy2));
		assertEquals(frenzy2.getMovimientosRestantes() -1 , frenzy.getMovimientosRestantes());

	}
}
