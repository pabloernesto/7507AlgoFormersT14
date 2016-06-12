package fiuba.algo3.algoformers.test;


import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;

import fiuba.algo3.algoformers.algoformers.*;
import fiuba.algo3.algoformers.escenario.*;
import fiuba.algo3.algoformers.excepciones.PosicionInvalidaException;

public class DecepticonInteractuaConTableroTest {

		private FormaHumanoide humanoide = new FormaHumanoide(1, 2, 3);
		private FormaAlterna alterna = new FormaAerea(3, 2, 1);
		private AutoBot decepticon;
		
		
		@Before
		public void setUp(){
			decepticon=null;
			decepticon = new AutoBot("decepticon", 10, humanoide, alterna);
			Tablero.reiniciarTablero();
			}
		
		@Test
		public void test01ColocarDecepticonEnTableroCorrectamente(){
			Tablero tablero= Tablero.getInstance();
			Posicion posicion = new Posicion (2,5);
			tablero.colocarAlgoformer(decepticon,posicion);
			Assert.assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(posicion));
			Assert.assertTrue(tablero.posicionEstaOcupada(posicion));
			}
		
		@Test()
		public void test02ColocarDecepticonEnTableroPosicionInvalida(){
			Tablero tablero= Tablero.getInstance();
			Posicion posicion = new Posicion (80,80);
			try{
			tablero.colocarAlgoformer(decepticon, posicion);
			}
			catch (PosicionInvalidaException e){
				Assert.assertEquals(tablero.getPosicionAlgoformer(decepticon),null);
			}
		}
		
		@Test
		public void test03MoverDecepticonEnTableroAPosicionValida(){
			Tablero tablero= Tablero.getInstance();
			Posicion posicion = new Posicion (2,5);
			tablero.colocarAlgoformer(decepticon,posicion);
			Assert.assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(posicion));
			tablero.moverAlgoformer(decepticon, Movimiento.ARRIBA);
			Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
			Assert.assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(nuevaPosicion));
			Assert.assertTrue(tablero.posicionEstaOcupada(nuevaPosicion));
			Assert.assertFalse(tablero.posicionEstaOcupada(posicion));
		}
		
		@Test(expected=PosicionInvalidaException.class)
		public void test04MoverDecepticonAPosicionInvalida(){
			Tablero tablero= Tablero.getInstance();
			Posicion posicion = new Posicion (1,1);
			tablero.colocarAlgoformer(decepticon,posicion);
			tablero.moverAlgoformer(decepticon, Movimiento.ARRIBA);
			tablero.moverAlgoformer(decepticon, Movimiento.ARRIBA);
		}
		
		@Test()
		public void test05MoverDecepticonTransformarDecepticonYMoverDecepticon(){
			Tablero tablero= Tablero.getInstance();
			Posicion posicion = new Posicion (2,5);
			tablero.colocarAlgoformer(decepticon,posicion);
			Assert.assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(posicion));
			tablero.moverAlgoformer(decepticon, Movimiento.ARRIBA);
			Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
			Assert.assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(nuevaPosicion));
			Assert.assertTrue(tablero.posicionEstaOcupada(nuevaPosicion));
			Assert.assertFalse(tablero.posicionEstaOcupada(posicion));
			decepticon.transformarse();
			Assert.assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(nuevaPosicion));
			tablero.moverAlgoformer(decepticon, Movimiento.ARRIBA);
			Posicion otraNuevaPosicion = nuevaPosicion.sumarMovimiento(Movimiento.ARRIBA);
			Assert.assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(otraNuevaPosicion));
			Assert.assertTrue(tablero.posicionEstaOcupada(otraNuevaPosicion));
			Assert.assertFalse(tablero.posicionEstaOcupada(nuevaPosicion));
			
		}
		
	

	
}
