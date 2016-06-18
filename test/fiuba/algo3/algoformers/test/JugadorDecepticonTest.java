package fiuba.algo3.algoformers.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;


import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;
import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Forma;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.excepciones.*;

import java.util.List;
import java.lang.NullPointerException;

public class JugadorDecepticonTest {
    
	public Jugador jugador;
	
    @Before
    public void setUp(){
        jugador = new Jugador(new DecepticonFactory());
    }
    
    @After
    public void tearDown(){
    	Tablero.reiniciarTablero();
    }
    
    @Test(expected = NullPointerException.class)
    public void testAtacarSinElegirAlgoFormerCausaExcepcion(){
        jugador = new Jugador(new DecepticonFactory());
        List<AlgoFormer> equipo = jugador.getListaAlgoformers();
        jugador.atacar(equipo.get(0));
	}
	
	@Test
    public void testAtacarHaceQueElAlgoFormerActualAtaque(){
		Jugador jugador2 = new Jugador(new AutoBotFactory());
        jugador.elegirAlgoFormer("Bonecrusher");  
        jugador2.elegirAlgoFormer("Bumblebee");
        Tablero tablero = Tablero.getInstance();
        AlgoFormer objetivo = jugador2.getAlgoformerElegido();
        Posicion posicionInicial = new Posicion(5,5);
        Posicion posicionInicialObjetivo = new Posicion(6,5);
        tablero.colocarAlgoformer(jugador.getAlgoformerElegido(),posicionInicial);
        tablero.colocarAlgoformer(jugador2.getAlgoformerElegido(), posicionInicialObjetivo);
        int vidaInicial = objetivo.getVida();
        jugador.atacar(objetivo);
        int ataque=jugador.getAlgoformerElegido().getAtaque();
        assertTrue(objetivo.getVida()<vidaInicial);
        assertTrue(objetivo.getVida()+ataque==vidaInicial);
	}

	@Test(expected=FuegoAmigoException.class)
	public void testAtacarAAlgunAgoformerPropioLanzaException(){
        jugador.elegirAlgoFormer("Bonecrusher");  
        Tablero tablero = Tablero.getInstance();
        AlgoFormer objetivo = jugador.getAlgoformerElegido();
        Posicion posicionInicial = new Posicion(5,5);
        tablero.colocarAlgoformer(jugador.getAlgoformerElegido(),posicionInicial);
        jugador.atacar(objetivo);
	}
	
	@Test
    public void testMoverHaceQueElAlgoFormerActualSeMueva(){
        jugador.elegirAlgoFormer("Bonecrusher");
        Tablero tablero = Tablero.getInstance();
        Posicion posicionInicial = new Posicion(5,5);
        tablero.colocarAlgoformer(jugador.getAlgoformerElegido(),posicionInicial);
        jugador.mover(Movimiento.IZQUIERDA);
        assertTrue(tablero.getPosicionAlgoformer(jugador.getAlgoformerElegido())!=posicionInicial);
	}

	
	@Test
    public void testTransformarHaceQueElAlgoFormerActualSeTransforme(){
        jugador.elegirAlgoFormer("Bonecrusher");
        Forma formaInicial=jugador.getAlgoformerElegido().getEstadoActivo();
        jugador.transformar();
        assertTrue(jugador.getAlgoformerElegido().getEstadoActivo()!=formaInicial);
	}
	
	
	@Test(expected=NoEstaCombinadoException.class)
    public void testDesombinarseSinEstarCombinadoLanzaExcepcion(){
		Jugador jugador = new Jugador(new DecepticonFactory());
		jugador.descombinar();
    }
	
	
	@Test(expected=AlgoformerMuyLejosException.class)
	public void testCombinarseEstandoFueraRangoDeRangoLanzaExcepcion(){
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Jugador jugador = juego.jugadorActual();
		AlgoFormer algoformer = jugador.getListaAlgoformers().get(0);
		algoformer.transformarse();
		for (int i = 0 ; i < algoformer.getVelocidad() ; i++)
			algoformer.moverse(Movimiento.DERECHA);
		jugador.combinar();
	}
	
	
	@Test(expected=EquipoIncompletoException.class)
	public void testCombinarseSinEquipoCompletoLanzaExcepcion(){
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Jugador jugador = juego.jugadorActual();
		AlgoFormer algoformer = jugador.getListaAlgoformers().get(1);
		jugador.getListaAlgoformers().remove(algoformer); //Saco a un algoformer del equipo
		Tablero tablero = Tablero.getInstance();
		tablero.borrarAlgoformer(algoformer); //Borro al algoformer del mapa
		jugador.combinar();
	}
	
	
	@Test(expected=SinLugarParaDescombinarseException.class)
	public void testDescombinarseSinSuficienteEspacioLanzaExcepcion(){
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Jugador jugador = juego.jugadorActual();
		AlgoFormer algoformer = jugador.getListaAlgoformers().get(0);
		jugador.combinar();
		AlgoFormer combinado = jugador.getListaAlgoformers().get(0);
		Tablero tablero = Tablero.getInstance();
		tablero.borrarAlgoformer(combinado);
		tablero.colocarAlgoformer(combinado, new Posicion(1,1)); //Pongo al combinado en una esquina
																//por lo que hay 3 lugares libres alrededor
		tablero.colocarAlgoformer(algoformer, new Posicion(1, 2)); //Coloco un algoformer al lado, entonces quedan 2 lugares libres
		jugador.descombinar();
		
	}
	
	@Test(expected=YaEstaCombinadoException.class)
	public void testCombinarseEstandoEnRangoEIntentarVolverACombinarseLanzaExcepcion(){
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Jugador jugador = juego.jugadorActual();
		List<AlgoFormer> autobots = jugador.getListaAlgoformers();
		Tablero tablero = Tablero.getInstance();
		Posicion posicionCapitan = tablero.getPosicionAlgoformer(autobots.get(0));
		jugador.combinar();
		for (AlgoFormer algoformer : autobots)
			assertNull(tablero.getPosicionAlgoformer(algoformer)); //No estan en el tablero
		List<AlgoFormer> combinado = jugador.getListaAlgoformers();
		assertEquals(1, combinado.size()); //el equipo lo conforma solo el combinado
		Posicion posicionCombinado = tablero.getPosicionAlgoformer(combinado.get(0));
		assertNotNull(posicionCombinado); //el combinado esta en el tablero
		assertTrue(posicionCapitan.equals(posicionCombinado)); //el combinado es colocado donde estaba el capitan
		jugador.combinar(); //esto lanza la excepcion
	}
	
	
	@Test
	public void testDescombinarse(){
        Tablero tablero = Tablero.getInstance();
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Jugador jugador = juego.jugadorActual();
        
		jugador.combinar();
        
        Posicion posicionCombinado =
            tablero.getPosicionAlgoformer(jugador.getListaAlgoformers().get(0));
        List<Posicion> posicionesLibresAntes =
            tablero.movimientosValidos(posicionCombinado);
        
		jugador.descombinar();
        
        List<Posicion> posicionesLibresDespues = tablero.movimientosValidos(posicionCombinado);
        
        assertEquals(posicionesLibresDespues.size(),posicionesLibresAntes.size() - 3);
	}
}

