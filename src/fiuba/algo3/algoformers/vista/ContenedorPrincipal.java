package fiuba.algo3.algoformers.vista;


import java.util.ArrayList;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieAerea;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieTerrestre;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ContenedorPrincipal extends BorderPane {

    //BarraDeMenu menuBar;
    //VistaAlgoformer vistaAlgoformer; Implementar
   	

    public ContenedorPrincipal(Stage stage,Tablero tablero){ //ArrayList<AlgoFormer> ListaAlgoformers ??) {
    	
        //this.setConsola();
    	this.setCentro(tablero);
        this.setBotonera();//Agregar Algoformer!!);
    }

    private void setBotonera(){//AlgoFormer algoformer) {

        Button botonMover = new Button("Mover");
        //BotonElegirMoverHandler moveButtonHandler = new BotonElegirMoverHandler(vistaAlgoformer, algoformer);
        //botonMover.setOnAction(moveButtonHandler);
        
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        //BotonElegirAtacar moveButtonHandler = newBotonElegirAtacar(vistaAlgoformer, algoformer);
        //botonMover.setOnAction(moveButtonHandler);
        
        Button botonTransformarse = new Button();
        botonTransformarse.setText("Transformarse");
        //BotonElegirTransformarse moveButtonHandler = new BotonElegirTransformarse(vistaAlgoformer, algoformer);
        //botonMover.setOnAction(moveButtonHandler);
        
        Button botonCombinarse = new Button();
        botonCombinarse.setText("Combinarse");
        //BotonElegirCombinarse moveButtonHandler = new BotonMoverHandler(vistaAlgoformer, algoformer);
        //botonMover.setOnAction(moveButtonHandler);
        
        botonAtacar.setMaxWidth(200);
        botonMover.setMaxWidth(200);
        botonCombinarse.setMaxWidth(200);
        botonTransformarse.setMaxWidth(200);
        
        VBox contenedorVertical = new VBox(botonMover, botonAtacar,botonTransformarse,botonCombinarse);
        contenedorVertical.setSpacing(15);
        contenedorVertical.setPadding(new Insets(150,50,50,50));
        contenedorVertical.setPrefWidth(300);
        
        Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/FondoGris.jpg", 300, 0, false, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorVertical.setBackground(new Background(imagenDeFondo));
        
        this.setLeft(contenedorVertical);

    }
    
   

    private void setCentro(Tablero tablero){

        //Como hago para dibujar cada Algoformer??
        //Capaz tengo que preguntarle a cada celda si contiene un algoformer y
        //Segun la respuesta actuar...
        VBox contenedorCentral = new VBox();
    	//Button[][] matriz;

    	contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(0);
        contenedorCentral.setPadding(new Insets(10));
    	/*matriz = new Button[tablero.ancho()][tablero.altura()];
    	for (int y=0;y<tablero.altura();y++){
    		for (int x=0;x<tablero.ancho();x++){
    			/*
    			SuperficieAerea superficieAerea= tablero.getCelda(new Posicion(x,y)).getSuperficieAerea();
    			SuperficieTerrestre superficieTerrestre= tablero.getCelda(new Posicion(x,y)).getSuperficieTerrestre();
    			//Image imagen = new Image(getClass().getResourceAsStream("src/fiuba/algo3/algoformers/vista/imagenes/escenario/rocoso-nubes.jpg"));
    			matriz[y][x]= new Button ("");//,new ImageView(imagen));
    	    	contenedorCentral.getChildren().add(matriz[x][y]);
    		}
    	}
		*/
    	this.setCenter(contenedorCentral);

    }

    
   /*

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
	*/
 
}
