package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class DecepticonFactoryTest {

	private DecepticonFactory factory = new DecepticonFactory();
	private Decepticon megatron;
	private Decepticon bonecrusher;
	private Decepticon frenzy;
	
	@Before
	public void setUp(){
		megatron = factory.crearMegatron();
		bonecrusher = factory.crearBonecrusher();
		frenzy = factory.crearFrenzy();
	}
	@Test
	public void testMegatronSeCreaCorrectamente(){
		
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
	
	@Test
	public void testMenasorSeCreaCorrectamente(){
		List<AlgoFormer> decepticons = new ArrayList<AlgoFormer>();
		decepticons.add(megatron);
		decepticons.add(bonecrusher);
		decepticons.add(frenzy);
		Decepticon menasor = factory.crearCombinado(decepticons);
		
		assertEquals("Menasor", menasor.getNombre());
		assertEquals(115, menasor.getAtaque());
		assertEquals(2, menasor.getVelocidad());
		assertEquals(2, menasor.getDistAtaque());
		assertEquals(menasor.getEstadoActivo().getClass(), FormaTerrestre.class);
	}
	
}