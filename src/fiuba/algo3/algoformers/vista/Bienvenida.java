package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.vista.eventos.BotonEntrarEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonSalirEventHandler;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Bienvenida extends VBox
{
    Stage stage;

    public Bienvenida(Stage stage, Scene proximaEscena)
    {
        super();
        this.stage = stage;
        
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(20);
        this.setPadding(new Insets(480, 50, 50, 50));
        
        Image imagen = new Image("file:" + 
            "src/fiuba/algo3/algoformers/vista/imagenes/intro/" +
            "IntroPrincipal.jpg");
        BackgroundImage imagenDeFondo =
            new BackgroundImage(imagen, BackgroundRepeat.REPEAT,
            BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("Jugar!");
        botonEntrar.setMinSize(200, 120);
        botonEntrar.setFont(Font.font("Courier New",FontWeight.BOLD, 56));
        
        Button botonSalir = new Button();
        botonSalir.setText("Salir :(");
        botonSalir.setFont(Font.font("", 20));

        Button botonMaximizar= new Button();
        botonMaximizar.setText("Maximizar Pantalla");
        
        Button botonMinimizar= new Button();
        botonMinimizar.setText("Minimizar Pantalla");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 80));

        etiqueta.setText("AlgoFormers");
        etiqueta.setTextFill(Color.web("#66A7C5"));

        BotonEntrarEventHandler botonEntrarHandler =
            new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);
        
        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);
        this.getChildren().addAll(etiqueta, botonEntrar,botonSalir);
    }
}

