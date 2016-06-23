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
		System.out.println("Entro a chequearGanador");
		if (!juego.hayGanador())
			return;
		String ganador = juego.getJugadorGanador().getNombre();
		System.out.println("Acaba de pedir el ganador");
		ContenedorVictoria.recibirGanador(ganador);
		ContenedorVictoria.imprimirGanador();
		System.out.println("Le paso el ganador a contenedorVictoria");
		Stage stage = contenedorPrincipal.getStage();
		System.out.println("Pidio el stage");
		Scene proximaEscena = contenedorPrincipal.getSiguienteEscena();
		System.out.println("Pidio la siguiente escena");
		stage.setScene(proximaEscena);
		System.out.println("Seteo la siguiente escena");
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.show();
        System.out.println("Ultimo paso antes de salir de chequearGanador");
	}
}
