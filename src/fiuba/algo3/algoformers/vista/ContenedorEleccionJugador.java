package fiuba.algo3.algoformers.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.eventos.BotonAceptarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorEleccionJugador extends VBox{
	
	Stage stage;
	Juego juego;
	Scene proximaEscena;
	ContenedorPrincipal contenedorPrincipal;
	
	public ContenedorEleccionJugador(Stage stage, Scene proximaEscena, Juego juego, ContenedorPrincipal contenedor){
		super();
		this.stage = stage;
		this.proximaEscena = proximaEscena;
		this.contenedorPrincipal = contenedor;
		
		this.setAlignment(Pos.CENTER);
		Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/eleccionJugadores.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        Button botonAceptar = new Button();
        botonAceptar.setText("Aceptar");
        botonAceptar.setStyle("-fx-base: #001234");
        
        Text jugador = new Text("Jugador Autobots");
        jugador.setFill(Color.DARKORANGE);
        jugador.setFont(Font.font("Tahoma", FontWeight.BOLD, 24));
        
		TextField texto = new TextField();
		texto.setPromptText("Ingrese su nombre");
		texto.setMaxWidth(200);
		texto.requestFocus();
		
		
        Label etiqueta = new Label();
        VBox contenedorIngreso = new VBox(jugador, texto, botonAceptar, etiqueta);
        contenedorIngreso.setSpacing(30);
        contenedorIngreso.setPadding(new Insets(100));
        
        List<String> nombresJugadores = new ArrayList<String>();
        // Asociar botonEnviar a su comportamiento
        BotonAceptarEventHandler botonAceptarEventHandler =
        new BotonAceptarEventHandler(texto, etiqueta, jugador, nombresJugadores, juego, proximaEscena, stage, contenedorPrincipal);
        botonAceptar.setOnAction(botonAceptarEventHandler);
        texto.setOnAction(botonAceptarEventHandler);
        
        this.getChildren().add(contenedorIngreso);
	}

}
