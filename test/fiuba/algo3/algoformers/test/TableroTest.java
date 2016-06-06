package fiuba.algo3.algoformers.test;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.UnidadAerea;
import fiuba.algo3.algoformers.algoformers.UnidadAlterna;
import fiuba.algo3.algoformers.algoformers.UnidadHumanoide;

import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;

import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;
import fiuba.algo3.algoformers.excepciones.PosicionInvalidaException;

public class TableroTest {
	
	private Tablero tablero;
	private UnidadHumanoide humanoide = new UnidadHumanoide(1, 2, 3);
	private UnidadAlterna alterna = new UnidadAerea(3, 2, 1);
	private AlgoFormer algoformer = new Decepticon("Ejemplo", 10, humanoide, alterna);
	
	@Before
	public void setUp(){
		tablero = Tablero.getInstance();
	}
	
	@After
	public void tearDown(){
		Tablero.reiniciarTablero();
	}

	@Test
	public void tableroEsRectangularDe60x20(){
		assertEquals(60, tablero.ancho());
		assertEquals(20, tablero.altura());
	}
	
	@Test
    public void testColocarAlgoformerYObtenerPosicionDevuelveLaPosicionCorrecta(){
    	Posicion posicion = new Posicion(1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	assertTrue(tablero.getPosicionAlgoformer(algoformer).equals(posicion));
    }
	
	@Test
    public void testObtenerPosicionDeAlgoformerNoColocadoDevuelveNull(){
    	assertNull(tablero.getPosicionAlgoformer(algoformer));
    }
	
	@Test(expected=PosicionInvalidaException.class)
    public void testColocarAlgoFormerEnPosicionInvalidaLanzaExcepcion(){
    	Posicion posicion = new Posicion (-1,0);
    	tablero.colocarAlgoformer(algoformer, posicion);
    }
	
	@Test(expected=CeldaOcupadaException.class)
    public void testColocarAlgoFormerEnUnaCeldaOcupadaLanzaExcepcion(){
		AlgoFormer algoformer2 = new Decepticon("Ejemplo", 10, humanoide, alterna);
    	Posicion posicion = new Posicion(2,2);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	tablero.colocarAlgoformer(algoformer2, posicion);
    }
	
	@Test
    public void testMoverAlgoformer(){
    	Posicion posicion = new Posicion(1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	tablero.moverAlgoformer(algoformer, Movimiento.DERECHA);
    	Posicion posicionFinal = posicion.sumarMovimiento(Movimiento.DERECHA);
    	assertTrue(tablero.getPosicionAlgoformer(algoformer).equals(posicionFinal));
    }
	
	@Test(expected=PosicionInvalidaException.class)
    public void testMoverAlgoformerAPosicionInvalidaLanzaExcepcion(){
    	Posicion posicion= new Posicion(1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	assertTrue(tablero.getPosicionAlgoformer(algoformer).equals(posicion));
    	tablero.moverAlgoformer(algoformer, Movimiento.ARRIBA);
    }
	
	@Test(expected=CeldaOcupadaException.class)
    public void testMoverAlgoformerACeldaOcupadaLanzaExcepcion(){
    	Posicion posicion = new Posicion (1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	AlgoFormer nuevoAlgoformer = new Decepticon("Ejemplo", 10, humanoide, alterna);
    	Posicion nuevaPosicion = new Posicion(2,1);
    	tablero.colocarAlgoformer (nuevoAlgoformer, nuevaPosicion);
    	tablero.moverAlgoformer(nuevoAlgoformer, Movimiento.IZQUIERDA);
    }
	
	@Test
    public void testColocarChispaSupremaLaAgregaEnElMedio()
    {
    	tablero.colocarChispaSuprema();
    	Posicion medio = tablero.getMedio();
    	
    	assertTrue(tablero.posicionContieneChispaSuprema(medio));
    }
	
	@Test
    public void testAntesDeAgregarLaChispaElMedioEstaVacio()
    {
        Posicion medio = tablero.getMedio();
    	
    	assertFalse(tablero.posicionContieneChispaSuprema(medio));
    }
	
	@Test
    public void testPosicionEstaOcupada(){
    	Posicion posicion = new Posicion(1,1);
    	assertFalse(tablero.posicionEstaOcupada(posicion));
    	tablero.colocarAlgoformer(algoformer, posicion);
    	assertTrue(tablero.posicionEstaOcupada(posicion));
    }
	
	@Test()
    public void testPosicionContieneChispaSuprema(){
    	Posicion posicion = tablero.getMedio();
    	assertFalse(tablero.posicionContieneChispaSuprema(posicion));
    	tablero.colocarChispaSuprema();
    	assertTrue(tablero.posicionContieneChispaSuprema(posicion));
    }
	
	@Test
    public void testTableroCalculaCorrectamenteDistanciasEntreAlgoformers(){
		AlgoFormer algoformer2 = new Decepticon("Ejemplo", 10, humanoide, alterna);
		AlgoFormer algoformer3 = new Decepticon("Ejemplo", 10, humanoide, alterna);
    	Posicion posicion = new Posicion(1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	posicion = new Posicion(2,2);
    	tablero.colocarAlgoformer(algoformer2, posicion);
    	posicion = new Posicion(4,1);
    	tablero.colocarAlgoformer(algoformer3, posicion);
    	assertEquals(1, tablero.distanciaEntreAlgoformers(algoformer, algoformer2));
    	assertEquals(3, tablero.distanciaEntreAlgoformers(algoformer, algoformer3));
    	assertEquals(2, tablero.distanciaEntreAlgoformers(algoformer2, algoformer3));
    	assertEquals(0, tablero.distanciaEntreAlgoformers(algoformer, algoformer));
    }
}
