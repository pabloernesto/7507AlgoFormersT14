package fiuba.algo3.algoformers.test.segundaEntrega;

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

public class AtravesarTormentaEnModoAereoCuestaUnMovimientoTest {

	private Celda celda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer ratchet;
	private AlgoFormer megatron;
	private AlgoFormer ratchet2;
	private AlgoFormer megatron2;
	
	private SuperficieTerrestre rocosa = new Rocosa();
	private SuperficieAerea tormenta = new TormentaPsionica();
	
	@Before
	public void setUp(){
		celda = new Celda(rocosa, tormenta);	
	}
	
	@Test
	public void test01RatchetAtravesarTormentaEnModoAereoRestaAtaque(){
		ratchet = autobotFactory.crearRatchet();
		ratchet2 = autobotFactory.crearRatchet();
		ratchet.transformarse();
		ratchet2.transformarse();

		ratchet.entrarACelda(celda);
		assertEquals(ratchet2.getMovimientosRestantes() -1, ratchet.getMovimientosRestantes());
	}
	
	@Test
	public void test02MegatronAtravesarTormentaEnModoAereoRestaAtaque(){
		megatron = decepticonFactory.crearMegatron();
		megatron2 = decepticonFactory.crearMegatron();
		megatron.transformarse();
		megatron2.transformarse();
		
		megatron.entrarACelda(celda);
		assertEquals(megatron2.getMovimientosRestantes() -1, megatron.getMovimientosRestantes());
	}
}