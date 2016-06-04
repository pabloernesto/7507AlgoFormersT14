package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.UnidadAerea;
import fiuba.algo3.algoformers.algoformers.UnidadAlterna;
import fiuba.algo3.algoformers.algoformers.UnidadHumanoide;
import fiuba.algo3.algoformers.algoformers.UnidadTerrestre;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;

public class CeldaTest {
	
	private UnidadHumanoide humanoide = new UnidadHumanoide(1, 2, 3);
	private UnidadAlterna aerea = new UnidadAerea(3, 2, 1);
	private UnidadAlterna terrestre = new UnidadTerrestre(2, 2, 2);
	
	@Test
	public void testCeldaEstaOcupadaEstandoDesocupadaDaFalso(){
		Celda celda = new Celda();
		assertFalse(celda.estaOcupada());
	}
	
	@Test
	public void testCeldaEstaOcupadaEstandoOcupadaDaVerdadero(){
		Celda celda = new Celda();
		AlgoFormer algoformer = new AutoBot("Ejemplo", 1, humanoide, aerea);
		celda.recibirAlgoformer(algoformer);
		assertTrue(celda.estaOcupada());
	}
	
	@Test(expected=CeldaOcupadaException.class)
	public void testRecibirAlgoformerLanzaExcepcionSiLaCeldaYaEstabaOcupada(){
		Celda celda = new Celda();
		AlgoFormer algoformer1 = new AutoBot("Ejemplo", 1, humanoide, aerea);
		celda.recibirAlgoformer(algoformer1);
		AlgoFormer algoformer2 = new AutoBot("Ejemplo", 1, humanoide, aerea);
		celda.recibirAlgoformer(algoformer2);
	}
	
	@Test
	public void testGetAlgoFormerDevuelveElAlgoFormerCorrecto(){
		Celda celda = new Celda();
		AlgoFormer algoformer = new AutoBot("Ejemplo", 1, humanoide, terrestre);
		celda.recibirAlgoformer(algoformer);
		assertEquals(algoformer, celda.getAlgoformer());
	}
	
	@Test
	public void testDesocuparCeldaEstandoOcupadaLaDesocupa(){
		Celda celda = new Celda();
		AlgoFormer algoformer = new AutoBot("Ejemplo", 1, humanoide, aerea);
		celda.recibirAlgoformer(algoformer);
		assertNotNull(celda.getAlgoformer());
		celda.desocuparCelda();
		assertFalse(celda.estaOcupada());
	}
	
	@Test
	public void testDesocuparCeldaEstandoDesocupadaLaDejaIgual(){
		Celda celda = new Celda();
		assertNull(celda.getAlgoformer());
		celda.desocuparCelda();
		assertNull(celda.getAlgoformer());
	}
	
	@Test
	public void testCeldaContieneChispaSupremaSinContenerlaDaFalso(){
		assertFalse(new Celda().contieneChispaSuprema());
	}
	
	@Test
	public void testCeldaContieneChispaSupremaConteniendolaDaVerdadero(){
		Celda celda = new Celda();
		celda.colocarChispaSuprema();
		assertTrue(celda.contieneChispaSuprema());
	}
	
	@Test
	public void testGetCostoDeEntradaSiempreDevuelve1(){
		Celda celda = new Celda();
		AlgoFormer tipoHumanoide = new AutoBot("Ejemplo", 1, humanoide, terrestre);
		AlgoFormer tipoAerea = new AutoBot("Ejemplo", 1, humanoide, aerea);
		AlgoFormer tipoTerrestre = new AutoBot("Ejemplo", 1, humanoide, terrestre);
		tipoAerea.transformarse();
		tipoTerrestre.transformarse();
		assertEquals(1, celda.getCostoDeEntrada(tipoHumanoide.getEstadoActivo()));
		assertEquals(1, celda.getCostoDeEntrada(tipoTerrestre.getEstadoActivo()));
		assertEquals(1, celda.getCostoDeEntrada(tipoAerea.getEstadoActivo()));
	}
	
}