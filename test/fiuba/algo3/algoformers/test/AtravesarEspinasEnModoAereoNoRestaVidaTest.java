package fiuba.algo3.algoformers.test;

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

public class AtravesarEspinasEnModoAereoNoRestaVidaTest {
	
	private Celda celda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer ratchet;
	private AlgoFormer megatron;
	
	private SuperficieAerea nubes = new Nube();
	private SuperficieTerrestre espinas = new Espinas();
	
	@Before
	public void setUp(){
		celda = new Celda(espinas, nubes);
	}
	
	@Test
	public void test01RatchetAtravesarEspinasEnModoAereoNoRestaVida(){
		ratchet = autobotFactory.crearRatchet();
		int vida = ratchet.getVida();
		ratchet.transformarse();
		ratchet.entrarACelda(celda);
		int nuevaVida = ratchet.getVida();
		assertEquals(vida, nuevaVida);
	}
	
	@Test
	public void test02MegatronAtravesarEspinasEnModoAereoNoRestaVida(){
		megatron = decepticonFactory.crearMegatron();
		int vida = megatron.getVida();
		megatron.transformarse();
		megatron.entrarACelda(celda);
		int nuevaVida = megatron.getVida();
		assertEquals(vida, nuevaVida);
	}
}