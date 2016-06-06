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
	
	private UnidadHumanoide formaHumanoide = new UnidadHumanoide(1, 2, 3);
	private UnidadAlterna formaAerea = new UnidadAerea(3, 2, 1);
	private UnidadAlterna formaTerrestre = new UnidadTerrestre(2, 2, 2);
	
	AlgoFormer autobotTerrestre =
	    new AutoBot("Ejemplo", 1, formaHumanoide, formaTerrestre);
	
	AlgoFormer autobotAereo =
	    new AutoBot("Ejemplo", 1, formaHumanoide, formaAerea);
	
	@Test
	public void testCeldaEstaOcupadaEstandoDesocupadaDaFalso()
	{
		Celda celda = new Celda();
		assertFalse(celda.estaOcupada());
	}
	
	@Test
	public void testCeldaEstaOcupadaEstandoOcupadaDaVerdadero()
	{
		Celda celda = new Celda();
		
		celda.recibirAlgoformer(autobotAereo);
		
		assertTrue(celda.estaOcupada());
	}
	
	@Test(expected=CeldaOcupadaException.class)
	public void testRecibirAlgoformerLanzaExcepcionSiLaCeldaYaEstabaOcupada()
	{
		Celda celda = new Celda();
		
		celda.recibirAlgoformer(autobotTerrestre);
		celda.recibirAlgoformer(autobotAereo);
	}
	
	@Test
	public void testGetAlgoFormerDevuelveElAlgoFormerCorrecto()
	{
		Celda celda = new Celda();

		celda.recibirAlgoformer(autobotTerrestre);
		
		assertEquals(autobotTerrestre, celda.getAlgoformer());
	}
	
	@Test
	public void testDesocuparCeldaEstandoOcupadaLaDesocupa()
	{
		Celda celda = new Celda();
		
		celda.recibirAlgoformer(autobotAereo);
		celda.desocuparCelda();
		
		assertFalse(celda.estaOcupada());
	}
	
	@Test
	public void testDesocuparCeldaEstandoDesocupadaLaDejaIgual()
	{
		Celda celda = new Celda();
		
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
}
