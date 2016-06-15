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

public class Test04AtravesarPantanoEnModoAereoSoloRestaUnMovimientoTest {
	
	private Celda celda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer ratchet;
	private AlgoFormer megatron;
	private AlgoFormer ratchet2;
	private AlgoFormer megatron2;
	
	private SuperficieAerea nubes = new Nube();
	private SuperficieTerrestre pantano = new Pantano();
	
	@Before
	public void setUp(){
		celda = new Celda(pantano, nubes);
	}
	
	@Test
	public void test01RatchetAtravesarPantanoEnModoAereoSoloRestaUnMovimiento(){
		ratchet = autobotFactory.crearRatchet();
		ratchet.transformarse();
		ratchet2 = autobotFactory.crearRatchet();
		ratchet2.transformarse();
		
		ratchet.entrarACelda(celda);
		
		assertTrue(ratchet.atributosSonIguales(ratchet2));
		assertEquals(ratchet2.getMovimientosRestantes() - 1, ratchet.getMovimientosRestantes());
	}
	
	@Test
	public void test02MegatronAtravesarPantanoEnModoAereoSoloRestaUnMovimiento(){
		megatron = decepticonFactory.crearMegatron();
		megatron.transformarse();
		megatron2 = decepticonFactory.crearMegatron();
		megatron2.transformarse();
		
		megatron.entrarACelda(celda);
		
		assertTrue(megatron.atributosSonIguales(megatron2));
		assertEquals(megatron2.getMovimientosRestantes() - 1, megatron.getMovimientosRestantes());
	}
}
