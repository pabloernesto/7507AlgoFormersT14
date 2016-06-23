package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.vista.eventos.BotonSalirEventHandler;
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

public class ContenedorDerrota extends VBox{  
        Stage stage;

        public ContenedorDerrota(Stage stage, Scene proximaEscena) {
        	
        	
            super();
            this.stage = stage;
            this.setAlignment(Pos.CENTER_LEFT);
            this.setSpacing(20);
            this.setPadding(new Insets(600, 50, 50, 50));
            Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/derrota.jpg");
            BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            this.setBackground(new Background(imagenDeFondo));

            Button botonAceptar = new Button();
            botonAceptar.setText("Aceptar Derrota");
            botonAceptar.setMinSize(200, 130);
            botonAceptar.setFont(Font.font("Courier New",FontWeight.BOLD, 42));
            
            BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
            botonAceptar.setOnAction(botonSalirHandler);
                    
            this.getChildren().addAll(botonAceptar);
        }
}