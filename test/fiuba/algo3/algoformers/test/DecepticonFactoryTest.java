package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class DecepticonFactoryTest {

	@Test
	public void testMegatronSeCreaCorrectamente(){
		DecepticonFactory factory = new DecepticonFactory();
		Decepticon megatron = factory.crearMegatron();
		
		assertEquals("Megatron", megatron.getNombre());
		assertEquals(550, megatron.getVida());
		assertEquals(10, megatron.getAtaque());
		assertEquals(1, megatron.getVelocidad());
		assertEquals(3, megatron.getDistAtaque());
		assertEquals(megatron.getEstadoActivo().getClass(), FormaHumanoide.class);
		megatron.transformarse();
		assertEquals(55, megatron.getAtaque());
		assertEquals(8, megatron.getVelocidad());
		assertEquals(2, megatron.getDistAtaque());
		assertEquals(megatron.getEstadoActivo().getClass(), FormaAerea.class);
	}
	
	@Test
	public void testBonecrusherSeCreaCorrectamente(){
		DecepticonFactory factory = new DecepticonFactory();
		Decepticon bonecrusher = factory.crearBonecrusher();
		assertEquals("Bonecrusher", bonecrusher.getNombre());
		assertEquals(200, bonecrusher.getVida());
		assertEquals(30, bonecrusher.getAtaque());
		assertEquals(1, bonecrusher.getVelocidad());
		assertEquals(3, bonecrusher.getDistAtaque());
		assertEquals(bonecrusher.getEstadoActivo().getClass(), FormaHumanoide.class);
		bonecrusher.transformarse();
		assertEquals(30, bonecrusher.getAtaque());
		assertEquals(8, bonecrusher.getVelocidad());
		assertEquals(3, bonecrusher.getDistAtaque());
		assertEquals(bonecrusher.getEstadoActivo().getClass(), FormaTerrestre.class);
	}
	
	@Test
	public void testFrenzySeCreaCorrectamente(){
		DecepticonFactory factory = new DecepticonFactory();
		Decepticon frenzy = factory.crearFrenzy();
		assertEquals("Frenzy", frenzy.getNombre());
		assertEquals(400, frenzy.getVida());
		assertEquals(10, frenzy.getAtaque());
		assertEquals(2, frenzy.getVelocidad());
		assertEquals(5, frenzy.getDistAtaque());
		assertEquals(frenzy.getEstadoActivo().getClass(), FormaHumanoide.class);
		frenzy.transformarse();
		assertEquals(25, frenzy.getAtaque());
		assertEquals(6, frenzy.getVelocidad());
		assertEquals(2, frenzy.getDistAtaque());
		assertEquals(frenzy.getEstadoActivo().getClass(), FormaTerrestre.class);
	}
	
}