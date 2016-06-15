package fiuba.algo3.algoformers.test.segundaEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Espinas;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieAerea;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieTerrestre;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class Test06AtravesarEspinasEnModoAereoNoRestaVidaTest {
	
	private Celda celda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer ratchet;
	private AlgoFormer megatron;
	private AlgoFormer ratchet2;
	private AlgoFormer megatron2;
	
	private SuperficieAerea nubes = new Nube();
	private SuperficieTerrestre espinas = new Espinas();
	
	@Before
	public void setUp(){
		celda = new Celda(espinas, nubes);
	}
	
	@Test
	public void test01RatchetAtravesarEspinasEnModoAereoNoRestaVida(){
		ratchet = autobotFactory.crearRatchet();
		ratchet2 = autobotFactory.crearRatchet();
		
		ratchet.transformarse();
		ratchet.entrarACelda(celda);
		assertEquals(ratchet2.getVida(), ratchet.getVida());
	}
	
	@Test
	public void test02MegatronAtravesarEspinasEnModoAereoNoRestaVida(){
		megatron = decepticonFactory.crearMegatron();
		megatron2 = decepticonFactory.crearMegatron();

		megatron.transformarse();
		megatron.entrarACelda(celda);
		assertEquals(megatron2.getVida(), megatron.getVida());
	}
}
