package fiuba.algo3.algoformers.vista.eventos;


import fiuba.algo3.algoformers.vista.BarraDeMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionMinimizarHandler implements EventHandler<ActionEvent> {


    Stage stage;
    MenuItem opcionMinimizar;
    BarraDeMenu menuBar;
    
    public OpcionMinimizarHandler(Stage stage, MenuItem opcionMinimizar,BarraDeMenu menuBar) {
        this.stage = stage;
        this.opcionMinimizar = opcionMinimizar;
        this.menuBar=menuBar;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(false);
            opcionMinimizar.setDisable(true);
            stage.show();
            menuBar.aplicacionMaximizada(false);
        }
    }
}
