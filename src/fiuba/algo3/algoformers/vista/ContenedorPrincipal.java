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
    	this.setMensajeConsola("debe elegir un algoformer");
    	this.setBotoneraEleccion();
    	this.setBottom(contenedorAbajo);
    }

    private void setMenu() {
        this.setTop(barraMenu);
    }
    
    private void setConsola(){
    	Label etiqueta = new Label("");
    	HBox consola = new HBox(etiqueta);
    	consola.setMinSize(350, 75);
    	consola.setStyle("-fx-background-color: black;");
    	contenedorAbajo.getChildren().add(consola);
    }
    
    public void setMensajeConsola(String mensaje){
    	Jugador jugador = juego.jugadorActual();
    	Label etiqueta = new Label();
    	etiqueta.setText(jugador.getNombre() + " " + mensaje);
    	etiqueta.setTextFill(Color.WHITE);
    	HBox consola = (HBox) contenedorAbajo.getChildren().get(0);
    	consola.getChildren().remove(0); //Borra el comentario anterior
    	consola.getChildren().add(etiqueta); //Aniade el comentario nuevo
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
    		BotonInfoAlgoformerEventHandler infoHandler = new BotonInfoAlgoformerEventHandler(algoformer, contenedorAbajo);
    		botonInfo.setOnAction(infoHandler);
    		BotonElegirAlgoformerEventHandler elegirHandler = new BotonElegirAlgoformerEventHandler(jugador, algoformer, infoHandler , this);
    		boton.setOnAction(elegirHandler);
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
    
    public void setBotoneraAcciones(){
    	Button botonMover = new Button("Mover");
        //BotonMoverEventHandler moverHandler = new BotonElegirMoverHandler(vistaTablero, juego, this);
        //botonMover.setOnAction(moverHandler);
        
        Button botonAtacar = new Button("Atacar");
        //BotonAtacarEventHandler atacarHandler = new BotonAtacarEventHandler(vistaTablero, juego, this);
        //botonAtacar.setOnAction(atacarHandler);
        
        Button botonTransformarse = new Button("Transformarse");
        //BotonTransformarseEventHandler transformarHandler = new BotonTransformarseEventHandler(vistaTablero, juego, this);
        //botonTransformarse.setOnAction(transformarHandler);
        
        Button botonCombinarse = new Button("Combinarse");
        //BotonCombinarseEventHandler combinarseHandler = new BotonCombinarseEventHandler(vistaTablero, juego, this);
        //botonCombinarse.setOnAction(combinarseHandler);

        botonAtacar.setMaxSize(100, 30);
        botonMover.setMaxSize(100, 30);
        botonCombinarse.setMaxSize(100, 30);
        botonTransformarse.setMaxSize(100, 30);
        
        HBox contenedorHorizontal = 
        		new HBox(botonMover, botonAtacar, botonTransformarse, botonCombinarse);
        contenedorHorizontal.setSpacing(30);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        contenedorHorizontal.setMinHeight(75);
        
        contenedorAbajo.getChildren().set(1, contenedorHorizontal);

    }

    private void setCentro(){
    	vistaTablero.dibujar();
    	this.setCenter(vistaTablero);
    }

    public BarraDeMenu getBarraDeMenu() {
        return barraMenu;
    }
	
 
}
