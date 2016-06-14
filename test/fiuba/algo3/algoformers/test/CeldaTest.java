package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;
import fiuba.algo3.algoformers.factories.AutoBotFactory;

public class CeldaTest {
	
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private Celda celda;
	
	AlgoFormer autobotTerrestre = autobotFactory.crearOptimusPrime();
	
	AlgoFormer autobotAereo = autobotFactory.crearRatchet();
	
	@Before
	public void setUp(){
		celda = new Celda(new Rocosa(), new Nube());
	}
	
	@Test
	public void testCeldaEstaOcupadaEstandoDesocupadaDaFalso()
	{
		assertFalse(celda.estaOcupada());
	}
	
	@Test
	public void testCeldaEstaOcupadaEstandoOcupadaDaVerdadero()
	{
		
		celda.recibirAlgoformer(autobotAereo);
		
		assertTrue(celda.estaOcupada());
	}
	
	@Test(expected=CeldaOcupadaException.class)
	public void testRecibirAlgoformerLanzaExcepcionSiLaCeldaYaEstabaOcupada()
	{
		
		celda.recibirAlgoformer(autobotTerrestre);
		celda.recibirAlgoformer(autobotAereo);
	}
	
	@Test
	public void testGetAlgoFormerDevuelveElAlgoFormerCorrecto()
	{

		celda.recibirAlgoformer(autobotTerrestre);
		
		assertEquals(autobotTerrestre, celda.getAlgoformer());
	}
	
	@Test
	public void testDesocuparCeldaEstandoOcupadaLaDesocupa()
	{
		
		celda.recibirAlgoformer(autobotAereo);
		celda.desocuparCelda();
		
		assertFalse(celda.estaOcupada());
	}
	
	@Test
	public void testDesocuparCeldaEstandoDesocupadaLaDejaIgual()
	{
		
		celda.desocuparCelda();
		
		assertNull(celda.getAlgoformer());
	}
	
	@Test
	public void testCeldaContieneChispaSupremaSinContenerlaDaFalso(){
		assertFalse(celda.contieneChispaSuprema());
	}
	
	@Test
	public void testCeldaContieneChispaSupremaConteniendolaDaVerdadero(){
		celda.colocarChispaSuprema();
		assertTrue(celda.contieneChispaSuprema());
	}
}
