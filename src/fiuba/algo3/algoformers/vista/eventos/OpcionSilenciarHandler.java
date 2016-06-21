package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.vista.BarraDeMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class OpcionSilenciarHandler implements EventHandler<ActionEvent>{

	Stage stage;
    MenuItem opcionSilenciar;
    BarraDeMenu menuBar;
    AudioClip musica;

    public OpcionSilenciarHandler(Stage stage, MenuItem opcionSilenciar, BarraDeMenu menuBar, AudioClip musica) {
        this.stage = stage;
        this.opcionSilenciar = opcionSilenciar;
        this.menuBar = menuBar;
        this.musica = musica;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        musica.stop();
        menuBar.reproduciendoMusica(false);
    }

}
