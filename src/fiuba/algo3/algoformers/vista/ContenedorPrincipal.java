package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.juego.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class ContenedorPrincipal extends BorderPane {

	BarraDeMenu barraMenu;
	Juego juego;
	Stage stage;
	VistaTablero vistaTablero;

    public ContenedorPrincipal(Stage stage, Juego juego, BarraDeMenu barraMenu){
    	
    	this.juego = juego;
    	this.stage = stage;
    	this.barraMenu = barraMenu;
    	this.vistaTablero = new VistaTablero();
    }
    
    public void inicializar(){
    	setMenu();
    	setCentro();
    	this.setBotonera();
    }

    private void setMenu() {
        this.setTop(barraMenu);
    }
    
    private void setBotonera(){//AlgoFormer algoformer) {

        Button botonMover = new Button("Mover");
        //BotonElegirMoverHandler moveButtonHandler = 
        //new BotonElegirMoverHandler(vistaAlgoformer, algoformer);
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
