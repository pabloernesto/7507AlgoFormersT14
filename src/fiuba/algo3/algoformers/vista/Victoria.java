package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.vista.eventos.BotonAceptarVictoriaEventHandler;
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
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Victoria extends VBox{  
        Stage stage;

        public Victoria(Stage stage, Scene proximaEscena, AudioClip audioViejo) {

            super();
            this.stage = stage;
            audioViejo.stop();
            
            this.setAlignment(Pos.CENTER);
            this.setSpacing(20);
            this.setPadding(new Insets(480, 50, 50, 50));
           	Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/victoria.jpg");
            BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            this.setBackground(new Background(imagenDeFondo));

            Button botonAceptar = new Button();
            botonAceptar.setText("Aceptar Victoria!");
            botonAceptar.setMinSize(300, 170);
            botonAceptar.setFont(Font.font("Courier New",FontWeight.BOLD, 72));
            
            BotonAceptarVictoriaEventHandler botonVictoria = new BotonAceptarVictoriaEventHandler(stage, proximaEscena);
            botonAceptar.setOnAction(botonVictoria);
           
            AudioClip audioVictoria = new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/victoria.mp3");
	        audioVictoria.play();
	        
            this.getChildren().addAll(botonAceptar);
        }
}