package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import fiuba.algo3.algoformers.vista.eventos.MovimientoHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BotonMoverEventHandler implements EventHandler<ActionEvent>
{
    private VistaTablero vistaTablero;
    private Juego juego;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonMoverEventHandler(VistaTablero vistaTablero, Juego juego,
        ContenedorPrincipal contenedorPrincipal)
    {
        this.vistaTablero = vistaTablero;
        this.juego = juego;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    public void handle(ActionEvent event)
    {
        GridPane matrizBotones = new GridPane();

        Button volver = new Button("Volver");
        volver.setOnAction(evento -> contenedorPrincipal.setBotoneraAcciones());
        matrizBotones.add(volver, 4, 2);
        
        for (Movimiento movimiento : Movimiento.values())
        {
            Button boton = new Button(movimiento.flecha());
            boton.setOnAction(new MovimientoHandler(movimiento, vistaTablero,
                juego, volver, contenedorPrincipal));

            int posicionHorizontal = movimiento.getMovimientoEnX() + 1;
            int posicionVertical = movimiento.getMovimientoEnY() + 1;
            matrizBotones.add(boton, posicionHorizontal, posicionVertical);
        }

        Button terminarTurno = new Button("Terminar turno");
        terminarTurno.setOnAction(
            new BotonTerminarTurnoEventHandler(juego.jugadorActual(),
                contenedorPrincipal));
        matrizBotones.add(terminarTurno, 4, 0);

        contenedorPrincipal.botonera.getChildren().clear();
        contenedorPrincipal.botonera.getChildren().add(matrizBotones);
    }
}

