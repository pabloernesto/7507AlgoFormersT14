package fiuba.algo3.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class OpcionSalirEventHandler implements EventHandler<ActionEvent>{

	private Stage stage;
	
	 public OpcionSalirEventHandler(Stage stage) {
	        this.stage = stage;
	    }
	
	@Override
	public void handle(ActionEvent event) {
		stage.close();
	}

}
