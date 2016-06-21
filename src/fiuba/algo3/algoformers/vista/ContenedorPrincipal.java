package fiuba.algo3.algoformers.vista;


import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.juego.Juego;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class ContenedorPrincipal extends BorderPane {

	BarraDeMenu menuBar;
	Canvas canvasCentral;
	Juego juego;
	Stage stage;
	//VistaTablero vistaTablero
   	

    public ContenedorPrincipal(Stage stage, Juego juego){ //ArrayList<AlgoFormer> ListaAlgoformers ??) {
    	
    	this.juego = juego;
    	this.stage = stage;
    }
    
    public void inicializar(){
    	setMenu();
    	setCentro();
    	this.setBotonera();
    }

    private void setMenu() {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
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


        botonAtacar.setMinSize(100, 60);
        botonMover.setMinSize(100, 60);
        botonCombinarse.setMinSize(100, 60);
        botonTransformarse.setMinSize(100, 60);
        
        HBox contenedorHorizontal = 
        new HBox(botonMover, botonAtacar,botonTransformarse,botonCombinarse);
        contenedorHorizontal.setSpacing(30);
        contenedorHorizontal.setPadding(new Insets(50,0,50,450)); //el primero es para el alto.. el ultimo para el lugar horizontal
        //contenedorVertical.setMinHeight(100);
        
        Image imagen = 
        new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/FondoGris.jpg", 300, 0, false, true);
        BackgroundImage imagenDeFondo = 
        new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorHorizontal.setBackground(new Background(imagenDeFondo));
        
        this.setBottom(contenedorHorizontal);

    }
    
   

    private void setCentro(){

        //Como hago para dibujar cada Algoformer??
        //Capaz tengo que preguntarle a cada celda si contiene un algoformer y
        //Segun la respuesta actuar...
        //Button[][] matriz;

        Tablero tablero = Tablero.getInstance();

    	       
        GridPane root = new GridPane();
        for (int row = 1; row < tablero.altura(); row++) {
            for (int col = 1; col < tablero.ancho(); col ++){
                StackPane celda = new VistaDeCelda(tablero.getCelda(col, row));
                root.add(celda, col, row);
            }
        }

        for (int i = 0; i < tablero.ancho(); i++) {
            root.getColumnConstraints().add(
            		new ColumnConstraints(32));
        }
        for (int i = 0; i < tablero.altura(); i++) {
            root.getRowConstraints().add(
            		new RowConstraints(32));
        }
    	this.setCenter(root);
    	root.setMaxWidth(600);
    	root.setMaxHeight(700);
    }




    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
	
 
}
