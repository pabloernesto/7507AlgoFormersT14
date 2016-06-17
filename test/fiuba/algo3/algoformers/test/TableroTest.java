package fiuba.algo3.algoformers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.*;
import fiuba.algo3.algoformers.escenario.*;
import fiuba.algo3.algoformers.excepciones.*;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.BonusNuloFactory;
import fiuba.algo3.algoformers.factories.CeldaFactory;
import fiuba.algo3.algoformers.factories.CeldaRandomFactory;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;

public class TableroTest {
	
	private Tablero tablero;
	private AutoBotFactory factory = new AutoBotFactory();
	private AlgoFormer algoformer = factory.crearOptimusPrime();
	private CeldaFactory generadorDeRocosaYNubes = new RocasYNubesFactory();
	
	@Before
	public void setUp(){
		Tablero.setGeneradorDeCeldas(generadorDeRocosaYNubes);
		Tablero.setGeneradorDeBonus(new BonusNuloFactory());
		tablero = Tablero.getInstance();
	}
	
	@After
	public void tearDown(){
		Tablero.reiniciarTablero();
	}

	@Test
	public void tableroEsRectangularDe60x20(){
		assertEquals(60, tablero.ancho());
		assertEquals(20, tablero.altura());
	}
	
	@Test
	public void tableroLlenaLasCeldasConSuperficiesAleatorias(){
		Tablero.setGeneradorDeCeldas(new CeldaRandomFactory());
		
		Tablero.reiniciarTablero();
		tablero = Tablero.getInstance();
		Celda celda1 = tablero.devolverPrimerCelda();
		
		Tablero.reiniciarTablero();
		tablero = Tablero.getInstance();
		Celda celda2 = tablero.devolverPrimerCelda();
		
		Tablero.reiniciarTablero();
		tablero = Tablero.getInstance();
		Celda celda3 = tablero.devolverPrimerCelda();
		
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimus1 = factory.crearOptimusPrime();
		AlgoFormer optimus2 = factory.crearOptimusPrime();
		AlgoFormer optimus3 = factory.crearOptimusPrime();
		
		boolean sonIguales = true;
		
		optimus1.entrarACelda(celda1);
		optimus2.entrarACelda(celda2);
		optimus3.entrarACelda(celda3);
		
		if (optimus1.getVida() != optimus2.getVida())
			sonIguales = false;
		
		if (optimus1.getMovimientosRestantes() != optimus2.getMovimientosRestantes())
			sonIguales = false;
	
		if (optimus1.getVida() != optimus3.getVida())
			sonIguales = false;
		
		if (optimus1.getMovimientosRestantes() != optimus3.getMovimientosRestantes())
			sonIguales = false;
		
		if (optimus2.getVida() != optimus3.getVida())
			sonIguales = false;
		
		if (optimus2.getMovimientosRestantes() != optimus3.getMovimientosRestantes())
			sonIguales = false;
		
		
		AlgoFormer ratchet1 = factory.crearRatchet();
		AlgoFormer ratchet2 = factory.crearRatchet();
		AlgoFormer ratchet3 = factory.crearRatchet();
		ratchet1.transformarse();
		ratchet2.transformarse();
		ratchet3.transformarse();
		
		celda1.desocuparCelda();
		celda2.desocuparCelda();
		celda3.desocuparCelda();
		ratchet1.entrarACelda(celda1);
		ratchet2.entrarACelda(celda2);
		ratchet3.entrarACelda(celda3);
		
		if (ratchet1.getAtaque() != ratchet2.getAtaque())
			sonIguales = false;
		
		if (ratchet1.getMovimientosRestantes() != ratchet2.getMovimientosRestantes())
			sonIguales = false;
	
		if (ratchet1.getAtaque() != ratchet3.getAtaque())
			sonIguales = false;
		
		if (ratchet1.getMovimientosRestantes() != ratchet3.getMovimientosRestantes())
			sonIguales = false;
		
		if (ratchet2.getAtaque() != ratchet3.getAtaque())
			sonIguales = false;
		
		if (ratchet2.getMovimientosRestantes() != ratchet3.getMovimientosRestantes())
			sonIguales = false;
		
		assertFalse(sonIguales);
	}
	
	@Test
    public void testColocarAlgoformerYObtenerPosicionDevuelveLaPosicionCorrecta(){
    	Posicion posicion = new Posicion(1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	assertTrue(tablero.getPosicionAlgoformer(algoformer).equals(posicion));
    }
	
	@Test
    public void testObtenerPosicionDeAlgoformerNoColocadoDevuelveNull(){
    	assertNull(tablero.getPosicionAlgoformer(algoformer));
    }
	
	@Test(expected=PosicionInvalidaException.class)
    public void testColocarAlgoFormerEnPosicionInvalidaLanzaExcepcion(){
    	Posicion posicion = new Posicion (-1,0);
    	tablero.colocarAlgoformer(algoformer, posicion);
    }
	
	@Test(expected=CeldaOcupadaException.class)
    public void testColocarAlgoFormerEnUnaCeldaOcupadaLanzaExcepcion(){
		AlgoFormer algoformer2 = factory.crearBumblebee();
    	Posicion posicion = new Posicion(2,2);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	tablero.colocarAlgoformer(algoformer2, posicion);
    }
	
	@Test
    public void testMoverAlgoformer(){
    	Posicion posicion = new Posicion(1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	tablero.moverAlgoformer(algoformer, Movimiento.DERECHA);
    	Posicion posicionFinal = posicion.sumarMovimiento(Movimiento.DERECHA);
    	assertTrue(tablero.getPosicionAlgoformer(algoformer).equals(posicionFinal));
    	assertTrue(tablero.posicionEstaOcupada(posicionFinal));
    	assertFalse(tablero.posicionEstaOcupada(posicion));
    }
	
	@Test(expected=PosicionInvalidaException.class)
    public void testMoverAlgoformerAPosicionInvalidaLanzaExcepcion(){
    	Posicion posicion= new Posicion(1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	assertTrue(tablero.getPosicionAlgoformer(algoformer).equals(posicion));
    	tablero.moverAlgoformer(algoformer, Movimiento.ARRIBA);
    }
	
	@Test(expected=CeldaOcupadaException.class)
    public void testMoverAlgoformerACeldaOcupadaLanzaExcepcion(){
    	Posicion posicion = new Posicion (1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	AlgoFormer nuevoAlgoformer = factory.crearBumblebee();
    	Posicion nuevaPosicion = new Posicion(2,1);
    	tablero.colocarAlgoformer (nuevoAlgoformer, nuevaPosicion);
    	tablero.moverAlgoformer(nuevoAlgoformer, Movimiento.IZQUIERDA);
    }
	
	@Test
    public void testColocarChispaSupremaLaAgregaEnElMedio()
    {
		Posicion posicion = new Posicion(10, 10);
    	tablero.colocarChispaSuprema(posicion);
    	
    	assertTrue(tablero.posicionContieneChispaSuprema(posicion));
    }
	
	@Test
    public void testAntesDeAgregarLaChispaElMedioEstaVacio()
    {
		int cuartoDeAncho = tablero.ancho() / 4;
		int tresCuartosDeAncho = cuartoDeAncho * 3;
		int cuartoDeAlto = tablero.altura() / 4;
		int tresCuartosDeAlto = cuartoDeAlto * 3;
		
		boolean estaLaChispa = false;
		for (int x = cuartoDeAncho ; x <= tresCuartosDeAncho ; x++){
			for (int y = cuartoDeAlto ; y <= tresCuartosDeAlto ; y++){
				Posicion posicion = new Posicion(x, y);
				if (tablero.posicionContieneChispaSuprema(posicion))
					estaLaChispa = true;
			}
		}
    	assertFalse(estaLaChispa);
    }
	
	@Test
    public void testPosicionEstaOcupada(){
    	Posicion posicion = new Posicion(1,1);
    	assertFalse(tablero.posicionEstaOcupada(posicion));
    	tablero.colocarAlgoformer(algoformer, posicion);
    	assertTrue(tablero.posicionEstaOcupada(posicion));
    }
	
	@Test
    public void testTableroCalculaCorrectamenteDistanciasEntreAlgoformers()
    {
    	Posicion posicion = new Posicion(1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	
		AlgoFormer algoformer2 = factory.crearBumblebee();
    	posicion = new Posicion(2,2);
    	tablero.colocarAlgoformer(algoformer2, posicion);
    	
		AlgoFormer algoformer3 = factory.crearRatchet();
    	posicion = new Posicion(4,1);
    	tablero.colocarAlgoformer(algoformer3, posicion);
    	
    	assertEquals(1,
    	    tablero.distancia(algoformer, algoformer2));
    	assertEquals(3,
    	    tablero.distancia(algoformer, algoformer3));
    	assertEquals(2,
    	    tablero.distancia(algoformer2, algoformer3));
    	assertEquals(0,
    	    tablero.distancia(algoformer, algoformer));
    }
	
	@Test
    public void testTableroBorrarAlgoformerLoBorraDelMapa(){
		Posicion posicion = new Posicion(1,1);
    	tablero.colocarAlgoformer(algoformer, posicion);
    	tablero.borrarAlgoformer(algoformer);
    	assertFalse(tablero.posicionEstaOcupada(posicion));
	}
	
	@Test
    public void testTableroConseguirMovimientosValidos(){
		tablero.colocarAlgoformer(algoformer, new Posicion(1, 2));
        List<Posicion> posicionesLibres =
            tablero.movimientosValidos(new Posicion(1,1));
		assertEquals(2, posicionesLibres.size());
		assertTrue(posicionesLibres.contains(new Posicion(2, 2)));
		assertTrue(posicionesLibres.contains(new Posicion(2, 1)));
	}
}
