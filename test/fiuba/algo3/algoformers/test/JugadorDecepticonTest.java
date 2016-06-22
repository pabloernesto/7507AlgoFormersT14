package fiuba.algo3.algoformers.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;


import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.BonusNuloFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;
import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Forma;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.bonus.DobleCanion;
import fiuba.algo3.algoformers.excepciones.*;

import java.util.List;
import java.lang.NullPointerException;

public class JugadorDecepticonTest {
    
	private Jugador jugador;
	
    @Before
    public void setUp(){
        jugador = new Jugador(new DecepticonFactory(), "Nombre");
        Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
        Tablero.setGeneradorDeBonus(new BonusNuloFactory());
    }
    
    @After
    public void tearDown(){
    	Tablero.reiniciarTablero();
    }
    
    @Test(expected = NullPointerException.class)
    public void test01AtacarSinElegirAlgoFormerCausaExcepcion(){
        jugador = new Jugador(new DecepticonFactory(), "Nombre");
        List<AlgoFormer> equipo = jugador.getListaAlgoformers();
        jugador.atacar(equipo.get(0));
	}
	
	@Test
    public void test02AtacarHaceQueElAlgoFormerActualAtaque(){
		Jugador jugador2 = new Jugador(new AutoBotFactory(), "Nombre");
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
	public void test03AtacarAAlgunAgoformerPropioLanzaException(){
        jugador.elegirAlgoFormer("Bonecrusher");  
        Tablero tablero = Tablero.getInstance();
        AlgoFormer objetivo = jugador.getAlgoformerElegido();
        Posicion posicionInicial = new Posicion(5,5);
        tablero.colocarAlgoformer(jugador.getAlgoformerElegido(),posicionInicial);
        jugador.atacar(objetivo);
	}
	
	@Test
    public void test04MoverHaceQueElAlgoFormerActualSeMueva(){
        jugador.elegirAlgoFormer("Bonecrusher");
        Tablero tablero = Tablero.getInstance();
        Posicion posicionInicial = new Posicion(5,5);
        tablero.colocarAlgoformer(jugador.getAlgoformerElegido(),posicionInicial);
        jugador.mover(Movimiento.IZQUIERDA);
        assertTrue(tablero.getPosicionAlgoformer(jugador.getAlgoformerElegido())!=posicionInicial);
	}

	
	@Test
    public void test05TransformarHaceQueElAlgoFormerActualSeTransforme(){
        jugador.elegirAlgoFormer("Bonecrusher");
        Forma formaInicial=jugador.getAlgoformerElegido().getEstadoActivo();
        jugador.transformar();
        assertTrue(jugador.getAlgoformerElegido().getEstadoActivo()!=formaInicial);
	}
	
	
	@Test(expected=NoEstaCombinadoException.class)
    public void test06DesombinarseSinEstarCombinadoLanzaExcepcion(){
		Jugador jugador = new Jugador(new DecepticonFactory(), "Nombre");
		jugador.descombinar();
    }
	
	
	@Test(expected=AlgoformerMuyLejosException.class)
	public void test07CombinarseEstandoFueraRangoDeRangoLanzaExcepcion(){
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
	public void test08CombinarseSinEquipoCompletoLanzaExcepcion(){
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
	public void test09DescombinarseSinSuficienteEspacioLanzaExcepcion(){
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
	public void test10CombinarseEstandoEnRangoEIntentarVolverACombinarseLanzaExcepcion(){
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
	public void test11Descombinarse(){
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Tablero tablero = Tablero.getInstance();
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
	
	@Test
	public void test12CombinarseHacePerdeLosBonus(){
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Jugador jugador = juego.jugadorInactivo();
		jugador.iniciarTurno();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer algoformer = jugador.getListaAlgoformers().get(0);
		Posicion posicionAlgoformer = tablero.getPosicionAlgoformer(algoformer);
		Posicion posicionBonus = posicionAlgoformer.sumarMovimiento(Movimiento.IZQUIERDA);
		tablero.getCelda(posicionBonus).setBonus(new DobleCanion()); //El capitan agarra un doble canion
		algoformer.moverse(Movimiento.IZQUIERDA);
		List<AlgoFormer> integrantes = jugador.getListaAlgoformers();
		jugador.combinar();
		
		AlgoFormer combinado = jugador.getListaAlgoformers().get(0);
		
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer menasorOriginal = factory.crearCombinado(integrantes);
		
		assertEquals(menasorOriginal.getAtaque(), combinado.getAtaque());
	}
	
	@Test
	public void test13DescombinarseHacerPerderLosBonus(){
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = juego.jugadorInactivo();
		jugador.iniciarTurno();
		List<AlgoFormer> integrantesAnteriores = jugador.getListaAlgoformers();
		jugador.combinar();
		AlgoFormer combinado = jugador.getListaAlgoformers().get(0);
		Posicion posicionCombinado = tablero.getPosicionAlgoformer(combinado);
		Posicion posicionBonus = posicionCombinado.sumarMovimiento(Movimiento.IZQUIERDA);
		tablero.getCelda(posicionBonus).setBonus(new DobleCanion()); //Setea el bonus
		combinado.moverse(Movimiento.IZQUIERDA); //Agarra el bonus
		jugador.descombinar();
		for (int i = 0 ; i < 3 ; i++){
			AlgoFormer algoformerOriginal = integrantesAnteriores.get(i);
			AlgoFormer algoformerDescombinado = jugador.getListaAlgoformers().get(i);
			assertEquals(algoformerOriginal.getAtaque(), algoformerDescombinado.getAtaque());
		}
	}
}

