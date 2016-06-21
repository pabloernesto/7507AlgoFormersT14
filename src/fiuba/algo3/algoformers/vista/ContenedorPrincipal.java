package fiuba.algo3.algoformers.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.vista.eventos.BotonAlgoformer;
import fiuba.algo3.algoformers.vista.eventos.BotonElegirAlgoformerEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonInfo;
import fiuba.algo3.algoformers.vista.eventos.BotonInfoAlgoformerEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ContenedorPrincipal extends BorderPane {

	BarraDeMenu barraMenu;
	Juego juego;
	Stage stage;
	VistaTablero vistaTablero;
	HBox contenedorAbajo;

    public ContenedorPrincipal(Stage stage, Juego juego, BarraDeMenu barraMenu){
    	
    	this.juego = juego;
    	this.stage = stage;
    	this.barraMenu = barraMenu;
    	this.contenedorAbajo = new HBox();
    	this.contenedorAbajo.setSpacing(75);
    	Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/FondoGris.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	contenedorAbajo.setBackground(new Background(imagenDeFondo));
    	this.vistaTablero = new VistaTablero();
    }
    
    public void inicializar(){
    	setMenu();
    	setCentro();
    	this.setConsola();
    	this.setBotoneraEleccion();
    	this.setBottom(contenedorAbajo);
    }

    private void setMenu() {
        this.setTop(barraMenu);
    }
    
    private void setConsola(){
    	Jugador jugador = juego.jugadorActual();
    	Label etiqueta = new Label();
    	etiqueta.setText(jugador.getNombre() + " debe elegir un algoformer");
    	etiqueta.setTextFill(Color.WHITE);
    	HBox consola = new HBox(etiqueta);
    	consola.setMinSize(350, 75);
    	consola.setStyle("-fx-background-color: black;");
    	contenedorAbajo.getChildren().add(consola);
    }
    
    private void setBotoneraEleccion(){
    	Jugador jugador = juego.jugadorActual();
    	List<VBox> listaBotones = new ArrayList<VBox>();
    	for (AlgoFormer algoformer : jugador.getListaAlgoformers()){
    		BotonAlgoformer boton = new BotonAlgoformer(algoformer);
    		boton.setText(algoformer.getNombre());
    		boton.setMinSize(100, 30);
    		BotonInfo botonInfo = new BotonInfo(algoformer);
    		botonInfo.setText("Info");
    		botonInfo.setMinSize(50, 10);
    		BotonElegirAlgoformerEventHandler elegirHandler = new BotonElegirAlgoformerEventHandler(jugador, algoformer);
    		boton.setOnAction(elegirHandler);
    		BotonInfoAlgoformerEventHandler infoHandler = new BotonInfoAlgoformerEventHandler(algoformer, contenedorAbajo);
    		botonInfo.setOnAction(infoHandler);
    		VBox caja = new VBox(boton, botonInfo);
    		caja.setSpacing(5);
    		listaBotones.add(caja);
    	}
    	HBox contenedor = new HBox();
    	contenedor.setSpacing(30);
    	contenedor.setMinHeight(75);
    	contenedor.getChildren().addAll(listaBotones);
    	contenedorAbajo.getChildren().add(contenedor);
    }
    
    private void setBotoneraAcciones(){//AlgoFormer algoformer) {

    	Button botonMover = new Button("Mover");
        //BotonElegirMoverHandler moveButtonHandler = new BotonElegirMoverHandler(vistaAlgoformer, algoformer);
        //botonMover.setOnAction(moveButtonHandler);
        
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        //BotonElegirAtacar moveButtonHandler = 
        //newBotonElegirAtacar(vistaAlgoformer, algoformer);
        //botonMover.setOnAction(moveButtonHandler);
        
        Button botonTransformarse = new Button();
        botonTransformarse.setText("Transformarse");
        //BotonElegirTransformarse moveButtonHandler = 
        //new BotonElegirTransformarse(vistaAlgoformer, algoformer);
        //botonMover.setOnAction(moveButtonHandler);
        
        Button botonCombinarse = new Button();
        botonCombinarse.setText("Combinarse");
        //BotonElegirCombinarse moveButtonHandler = 
        //new BotonMoverHandler(vistaAlgoformer, algoformer);
        //botonMover.setOnAction(moveButtonHandler);

        botonAtacar.setMaxSize(100, 30);
        botonMover.setMaxSize(100, 30);
        botonCombinarse.setMaxSize(100, 30);
        botonTransformarse.setMaxSize(100, 30);
        
        HBox contenedorHorizontal = 
        		new HBox(botonMover, botonAtacar,botonTransformarse,botonCombinarse);
        contenedorHorizontal.setSpacing(30);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        //contenedorHorizontal.setPadding(new Insets(50,0,50,450)); //el primero es para el alto.. el ultimo para el lugar horizontal
        contenedorHorizontal.setMinHeight(75);
        
        Image imagen = 
        new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/FondoGris.jpg", 300, 0, false, true);
        BackgroundImage imagenDeFondo = 
        new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorHorizontal.setBackground(new Background(imagenDeFondo));
        
        this.setBottom(contenedorHorizontal);

    }

    private void setCentro(){
    	vistaTablero.dibujar();
    	this.setCenter(vistaTablero);
    }

    public BarraDeMenu getBarraDeMenu() {
        return barraMenu;
    }
	
 
}
