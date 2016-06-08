package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Espinas;
import fiuba.algo3.algoformers.escenario.superficies.NebulosaDeAndromeda;
import fiuba.algo3.algoformers.factories.AutoBotFactory;

public class EfectosTest {
	
	@Test
	public void testSuperficies(){
		Celda celda = new Celda(new Espinas(), new NebulosaDeAndromeda());
		AutoBotFactory factory = new AutoBotFactory();
		AutoBot optimus = factory.crearOptimusPrime();
		int vida = optimus.getVida();
		assertTrue(vida == 500);
		optimus.entrarACelda(celda);
		int vidaActualizada = optimus.getVida();
		assertTrue(vidaActualizada == 500 / 100 * 95);
	}
}
