package fiuba.algo3.algoformers.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonVolverAlJuegoEventHandler implements EventHandler<ActionEvent>{

	Stage stage;
	Stage stagePrincipal;
	
	public BotonVolverAlJuegoEventHandler (Stage stage,Stage stagePrincipal){
				this.stage= stage;
				this.stagePrincipal = stagePrincipal;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		stage.close();
		stagePrincipal.setFullScreen(true);
	}

}
