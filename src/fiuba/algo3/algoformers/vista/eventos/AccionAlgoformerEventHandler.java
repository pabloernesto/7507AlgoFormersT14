package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.ContenedorVictoria;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public abstract class AccionAlgoformerEventHandler {

	protected ContenedorPrincipal contenedorPrincipal;
	
	protected void crearError(String titulo, String encabezado, String mensaje){
    	/*Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.show();*/
    }
	
	protected void chequearGanador(Juego juego){
		if (!juego.hayGanador())
			return;
		String ganador = juego.getJugadorGanador().getNombre();
		ContenedorVictoria.recibirGanador(ganador);
		Stage stage = contenedorPrincipal.getStage();
		Scene proximaEscena = contenedorPrincipal.getSiguienteEscena();
		stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.show();
	}
}
