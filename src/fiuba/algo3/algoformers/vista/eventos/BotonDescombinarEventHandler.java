package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.excepciones.SinLugarParaDescombinarseException;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;

public class BotonDescombinarEventHandler implements EventHandler<ActionEvent>{
	
	private VistaTablero vistaTablero;
    private Juego juego;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonDescombinarEventHandler(VistaTablero vistaTablero, Juego juego, ContenedorPrincipal contenedor)
    {
        this.vistaTablero = vistaTablero;
        this.juego = juego;
        this.contenedorPrincipal = contenedor;
    }

	public void handle(ActionEvent event) {
		//try{
			juego.jugadorActual().descombinar();
	        new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/" +
	            "combinar.mp3").play();
	        contenedorPrincipal.setMensajeConsola(
	            juego.jugadorActual().getNombre() + " se ha descombinado");
	        vistaTablero.actualizar();
	        contenedorPrincipal.setBotoneraEleccion();
		/*}
		catch (SinLugarParaDescombinarseException e){
			crearError("ERROR", "No se puede descombinar", "No hay suficiente lugar para descombinarse");
		}*/
	}
	
	/*private void crearError(String titulo, String encabezado, String mensaje){
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.show();
	}*/
}
