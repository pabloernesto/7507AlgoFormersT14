package fiuba.algo3.algoformers.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.vista.eventos.BotonCombinarEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonElegirAlgoformerEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonInfoAlgoformerEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonMoverEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonTransformarseEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class ContenedorPrincipal extends BorderPane
{
    BarraDeMenu barraMenu;
    Juego juego;
    Stage stage;
    VistaTablero vistaTablero;
    HBox contenedorAbajo;

    public ContenedorPrincipal(Stage stage, Juego juego, BarraDeMenu barraMenu)
    {
        this.juego = juego;
        this.stage = stage;
        this.barraMenu = barraMenu;
        this.contenedorAbajo = new HBox();
        this.contenedorAbajo.setSpacing(75);

        contenedorAbajo.setBackground(
            new Background(
                new BackgroundImage(
                    new Image("file:src/fiuba/algo3/algoformers/vista/" +
                        "imagenes/intro/FondoGris.jpg"),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        this.vistaTablero = new VistaTablero();
    }

    public void inicializar()
    {
    	inicializarContenedorAbajo();
        setMenu();
        setCentro();
        setBotoneraEleccion();
        setBottom(contenedorAbajo);
    }
    
    private void inicializarContenedorAbajo(){ //Esto hace que siempre haya tres HBox en contenedorAbajo
    											//Sirve para poder hacer contenedorAbajo.getChildren().set(1, cajaNueva)
    	inicializarConsola();
    	inicializarContenedor();
    	inicializarContenedor();
    }
    
    private void inicializarConsola()
    {
        HBox consola = new HBox(new Label(""));
        consola.setMinSize(350, 75);
        consola.setStyle("-fx-background-color: black;");

        contenedorAbajo.getChildren().add(consola);
    }
    
    private void inicializarContenedor(){
    	HBox contenedor = new HBox();
    	contenedorAbajo.getChildren().add(contenedor);
    }

    private void setMenu()
    {
        this.setTop(barraMenu);
    }

    public void setMensajeConsola(String mensaje)
    {
        Label etiqueta = new Label();
        etiqueta.setText(mensaje);
        etiqueta.setTextFill(Color.WHITE);

        HBox consola = (HBox) contenedorAbajo.getChildren().get(0);
        consola.getChildren().set(0, etiqueta);
    }
    
    public void agregarMensajeConsola(String mensaje){
    	HBox consola = (HBox) contenedorAbajo.getChildren().get(0);
    	Label etiqueta = (Label) consola.getChildren().get(0);
    	etiqueta.setTextFill(Color.WHITE);
    	etiqueta.setText(etiqueta.getText() + "\n" + mensaje);
    }

    public void setBotoneraEleccion()
    {
    	contenedorAbajo.getChildren().remove(2);
        Jugador jugador = juego.jugadorActual();
    	agregarMensajeConsola(jugador.getNombre() + " debe elegir un algoformer");
        List<VBox> listaBotones = new ArrayList<VBox>();

        for (AlgoFormer algoformer : jugador.getListaAlgoformers())
        {
        	
        	Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/" +
					"imagenes/algoformers/" + algoformer.getNombre() +
						algoformer.nombreEstadoActivo() + ".jpg");
        	ImageView imagenView = new ImageView(imagen);
        	imagenView.setPreserveRatio(true);
        	imagenView.setFitHeight(30);
        	
            Button boton = new Button(algoformer.getNombre(), imagenView);
            boton.setMinSize(100, 50);

            Button botonInfo = new Button();
            botonInfo.setText("Info");
            botonInfo.setMinSize(50, 10);

            BotonInfoAlgoformerEventHandler infoHandler =
                new BotonInfoAlgoformerEventHandler(algoformer, contenedorAbajo);
            BotonElegirAlgoformerEventHandler elegirHandler =
                new BotonElegirAlgoformerEventHandler(jugador, algoformer, infoHandler , this);

            botonInfo.setOnAction(infoHandler);
            boton.setOnAction(elegirHandler);

            VBox caja = new VBox(boton, botonInfo);
            caja.setSpacing(5);
            listaBotones.add(caja);
        }
        HBox contenedor = new HBox();
        contenedor.setSpacing(30);
        contenedor.setMinHeight(75);
        contenedor.getChildren().addAll(listaBotones);
        contenedorAbajo.getChildren().set(1, contenedor);
    }

    public void setBotoneraAcciones()
    {
        Button botonMover = new Button("Mover");
        BotonMoverEventHandler moverHandler =
            new BotonMoverEventHandler(vistaTablero, juego, contenedorAbajo);
        botonMover.setOnAction(moverHandler);

        Button botonAtacar = new Button("Atacar");
        //BotonAtacarEventHandler atacarHandler =
            //new BotonAtacarEventHandler(vistaTablero, juego, this);
        //botonAtacar.setOnAction(atacarHandler);

        Button botonTransformarse = new Button("Transformarse");
        BotonTransformarseEventHandler transformarHandler =
            new BotonTransformarseEventHandler(vistaTablero, juego, this);
        botonTransformarse.setOnAction(transformarHandler);

        Button botonCombinarse = new Button("Combinarse");
        
        Button botonDescombinarse = new Button("Descombinarse");
        
        botonCombinarse.setOnAction(
                new BotonCombinarEventHandler(vistaTablero, juego, botonDescombinarse, this));
        
        //BotonCombinarseEventHandler combinarseHandler =
            //new BotonCombinarseEventHandler(vistaTablero, juego, botonDescombinarse, this);
        //botonCombinarse.setOnAction(combinarseHandler);
        
        botonDescombinarse.setDisable(true);
        //BotonDescombinarseEventHandler descombinarseHandler =
            //new BotonDescombinarseEventHandler(vistaTablero, juego, botonCombinarse, this);
        //botonDescombinarse.setOnAction(descombinarseHandler);

        botonAtacar.setMaxSize(100, 30);
        botonMover.setMaxSize(100, 30);
        botonCombinarse.setMaxSize(100, 30);
        botonTransformarse.setMaxSize(100, 30);

        HBox contenedorHorizontal =
            new HBox(botonMover, botonAtacar, botonTransformarse,
                botonCombinarse, botonDescombinarse);
        contenedorHorizontal.setSpacing(30);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        contenedorHorizontal.setMinHeight(75);

        contenedorAbajo.getChildren().set(1, contenedorHorizontal);
    }

    private void setCentro()
    {
        vistaTablero.dibujar();
        
        // ScrollPane permite ver el tablero aunque no entre en la pantalla.
        ScrollPane sp = new ScrollPane();
        sp.setContent(vistaTablero);
        
        
        this.setCenter(sp);
    }

    public BarraDeMenu getBarraDeMenu()
    {
        return barraMenu;
    }
}

