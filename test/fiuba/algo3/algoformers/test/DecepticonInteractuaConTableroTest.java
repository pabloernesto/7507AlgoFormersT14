package fiuba.algo3.algoformers.test;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import fiuba.algo3.algoformers.algoformers.*;
import fiuba.algo3.algoformers.escenario.*;
import fiuba.algo3.algoformers.excepciones.PosicionInvalidaException;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;

public class DecepticonInteractuaConTableroTest {

	private FormaHumanoide humanoide = new FormaHumanoide(1, 2, 3);
	private FormaAlterna alterna = new FormaAerea(3, 2, 1);
	private Decepticon decepticon;
	private Tablero tablero;
	
	
	@Before
	public void setUp(){
		decepticon = new Decepticon("decepticon", 10, humanoide, alterna);
		Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
		tablero = Tablero.getInstance();
	}
	
	@After
	public void tearDown(){
		Tablero.reiniciarTablero();
	}
	
	@Test
	public void test01ColocarDecepticonEnTableroCorrectamente(){
		Posicion posicion = new Posicion (2,5);
		tablero.colocarAlgoformer(decepticon, posicion);
		assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(posicion));
		assertTrue(tablero.posicionEstaOcupada(posicion));
		}
	
	@Test(expected=PosicionInvalidaException.class)
	public void test02ColocarDecepticonEnTableroPosicionInvalida(){
		Posicion posicion = new Posicion (80,80);
		try{
			tablero.colocarAlgoformer(decepticon, posicion);
		}
		catch (PosicionInvalidaException e){
			assertEquals(tablero.getPosicionAlgoformer(decepticon), null);
			throw e;
		}
	}
	
	@Test
	public void test03MoverDecepticonEnTableroAPosicionValida(){
		Posicion posicion = new Posicion (2,5);
		tablero.colocarAlgoformer(decepticon,posicion);
		Assert.assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(posicion));
		tablero.moverAlgoformer(decepticon, Movimiento.ARRIBA);
		Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
		assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(nuevaPosicion));
		assertTrue(tablero.posicionEstaOcupada(nuevaPosicion));
		assertFalse(tablero.posicionEstaOcupada(posicion));
	}
	
	@Test(expected=PosicionInvalidaException.class)
	public void test04MoverDecepticonAPosicionInvalida(){
		Posicion posicion = new Posicion (1,1);
		tablero.colocarAlgoformer(decepticon,posicion);
		tablero.moverAlgoformer(decepticon, Movimiento.ARRIBA);
		tablero.moverAlgoformer(decepticon, Movimiento.ARRIBA);
	}
	
	@Test
	public void test05MoverDecepticonTransformarDecepticonYMoverDecepticon(){
		Posicion posicion = new Posicion (2,5);
		tablero.colocarAlgoformer(decepticon,posicion);
		assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(posicion));
		tablero.moverAlgoformer(decepticon, Movimiento.ARRIBA);
		Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
		assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(nuevaPosicion));
		assertTrue(tablero.posicionEstaOcupada(nuevaPosicion));
		assertFalse(tablero.posicionEstaOcupada(posicion));
		decepticon.transformarse();
		assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(nuevaPosicion));
		tablero.moverAlgoformer(decepticon, Movimiento.ARRIBA);
		Posicion otraNuevaPosicion = nuevaPosicion.sumarMovimiento(Movimiento.ARRIBA);
		assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(otraNuevaPosicion));
		assertTrue(tablero.posicionEstaOcupada(otraNuevaPosicion));
		assertFalse(tablero.posicionEstaOcupada(nuevaPosicion));
		
	}

}