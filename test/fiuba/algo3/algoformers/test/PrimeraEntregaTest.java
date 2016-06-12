package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.excepciones.FueraDeAlcanceException;

public class PrimeraEntregaTest {
	
	private FormaHumanoide humanoide = new FormaHumanoide(1, 2, 3);
	private FormaAlterna alterna = new FormaAerea(4, 5, 6);
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
	public void test04AAutoBotPuedeAtacarDecepticonEstandoEnRango(){
		Juego juego = new Juego();
		
		assertNotNull(juego);
		
		juego.inicializar();
		Jugador jugador1 = juego.jugadorActual();
		Jugador jugador2 = juego.jugadorInactivo();
		
		assertNotNull(jugador1);
		assertNotNull(jugador2);
		
		List<AlgoFormer> equipo1 = jugador1.getListaAlgoformers();
		List<AlgoFormer> equipo2 = jugador2.getListaAlgoformers();
		
		
		//Veo que los algoformers de cada equipo esten juntos
		//Tambien veo que los equipos esten en extremos opuestos
		int alturaMedia = tablero.altura() / 2;
		int ancho = tablero.ancho();
		
		assertTrue(new Posicion(1, alturaMedia).equals
				(tablero.getPosicionAlgoformer(equipo1.get(0))));  //El algoformer del equipo 1 esta en el extremo izquierdo
		
		assertTrue(new Posicion(ancho, alturaMedia).equals
				(tablero.getPosicionAlgoformer(equipo2.get(0))));  //El algoformer del equipo 2 esta en el extremo derecho
		
		assertEquals(ancho - 1,
				tablero.distanciaEntreAlgoformers(equipo1.get(0), equipo2.get(0)));
		
		//Los algoformers del mismo equipo estan juntos
		assertEquals(1,
				tablero.distanciaEntreAlgoformers(equipo1.get(0), equipo1.get(1)));
	        
	    assertEquals(1,
	        	tablero.distanciaEntreAlgoformers(equipo1.get(1), equipo1.get(2)));
	        
	    assertEquals(1,
		        tablero.distanciaEntreAlgoformers(equipo2.get(0), equipo2.get(1)));
		        
		assertEquals(1,
		        tablero.distanciaEntreAlgoformers(equipo2.get(1), equipo2.get(2)));
		
		
		//Veo si esta la chispa
		int cuartoDeAncho = ancho / 4;
		int tresCuartosDeAncho = cuartoDeAncho * 3;
		int cuartoDeAlto = alturaMedia / 2;
		int tresCuartosDeAlto = cuartoDeAlto * 3;
		
		boolean estaLaChispa = false;
		for (int x = cuartoDeAncho ; x <= tresCuartosDeAncho ; x++){
			for (int y = cuartoDeAlto ; y <= tresCuartosDeAlto ; y++){
				Posicion posicion = new Posicion(x, y);
				if (tablero.posicionContieneChispaSuprema(posicion))
					estaLaChispa = true;
			}
		}
		assertTrue(estaLaChispa);
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