package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.escenario.Tablero;

public class Juego {

	Tablero tablero;
	private Jugador jugadorActual;
	private Jugador jugadorInactivo;
	
	public Juego (){
		
	}
	
	private void inicializarJuego (){
		tablero = Tablero.getInstance();
		JugadorAutoBots jugadorAutobots = new JugadorAutoBots();
		JugadorDecepticons jugadorDecepticons = new JugadorDecepticons();
		if (Math.random() > 0.5){
			jugadorActual = jugadorAutobots;
			jugadorInactivo = jugadorDecepticons;
		} else {
			jugadorActual = jugadorDecepticons;
			jugadorInactivo = jugadorAutobots;
		}
		ubicarAlgoformers();
		ubicarChispaSuprema();
	}
	
	private void cicloPrincipal (){
	}
	
	private void ubicarAlgoformers(){
		tablero.colocarEquipo1(jugadorActual.getListaAlgoformers());
		tablero.colocarEquipo2(jugadorInactivo.getListaAlgoformers());
	}
	
	private void ubicarChispaSuprema(){
		tablero.colocarChispaSuprema();
	}

}
