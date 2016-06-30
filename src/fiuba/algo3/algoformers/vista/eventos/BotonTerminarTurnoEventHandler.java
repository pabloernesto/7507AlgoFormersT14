package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTerminarTurnoEventHandler implements EventHandler<ActionEvent>{

	private Jugador jugador;
	private ContenedorPrincipal contenedorPrincipal;
	
	public BotonTerminarTurnoEventHandler(Jugador jugador, ContenedorPrincipal contenedorPrincipal){
		this.jugador = jugador;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	public void handle(ActionEvent event) {
		jugador.terminarTurno();
		contenedorPrincipal.setBotoneraEleccion();
		contenedorPrincipal.setImagenEquipo();
		contenedorPrincipal.setImagenAlgoformersJugadorActual();
	}
}
