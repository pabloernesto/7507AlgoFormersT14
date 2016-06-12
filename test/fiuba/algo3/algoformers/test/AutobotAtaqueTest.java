package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.*;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.excepciones.FriendlyFireException;

public class AutobotAtaqueTest {
	
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
	public void test10RecibirDanioDeUnDecepticonRestaVidaAmbosEnModoHumanoide(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void test11RecibirDanioDeOtroAutoBotNoRestaVidaAmbosEnModoHumanoide(){
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
	public void test12RecibirDanioDeUnDecepticonRestaVidaAmbosEnModoAlterno(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	autobot.transformarse();
	decepticon.transformarse();
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void test13RecibirDanioDeOtroAutoBotNoRestaVidaAmbosEnModoAlterno(){
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
	public void test14RecibirDanioDeUnDecepticonAlternoRestaVidaEstandoEnModoHumanoide(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	decepticon.transformarse();
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void test15RecibirDanioDeOtroAutoBotAlternoNoRestaVidaEstandoEnModoHumanoide(){
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
	public void test16RecibirDanioDeUnDecepticonHumanoideRestaVidaEstandoEnModoAlterno(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	autobot.transformarse();
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void test17RecibirDanioDeOtroAutoBotHumanoideNoRestaVidaEstandoEnModoAlterno(){
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
	public void test18AtacarnDecepticonLeRestaVidaAmbosEnModoHumanoide(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	int vidaAnterior = decepticon.getVida();
	autobot.atacarAlgoformer(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void test19AtacarAOtroAutoBotNoLeRestaVidaAmbosEnModoHumanoide(){
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
	public void test20AtacarAUnDecepticonLeRestaVidaAmbosEnModoAlterno(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	autobot.transformarse();
	decepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	autobot.atacarAlgoformer(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void test21AtacarOtroAutoBotNoLeRestaVidaAmbosEnModoAlterno(){
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
	public void test22AtacarAUnDecepticonAlternoLeRestaVidaEstandoEnModoHumanoide(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	decepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	autobot.atacarAlgoformer(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void test23AtacarAOtroAutoBotAlternoNoLeRestaVidaEstandoEnModoHumanoide(){
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
	public void test24AtacarAUnDecepticonHumanoideLeRestaVidaEstandoEnModoAlterno(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	autobot.transformarse();
	int vidaAnterior = decepticon.getVida();
	autobot.atacarAlgoformer(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void test25AtacarAOtroAutoBotHumanoideNoLeRestaVidaEstandoEnModoAlterno(){
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
