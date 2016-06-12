package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.excepciones.FuegoAmigoException;

public class DecepticonAtaqueTest {

	private FormaHumanoide humanoide = new FormaHumanoide(1, 2, 3);
	private FormaAlterna alterna = new FormaAerea(3, 2, 1);
	private Decepticon decepticon;
	
	@Before
	public void setUp(){
		decepticon = new Decepticon("decepticon", 10, humanoide, alterna);
	}
	
	@Test
	public void testRecibirDanioDeUnAutoBotRestaVidaAmbosEnModoHumanoide(){
	AutoBot autobot = new AutoBot("autobot", 20, humanoide, alterna);
	int vidaAnterior = decepticon.getVida();
	decepticon.recibirDanio(autobot, autobot.getAtaque());
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroDecepticonNoRestaVidaAmbosEnModoHumanoide(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
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
	AutoBot autobot = new AutoBot("autobot", 20, humanoide, alterna);
	decepticon.transformarse();
	autobot.transformarse();
	int vidaAnterior = decepticon.getVida();
	decepticon.recibirDanio(autobot, autobot.getAtaque());
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroDecepticonNoRestaVidaAmbosEnModoAlterno(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
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
	AutoBot autobot = new AutoBot("autobot", 20, humanoide, alterna);
	autobot.transformarse();
	int vidaAnterior = decepticon.getVida();
	decepticon.recibirDanio(autobot, autobot.getAtaque());
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroDecepticonAlternoNoRestaVidaEstandoEnModoHumanoide(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
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
	AutoBot autobot = new AutoBot("autobot", 20, humanoide, alterna);
	decepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	decepticon.recibirDanio(autobot, autobot.getAtaque());
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testRecibirDanioDeOtroDecepticonHumanoideNoRestaVidaEstandoEnModoAlterno(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
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
	
	//Inicio pruebas atacarAlgoformer
	
	@Test
	public void testAtacarnAutoBotLeRestaVidaAmbosEnModoHumanoide(){
	AutoBot autobot = new AutoBot("autobot", 20, humanoide, alterna);
	int vidaAnterior = autobot.getVida();
	decepticon.atacarAlgoformer(autobot);
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroDecepticonNoLeRestaVidaAmbosEnModoHumanoide(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.atacarAlgoformer(otroDecepticon);
	} catch (FuegoAmigoException e){
		assertEquals(otroDecepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
	@Test
	public void testAtacarAUnAutoBotLeRestaVidaAmbosEnModoAlterno(){
	AutoBot autobot = new AutoBot("autobot", 20, humanoide, alterna);
	decepticon.transformarse();
	autobot.transformarse();
	int vidaAnterior = autobot.getVida();
	decepticon.atacarAlgoformer(autobot);
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarOtroDecepticonNoLeRestaVidaAmbosEnModoAlterno(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	decepticon.transformarse();
	otroDecepticon.transformarse();
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.atacarAlgoformer(otroDecepticon);
	} catch (FuegoAmigoException e){
		assertEquals(otroDecepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
	@Test
	public void testAtacarAUnAutoBotAlternoLeRestaVidaEstandoEnModoHumanoide(){
	AutoBot autobot = new AutoBot("autobot", 20, humanoide, alterna);
	autobot.transformarse();
	int vidaAnterior = autobot.getVida();
	decepticon.atacarAlgoformer(autobot);
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroDecepticonAlternoNoLeRestaVidaEstandoEnModoHumanoide(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	otroDecepticon.transformarse();
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.atacarAlgoformer(otroDecepticon);
	} catch (FuegoAmigoException e){
		assertEquals(otroDecepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
	@Test
	public void testAtacarAUnAutoBotHumanoideLeRestaVidaEstandoEnModoAlterno(){
	AutoBot autobot = new AutoBot("autobot", 20, humanoide, alterna);
	decepticon.transformarse();
	int vidaAnterior = autobot.getVida();
	decepticon.atacarAlgoformer(autobot);
	assertEquals(autobot.getVida(), vidaAnterior - decepticon.getAtaque());
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAOtroDecepticonHumanoideNoLeRestaVidaEstandoEnModoAlterno(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	decepticon.transformarse();
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.atacarAlgoformer(otroDecepticon);
	} catch (FuegoAmigoException e){
		assertEquals(otroDecepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
}