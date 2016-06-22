package fiuba.algo3.algoformers.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ChoiceBox;
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
        setMenu();
        setCentro();
        setConsola();
        setMensajeConsola("debe elegir un algoformer");
        setBotoneraEleccion();
        setBottom(contenedorAbajo);
    }

    private void setMenu()
    {
        this.setTop(barraMenu);
    }

    private void setConsola()
    {
        HBox consola = new HBox(new Label(""));
        consola.setMinSize(350, 75);
        consola.setStyle("-fx-background-color: black;");

        contenedorAbajo.getChildren().add(consola);
    }

    public void setMensajeConsola(String mensaje)
    {
        Label etiqueta = new Label();
        etiqueta.setText(juego.jugadorActual().getNombre() + " " + mensaje);
        etiqueta.setTextFill(Color.WHITE);

        HBox consola = (HBox) contenedorAbajo.getChildren().get(0);
        consola.getChildren().set(0, etiqueta);
    }

    private void setBotoneraEleccion()
    {
        ChoiceBox cb = new ChoiceBox();

        for (AlgoFormer af : juego.jugadorActual().getListaAlgoformers())
            cb.getItems().add(af.getNombre());

        // Explicarle al ChoiceBox que debe hacer cuando se selecciona uno de
        // sus elementos.
        cb.getSelectionModel().selectedItemProperty().addListener(
            (observableValue, oldValue, newValue) ->
            {
                juego.jugadorActual().elegirAlgoFormer((String) newValue);
                this.setMensajeConsola("eligio a: " + (String) newValue);
                this.setBotoneraAcciones();
            }
        );

        contenedorAbajo.getChildren().add(cb);
    }

    public void setBotoneraAcciones()
    {
        Button botonMover = new Button("Mover");
        //BotonMoverEventHandler moverHandler =
            //new BotonElegirMoverHandler(vistaTablero, juego, this);
        //botonMover.setOnAction(moverHandler);

        Button botonAtacar = new Button("Atacar");
        //BotonAtacarEventHandler atacarHandler =
            //new BotonAtacarEventHandler(vistaTablero, juego, this);
        //botonAtacar.setOnAction(atacarHandler);

        Button botonTransformarse = new Button("Transformarse");
        //BotonTransformarseEventHandler transformarHandler =
            //new BotonTransformarseEventHandler(vistaTablero, juego, this);
        //botonTransformarse.setOnAction(transformarHandler);

        Button botonCombinarse = new Button("Combinarse");
        //BotonCombinarseEventHandler combinarseHandler =
            //new BotonCombinarseEventHandler(vistaTablero, juego, this);
        //botonCombinarse.setOnAction(combinarseHandler);

        botonAtacar.setMaxSize(100, 30);
        botonMover.setMaxSize(100, 30);
        botonCombinarse.setMaxSize(100, 30);
        botonTransformarse.setMaxSize(100, 30);

        HBox contenedorHorizontal =
            new HBox(botonMover, botonAtacar, botonTransformarse,
                botonCombinarse);
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

