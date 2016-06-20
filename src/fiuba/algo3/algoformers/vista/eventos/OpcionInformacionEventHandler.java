package fiuba.algo3.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class OpcionInformacionEventHandler implements EventHandler<ActionEvent>{

	Stage stagePrincipal;
	
	public OpcionInformacionEventHandler (Stage stagePrincipal){
		this.stagePrincipal=stagePrincipal;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Stage stage= new Stage();
		VBox root = new VBox();
		Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/ImagenReglas.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Button volverAlJuego = new Button("Volver al juego");
        BotonVolverAlJuegoEventHandler salir = new BotonVolverAlJuegoEventHandler(stage,stagePrincipal);
        volverAlJuego.setOnAction(salir);
        volverAlJuego.setMinSize(100, 50);
        volverAlJuego.setFont(Font.font("Courier New",FontWeight.BOLD, 20));
        root.setPadding(new Insets(50,0,50,50));
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.getChildren().add(volverAlJuego);
        root.setBackground(new Background(imagenDeFondo));
        stage.setFullScreen(true);
        stage.setScene(new Scene(root));
        stage.setFullScreenExitHint("");
        stage.show();        
	}

}
