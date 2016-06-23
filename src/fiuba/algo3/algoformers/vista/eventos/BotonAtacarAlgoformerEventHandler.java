package fiuba.algo3.algoformers.vista.eventos;


import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.excepciones.*;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;

public class BotonAtacarAlgoformerEventHandler implements EventHandler<ActionEvent> {

	private Jugador jugadorAtacante;
	private AlgoFormer algoformerAtacado;
	private ContenedorPrincipal contenedorPrincipal;
	private VistaTablero vistaTablero;
	
	public BotonAtacarAlgoformerEventHandler(Jugador jugadorActual, AlgoFormer algoformer,
												VistaTablero vistaTablero, ContenedorPrincipal contenedor) {
		this.jugadorAtacante = jugadorActual;
		this.algoformerAtacado = algoformer;
		this.contenedorPrincipal = contenedor;
		this.vistaTablero = vistaTablero;
	}

	public void handle(ActionEvent event) {
	//try{
		jugadorAtacante.atacar(algoformerAtacado);
		contenedorPrincipal.setMensajeConsola(jugadorAtacante.getAlgoformerElegido().getNombre() +
													"ataco a " + algoformerAtacado.getNombre());
		AudioClip audioAtacar = new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/atacar.mp3");
		audioAtacar.play();
		vistaTablero.actualizar();
		contenedorPrincipal.setBotoneraEleccion();
	/*}
	
	catch (FueraDeAlcanceException exception){
		crearError("ERROR", "Algoformer no puede atacar", "El algoformer atacado esta fuera de alcance");
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
