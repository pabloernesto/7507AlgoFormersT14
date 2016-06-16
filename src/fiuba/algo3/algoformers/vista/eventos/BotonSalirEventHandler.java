package fiuba.algo3.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {


	    @Override
	    public void handle(ActionEvent actionEvent) {
	    	System.exit(0);
	    }

}
