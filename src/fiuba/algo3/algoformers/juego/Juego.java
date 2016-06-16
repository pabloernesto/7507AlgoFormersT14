package fiuba.algo3.algoformers.juego;

import java.util.List;
import java.util.Random;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class Juego {

	Tablero tablero;
	private ControlDeTurnos turnos;
	private static boolean hayGanador = false;
	
	public Juego() {}
	
	public void inicializar()
	{
		tablero = Tablero.getInstance();
		turnos = new ControlDeTurnos();
		
		Jugador jAutobot = new Jugador(new AutoBotFactory());
		jAutobot.setControlDeTurnos(turnos);
		
		Jugador jDecepticon = new Jugador(new DecepticonFactory());
		jDecepticon.setControlDeTurnos(turnos);
		
		turnos.terminarTurno();
		
		ubicarAlgoformers();
		ubicarChispaSuprema();
	}
	
	public Jugador jugadorActual()
	{
	    return turnos.jugadorActual();
	}

	public Jugador jugadorInactivo()
	{
	    return turnos.jugadorSiguiente();
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
}
