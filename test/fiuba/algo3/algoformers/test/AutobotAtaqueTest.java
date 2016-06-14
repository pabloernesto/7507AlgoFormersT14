package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.*;
import fiuba.algo3.algoformers.excepciones.FuegoAmigoException;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class AutobotAtaqueTest {
	
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	private AutoBot autobot;

	@Before
	public void setUp(){
		autobot = autobotFactory.crearOptimusPrime();
	}

	@Test
	public void testRecibirDanioDeUnDecepticonRestaVidaAmbosEnModoHumanoide(){
	Decepticon decepticon = decepticonFactory.crearMegatron();
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroAutoBotNoRestaVidaAmbosEnModoHumanoide(){
	AutoBot otroAutobot = autobotFactory.crearBumblebee();
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
	Decepticon decepticon = decepticonFactory.crearMegatron();
	autobot.transformarse();
	decepticon.transformarse();
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroAutoBotNoRestaVidaAmbosEnModoAlterno(){
	AutoBot otroAutobot = autobotFactory.crearBumblebee();
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
	Decepticon decepticon = decepticonFactory.crearMegatron();
	decepticon.transformarse();
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroAutoBotAlternoNoRestaVidaEstandoEnModoHumanoide(){
	AutoBot otroAutobot = autobotFactory.crearBumblebee();
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
	Decepticon decepticon = decepticonFactory.crearMegatron();
	autobot.transformarse();
	int vidaAnterior = autobot.getVida();
	autobot.recibirDanio(decepticon, decepticon.getAtaque());
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroAutoBotHumanoideNoRestaVidaEstandoEnModoAlterno(){
	AutoBot otroAutobot = autobotFactory.crearBumblebee();
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
	
	//Inicio pruebas enviarRecibirDanio
	
	@Test
	public void testAtacarnDecepticonLeRestaVidaAmbosEnModoHumanoide(){
	Decepticon decepticon = decepticonFactory.crearMegatron();
	int vidaAnterior = decepticon.getVida();
	autobot.enviarRecibirDanio(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroAutoBotNoLeRestaVidaAmbosEnModoHumanoide(){
	AutoBot otroAutobot = autobotFactory.crearBumblebee();
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.enviarRecibirDanio(otroAutobot);
	} catch (FuegoAmigoException e){
		assertEquals(otroAutobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
	@Test
	public void testAtacarAUnDecepticonLeRestaVidaAmbosEnModoAlterno(){
	Decepticon decepticon = decepticonFactory.crearMegatron();
	autobot.transformarse();
	decepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	autobot.enviarRecibirDanio(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarOtroAutoBotNoLeRestaVidaAmbosEnModoAlterno(){
	AutoBot otroAutobot = autobotFactory.crearBumblebee();
	autobot.transformarse();
	otroAutobot.transformarse();
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.enviarRecibirDanio(otroAutobot);
	} catch (FuegoAmigoException e){
		assertEquals(otroAutobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
	@Test
	public void testAtacarAUnDecepticonAlternoLeRestaVidaEstandoEnModoHumanoide(){
	Decepticon decepticon = decepticonFactory.crearMegatron();
	decepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	autobot.enviarRecibirDanio(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroAutoBotAlternoNoLeRestaVidaEstandoEnModoHumanoide(){
	AutoBot otroAutobot = autobotFactory.crearBumblebee();
	otroAutobot.transformarse();
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.enviarRecibirDanio(otroAutobot);
	} catch (FuegoAmigoException e){
		assertEquals(otroAutobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
	@Test
	public void testAtacarAUnDecepticonHumanoideLeRestaVidaEstandoEnModoAlterno(){
	Decepticon decepticon = decepticonFactory.crearMegatron();
	autobot.transformarse();
	int vidaAnterior = decepticon.getVida();
	autobot.enviarRecibirDanio(decepticon);
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroAutoBotHumanoideNoLeRestaVidaEstandoEnModoAlterno(){
	AutoBot otroAutobot = autobotFactory.crearBumblebee();
	autobot.transformarse();
	int vidaAnterior = otroAutobot.getVida();
	try{
		autobot.enviarRecibirDanio(otroAutobot);
	} catch (FuegoAmigoException e){
		assertEquals(otroAutobot.getVida(), vidaAnterior);
		throw e;
		}
	}
	
}
