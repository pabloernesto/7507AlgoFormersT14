package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.vista.eventos.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenida extends VBox
{
    Stage stage;

    public ContenedorBienvenida(Stage stage, BarraDeMenu barraMenu, AudioClip musica, Scene proximaEscena)
    {
        super();
        this.stage = stage;
        
        this.setAlignment(Pos.BOTTOM_LEFT);
        this.setSpacing(50);
        
        Image imagen = new Image("file:" + 
            "src/fiuba/algo3/algoformers/vista/imagenes/intro/" +
            "IntroPrincipal.jpg");
        BackgroundImage imagenDeFondo =
            new BackgroundImage(imagen, BackgroundRepeat.REPEAT,
            BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 80));
        etiqueta.setPadding(new Insets(40, 0, 0, 0));

        etiqueta.setText("AlgoFormers");
        etiqueta.setTextFill(Color.web("#0000ff"));

        Button botonEntrar = new Button();
        botonEntrar.setText("Jugar!");
        botonEntrar.setMinSize(200, 120);
        botonEntrar.setFont(Font.font("Courier New",FontWeight.BOLD, 56));
        botonEntrar.setStyle("-fx-base: #1234");
        botonEntrar.defaultButtonProperty().bind(botonEntrar.focusedProperty());
        
        Button botonReglas = new Button();
        botonReglas.setText("Reglas de juego");
        botonReglas.setFont(Font.font("", 20));
        botonReglas.setStyle("-fx-base: #1234");
        botonReglas.defaultButtonProperty().bind(botonReglas.focusedProperty());
        botonReglas.setMinSize(180, 40);
        
        Button botonSalir = new Button();
        botonSalir.setText("Salir :(");
        botonSalir.setFont(Font.font("", 20));
        botonSalir.setStyle("-fx-base: #1234");
        botonSalir.defaultButtonProperty().bind(botonSalir.focusedProperty());
        botonSalir.setMinSize(180, 40);
        
        Button botonSilenciar = new Button();
        botonSilenciar.setText("Silenciar musica");
        botonSilenciar.setFont(Font.font("", 16));
        botonSilenciar.setStyle("-fx-base: #1234");
        botonSilenciar.defaultButtonProperty().bind(botonSilenciar.focusedProperty());
        botonSilenciar.setMinSize(180, 40);
        
        BotonEntrarEventHandler botonEntrarHandler =
            new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);
        
        BotonReglasEventHandler botonReglasHandler =
        		new BotonReglasEventHandler(stage);
        botonReglas.setOnAction(botonReglasHandler);
        
        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);
        
        OpcionSilenciarHandler botonSilenciarHandler = new OpcionSilenciarHandler(barraMenu, musica);
        botonSilenciar.setOnAction(botonSilenciarHandler);
        
        this.getChildren().addAll(etiqueta,botonEntrar, botonSilenciar,botonReglas, botonSalir);
        this.setPadding(new Insets(30));
        this.setSpacing(20);
    }
}

