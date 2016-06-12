package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;

public class DecepticonTest {
	
	private FormaHumanoide humanoide = new FormaHumanoide(1, 2, 3);
	private FormaAlterna alterna = new FormaAerea(3, 2, 1);
	private Decepticon decepticon;
	private Celda celda;
	private Rocosa rocosa = new Rocosa();
	private Nube nube = new Nube();
	
	@Before
	public void setUp(){
		decepticon = new Decepticon("decepticon", 10, humanoide, alterna);
		celda = new Celda(new Rocosa(), new Nube());
	}
	
	@Test
	public void testAlgoformerSePuedeTransformarEnAmbosSentidosYCambiaElComportamiento(){
		assertEquals(1, decepticon.getAtaque()); //Se que el ataque es 1 porque lo declare arriba
		decepticon.transformarse();
		assertEquals(3, decepticon.getAtaque());
		decepticon.transformarse();
		assertEquals(1, decepticon.getAtaque());
	}
	
	@Test
	public void testEntrarACeldaReduceLaCantidadDeMovimientosRestantesEnModoHumanoide(){
		int movimientosRestantesAntes = decepticon.getMovimientosRestantes();
		decepticon.entrarACelda(celda);
		assertTrue(movimientosRestantesAntes > decepticon.getMovimientosRestantes());
	}
	
	@Test
	public void testEntrarACeldaReduceLaCantidadDeMovimientosRestantesEnModoAlterno(){
		decepticon.transformarse();
		int movimientosRestantesAntes = decepticon.getMovimientosRestantes();
		decepticon.entrarACelda(celda);
		assertTrue(movimientosRestantesAntes > decepticon.getMovimientosRestantes());
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void testNoSePuedeMoverMasQueLaCantidadDeCeldasIndicadasPorLaVelocidadEnModoHumanoide(){
		for (int i = 0 ; i < decepticon.getVelocidad() + 1 ; i++)
			decepticon.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void testNoSePuedeMoverMasQueLaCantidadDeCeldasIndicadasPorLaVelocidadEnModoAlterno(){
		decepticon.transformarse();
		for (int i = 0 ; i < decepticon.getVelocidad() + 1 ; i++)
			decepticon.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testDecepticonSePuedeMoverLaCantidadDeCasillerosIndicadaPorSuVelocidadEnModoHumanoide(){
		for (int i = 0 ; i < decepticon.getVelocidad() ; i++)
			decepticon.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testDecepticonSePuedeMoverLaCantidadDeCasillerosIndicadaPorSuVelocidadEnModoAlterno(){
		decepticon.transformarse();
		for (int i = 0 ; i < decepticon.getVelocidad() ; i++)
			decepticon.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testReinicarMovimientosRestantesLosReiniciaEnModoHumanoide(){
		int movimientos = decepticon.getMovimientosRestantes();
		decepticon.entrarACelda(celda);
		assertTrue(movimientos > decepticon.getMovimientosRestantes());
		decepticon.reiniciarMovimientosRestantes();
		assertTrue(movimientos == decepticon.getMovimientosRestantes());
	}
	
	@Test
	public void testReinicarMovimientosRestantesLosReiniciaEnModoAlterno(){
		decepticon.transformarse();
		int movimientos = decepticon.getMovimientosRestantes();
		decepticon.entrarACelda(celda);
		assertTrue(movimientos > decepticon.getMovimientosRestantes());
		decepticon.reiniciarMovimientosRestantes();
		assertTrue(movimientos == decepticon.getMovimientosRestantes());
	}
}