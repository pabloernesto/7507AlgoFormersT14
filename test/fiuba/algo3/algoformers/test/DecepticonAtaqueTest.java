package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.excepciones.FuegoAmigoException;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class DecepticonAtaqueTest {

	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	private Decepticon decepticon;
	
	@Before
	public void setUp(){
		decepticon = decepticonFactory.crearMegatron();
	}
	
	@Test
	public void testRecibirDanioDeUnAutoBotRestaVidaAmbosEnModoHumanoide(){
	AutoBot autobot = autobotFactory.crearOptimusPrime();
	int vidaAnterior = decepticon.getVida();
	decepticon.recibirDanio(autobot, autobot.getAtaque());
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroDecepticonNoRestaVidaAmbosEnModoHumanoide(){
	Decepticon otroDecepticon = decepticonFactory.crearBonecrusher();
	int vidaAnterior = decepticon.getVida();
	try{
		decepticon.recibirDanio(otroDecepticon, otroDecepticon.getAtaque());
	} catch (FuegoAmigoException e){
		assertEquals(decepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
	@Test
	public void testRecibirDanioDeUnAutoBotRestaVidaAmbosEnModoAlterno(){
	AutoBot autobot = autobotFactory.crearOptimusPrime();
	decepticon.transformarse();
	autobot.transformarse();
	int vidaAnterior = decepticon.getVida();
	decepticon.recibirDanio(autobot, autobot.getAtaque());
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroDecepticonNoRestaVidaAmbosEnModoAlterno(){
	Decepticon otroDecepticon = decepticonFactory.crearBonecrusher();
	decepticon.transformarse();
	otroDecepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	try{
		decepticon.recibirDanio(otroDecepticon, otroDecepticon.getAtaque());
	} catch (FuegoAmigoException e){
		assertEquals(decepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
	@Test
	public void testRecibirDanioDeUnAutoBotAlternoRestaVidaEstandoEnModoHumanoide(){
	AutoBot autobot = autobotFactory.crearOptimusPrime();
	autobot.transformarse();
	int vidaAnterior = decepticon.getVida();
	decepticon.recibirDanio(autobot, autobot.getAtaque());
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroDecepticonAlternoNoRestaVidaEstandoEnModoHumanoide(){
	Decepticon otroDecepticon = decepticonFactory.crearBonecrusher();
	otroDecepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	try{
		decepticon.recibirDanio(otroDecepticon, otroDecepticon.getAtaque());
	} catch (FuegoAmigoException e){
		assertEquals(decepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
	@Test
	public void testRecibirDanioDeUnAutoBotHumanoideRestaVidaEstandoEnModoAlterno(){
	AutoBot autobot = autobotFactory.crearOptimusPrime();
	decepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	decepticon.recibirDanio(autobot, autobot.getAtaque());
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroDecepticonHumanoideNoRestaVidaEstandoEnModoAlterno(){
	Decepticon otroDecepticon = decepticonFactory.crearBonecrusher();
	decepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	try{
		decepticon.recibirDanio(otroDecepticon, otroDecepticon.getAtaque());
	} catch (FuegoAmigoException e){
		assertEquals(decepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
	//Fin pruebas recibirDanio
	
	//Inicio pruebas enviarRecibirDanio
	
	@Test
	public void testAtacarnAutoBotLeRestaVidaAmbosEnModoHumanoide(){
	AutoBot autobot = autobotFactory.crearOptimusPrime();
	int vidaAnterior = autobot.getVida();
	decepticon.enviarRecibirDanio(autobot);
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroDecepticonNoLeRestaVidaAmbosEnModoHumanoide(){
	Decepticon otroDecepticon = decepticonFactory.crearBonecrusher();
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.enviarRecibirDanio(otroDecepticon);
	} catch (FuegoAmigoException e){
		assertEquals(otroDecepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
	@Test
	public void testAtacarAUnAutoBotLeRestaVidaAmbosEnModoAlterno(){
	AutoBot autobot = autobotFactory.crearOptimusPrime();
	decepticon.transformarse();
	autobot.transformarse();
	int vidaAnterior = autobot.getVida();
	decepticon.enviarRecibirDanio(autobot);
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarOtroDecepticonNoLeRestaVidaAmbosEnModoAlterno(){
	Decepticon otroDecepticon = decepticonFactory.crearBonecrusher();
	decepticon.transformarse();
	otroDecepticon.transformarse();
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.enviarRecibirDanio(otroDecepticon);
	} catch (FuegoAmigoException e){
		assertEquals(otroDecepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
	@Test
	public void testAtacarAUnAutoBotAlternoLeRestaVidaEstandoEnModoHumanoide(){
	AutoBot autobot = autobotFactory.crearOptimusPrime();
	autobot.transformarse();
	int vidaAnterior = autobot.getVida();
	decepticon.enviarRecibirDanio(autobot);
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroDecepticonAlternoNoLeRestaVidaEstandoEnModoHumanoide(){
	Decepticon otroDecepticon = decepticonFactory.crearBonecrusher();
	otroDecepticon.transformarse();
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.enviarRecibirDanio(otroDecepticon);
	} catch (FuegoAmigoException e){
		assertEquals(otroDecepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
	@Test
	public void testAtacarAUnAutoBotHumanoideLeRestaVidaEstandoEnModoAlterno(){
	AutoBot autobot = autobotFactory.crearOptimusPrime();
	decepticon.transformarse();
	int vidaAnterior = autobot.getVida();
	decepticon.enviarRecibirDanio(autobot);
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroDecepticonHumanoideNoLeRestaVidaEstandoEnModoAlterno(){
	Decepticon otroDecepticon = decepticonFactory.crearBonecrusher();
	decepticon.transformarse();
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.enviarRecibirDanio(otroDecepticon);
	} catch (FuegoAmigoException e){
		assertEquals(otroDecepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
}
