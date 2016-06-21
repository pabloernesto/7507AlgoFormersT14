package fiuba.algo3.algoformers.vista.eventos;


import fiuba.algo3.algoformers.vista.BarraDeMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionVentanaHandler implements EventHandler<ActionEvent> {


    Stage stage;
    MenuItem opcionMinimizar;
    BarraDeMenu barraMenu;
    
    public OpcionVentanaHandler(Stage stage, MenuItem opcionMinimizar,BarraDeMenu barraMenu) {
        this.stage = stage;
        this.opcionMinimizar = opcionMinimizar;
        this.barraMenu = barraMenu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(false);
            opcionMinimizar.setDisable(true);
            stage.setMaximized(true);
            stage.show();
            barraMenu.aplicacionMaximizada(false);
        }
    }
}
