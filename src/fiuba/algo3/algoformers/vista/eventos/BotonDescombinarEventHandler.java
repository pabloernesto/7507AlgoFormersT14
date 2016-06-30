package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.excepciones.SinLugarParaDescombinarseException;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonDescombinarEventHandler extends AccionAlgoformerEventHandler implements EventHandler<ActionEvent>{
	
	private VistaTablero vistaTablero;
    private Juego juego;

    public BotonDescombinarEventHandler(VistaTablero vistaTablero, Juego juego, ContenedorPrincipal contenedor)
    {
        this.vistaTablero = vistaTablero;
        this.juego = juego;
        this.contenedorPrincipal = contenedor;
    }

	public void handle(ActionEvent event) {
		try{
			juego.jugadorActual().descombinar();
	        new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/" +
	            "combinar.mp3").play();
            contenedorPrincipal.consola.setMensaje(
                juego.jugadorActual().getNombre() + " se ha descombinado");
	        vistaTablero.actualizar();
	        chequearGanador(juego);
	        contenedorPrincipal.setBotoneraEleccion();
	        contenedorPrincipal.setImagenEquipo();
	        contenedorPrincipal.setImagenAlgoformersJugadorActual();
		}
		catch (SinLugarParaDescombinarseException e){
			crearError("ERROR", "No se puede descombinar", "No hay suficiente lugar para descombinarse");
		}
	}
}
