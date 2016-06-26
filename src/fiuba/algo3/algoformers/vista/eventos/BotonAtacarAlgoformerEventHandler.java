package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.excepciones.*;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonAtacarAlgoformerEventHandler extends AccionAlgoformerEventHandler implements EventHandler<ActionEvent> {

	private Jugador jugadorAtacante;
	private AlgoFormer algoformerAtacado;
	private VistaTablero vistaTablero;
	private Juego juego;
	
	public BotonAtacarAlgoformerEventHandler(Juego juego, AlgoFormer algoformer,
												VistaTablero vistaTablero, ContenedorPrincipal contenedor) {
		this.juego = juego;
		this.jugadorAtacante = juego.jugadorActual();
		this.algoformerAtacado = algoformer;
		this.contenedorPrincipal = contenedor;
		this.vistaTablero = vistaTablero;
	}

	public void handle(ActionEvent event) {
	try{
		jugadorAtacante.atacar(algoformerAtacado);
        contenedorPrincipal.consola.setMensaje(
            jugadorAtacante.getAlgoformerElegido().getNombre() + "ataco a " +
            algoformerAtacado.getNombre());
		AudioClip audioAtacar = new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/atacar.mp3");
		audioAtacar.play();
		vistaTablero.actualizar();
		chequearGanador(juego);
		contenedorPrincipal.setBotoneraEleccion();
	}
	
	catch (FueraDeAlcanceException exception){
		crearError("ERROR", "Algoformer no puede atacar", "El algoformer atacado esta fuera de alcance");
	}
	}
	
}
