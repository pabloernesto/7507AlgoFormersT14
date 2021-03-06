package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.excepciones.AlgoformerMuyLejosException;
import fiuba.algo3.algoformers.excepciones.EquipoIncompletoException;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonCombinarEventHandler extends AccionAlgoformerEventHandler implements EventHandler<ActionEvent>
{
    private VistaTablero vistaTablero;
    private Juego juego;

    public BotonCombinarEventHandler(VistaTablero vistaTablero, Juego juego, ContenedorPrincipal contenedor)
    {
        this.vistaTablero = vistaTablero;
        this.juego = juego;
        this.contenedorPrincipal = contenedor;
    }

    public void handle(ActionEvent event)
    {
    	try{
    		
    		juego.jugadorActual().combinar();
    		new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/" +
    				"combinar.mp3").play();
    		contenedorPrincipal.consola.setMensaje(
    				juego.jugadorActual().getNombre() + " se ha combinado");
    		crearError("Atencion", "No podras realizar acciones", "La combinacion tarda dos turnos en completarse");
    		vistaTablero.actualizar();
    		contenedorPrincipal.setBotoneraEleccion();
    		contenedorPrincipal.setImagenEquipo();
    		contenedorPrincipal.setImagenAlgoformersJugadorActual();
    		}
    	catch (EquipoIncompletoException e){
    		crearError("ERROR", "Los algoformers no se pueden combinar", "Todos los algoformers deben estar vivos para poder combinarse");
    	}
    	catch (AlgoformerMuyLejosException e){
    		crearError("Error", "Los algoformers no se pueden combinar", "Todos los algoformers deben estar a 2 casilleros del capitan");
    	}
    }
}

