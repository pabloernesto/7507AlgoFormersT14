package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;
import org.junit.Test;
import fiuba.algo3.algoformers.modelo.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Celda;

public class CeldaTest {

	@Test
	public void testCrearUnaCelda(){
		Celda celda = new Celda();
		assertNotNull(celda);
	}
	
	@Test
	public void testSetYGetAlgoFormer(){
		Celda celda = new Celda();
		AlgoFormer algoformer = new AlgoFormer();
		celda.setAlgoformer(algoformer);
		assertEquals(algoformer, celda.getAlgoformer());
	}
	
	@Test
	public void testDesocuparCeldaEstandoOcupadaLaDesocupa(){
		Celda celda = new Celda();
		AlgoFormer algoformer = new AlgoFormer();
		celda.setAlgoformer(algoformer);
		assertNotNull(celda.getAlgoformer());
		celda.desocuparCelda();
		assertNull(celda.getAlgoformer());
	}
	
	@Test
	public void testDesocuparCeldaEstandoDesocupadaLaDejaIgual(){
		Celda celda = new Celda();
		assertNull(celda.getAlgoformer());
		celda.desocuparCelda();
		assertNull(celda.getAlgoformer());
	}
	
	@Test
	public void testCeldaEstaOcupadaEstandoDesocupadaDaFalso(){
		Celda celda = new Celda();
		assertFalse(celda.estaOcupada());
	}
	
	@Test
	public void testCeldaEstaOcupadaEstandoOcupadaDaVerdadero(){
		Celda celda = new Celda();
		AlgoFormer algoformer = new AlgoFormer();
		celda.setAlgoformer(algoformer);
		assertTrue(celda.estaOcupada());
	}
	
	@Test
	public void testCeldaRecienCreadaNoContieneChispaSuprema(){
		assertFalse(new Celda().contieneChispaSuprema());
	}
	
	@Test
	public void testCeldaContieneChispaSuprema(){
		Celda celda = new Celda();
		celda.colocarChispaSuprema();
		assertTrue(celda.contieneChispaSuprema());
	}
}
