package fiuba.algo3.algoformers.vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AplicacionOnKeyPressEventHandler implements EventHandler<KeyEvent> {

    private Stage stage;

    public AplicacionOnKeyPressEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ESCAPE) {
            stage.setMaximized(true);
        }
    }
}
