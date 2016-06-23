package fiuba.algo3.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

public class BotonAceptarVictoriaEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public BotonAceptarVictoriaEventHandler(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        AudioClip audioBoton = new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/derrota.mp3");
        audioBoton.play();
    }
}
