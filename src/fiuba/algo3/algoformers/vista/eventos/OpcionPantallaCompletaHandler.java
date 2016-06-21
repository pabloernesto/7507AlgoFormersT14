package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.vista.BarraDeMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaHandler implements EventHandler<ActionEvent> {

	 	Stage stage;
	    MenuItem opcionPantallaCompleta;
	    BarraDeMenu barraMenu;

	    public OpcionPantallaCompletaHandler(Stage stage, MenuItem opcionPantallaCompleta,BarraDeMenu barraMenu) {
	        this.stage = stage;
	        this.opcionPantallaCompleta = opcionPantallaCompleta;
	        this.barraMenu = barraMenu;
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	        if (!stage.isFullScreen()) {
	            stage.hide();
	            stage.setFullScreen(true);
	            opcionPantallaCompleta.setDisable(true);
	            stage.show();
	            barraMenu.aplicacionMaximizada(true);
	        }
    }

}

