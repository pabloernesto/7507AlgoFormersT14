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
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.excepciones.FriendlyFireException;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;

public class DecepticonTest {
	
	private FormaHumanoide humanoide = new FormaHumanoide(1, 2, 3);
	private FormaAlterna alterna = new FormaAerea(3, 2, 1);
	private Decepticon decepticon;
	private Celda celda;
	private Rocosa rocosa = new Rocosa();
	private Nube nube = new Nube();
	
	@Before
	public void setUp(){
		decepticon = new Decepticon("decepticon", 10, humanoide, alterna);
		celda = new Celda(new Rocosa(), new Nube());
	}
	
	@Test
	public void testAlgoformerSePuedeTransformarEnAmbosSentidosYCambiaElComportamiento(){
		assertEquals(1, decepticon.getAtaque()); //Se que el ataque es 1 porque lo declare arriba
		decepticon.transformarse();
		assertEquals(3, decepticon.getAtaque());
		decepticon.transformarse();
		assertEquals(1, decepticon.getAtaque());
	}
	
	@Test
	public void testEntrarACeldaReduceLaCantidadDeMovimientosRestantesEnModoHumanoide(){
		int movimientosRestantesAntes = decepticon.getMovimientosRestantes();
		decepticon.entrarACelda(celda);
		assertTrue(movimientosRestantesAntes > decepticon.getMovimientosRestantes());
	}
	
	@Test
	public void testEntrarACeldaReduceLaCantidadDeMovimientosRestantesEnModoAlterno(){
		decepticon.transformarse();
		int movimientosRestantesAntes = decepticon.getMovimientosRestantes();
		decepticon.entrarACelda(celda);
		assertTrue(movimientosRestantesAntes > decepticon.getMovimientosRestantes());
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void testNoSePuedeMoverMasQueLaCantidadDeCeldasIndicadasPorLaVelocidadEnModoHumanoide(){
		for (int i = 0 ; i < decepticon.getVelocidad() + 1 ; i++)
			decepticon.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void testNoSePuedeMoverMasQueLaCantidadDeCeldasIndicadasPorLaVelocidadEnModoAlterno(){
		decepticon.transformarse();
		for (int i = 0 ; i < decepticon.getVelocidad() + 1 ; i++)
			decepticon.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testDecepticonSePuedeMoverLaCantidadDeCasillerosIndicadaPorSuVelocidadEnModoHumanoide(){
		for (int i = 0 ; i < decepticon.getVelocidad() ; i++)
			decepticon.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testDecepticonSePuedeMoverLaCantidadDeCasillerosIndicadaPorSuVelocidadEnModoAlterno(){
		decepticon.transformarse();
		for (int i = 0 ; i < decepticon.getVelocidad() ; i++)
			decepticon.entrarACelda(new Celda(rocosa, nube));
	}
	
	@Test
	public void testReinicarMovimientosRestantesLosReiniciaEnModoHumanoide(){
		int movimientos = decepticon.getMovimientosRestantes();
		decepticon.entrarACelda(celda);
		assertTrue(movimientos > decepticon.getMovimientosRestantes());
		decepticon.reiniciarMovimientosRestantes();
		assertTrue(movimientos == decepticon.getMovimientosRestantes());
	}
	
	@Test
	public void testReinicarMovimientosRestantesLosReiniciaEnModoAlterno(){
		decepticon.transformarse();
		int movimientos = decepticon.getMovimientosRestantes();
		decepticon.entrarACelda(celda);
		assertTrue(movimientos > decepticon.getMovimientosRestantes());
		decepticon.reiniciarMovimientosRestantes();
		assertTrue(movimientos == decepticon.getMovimientosRestantes());
	}

	//Inicio pruebas recibirDanio
	
	@Test
	public void testRecibirDanioDeUnAutoBotRestaVidaAmbosEnModoHumanoide(){
	AutoBot autobot = new AutoBot("autobot", 20, humanoide, alterna);
	int vidaAnterior = decepticon.getVida();
	decepticon.recibirDanio(autobot, autobot.getAtaque());
	assertEquals(decepticon.getVida(), vidaAnterior - autobot.getAtaque());
	}
	
	@Test(expected=FriendlyFireException.class)
	public void testRecibirDanioDeOtroDecepticonNoRestaVidaAmbosEnModoHumanoide(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	int vidaAnterior = decepticon.getVida();
	try{
		decepticon.recibirDanio(otroDecepticon, otroDecepticon.getAtaque());
	} catch (FriendlyFireException e){
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
	
	@Test(expected=FriendlyFireException.class)
	public void testRecibirDanioDeOtroDecepticonNoRestaVidaAmbosEnModoAlterno(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	decepticon.transformarse();
	otroDecepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	try{
		decepticon.recibirDanio(otroDecepticon, otroDecepticon.getAtaque());
	} catch (FriendlyFireException e){
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
	
	@Test(expected=FriendlyFireException.class)
	public void testRecibirDanioDeOtroDecepticonAlternoNoRestaVidaEstandoEnModoHumanoide(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	otroDecepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	try{
		decepticon.recibirDanio(otroDecepticon, otroDecepticon.getAtaque());
	} catch (FriendlyFireException e){
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
	
	@Test(expected=FriendlyFireException.class)
	public void testRecibirDanioDeOtroDecepticonHumanoideNoRestaVidaEstandoEnModoAlterno(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	decepticon.transformarse();
	int vidaAnterior = decepticon.getVida();
	try{
		decepticon.recibirDanio(otroDecepticon, otroDecepticon.getAtaque());
	} catch (FriendlyFireException e){
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
	
	@Test(expected=FriendlyFireException.class)
	public void testAtacarAOtroDecepticonNoLeRestaVidaAmbosEnModoHumanoide(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.atacarAlgoformer(otroDecepticon);
	} catch (FriendlyFireException e){
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
	
	@Test(expected=FriendlyFireException.class)
	public void testAtacarOtroDecepticonNoLeRestaVidaAmbosEnModoAlterno(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	decepticon.transformarse();
	otroDecepticon.transformarse();
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.atacarAlgoformer(otroDecepticon);
	} catch (FriendlyFireException e){
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
	
	@Test(expected=FriendlyFireException.class)
	public void testAtacarAOtroDecepticonAlternoNoLeRestaVidaEstandoEnModoHumanoide(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	otroDecepticon.transformarse();
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.atacarAlgoformer(otroDecepticon);
	} catch (FriendlyFireException e){
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
	
	@Test(expected=FriendlyFireException.class)
	public void testAtacarAOtroDecepticonHumanoideNoLeRestaVidaEstandoEnModoAlterno(){
	Decepticon otroDecepticon = new Decepticon("decepticon2", 20, humanoide, alterna);
	decepticon.transformarse();
	int vidaAnterior = otroDecepticon.getVida();
	try{
		decepticon.atacarAlgoformer(otroDecepticon);
	} catch (FriendlyFireException e){
		assertEquals(otroDecepticon.getVida(), vidaAnterior);
		throw e;
	}
	}
	
}