package fiuba.algo3.algoformers.juego;

import java.util.ArrayList;
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
	private static Jugador ganador;
    
    private static Jugador [] jugadores;
    private static int jugadorActual;
    
	public Juego() {
		ganador = null;
	}
	
	//Antes de llamar a esta funcion hay que llamar a crearJugadores SI O SI
	public void inicializar()
	{
		tablero = Tablero.getInstance();
		inicializarJugadores();
		
		ubicarAlgoformers();
		ubicarChispaSuprema();
	}
	
	public void crearJugadores(String nombreJugadorAutobots, String nombreJugadorDecepticons){
		jugadores = new Jugador[2];
		jugadores[0] = new Jugador(new AutoBotFactory(), nombreJugadorAutobots);
		jugadores[1] = new Jugador(new DecepticonFactory(), nombreJugadorDecepticons);
		jugadores[0].setJuego(this);
		jugadores[1].setJuego(this);
	}

    private void inicializarJugadores()
    {
        jugadorActual = new Random().nextInt(2);
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

	public static void chispaCapturada() {
		ganador = jugadores[jugadorActual];
	}
	
	void terminarTurno()
	{
		limpiarMuertos();
		chequearGanadorPorMuertes();
	    jugadorActual = siguienteJugador();
	    jugadorActual().iniciarTurno();
	}
	
	public void limpiarMuertos(){
		for (Jugador jugador : jugadores){
			List<AlgoFormer> muertos = new ArrayList<AlgoFormer>();
			for (AlgoFormer algoformer : jugador.getListaAlgoformers()){
				if (!algoformer.estaVivo()){
					muertos.add(algoformer);
				}
			}
			for (AlgoFormer algoformer : muertos){
				jugador.getListaAlgoformers().remove(algoformer);
				tablero.borrarAlgoformer(algoformer);
			}
		}
	}
	
	public void chequearGanadorPorMuertes(){
		for (int i = 0 ; i < 2 ; i++){
			if (jugadores[i].getListaAlgoformers().size() == 0){
				ganador = jugadores[(i + 1) % jugadores.length];
			}
		}
	}
	
	//La idea es que la interfaz haga un ciclo mientras no haya un ganador
	//cuando ya haya un ganador, la interfaz termina el juego
	public boolean hayGanador(){
		return ganador != null;
	}
	
	public Jugador getJugadorGanador(){
		return ganador;
	}
	
	//Metodos para pruebas
	
	public void inicializarSinAleatoridad()
	{
		Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
		Tablero.setGeneradorDeBonus(new BonusNuloFactory());
		tablero = Tablero.getInstance();
		
		jugadores = new Jugador [2];
        jugadorActual = 0;

        jugadores[0] = new Jugador(new AutoBotFactory(), "Autobots");
        jugadores[1] = new Jugador(new DecepticonFactory(), "Decepticons");

        jugadores[0].setJuego(this);
        jugadores[1].setJuego(this);

        jugadores[jugadorActual].setEstado(new EstadoJugador_ModoPrueba());
        jugadores[siguienteJugador()].setEstado(new EstadoJugador_Inactivo());
		
		ubicarAlgoformers();
		ubicarChispaSuprema();
	}
}

