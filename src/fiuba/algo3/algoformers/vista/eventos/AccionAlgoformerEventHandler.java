package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.ContenedorVictoria;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class AccionAlgoformerEventHandler {

	protected ContenedorPrincipal contenedorPrincipal;
	
    void crearError(String titulo, String encabezado, String mensaje)
    {
        contenedorPrincipal.consola.setMensaje(titulo + ": " + encabezado);
        contenedorPrincipal.consola.agregarMensaje("\t" + mensaje);
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
