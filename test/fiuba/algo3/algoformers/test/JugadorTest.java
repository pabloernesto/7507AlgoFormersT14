package fiuba.algo3.algoformers.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

//import org.mockito.*;
//import static org.mockito.Mockito.*;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.excepciones.AlgoformerMuyLejosException;
import fiuba.algo3.algoformers.excepciones.EquipoIncompletoException;
import fiuba.algo3.algoformers.excepciones.NoEstaCombinadoException;
import fiuba.algo3.algoformers.excepciones.SinLugarParaDescombinarseException;
import fiuba.algo3.algoformers.excepciones.YaEstaCombinadoException;

import java.util.List;
import java.lang.NullPointerException;

public class JugadorTest
{
    @Mock protected AlgoFormer algoformerActual;
    @InjectMocks Jugador jugador;
    
    @Before
    public void setUp()
    {
        jugador = new Jugador(new AutoBotFactory());
    }
    
    @After
    public void tearDown(){
    	Tablero.reiniciarTablero();
    }
    
    @Test(expected = NullPointerException.class)
    public void testAtacarSinElegirAlgoFormerCausaExcepcion()
    {
        jugador = new Jugador(new AutoBotFactory());

        List<AlgoFormer> equipo = jugador.getListaAlgoformers();
        jugador.atacar(equipo.get(0));
	}
	
	@Test
    public void testAtacarHaceQueElAlgoFormerActualAtaque()
    {
        jugador.elegirAlgoFormer("Optimus Prime");
        MockitoAnnotations.initMocks(this);
        
        AlgoFormer objetivo = jugador.getListaAlgoformers().get(0);
        jugador.atacar(objetivo);
        
        verify(algoformerActual).atacar(objetivo);
	}

	@Test
    public void testMoverHaceQueElAlgoFormerActualSeMueva()
    {
        jugador.elegirAlgoFormer("Optimus Prime");
        MockitoAnnotations.initMocks(this);
        
        jugador.mover(Movimiento.DERECHA);
        
        verify(algoformerActual).moverse(Movimiento.DERECHA);
	}

	@Test
    public void testTransformarHaceQueElAlgoFormerActualSeTransforme()
    {
        jugador.elegirAlgoFormer("Optimus Prime");
        MockitoAnnotations.initMocks(this);
        
        jugador.transformar();
        
        verify(algoformerActual).transformarse();
	}
	
	@Test(expected=NoEstaCombinadoException.class)
    public void testDesombinarseSinEstarCombinadoLanzaExcepcion()
    {
		Jugador jugador = new Jugador(new AutoBotFactory());
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
		Juego juego = new Juego();
		juego.inicializarSinAleatoridad();
		Jugador jugador = juego.jugadorActual();
		jugador.combinar();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer combinado = jugador.getListaAlgoformers().get(0);
		Posicion posicionCombinado = tablero.getPosicionAlgoformer(combinado);
		List<Posicion> posicionesLibresAntes = tablero.posicionesAdyacentesLibres(posicionCombinado);
		jugador.descombinar();
		List<Posicion> posicionesLibresDespues = tablero.posicionesAdyacentesLibres(posicionCombinado);
		assertEquals(posicionesLibresDespues.size(), posicionesLibresAntes.size() - 3);
	}
}

