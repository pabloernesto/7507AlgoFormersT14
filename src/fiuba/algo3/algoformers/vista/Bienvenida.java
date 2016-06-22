package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.vista.eventos.BotonEntrarEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonSalirEventHandler;
import fiuba.algo3.algoformers.vista.eventos.OpcionSilenciarHandler;
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

public class Bienvenida extends VBox
{
    Stage stage;

    public Bienvenida(Stage stage, BarraDeMenu barraMenu, AudioClip musica, Scene proximaEscena)
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

        Button botonEntrar = new Button();
        botonEntrar.setText("کوردیی ناوەندی");
        botonEntrar.setMinSize(200, 120);
        botonEntrar.setFont(Font.font("Courier New",FontWeight.BOLD, 56));
        botonEntrar.setStyle("-fx-base: #1234");
        
        Button botonSalir = new Button();
        botonSalir.setText("Salir :(");
        botonSalir.setFont(Font.font("", 20));
        botonSalir.setStyle("-fx-base: #1234");
        
        Button botonSilenciar = new Button();
        botonSilenciar.setText("Silenciar musica");
        botonSilenciar.setFont(Font.font("", 16));
        botonSilenciar.setStyle("-fx-base: #1234");


        BotonEntrarEventHandler botonEntrarHandler =
            new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);
        
        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);
        
        OpcionSilenciarHandler botonSilenciarHandler = new OpcionSilenciarHandler(barraMenu, musica);
        botonSilenciar.setOnAction(botonSilenciarHandler);
        
        this.getChildren().addAll(botonEntrar, botonSalir, botonSilenciar);
    }
}

