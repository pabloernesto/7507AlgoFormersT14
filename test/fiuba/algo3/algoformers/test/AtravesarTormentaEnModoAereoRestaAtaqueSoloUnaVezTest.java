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

public class AtravesarTormentaEnModoAereoRestaAtaqueSoloUnaVezTest {

	private Celda celda;
	private Celda otraCelda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer ratchet;
	private AlgoFormer megatron;
	
	
	private SuperficieTerrestre rocosa = new Rocosa();
	private SuperficieAerea tormenta = new TormentaPsionica();
	
	@Before
	public void setUp(){
		celda = new Celda(rocosa, tormenta);
		otraCelda = new Celda(rocosa, tormenta);
	}
	
	@Test
	public void test01RatchetAtravesarTormentaEnModoAereoRestaAtaqueSoloUnaVez(){
		ratchet = autobotFactory.crearRatchet();
		ratchet.transformarse();
		int ataqueAnterior = ratchet.getAtaque();
		ratchet.entrarACelda(celda);
		ratchet.entrarACelda(otraCelda);
		assertEquals(ataqueAnterior * 60 / 100, ratchet.getAtaque());
	}
	
	@Test
	public void test01MegatronAtravesarTormentaEnModoAereoRestaAtaqueSoloUnaVez(){
		megatron = decepticonFactory.crearMegatron();
		megatron.transformarse();
		int ataqueAnterior = megatron.getAtaque();
		megatron.entrarACelda(celda);
		megatron.entrarACelda(otraCelda);
		assertEquals(ataqueAnterior * 60 / 100, megatron.getAtaque());
	}
}
