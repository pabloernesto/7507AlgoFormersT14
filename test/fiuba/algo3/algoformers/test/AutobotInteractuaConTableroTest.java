package fiuba.algo3.algoformers.test;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import fiuba.algo3.algoformers.algoformers.*;
import fiuba.algo3.algoformers.escenario.*;
import fiuba.algo3.algoformers.excepciones.PosicionInvalidaException;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;

public class AutobotInteractuaConTableroTest {

	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private AutoBot autobot;
	private Tablero tablero;
	
	
	@Before
	public void setUp(){
		autobot = autobotFactory.crearOptimusPrime();
		Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
		tablero = Tablero.getInstance();
	}
	
	@After
	public void tearDown(){
		Tablero.reiniciarTablero();
	}
	
	@Test
	public void test01ColocarAutobotEnTableroCorrectamente(){
		Posicion posicion = new Posicion (2,5);
		tablero.colocarAlgoformer(autobot,posicion);
		Assert.assertTrue(tablero.getPosicionAlgoformer(autobot).equals(posicion));
		Assert.assertTrue(tablero.posicionEstaOcupada(posicion));
	}
	
	@Test(expected=PosicionInvalidaException.class)
	public void test02ColocarAutobotEnTableroPosicionInvalida(){
		Posicion posicion = new Posicion (80,80);
		try{
			tablero.colocarAlgoformer(autobot, posicion);
		}
		catch (PosicionInvalidaException e){
			Assert.assertEquals(tablero.getPosicionAlgoformer(autobot),null);
			throw e;
		}
	}
	
	@Test
	public void test03MoverAutobotEnTableroAPosicionValida(){
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
		Posicion posicion = new Posicion (1,1);
		tablero.colocarAlgoformer(autobot,posicion);
		tablero.moverAlgoformer(autobot, Movimiento.ARRIBA);
		tablero.moverAlgoformer(autobot, Movimiento.ARRIBA);
	}
	
	@Test
	public void test05MoverAutobotTransformarAutobotYMoverAutobot(){
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