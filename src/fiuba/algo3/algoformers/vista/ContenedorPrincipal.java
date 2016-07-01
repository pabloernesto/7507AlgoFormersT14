package fiuba.algo3.algoformers.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.vista.eventos.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane
{
    BarraDeMenu barraMenu;
    Juego juego;
    Stage stage;
    VistaTablero vistaTablero;
    ScrollPane scrollPane;
    Scene siguienteEscena;
    public Consola consola;
    public HBox botonera;
    public VBox imagenEquipoActual;
    private int posicionPorDefectoAlto=0;
    private int posicionPorDefectoAncho=0;
	public VBox imagenAlgoformersJugadorActual;

    public ContenedorPrincipal(Stage stage, Scene siguienteEscena, Juego juego, BarraDeMenu barraMenu)
    {
        this.juego = juego;
        this.stage = stage;
        this.barraMenu = barraMenu;
        this.siguienteEscena = siguienteEscena;
        this.consola = new Consola();
        this.botonera = new HBox();
        this.imagenEquipoActual= new VBox();
        this.vistaTablero = new VistaTablero();
        this.imagenAlgoformersJugadorActual= new VBox();
        Tablero tablero=Tablero.getInstance();
        posicionPorDefectoAlto=tablero.altura()/2;
    }

    public void inicializar()
    {
        inicializarContenedorDerecha();
        inicializarContenedorIzquierdo();
        inicializarContenedorAbajo();
        setMenu();
        setCentro();
        setBotoneraEleccion();
        setImagenEquipo();
        setImagenAlgoformersJugadorActual();
    }

    private void inicializarContenedorDerecha()
    {
        VBox contenedorDerecha = new VBox();
        contenedorDerecha.setSpacing(15);
        contenedorDerecha.setBackground(
                new Background(
                        new BackgroundImage(
                            new Image("file:src/fiuba/algo3/algoformers/vista/" +
                                "imagenes/intro/FondoDerecha.jpg"),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        contenedorDerecha.getChildren().add(imagenAlgoformersJugadorActual);
        setRight(contenedorDerecha);
    }

    private void inicializarContenedorIzquierdo()
    {
        VBox contenedor = new VBox();
        contenedor.setPadding(new Insets(10));
        contenedor.getChildren().add(imagenEquipoActual);
       	contenedor.setBackground(
                new Background(
                        new BackgroundImage(
                            new Image("file:src/fiuba/algo3/algoformers/vista/" +
                                "imagenes/intro/FondoJuegoIzquierda.jpg",this.getPrefWidth(),this.getPrefHeight(),true,true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
       	VistaConsola vistaConsola = new VistaConsola(consola);
       	vistaConsola.setAlignment(Pos.TOP_LEFT);
       	vistaConsola.setMinSize(100, 200);
       	contenedor.getChildren().add(vistaConsola);
        setLeft(contenedor);
    }
    

    private void inicializarContenedorAbajo(){
    	HBox contenedor = new HBox();
    	contenedor.setPadding(new Insets(20,0,20,0));
        contenedor.setBackground(
                new Background(
                        new BackgroundImage(
                            new Image("file:src/fiuba/algo3/algoformers/vista/" +
                                "imagenes/intro/FondoNegro.jpg"),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        contenedor.setPrefHeight(100);
        contenedor.getChildren().add(botonera);
        contenedor.setAlignment(Pos.CENTER);
        setBottom(contenedor);
    }

    private void setMenu()
    {
        this.setTop(barraMenu);
    }

    public void setBotoneraEleccion()
    {
        Jugador jugador = juego.jugadorActual();
        ubicarseEnAlgoformer(jugador);
        consola.agregarMensaje(jugador.getNombre() +
            " debe elegir un algoformer");

        List<HBox> listaBotones = new ArrayList<HBox>();
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
            boton.setStyle("-fx-base: #1234");
            BotonInfoAlgoformerEventHandler infoHandler =
                new BotonInfoAlgoformerEventHandler(algoformer, this);
            BotonElegirAlgoformerEventHandler elegirHandler =
                new BotonElegirAlgoformerEventHandler(jugador, algoformer,
                infoHandler , this);

            boton.setOnAction(elegirHandler);

            HBox caja = new HBox(boton);
            caja.setSpacing(5);
            listaBotones.add(caja);
        }
        botonera.setSpacing(20);
        botonera.getChildren().clear();
        botonera.getChildren().addAll(listaBotones);
    }
    
    public void setImagenEquipo(){
    	String equipo = juego.jugadorActual().getEquipo();
    	Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/"+equipo+".jpg");
        ImageView imagenView = new ImageView(imagen);
        imagenView.setStyle("-fx-background-color:#1234");
    	imagenEquipoActual.getChildren().clear();
    	imagenEquipoActual.setPadding(new Insets(20));
    	imagenEquipoActual.getChildren().addAll(imagenView);
    	imagenEquipoActual.setAlignment(Pos.CENTER);
    }

    public void setImagenAlgoformersJugadorActual(){
    	imagenAlgoformersJugadorActual.getChildren().clear();
    	Jugador jugador = juego.jugadorActual();
    	List<HBox> listaBotones = new ArrayList<HBox>();
        for (AlgoFormer algoformer : jugador.getListaAlgoformers())
        {
            Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                    "imagenes/algoformers/" + algoformer.getNombre() + 
                    "humanoide.jpg");
            ImageView imagenView = new ImageView(imagen);
            imagenView.setPreserveRatio(true);
            imagenView.setFitHeight(30);
            String info ="Algoformer:"+ algoformer.getNombre()+ "\n"; 
            info +="Vida: " + algoformer.getVida() + "\n";
            info += "Ataque: " + algoformer.getAtaque() + "\n";
            info += "Distancia ataque: " + algoformer.getDistAtaque() + "\n";
            info += "Velocidad: " +
                algoformer.getMovimientosRestantes();
            Label etiqueta =new Label(info);
            etiqueta.setTextFill(Color.web("white"));
            etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
            HBox hbox = new HBox();
            hbox.getChildren().add(imagenView);
            hbox.getChildren().add(etiqueta);
            hbox.setPadding(new Insets(10));
            hbox.setStyle("-fx-background-color:#1234");
            listaBotones.add(hbox);
        }
        imagenAlgoformersJugadorActual.getChildren().addAll(listaBotones);
    }
    
    
    public void ubicarseEnAlgoformer(Jugador jugador){
        double x = calcularPosicionHorizontal(jugador);
        double y = calcularPosicionVertical(jugador);
        scrollPane.setHvalue(x);
        scrollPane.setVvalue(y);
    }

    public void setBotoneraAcciones()
    {
        Button botonMover = new Button("Mover");
        botonMover.setOnAction(evento -> setBotoneraMover());

        Button botonAtacar = new Button("Atacar");
        BotonAtacarEventHandler atacarHandler =
            new BotonAtacarEventHandler(juego, this);
        botonAtacar.setOnAction(atacarHandler);

        Button botonTransformarse = new Button("Transformarse");
        BotonTransformarseEventHandler transformarHandler =
            new BotonTransformarseEventHandler(vistaTablero, juego, this);
        botonTransformarse.setOnAction(transformarHandler);

        Button botonTerminarTurno = new Button("Terminar turno");
        BotonTerminarTurnoEventHandler terminarTurno =
            new BotonTerminarTurnoEventHandler(juego.jugadorActual(), this);
        botonTerminarTurno.setOnAction(terminarTurno);

        Button botonCombinarse = new Button("Combinarse");

        Button botonDescombinarse = new Button("Descombinarse");

        botonCombinarse.setOnAction(
                new BotonCombinarEventHandler(vistaTablero, juego, this));

        if (juego.jugadorActual().combinado){
            botonCombinarse.setDisable(true);
            botonTransformarse.setDisable(true);
        }
        else{
            botonDescombinarse.setDisable(true);
        }
        BotonCombinarEventHandler combinarseHandler =
            new BotonCombinarEventHandler(vistaTablero, juego, this);
        botonCombinarse.setOnAction(combinarseHandler);

        BotonDescombinarEventHandler descombinarseHandler =
            new BotonDescombinarEventHandler(vistaTablero, juego, this);
        botonDescombinarse.setOnAction(descombinarseHandler);

        botonAtacar.setMaxSize(100, 30);
        botonMover.setMaxSize(100, 30);
        botonCombinarse.setMaxSize(100, 30);
        botonTransformarse.setMaxSize(100, 30);

        botonera.getChildren().clear();
        botonera.getChildren().addAll(botonMover, botonAtacar,
            botonTransformarse, botonCombinarse, botonDescombinarse,
            botonTerminarTurno);
    }

    public void setBotoneraAtaque()
    {
        consola.agregarMensaje(juego.jugadorActual().getNombre() +
            " elegi a quien ATACAR");

        botonera.getChildren().clear();
        for (AlgoFormer algoformer :
            juego.jugadorInactivo().getListaAlgoformers())
        {
            Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                    "imagenes/algoformers/" + algoformer.getNombre() +
                        algoformer.nombreEstadoActivo() + ".jpg");
            ImageView imagenView = new ImageView(imagen);
            imagenView.setPreserveRatio(true);
            imagenView.setFitHeight(30);

            Button boton = new Button(algoformer.getNombre(), imagenView);
            boton.setMinSize(100, 50);
            boton.setStyle("-fx-base: #1234");

            BotonAtacarAlgoformerEventHandler elegirHandler =
                new BotonAtacarAlgoformerEventHandler(juego, algoformer,
                    vistaTablero, this);

            boton.setOnAction(elegirHandler);

            botonera.getChildren().add(boton);
        }

        Button botonVolver = new Button("Volver");
        botonVolver.setOnAction(evento -> setBotoneraAcciones());
        botonVolver.setMinSize(100, 50);
        botonera.getChildren().add(botonVolver);
    }

    public void setBotoneraMover()
    {
        Button volver = new Button("Volver");
        volver.setOnAction(evento -> setBotoneraAcciones());

        GridPane matrizBotones = new GridPane();
        for (Movimiento movimiento : Movimiento.values())
        {
        	Image imagen = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                    "imagenes/escenario/" + movimiento.flecha() +
                     ".jpg");
            ImageView imagenView = new ImageView(imagen);
            Button boton = new Button();
            boton.setGraphic(imagenView);
            boton.setOnAction(new MovimientoHandler(movimiento, vistaTablero,
                juego, volver, this));
            int posicionHorizontal = movimiento.getMovimientoEnX() + 1;
            int posicionVertical = movimiento.getMovimientoEnY() + 1;
            matrizBotones.add(boton, posicionHorizontal, posicionVertical);
        }
        Button terminarTurno = new Button("Terminar turno");
        terminarTurno.setOnAction(
            new BotonTerminarTurnoEventHandler(juego.jugadorActual(), this));
        botonera.getChildren().clear();
        botonera.getChildren().add(matrizBotones);
        botonera.getChildren().add(terminarTurno);
        botonera.getChildren().add(volver);
    }

    private void setCentro()
    {
        vistaTablero.dibujar();

        // ScrollPane permite ver el tablero aunque no entre en la pantalla.
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vistaTablero);
        this.scrollPane = scrollPane;

        this.setCenter(scrollPane);
    }

    public BarraDeMenu getBarraDeMenu()
    {
        return barraMenu;
    }

    public Stage getStage(){
        return stage;
    }

    public Scene getSiguienteEscena(){
        return siguienteEscena;
    }

    private double calcularPosicionHorizontal(Jugador jugador){
        jugador = juego.jugadorActual();
        Tablero tablero = Tablero.getInstance();
        Posicion posicionAlgoformer = tablero.getPosicionAlgoformer(jugador.getAlgoformerElegido());
        double x;
        if (posicionAlgoformer != null){
            x = posicionAlgoformer.getPosicionX();
        }
        else {
            x = posicionPorDefectoAncho;
            posicionPorDefectoAncho=tablero.ancho();
        }
        return x / tablero.ancho();
    }

    private double calcularPosicionVertical(Jugador jugador){
        jugador = juego.jugadorActual();
        Tablero tablero = Tablero.getInstance();
        Posicion posicionAlgoformer = tablero.getPosicionAlgoformer(jugador.getAlgoformerElegido());
        double y;
        if (posicionAlgoformer != null){
            y = posicionAlgoformer.getPosicionY();
        }
        else {
            y = posicionPorDefectoAlto;
        }
        return y / tablero.altura();
    }
}

