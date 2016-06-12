package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.*;
import fiuba.algo3.algoformers.excepciones.FuegoAmigoException;

public class AutobotAtaqueTest {
	
	private FormaHumanoide humanoide = new FormaHumanoide(1, 2, 3);
	private FormaAlterna alterna = new FormaAerea(3, 2, 1);
	private AutoBot autobot;

	@Before
	public void setUp(){
		autobot = new AutoBot("autobot", 10, humanoide, alterna);
	}

	@Test
	public void testRecibirDanioDeUnDecepticonRestaVidaAmbosEnModoHumanoide(){
	Decepticon decepticon = new Decepticon("decepticon", 20, humanoide, alterna);
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroAutoBotNoRestaVidaAmbosEnModoHumanoide(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	int vidaAnterior = autobot.getVida();
	try{
		autobot.recibirDanio(otroAutobot, otroAutobot.getAtaque());
	} catch (FuegoAmigoException e){
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
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroAutoBotNoRestaVidaAmbosEnModoAlterno(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	autobot.transformarse();
	otroAutobot.transformarse();
	int vidaAnterior = autobot.getVida();
	try{
		autobot.recibirDanio(otroAutobot, otroAutobot.getAtaque());
	} catch (FuegoAmigoException e){
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
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroAutoBotAlternoNoRestaVidaEstandoEnModoHumanoide(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	otroAutobot.transformarse();
	int vidaAnterior = autobot.getVida();
	try{
		autobot.recibirDanio(otroAutobot, otroAutobot.getAtaque());
	} catch (FuegoAmigoException e){
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
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroAutoBotHumanoideNoRestaVidaEstandoEnModoAlterno(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	autobot.transformarse();
	int vidaAnterior = autobot.getVida();
	try{
		autobot.recibirDanio(otroAutobot, otroAutobot.getAtaque());
	} catch (FuegoAmigoException e){
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
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroAutoBotNoLeRestaVidaAmbosEnModoHumanoide(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.atacarAlgoformer(otroAutobot);
	} catch (FuegoAmigoException e){
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
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarOtroAutoBotNoLeRestaVidaAmbosEnModoAlterno(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	autobot.transformarse();
	otroAutobot.transformarse();
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.atacarAlgoformer(otroAutobot);
	} catch (FuegoAmigoException e){
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
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroAutoBotAlternoNoLeRestaVidaEstandoEnModoHumanoide(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	otroAutobot.transformarse();
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.atacarAlgoformer(otroAutobot);
	} catch (FuegoAmigoException e){
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
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroAutoBotHumanoideNoLeRestaVidaEstandoEnModoAlterno(){
	AutoBot otroAutobot = new AutoBot("autobot2", 20, humanoide, alterna);
	autobot.transformarse();
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.atacarAlgoformer(otroAutobot);
	} catch (FuegoAmigoException e){
		assertEquals(otroAutobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
}
