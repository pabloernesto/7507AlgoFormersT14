package fiuba.algo3.algoformers.vista.eventos;


import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.excepciones.*;
import fiuba.algo3.algoformers.juego.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class BotonAtacarAlgoformerEventHandler implements EventHandler<ActionEvent> {

	Jugador jugadorAtacante;
	AlgoFormer algoformerAtacado;
	Stage stage;
	
	public BotonAtacarAlgoformerEventHandler(Jugador jugadorActual, AlgoFormer algoformer,Stage stage) {
		this.jugadorAtacante = jugadorActual;
		this.algoformerAtacado = algoformer;
		this.stage=stage;
	}

	@Override
	public void handle(ActionEvent event) {
	//try{
		jugadorAtacante.atacar(algoformerAtacado);
		AudioClip audioAtacar = new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/atacar.mp3");
		audioAtacar.play();
	//}
	/*
	catch (FuegoAmigoException exception){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Look, an Error Dialog");
		alert.setContentText("Ooops, there was an error!");

		alert.showAndWait();
	}
	catch (FueraDeAlcanceException exception){
		Alert alert = new Alert(AlertType.ERROR);
		alert.initOwner(stage);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Look, an Error Dialog");
		alert.setContentText("Ooops, there was an error!");

		alert.showAndWait();
	}
	*/
	}
	

}
