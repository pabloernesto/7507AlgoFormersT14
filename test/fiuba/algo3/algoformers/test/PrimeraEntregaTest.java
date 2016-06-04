package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.UnidadAerea;
import fiuba.algo3.algoformers.algoformers.UnidadAlterna;
import fiuba.algo3.algoformers.algoformers.UnidadHumanoide;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.excepciones.FueraDeAlcanceException;

public class PrimeraEntregaTest {
	
	private UnidadHumanoide humanoide = new UnidadHumanoide(1, 2, 3);
	private UnidadAlterna alterna = new UnidadAerea(4, 5, 6);
	private AutoBot autobot;
	private Decepticon decepticon;
	private Tablero tablero;
	
	@Before
	public void setUp(){
		autobot = new AutoBot("autobot", 50, humanoide, alterna);
		decepticon = new Decepticon("decepticon", 40, humanoide, alterna);
		tablero = Tablero.getInstance();
	}
	
	@After
	public void tearDown(){
		Tablero.reiniciarTablero();
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test01AColocarAutoBotHumanoideMoverYVerificarPosicion(){
		Posicion posicion = new Posicion(5,5);
		tablero.colocarAlgoformer(autobot, posicion);
		for (int i = 0 ; i < autobot.getVelocidad() ; i++){
			autobot.moverse(Movimiento.ABAJO);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
			assertTrue(tablero.getPosicionAlgoformer(autobot).equals(posicion));
		}
		try {
			autobot.moverse(Movimiento.ABAJO);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test01BColocarDecepticonHumanoideMoverYVerificarPosicion(){
		Posicion posicion = new Posicion(5,5);
		tablero.colocarAlgoformer(decepticon, posicion);
		for (int i = 0 ; i < decepticon.getVelocidad() ; i++){
			decepticon.moverse(Movimiento.ABAJO);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
			assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(posicion));
		}
		try {
			decepticon.moverse(Movimiento.ABAJO);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}
	
	@Test
	public void test02AAutoBotTransformarseEnAlternoYVolverATransformarseAHumanoide(){
		Posicion posicion = new Posicion(5,5);
		tablero.colocarAlgoformer(autobot, posicion);
		assertEquals(autobot.getAtaque(), 1);
		autobot.transformarse();
		assertEquals(autobot.getAtaque(), 4);
		autobot.transformarse();
		assertEquals(autobot.getAtaque(), 1);
	}
	
	@Test
	public void test02BDecepticonTransformarseEnAlternoYVolverATransformarseAHumanoide(){
		Posicion posicion = new Posicion(5,5);
		tablero.colocarAlgoformer(decepticon, posicion);
		assertEquals(decepticon.getAtaque(), 1);
		decepticon.transformarse();
		assertEquals(decepticon.getAtaque(), 4);
		decepticon.transformarse();
		assertEquals(decepticon.getAtaque(), 1);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test03AColocarAutoBotAlternoMoverYVerificarPosicion(){
		Posicion posicion = new Posicion(5,5);
		tablero.colocarAlgoformer(autobot, posicion);
		autobot.transformarse();
		for (int i = 0 ; i < autobot.getVelocidad() ; i++){
			autobot.moverse(Movimiento.ABAJO);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
			assertTrue(tablero.getPosicionAlgoformer(autobot).equals(posicion));
		}
		try {
			autobot.moverse(Movimiento.ABAJO);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test03BColocarDecepticonAlternoMoverYVerificarPosicion(){
		Posicion posicion = new Posicion(5,5);
		tablero.colocarAlgoformer(decepticon, posicion);
		for (int i = 0 ; i < decepticon.getVelocidad() ; i++){
			decepticon.moverse(Movimiento.ARRIBA);
			posicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
			assertTrue(tablero.getPosicionAlgoformer(decepticon).equals(posicion));
		}
		try {
			decepticon.moverse(Movimiento.ARRIBA);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}
	
	
	
	@Test
	public void test05AAutoBotPuedeAtacarDecepticonEstandoEnRango(){
		Posicion posicion = new Posicion(5,5);
		tablero.colocarAlgoformer(autobot, posicion);
		posicion = new Posicion(5,6);
		tablero.colocarAlgoformer(decepticon, posicion);
		
		int vidaAnterior = decepticon.getVida();
		autobot.atacar(decepticon);
		assertTrue(decepticon.getVida() == vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FueraDeAlcanceException.class)
	public void test05BAutoBotNoPuedeAtacarDecepticonSiNoEstanEnRango(){
		Posicion posicion = new Posicion(1,1);
		tablero.colocarAlgoformer(autobot, posicion);
		posicion = new Posicion(15,15);
		tablero.colocarAlgoformer(decepticon, posicion);
		
		int vidaAnterior = decepticon.getVida();
		try{
			autobot.atacar(decepticon);
		} catch (FueraDeAlcanceException e){
			assertTrue(decepticon.getVida() == vidaAnterior);
			throw e;
		}
	}
	
	@Test
	public void test05CDecepticonPuedeAtacarAutoBotEstandoEnRango(){
		Posicion posicion = new Posicion(5,5);
		tablero.colocarAlgoformer(decepticon, posicion);
		posicion = new Posicion(5,6);
		tablero.colocarAlgoformer(autobot, posicion);
		
		int vidaAnterior = autobot.getVida();
		decepticon.atacar(autobot);
		assertTrue(autobot.getVida() == vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FueraDeAlcanceException.class)
	public void test05DDecepticonNoPuedeAtacarAutoBotSiNoEstanEnRango(){
		Posicion posicion = new Posicion(1,1);
		tablero.colocarAlgoformer(decepticon, posicion);
		posicion = new Posicion(15,15);
		tablero.colocarAlgoformer(autobot, posicion);
		
		int vidaAnterior = autobot.getVida();
		try{
			decepticon.atacar(autobot);
		} catch (FueraDeAlcanceException e){
			assertTrue(autobot.getVida() == vidaAnterior);
			throw e;
		}
	}

}