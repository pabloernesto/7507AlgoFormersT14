package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.UnidadAerea;
import fiuba.algo3.algoformers.algoformers.UnidadHumanoide;
import fiuba.algo3.algoformers.algoformers.UnidadTerrestre;
import fiuba.algo3.algoformers.factories.AutoBotFactory;

public class AutoBotFactoryTest {

	@Test
	public void testOptimusPrimeSeCreaCorrectamente(){
		AutoBotFactory factory = new AutoBotFactory();
		AutoBot optimus = factory.crearOptimusPrime();
		
		assertEquals("Optimus Prime", optimus.getNombre());
		assertEquals(500, optimus.getVida());
		assertEquals(50, optimus.getAtaque());
		assertEquals(2, optimus.getVelocidad());
		assertEquals(2, optimus.getDistAtaque());
		assertEquals(optimus.getEstadoActivo().getClass(), UnidadHumanoide.class);
		
		optimus.transformarse();
		assertEquals("Optimus Prime", optimus.getNombre());
		assertEquals(500, optimus.getVida());
		assertEquals(15, optimus.getAtaque());
		assertEquals(5, optimus.getVelocidad());
		assertEquals(4, optimus.getDistAtaque());
		assertEquals(optimus.getEstadoActivo().getClass(), UnidadTerrestre.class);
	}
	
	@Test
	public void testBumblebeeSeCreaCorrectamente(){
		AutoBotFactory factory = new AutoBotFactory();
		AutoBot bumblebee = factory.crearBumblebee();
		
		assertEquals("Bumblebee", bumblebee.getNombre());
		assertEquals(350, bumblebee.getVida());
		assertEquals(40, bumblebee.getAtaque());
		assertEquals(2, bumblebee.getVelocidad());
		assertEquals(1, bumblebee.getDistAtaque());
		assertEquals(bumblebee.getEstadoActivo().getClass(), UnidadHumanoide.class);
		
		bumblebee.transformarse();
		assertEquals("Bumblebee", bumblebee.getNombre());
		assertEquals(350, bumblebee.getVida());
		assertEquals(20, bumblebee.getAtaque());
		assertEquals(5, bumblebee.getVelocidad());
		assertEquals(3, bumblebee.getDistAtaque());
		assertEquals(bumblebee.getEstadoActivo().getClass(), UnidadTerrestre.class);
	}
	
	@Test
	public void testRatchetSeCreaCorrectamente(){
		AutoBotFactory factory = new AutoBotFactory();
		AutoBot ratchet = factory.crearRatchet();
		
		assertEquals("Ratchet", ratchet.getNombre());
		assertEquals(150, ratchet.getVida());
		assertEquals(5, ratchet.getAtaque());
		assertEquals(1, ratchet.getVelocidad());
		assertEquals(5, ratchet.getDistAtaque());
		assertEquals(ratchet.getEstadoActivo().getClass(), UnidadHumanoide.class);
		
		ratchet.transformarse();
		assertEquals("Ratchet", ratchet.getNombre());
		assertEquals(150, ratchet.getVida());
		assertEquals(35, ratchet.getAtaque());
		assertEquals(8, ratchet.getVelocidad());
		assertEquals(2, ratchet.getDistAtaque());
		assertEquals(ratchet.getEstadoActivo().getClass(), UnidadAerea.class);
	}
	
}
