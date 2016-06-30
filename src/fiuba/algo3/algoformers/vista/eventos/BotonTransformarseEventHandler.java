package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonTransformarseEventHandler implements EventHandler<ActionEvent>{

	private VistaTablero vistaTablero;
	private Juego juego;
	private ContenedorPrincipal contenedorPrincipal;
	
	public BotonTransformarseEventHandler(VistaTablero vistaTablero, Juego juego, ContenedorPrincipal contenedor){
		this.vistaTablero = vistaTablero;
		this.juego = juego;
		this.contenedorPrincipal = contenedor;
	}

	public void handle(ActionEvent event) {
		AlgoFormer algoformerElegido = juego.jugadorActual().getAlgoformerElegido();
		juego.jugadorActual().transformar();
		AudioClip audioTransformarse = new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/transformar.mp3");
		audioTransformarse.play();
        contenedorPrincipal.consola.setMensaje(algoformerElegido.getNombre() +
            " se transformo!");
		vistaTablero.actualizar(); //es importante que se dibuje despues de que haya terminado el turno
		contenedorPrincipal.setBotoneraEleccion();
		contenedorPrincipal.setImagenEquipo();
		contenedorPrincipal.setImagenAlgoformersJugadorActual();
		//Con este no hace falta, pero con el resto de los botones hay que chequear si hubo un ganador
		//y si es asi, cambiar de escena, a la escena de ganador.
	}
}
