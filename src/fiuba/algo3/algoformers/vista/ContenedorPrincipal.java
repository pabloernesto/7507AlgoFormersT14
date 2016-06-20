package fiuba.algo3.algoformers.vista;


import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.vista.eventos.BotonAlgoformer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
	Canvas canvasCentral;
	Juego juego;
	Stage stage;
	//VistaTablero vistaTablero; -->Implementar (creo que es la unica vista que haria falta 
												// (no haria falta la vista de algoformer)
   	
    public ContenedorPrincipal(Stage stage, Juego juego){
    	
    	this.juego = juego;
    	this.stage = stage;
    	//this.setConsola();
        
    }
    
    public void iniciar(){
    	setMenu();
    	setCentro();
    	cicloPrincipal();
    }

    private void setMenu() {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
    //esto haria un ciclo hasta que haya un ganador
    public void cicloPrincipal(){
    	Jugador jugadorActual = juego.jugadorActual();
        this.setBotoneraElegir(jugadorActual);
        this.setContenedorAtributos(jugadorActual);
    }
    
    private void setBotoneraElegir(Jugador jugador){
    	List<BotonAlgoformer> listaBotones = new ArrayList<BotonAlgoformer>();
    	for (AlgoFormer algoformer : jugador.getListaAlgoformers()){
    		BotonAlgoformer boton = new BotonAlgoformer(algoformer);
    		boton.setText(algoformer.getNombre());
    		boton.setMinSize(100, 75);
    		listaBotones.add(boton);
    	}
    	HBox contenedor = new HBox();
    	contenedor.setAlignment(Pos.BOTTOM_CENTER);
    	contenedor.setSpacing(30);
    	Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/FondoGris.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	contenedor.setBackground(new Background(imagenDeFondo));
    	contenedor.getChildren().addAll(listaBotones);
    	this.setBottom(contenedor);
    }
    
    private void setContenedorAtributos(Jugador jugador){
    	List<Label> listaEtiquetas = new ArrayList<Label>();
    	for (AlgoFormer algoformer : jugador.getListaAlgoformers()){
    		Label nombre = new Label();
    		nombre.setText("\n\n" + algoformer.getNombre());
    		nombre.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
    		Label vida = new Label();
    		vida.setText("Vida: " + String.valueOf(algoformer.getVida()));
    		Label ataque = new Label();
    		ataque.setText("Ataque: " + String.valueOf(algoformer.getAtaque()));
    		Label movimientosRestantes = new Label();
    		movimientosRestantes.setText("Movimientos restantes: " + String.valueOf(algoformer.getMovimientosRestantes()));
    		Label distAtaque = new Label();
    		distAtaque.setText("Distancia ataque: " + String.valueOf(algoformer.getDistAtaque()));
    		listaEtiquetas.add(nombre);
    		listaEtiquetas.add(vida);
    		listaEtiquetas.add(ataque);
    		listaEtiquetas.add(movimientosRestantes);
    		listaEtiquetas.add(distAtaque);
    	}
    	for (Label etiqueta : listaEtiquetas)
    		etiqueta.setTextFill(Color.web("#FF0000"));
    	VBox contenedor = new VBox();
    	Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/FondoGris.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	contenedor.setBackground(new Background(imagenDeFondo));
    	contenedor.getChildren().addAll(listaEtiquetas);
    	this.setLeft(contenedor);
    }
    
    //Se me ocurre que esta funcion es llamada desde los EventHandler de los botones que se tocan cuando se eligen algoformers
    private void setBotoneraAcciones(){//AlgoFormer algoformer) {

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


        botonAtacar.setMinSize(100, 60);
        botonMover.setMinSize(100, 60);
        botonCombinarse.setMinSize(100, 60);
        botonTransformarse.setMinSize(100, 60);
        
        HBox contenedorHorizontal = new HBox(botonMover, botonAtacar,botonTransformarse,botonCombinarse);
        contenedorHorizontal.setSpacing(30);
        contenedorHorizontal.setPadding(new Insets(50,0,50,450)); //el primero es para el alto.. el ultimo para el lugar horizontal
        //contenedorVertical.setMinHeight(100);
        
        Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/intro/FondoGris.jpg", 300, 0, false, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorHorizontal.setBackground(new Background(imagenDeFondo));
        
        //this.contenedorBotonesAcciones = contenedorHorizontal;

    }

    private void setCentro(){

        //Como hago para dibujar cada Algoformer??
        //Capaz tengo que preguntarle a cada celda si contiene un algoformer y
        //Segun la respuesta actuar...
        HBox contenedorCentral = new HBox();
    	//Button[][] matriz;

    	contenedorCentral.setAlignment(Pos.BOTTOM_CENTER);
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


    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
	
 
}
