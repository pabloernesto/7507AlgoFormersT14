package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;

import fiuba.algo3.algoformers.algoformers.*;
import fiuba.algo3.algoformers.escenario.*;
import fiuba.algo3.algoformers.escenario.superficies.*;
import fiuba.algo3.algoformers.excepciones.FriendlyFireException;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.excepciones.PosicionInvalidaException;

public class AutobotInteractuaConTableroTest {

	private FormaHumanoide humanoide = new FormaHumanoide(1, 2, 3);
	private FormaAlterna alterna = new FormaAerea(3, 2, 1);
	private AutoBot autobot;
	
	
	@Before
	public void setUp(){
		autobot=null;
		autobot = new AutoBot("autobot", 10, humanoide, alterna);
		Tablero.reiniciarTablero();
		}
	
	@Test
	public void test01ColocarAutobotEnTableroCorrectamente(){
		Tablero tablero= Tablero.getInstance();
		Posicion posicion = new Posicion (2,5);
		tablero.colocarAlgoformer(autobot,posicion);
		Assert.assertTrue(tablero.getPosicionAlgoformer(autobot).equals(posicion));
		Assert.assertTrue(tablero.posicionEstaOcupada(posicion));
		}
	
	@Test()
	public void test02ColocarAutobotEnTableroPosicionInvalida(){
		Tablero tablero= Tablero.getInstance();
		Posicion posicion = new Posicion (80,80);
		try{
		tablero.colocarAlgoformer(autobot, posicion);
		}
		catch (PosicionInvalidaException e){
			Assert.assertEquals(tablero.getPosicionAlgoformer(autobot),null);
		}
	}
	
	@Test
	public void test03MoverAutobotEnTableroAPosicionValida(){
		Tablero tablero= Tablero.getInstance();
		Posicion posicion = new Posicion (2,5);
		tablero.colocarAlgoformer(autobot,posicion);
		Assert.assertTrue(tablero.getPosicionAlgoformer(autobot).equals(posicion));
		tablero.moverAlgoformer(autobot, Movimiento.ARRIBA);
		Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
		Assert.assertTrue(tablero.getPosicionAlgoformer(autobot).equals(nuevaPosicion));
		Assert.assertTrue(tablero.posicionEstaOcupada(nuevaPosicion));
		Assert.assertFalse(tablero.posicionEstaOcupada(posicion));
	}
	
	@Test(expected=PosicionInvalidaException.class)
	public void test04MoverAutobotAPosicionInvalida(){
		Tablero tablero= Tablero.getInstance();
		Posicion posicion = new Posicion (1,1);
		tablero.colocarAlgoformer(autobot,posicion);
		tablero.moverAlgoformer(autobot, Movimiento.ARRIBA);
		tablero.moverAlgoformer(autobot, Movimiento.ARRIBA);
	}
	
	@Test()
	public void test05MoverAutobotTransformarAutobotYMoverAutobot(){
		Tablero tablero= Tablero.getInstance();
		Posicion posicion = new Posicion (2,5);
		tablero.colocarAlgoformer(autobot,posicion);
		Assert.assertTrue(tablero.getPosicionAlgoformer(autobot).equals(posicion));
		tablero.moverAlgoformer(autobot, Movimiento.ARRIBA);
		Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
		Assert.assertTrue(tablero.getPosicionAlgoformer(autobot).equals(nuevaPosicion));
		Assert.assertTrue(tablero.posicionEstaOcupada(nuevaPosicion));
		Assert.assertFalse(tablero.posicionEstaOcupada(posicion));
		autobot.transformarse();
		Assert.assertTrue(tablero.getPosicionAlgoformer(autobot).equals(nuevaPosicion));
		tablero.moverAlgoformer(autobot, Movimiento.ARRIBA);
		Posicion otraNuevaPosicion = nuevaPosicion.sumarMovimiento(Movimiento.ARRIBA);
		Assert.assertTrue(tablero.getPosicionAlgoformer(autobot).equals(otraNuevaPosicion));
		Assert.assertTrue(tablero.posicionEstaOcupada(otraNuevaPosicion));
		Assert.assertFalse(tablero.posicionEstaOcupada(nuevaPosicion));
		
	}
	
}
