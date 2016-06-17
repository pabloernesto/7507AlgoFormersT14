package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;
import fiuba.algo3.algoformers.factories.AutoBotFactory;

public class AutoBotFactoryTest {

	private AutoBotFactory factory = new AutoBotFactory();
	private AutoBot optimus;
	private AutoBot bumblebee;
	private AutoBot ratchet;
	
	@Before
	public void setUp(){
		optimus = factory.crearOptimusPrime();
		bumblebee = factory.crearBumblebee();
		ratchet = factory.crearRatchet();
	}

	@Test
	public void testOptimusPrimeSeCreaCorrectamente(){

		assertEquals("Optimus Prime", optimus.getNombre());
		assertEquals(500, optimus.getVida());
		assertEquals(50, optimus.getAtaque());
		assertEquals(2, optimus.getVelocidad());
		assertEquals(2, optimus.getDistAtaque());
		assertEquals(optimus.getEstadoActivo().getClass(), FormaHumanoide.class);
		
		optimus.transformarse();
		assertEquals("Optimus Prime", optimus.getNombre());
		assertEquals(500, optimus.getVida());
		assertEquals(15, optimus.getAtaque());
		assertEquals(5, optimus.getVelocidad());
		assertEquals(4, optimus.getDistAtaque());
		assertEquals(optimus.getEstadoActivo().getClass(), FormaTerrestre.class);
	}
	
	@Test
	public void testBumblebeeSeCreaCorrectamente(){

		assertEquals("Bumblebee", bumblebee.getNombre());
		assertEquals(350, bumblebee.getVida());
		assertEquals(40, bumblebee.getAtaque());
		assertEquals(2, bumblebee.getVelocidad());
		assertEquals(1, bumblebee.getDistAtaque());
		assertEquals(bumblebee.getEstadoActivo().getClass(), FormaHumanoide.class);
		
		bumblebee.transformarse();
		assertEquals("Bumblebee", bumblebee.getNombre());
		assertEquals(350, bumblebee.getVida());
		assertEquals(20, bumblebee.getAtaque());
		assertEquals(5, bumblebee.getVelocidad());
		assertEquals(3, bumblebee.getDistAtaque());
		assertEquals(bumblebee.getEstadoActivo().getClass(), FormaTerrestre.class);
	}
	
	@Test
	public void testRatchetSeCreaCorrectamente(){

		assertEquals("Ratchet", ratchet.getNombre());
		assertEquals(150, ratchet.getVida());
		assertEquals(5, ratchet.getAtaque());
		assertEquals(1, ratchet.getVelocidad());
		assertEquals(5, ratchet.getDistAtaque());
		assertEquals(ratchet.getEstadoActivo().getClass(), FormaHumanoide.class);
		
		ratchet.transformarse();
		assertEquals("Ratchet", ratchet.getNombre());
		assertEquals(150, ratchet.getVida());
		assertEquals(35, ratchet.getAtaque());
		assertEquals(8, ratchet.getVelocidad());
		assertEquals(2, ratchet.getDistAtaque());
		assertEquals(ratchet.getEstadoActivo().getClass(), FormaAerea.class);
	}
	
	@Test
	public void testSuperionSeCreaCorrectamente(){
		List<AlgoFormer> autobots = new ArrayList<AlgoFormer>();
		autobots.add(optimus);
		autobots.add(bumblebee);
		autobots.add(ratchet);
		AutoBot superion = factory.crearCombinado(autobots);
		
		assertEquals("Superion", superion.getNombre());
		assertEquals(100, superion.getAtaque());
		assertEquals(3, superion.getVelocidad());
		assertEquals(2, superion.getDistAtaque());
		assertEquals(superion.getEstadoActivo().getClass(), FormaTerrestre.class);
	}
	
}
