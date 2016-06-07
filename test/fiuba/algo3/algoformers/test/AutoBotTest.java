package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.excepciones.FriendlyFireException;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;

public class AutoBotTest {
	
	private FormaHumanoide humanoide = new FormaHumanoide(1, 2, 3);
	private FormaAlterna alterna = new FormaAerea(3, 2, 1);
	private AutoBot autobot;
	
	@Before
	public void setUp(){
		autobot = new AutoBot("autobot", 10, humanoide, alterna);
	}
	
	@Test
	public void testAlgoformerSePuedeTransformarEnAmbosSentidosYCambiaElComportamiento(){
		assertEquals(1, autobot.getAtaque()); //Se que el ataque es 1 porque lo declare arriba
		autobot.transformarse();
		assertEquals(3, autobot.getAtaque());
		autobot.transformarse();
		assertEquals(1, autobot.getAtaque());
	}
	
	@Test
	public void testEntrarACeldaReduceLaCantidadDeMovimientosRestantesEnModoHumanoide(){
		int movimientosRestantesAntes = autobot.getMovimientosRestantes();
		autobot.entrarACelda(new Celda());
		assertTrue(movimientosRestantesAntes > autobot.getMovimientosRestantes());
	}
	
	@Test
	public void testEntrarACeldaReduceLaCantidadDeMovimientosRestantesEnModoAlterno(){
		autobot.transformarse();
		int movimientosRestantesAntes = autobot.getMovimientosRestantes();
		autobot.entrarACelda(new Celda());
		assertTrue(movimientosRestantesAntes > autobot.getMovimientosRestantes());
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void testNoSePuedeMoverMasQueLaCantidadDeCeldasIndicadasPorLaVelocidadEnModoHumanoide(){
		for (int i = 0 ; i < autobot.getVelocidad() + 1 ; i++)
			autobot.entrarACelda(new Celda());
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void testNoSePuedeMoverMasQueLaCantidadDeCeldasIndicadasPorLaVelocidadEnModoAlterno(){
		autobot.transformarse();
		for (int i = 0 ; i < autobot.getVelocidad() + 1 ; i++)
			autobot.entrarACelda(new Celda());
	}
	
	@Test
	public void testAutoBotSePuedeMoverLaCantidadDeCasillerosIndicadaPorSuVelocidadEnModoHumanoide(){
		for (int i = 0 ; i < autobot.getVelocidad() ; i++)
			autobot.entrarACelda(new Celda());
	}
	
	@Test
	public void testAutoBotSePuedeMoverLaCantidadDeCasillerosIndicadaPorSuVelocidadEnModoAlterno(){
		autobot.transformarse();
		for (int i = 0 ; i < autobot.getVelocidad() ; i++)
			autobot.entrarACelda(new Celda());
	}
	
	@Test
	public void testReinicarMovimientosRestantesLosReiniciaEnModoHumanoide(){
		int movimientos = autobot.getMovimientosRestantes();
		autobot.entrarACelda(new Celda());
		assertTrue(movimientos > autobot.getMovimientosRestantes());
		autobot.reiniciarMovimientosRestantes();
		assertTrue(movimientos == autobot.getMovimientosRestantes());
	}
	
	@Test
	public void testReinicarMovimientosRestantesLosReiniciaEnModoAlterno(){
		autobot.transformarse();
		int movimientos = autobot.getMovimientosRestantes();
		autobot.entrarACelda(new Celda());
		assertTrue(movimientos > autobot.getMovimientosRestantes());
		autobot.reiniciarMovimientosRestantes();
		assertTrue(movimientos == autobot.getMovimientosRestantes());
	}
	
	//Inicio pruebas recibirDanio
	
	@Test
	public void testRecibirDanioDeUnDecepticonRestaVidaAmbosEnModoHumanoide(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void testRecibirDanioDeOtroAutoBotNoRestaVidaAmbosEnModoHumanoide(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	int vidaAnterior = autobot.getVida();
	try{
		autobot.recibirDanio(otroAutobot, otroAutobot.getAtaque());
	} catch (FriendlyFireException e){
		assertEquals(autobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
	@Test
	public void testRecibirDanioDeUnDecepticonRestaVidaAmbosEnModoAlterno(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	autobot.transformarse();
	decepticon.transformarse();
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void testRecibirDanioDeOtroAutoBotNoRestaVidaAmbosEnModoAlterno(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	autobot.transformarse();
	otroAutobot.transformarse();
	int vidaAnterior = autobot.getVida();
	try{
		autobot.recibirDanio(otroAutobot, otroAutobot.getAtaque());
	} catch (FriendlyFireException e){
		assertEquals(autobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
	@Test
	public void testRecibirDanioDeUnDecepticonAlternoRestaVidaEstandoEnModoHumanoide(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	decepticon.transformarse();
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void testRecibirDanioDeOtroAutoBotAlternoNoRestaVidaEstandoEnModoHumanoide(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	otroAutobot.transformarse();
	int vidaAnterior = autobot.getVida();
	try{
		autobot.recibirDanio(otroAutobot, otroAutobot.getAtaque());
	} catch (FriendlyFireException e){
		assertEquals(autobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
	@Test
	public void testRecibirDanioDeUnDecepticonHumanoideRestaVidaEstandoEnModoAlterno(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	autobot.transformarse();
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void testRecibirDanioDeOtroAutoBotHumanoideNoRestaVidaEstandoEnModoAlterno(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	autobot.transformarse();
	int vidaAnterior = autobot.getVida();
	try{
		autobot.recibirDanio(otroAutobot, otroAutobot.getAtaque());
	} catch (FriendlyFireException e){
		assertEquals(autobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
	//Fin pruebas recibirDanio
	
	//Inicio pruebas atacarAlgoformer
	
	@Test
	public void testAtacarnDecepticonLeRestaVidaAmbosEnModoHumanoide(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	int vidaAnterior = decepticon.getVida();
	autobot.atacarAlgoformer(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void testAtacarAOtroAutoBotNoLeRestaVidaAmbosEnModoHumanoide(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.atacarAlgoformer(otroAutobot);
	} catch (FriendlyFireException e){
		assertEquals(otroAutobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
	@Test
	public void testAtacarAUnDecepticonLeRestaVidaAmbosEnModoAlterno(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	autobot.transformarse();
	decepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	autobot.atacarAlgoformer(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void testAtacarOtroAutoBotNoLeRestaVidaAmbosEnModoAlterno(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	autobot.transformarse();
	otroAutobot.transformarse();
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.atacarAlgoformer(otroAutobot);
	} catch (FriendlyFireException e){
		assertEquals(otroAutobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
	@Test
	public void testAtacarAUnDecepticonAlternoLeRestaVidaEstandoEnModoHumanoide(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	decepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	autobot.atacarAlgoformer(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void testAtacarAOtroAutoBotAlternoNoLeRestaVidaEstandoEnModoHumanoide(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	otroAutobot.transformarse();
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.atacarAlgoformer(otroAutobot);
	} catch (FriendlyFireException e){
		assertEquals(otroAutobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
	@Test
	public void testAtacarAUnDecepticonHumanoideLeRestaVidaEstandoEnModoAlterno(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	autobot.transformarse();
	int vidaAnterior = decepticon.getVida();
	autobot.atacarAlgoformer(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void testAtacarAOtroAutoBotHumanoideNoLeRestaVidaEstandoEnModoAlterno(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	autobot.transformarse();
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.atacarAlgoformer(otroAutobot);
	} catch (FriendlyFireException e){
		assertEquals(otroAutobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
}