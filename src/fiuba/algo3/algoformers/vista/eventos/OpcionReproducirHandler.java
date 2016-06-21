package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.vista.BarraDeMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class OpcionReproducirHandler implements EventHandler<ActionEvent>{

	Stage stage;
    MenuItem opcionReproducir;
    BarraDeMenu menuBar;
    AudioClip musica;

    public OpcionReproducirHandler(Stage stage, MenuItem opcionReproducir, BarraDeMenu menuBar, AudioClip musica) {
        this.stage = stage;
        this.opcionReproducir = opcionReproducir;
        this.menuBar = menuBar;
        this.musica = musica;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        musica.play();
        menuBar.reproduciendoMusica(true);
    }
}
