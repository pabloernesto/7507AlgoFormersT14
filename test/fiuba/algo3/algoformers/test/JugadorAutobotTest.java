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
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.Forma;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.bonus.BurbujaInmaculada;
import fiuba.algo3.algoformers.escenario.bonus.DobleCanion;
import fiuba.algo3.algoformers.escenario.bonus.Flash;
import fiuba.algo3.algoformers.excepciones.*;

import java.util.List;
import java.lang.NullPointerException;

public class JugadorAutobotTest{
    
	private Jugador jugador;
	
    @Before
    public void setUp(){
        jugador = new Jugador(new AutoBotFactory(), "Nombre");
        Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
        Tablero.setGeneradorDeBonus(new BonusNuloFactory());
    }
    
    @After
    public void tearDown(){
    	Tablero.reiniciarTablero();
    }
    
    @Test(expected = NullPointerException.class)
    public void test01AtacarSinElegirAlgoFormerCausaExcepcion(){
        jugador = new Jugador(new AutoBotFactory(), "Nombre");
        List<AlgoFormer> equipo = jugador.getListaAlgoformers();
        jugador.atacar(equipo.get(0));
	}
	
	@Test
    public void test02AtacarHaceQueElAlgoFormerActualAtaque(){
		Jugador jugador2 = new Jugador(new DecepticonFactory(), "Nombre");
        jugador.elegirAlgoFormer("Optimus Prime");  
        jugador2.elegirAlgoFormer("Megatron");
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
        jugador.elegirAlgoFormer("Optimus Prime");  
        Tablero tablero = Tablero.getInstance();
        AlgoFormer objetivo = jugador.getAlgoformerElegido();
        Posicion posicionInicial = new Posicion(5,5);
        tablero.colocarAlgoformer(jugador.getAlgoformerElegido(),posicionInicial);
        jugador.atacar(objetivo);
	}
	
	@Test
    public void test04MoverHaceQueElAlgoFormerActualSeMueva(){
        jugador.elegirAlgoFormer("Optimus Prime");
        Tablero tablero = Tablero.getInstance();
        Posicion posicionInicial = new Posicion(5,5);
        tablero.colocarAlgoformer(jugador.getAlgoformerElegido(),posicionInicial);
        jugador.mover(Movimiento.IZQUIERDA);
        assertTrue(tablero.getPosicionAlgoformer(jugador.getAlgoformerElegido())!=posicionInicial);
	}

	
	@Test
    public void test05TransformarHaceQueElAlgoFormerActualSeTransforme(){
        jugador.elegirAlgoFormer("Optimus Prime");
        Forma formaInicial=jugador.getAlgoformerElegido().getEstadoActivo();
        jugador.transformar();
        assertTrue(jugador.getAlgoformerElegido().getEstadoActivo()!=formaInicial);
	}
	
	
	@Test(expected=NoEstaCombinadoException.class)
    public void test06DesombinarseSinEstarCombinadoLanzaExcepcion(){
		Jugador jugador = new Jugador(new AutoBotFactory(), "Nombre");
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
		Jugador jugador = juego.jugadorActual();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer algoformer = jugador.getListaAlgoformers().get(0);
		Posicion posicionAlgoformer = tablero.getPosicionAlgoformer(algoformer);
		Posicion posicionCanion = posicionAlgoformer.sumarMovimiento(Movimiento.ARRIBA_DERECHA);
		Posicion posicionFlash = posicionCanion.sumarMovimiento(Movimiento.ABAJO);
		Posicion posicionBurbuja = posicionFlash.sumarMovimiento(Movimiento.ABAJO);
		tablero.getCelda(posicionCanion).setBonus(new DobleCanion());
		tablero.getCelda(posicionFlash).setBonus(new Flash());
		tablero.getCelda(posicionBurbuja).setBonus(new BurbujaInmaculada());
		algoformer.moverse(Movimiento.ARRIBA_DERECHA);
		algoformer.finalizarTurno();
		algoformer.iniciarTurno();
		algoformer.moverse(Movimiento.ABAJO);
		algoformer.finalizarTurno();
		algoformer.iniciarTurno();
		algoformer.moverse(Movimiento.ABAJO);
		algoformer.finalizarTurno();
		algoformer.iniciarTurno();
		List<AlgoFormer> integrantes = jugador.getListaAlgoformers();
		jugador.combinar();
		
		AlgoFormer combinado = jugador.getListaAlgoformers().get(0);
		
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer superionOriginal = factory.crearCombinado(integrantes);
		
		assertEquals(superionOriginal.getAtaque(), combinado.getAtaque());
		assertEquals(superionOriginal.getMovimientosRestantes(), combinado.getMovimientosRestantes());
		
		DecepticonFactory decepticonFactory = new DecepticonFactory();
		Decepticon decepticon = decepticonFactory.crearMegatron();
		Posicion posicionCombinado = tablero.getPosicionAlgoformer(combinado);
		tablero.colocarAlgoformer(decepticon, posicionCombinado.sumarMovimiento(Movimiento.DERECHA));
		decepticon.atacar(combinado);
		assertTrue(combinado.getVida() < superionOriginal.getVida());
	}
	
	@Test
	public void test13DescombinarseHacerPerderLosBonus(){
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = juego.jugadorActual();
		List<AlgoFormer> integrantesAnteriores = jugador.getListaAlgoformers();
		jugador.combinar();
		AlgoFormer combinado = jugador.getListaAlgoformers().get(0);
		Posicion posicionCombinado = tablero.getPosicionAlgoformer(combinado);
		Posicion posicionCanion = posicionCombinado.sumarMovimiento(Movimiento.DERECHA);
		Posicion posicionFlash = posicionCanion.sumarMovimiento(Movimiento.DERECHA);
		Posicion posicionBurbuja = posicionFlash.sumarMovimiento(Movimiento.DERECHA);
		tablero.getCelda(posicionCanion).setBonus(new DobleCanion()); //Setea el bonus
		tablero.getCelda(posicionFlash).setBonus(new Flash());
		tablero.getCelda(posicionBurbuja).setBonus(new BurbujaInmaculada());
		combinado.moverse(Movimiento.DERECHA);
		combinado.finalizarTurno();
		combinado.iniciarTurno();
		combinado.moverse(Movimiento.DERECHA);
		combinado.finalizarTurno();
		combinado.iniciarTurno();
		combinado.moverse(Movimiento.DERECHA);
		combinado.finalizarTurno();
		combinado.iniciarTurno();
		posicionCombinado = tablero.getPosicionAlgoformer(combinado);
		jugador.descombinar();
		
		DecepticonFactory decepticonFactory = new DecepticonFactory();
		Decepticon decepticon = decepticonFactory.crearMegatron();
		tablero.colocarAlgoformer(decepticon, posicionCombinado);
		
		for (int i = 0 ; i < 3 ; i++){
			AlgoFormer algoformerOriginal = integrantesAnteriores.get(i);
			AlgoFormer algoformerDescombinado = jugador.getListaAlgoformers().get(i);
			assertEquals(algoformerOriginal.getAtaque(), algoformerDescombinado.getAtaque());
			assertEquals(algoformerOriginal.getMovimientosRestantes(), algoformerDescombinado.getMovimientosRestantes());
			
			int vidaOriginal = algoformerOriginal.getVida();
			decepticon.atacar(algoformerDescombinado);
			assertTrue(vidaOriginal > algoformerDescombinado.getVida());
		}
	}
	
	@Test
	public void test14VidaDeCombinadoEsSumatoriaDeIntegrantesYSeReparteEnPartesIgualesAlDescombinarse(){
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Jugador jugador = juego.jugadorActual();
		int vidaSumada = 0;
		for (AlgoFormer algoformer : jugador.getListaAlgoformers())
			vidaSumada += algoformer.getVida();
		jugador.combinar();
		int vidaCombinado = jugador.getListaAlgoformers().get(0).getVida();
		assertEquals(vidaSumada, vidaCombinado);
		jugador.descombinar();
		for (AlgoFormer algoformer : jugador.getListaAlgoformers())
			assertEquals(vidaCombinado / 3, algoformer.getVida());
	}

    @Test(expected = RuntimeException.class)
    public void testElegirAlgoFormerMientrasMoviendoCausaExcepcion()
    {
        Juego juego = new Juego();
        juego.crearJugadores("juan", "pedro");
        juego.inicializar();

        Jugador jugador = juego.jugadorActual();
        jugador.elegirAlgoFormer("Bumblebee");
        jugador.mover(Movimiento.DERECHA);

        jugador.elegirAlgoFormer("Ratchet");
    }
}

