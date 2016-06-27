package fiuba.algo3.algoformers.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.vista.eventos.BotonAtacarAlgoformerEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonAtacarEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonCombinarEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonDescombinarEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonElegirAlgoformerEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonInfoAlgoformerEventHandler;
import fiuba.algo3.algoformers.vista.eventos.MovimientoHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonTerminarTurnoEventHandler;
import fiuba.algo3.algoformers.vista.eventos.BotonTransformarseEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    public Consola infoPanel;
    public Pane botonera;

    public ContenedorPrincipal(Stage stage, Scene siguienteEscena, Juego juego, BarraDeMenu barraMenu)
    {
        this.juego = juego;
        this.stage = stage;
        this.barraMenu = barraMenu;
        this.siguienteEscena = siguienteEscena;
        consola = new Consola();
        infoPanel = new Consola();
        botonera = new VBox();

        this.vistaTablero = new VistaTablero();
    }

    public void inicializar()
    {
        inicializarContenedorAbajo();
        inicializarContenedorIzquierdo();
        setMenu();
        setCentro();
        setBotoneraEleccion();
    }

    private void inicializarContenedorAbajo()
    {
        HBox contenedorAbajo = new HBox();
        contenedorAbajo.setSpacing(75);
        contenedorAbajo.setBackground(
            new Background(
                new BackgroundImage(
                    new Image("file:src/fiuba/algo3/algoformers/vista/" +
                        "imagenes/intro/FondoGris.jpg"),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        contenedorAbajo.getChildren().add(new VistaConsola(infoPanel));
        contenedorAbajo.getChildren().add(new VistaConsola(consola));

        setBottom(contenedorAbajo);
    }

    private void inicializarContenedorIzquierdo()
    {
        HBox contenedor = new HBox();
        contenedor.setSpacing(75);
        contenedor.setBackground(
            new Background(
                new BackgroundImage(
                    new Image("file:src/fiuba/algo3/algoformers/vista/" +
                        "imagenes/intro/FondoGris.jpg"),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        contenedor.getChildren().add(botonera);

        setLeft(contenedor);
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
                new BotonInfoAlgoformerEventHandler(algoformer, this);
            BotonElegirAlgoformerEventHandler elegirHandler =
                new BotonElegirAlgoformerEventHandler(jugador, algoformer,
                infoHandler , this);

            botonInfo.setOnAction(infoHandler);
            boton.setOnAction(elegirHandler);

            VBox caja = new VBox(boton, botonInfo);
            caja.setSpacing(5);
            listaBotones.add(caja);
        }

        botonera.getChildren().clear();
        botonera.getChildren().addAll(listaBotones);
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

            BotonAtacarAlgoformerEventHandler elegirHandler =
                new BotonAtacarAlgoformerEventHandler(juego, algoformer,
                    vistaTablero, this);

            boton.setOnAction(elegirHandler);

            botonera.getChildren().add(boton);
        }

        Button botonVolver = new Button("Volver");
        botonVolver.setOnAction(evento -> setBotoneraEleccion());
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
            Button boton = new Button(movimiento.flecha());
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
            x = tablero.ancho() / 2;
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
            y = tablero.altura() / 2;
        }
        return y / tablero.altura();
    }
}

