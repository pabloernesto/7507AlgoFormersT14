package fiuba.algo3.algoformers.juego;

import java.util.List;
import java.util.Random;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.BonusNuloFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class Juego {

	Tablero tablero;
	private static boolean hayGanador = false;
    
    private Jugador [] jugadores;
    private int jugadorActual;
    
	public Juego() {}
	
	public void inicializar()
	{
		tablero = Tablero.getInstance();
		inicializarJugadores();
		
		ubicarAlgoformers();
		ubicarChispaSuprema();
	}

    private void inicializarJugadores()
    {
        jugadores = new Jugador [2];
        jugadorActual = new Random().nextInt(2);

        jugadores[0] = new Jugador(new AutoBotFactory());
        jugadores[1] = new Jugador(new DecepticonFactory());

        jugadores[0].setJuego(this);
        jugadores[1].setJuego(this);
        
        jugadores[jugadorActual].setEstado(new EstadoJugador_Activo());
        jugadores[siguienteJugador()].setEstado(new EstadoJugador_Inactivo());
    }

	public Jugador jugadorActual()
	{
	    return jugadores[jugadorActual];
	}

	public Jugador jugadorInactivo()
	{
	    return jugadores[siguienteJugador()];
	}

    private int siguienteJugador()
    {
        return (jugadorActual + 1) % jugadores.length;
    }

	private void ubicarAlgoformers()
	{
	    List<AlgoFormer> equipo;
	    Posicion inicio;
	    int medioDelTablero = tablero.altura() / 2;
	    
		inicio = new Posicion(1, medioDelTablero);
	    equipo = jugadorActual().getListaAlgoformers();
		colocarEquipo(equipo, inicio);
	    
		inicio = new Posicion(tablero.ancho(), medioDelTablero);
	    equipo = jugadorInactivo().getListaAlgoformers();
		colocarEquipo(equipo, inicio);
	}
	
	private void ubicarChispaSuprema(){
		int anchoTablero = tablero.ancho();
		int altoTablero = tablero.altura();
		int tercioDeAncho = anchoTablero / 3;
		int tercioDeAlto = altoTablero / 3;
		Random generador = new Random();
		int sumaDeAncho = generador.nextInt(tercioDeAncho);
		int sumaDeAlto = generador.nextInt(tercioDeAlto);
		
		int coordenadaX = tercioDeAncho + sumaDeAncho;
		int coordenadaY = tercioDeAlto + sumaDeAlto;
		Posicion posicionChispa = new Posicion(coordenadaX, coordenadaY);
		tablero.colocarChispaSuprema(posicionChispa);
	}

	private void colocarEquipo(List<AlgoFormer> equipo,
	    Posicion inicio)
    {
        Posicion posicion = inicio;
		for(AlgoFormer algoformer : equipo)
		{
			tablero.colocarAlgoformer(algoformer, posicion);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
		}
	}

	//la idea seria que juego chequee al final de cada turno si hay un ganador
	//consultando el booleanos hayGanador
	public static void hayGanador(AlgoFormer algoformer) {
		hayGanador = true;
	}
	
	void terminarTurno()
	{
	    jugadorActual = siguienteJugador();
	    jugadorActual().iniciarTurno();
	}
	
	//Metodos para pruebas
	
	public void inicializarSinAleatoridad()
	{
		Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
		Tablero.setGeneradorDeBonus(new BonusNuloFactory());
		tablero = Tablero.getInstance();
		
		jugadores = new Jugador [2];
        jugadorActual = 0;

        jugadores[0] = new Jugador(new AutoBotFactory());
        jugadores[1] = new Jugador(new DecepticonFactory());

        jugadores[0].setJuego(this);
        jugadores[1].setJuego(this);

        jugadores[jugadorActual].setEstado(new EstadoJugador_ModoPrueba());
        jugadores[siguienteJugador()].setEstado(new EstadoJugador_Inactivo());
		
		ubicarAlgoformers();
		ubicarChispaSuprema();
	}
}

