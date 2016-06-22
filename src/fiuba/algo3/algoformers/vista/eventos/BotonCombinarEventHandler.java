package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;

public class BotonCombinarEventHandler implements EventHandler<ActionEvent>
{
    private VistaTablero vistaTablero;
    private Juego juego;
    private ContenedorPrincipal contenedorPrincipal;
    private Button botonDescombinarse;

    public BotonCombinarEventHandler(VistaTablero vistaTablero, Juego juego,
    		 Button botonDescombinarse, ContenedorPrincipal contenedor)
    {
        this.vistaTablero = vistaTablero;
        this.juego = juego;
        this.contenedorPrincipal = contenedor;
        this.botonDescombinarse = botonDescombinarse;
    }

    public void handle(ActionEvent event)
    {
        juego.jugadorActual().combinar();
        new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/" +
            "combinar.mp3").play();
        contenedorPrincipal.setMensajeConsola(
            juego.jugadorActual().getNombre() + " se ha combinado");
        vistaTablero.actualizar();
        contenedorPrincipal.setBotoneraEleccion();
    }
}

