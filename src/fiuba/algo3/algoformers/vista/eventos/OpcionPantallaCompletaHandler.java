package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.vista.BarraDeMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaHandler implements EventHandler<ActionEvent> {

	 Stage stage;
	    MenuItem opcionPantallaCompleta;
	    BarraDeMenu menuBar;

	    public OpcionPantallaCompletaHandler(Stage stage, MenuItem opcionPantallaCompleta,BarraDeMenu menuBar) {
	        this.stage = stage;
	        this.opcionPantallaCompleta = opcionPantallaCompleta;
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	        if (!stage.isFullScreen()) {
	            stage.hide();
	            stage.setFullScreen(true);
	            opcionPantallaCompleta.setDisable(true);
	            stage.show();
	            menuBar.aplicacionMaximizada(true);
	        }
    }

}

