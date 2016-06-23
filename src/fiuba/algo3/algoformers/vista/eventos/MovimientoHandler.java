package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.juego.Juego;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.media.AudioClip;

class MovimientoHandler implements EventHandler<ActionEvent>
{
    private Movimiento direccion;
    private VistaTablero vistaTablero;
    private Juego juego;

    public MovimientoHandler(Movimiento direccion, VistaTablero vistaTablero,
        Juego juego)
    {
        this.direccion = direccion;
        this.vistaTablero = vistaTablero;
        this.juego = juego;
    }

    public void handle(ActionEvent actionEvent)
    {
        juego.jugadorActual().mover(direccion);
        new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/" +
            "mover.mp3").play();
        vistaTablero.actualizar();
    }
}

