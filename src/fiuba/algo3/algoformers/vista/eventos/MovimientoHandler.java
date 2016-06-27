package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.excepciones.PosicionInvalidaException;
import fiuba.algo3.algoformers.juego.Juego;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;

class MovimientoHandler
    extends AccionAlgoformerEventHandler
    implements EventHandler<ActionEvent>
{
    private Movimiento direccion;
    private VistaTablero vistaTablero;
    private Juego juego;
    private Button botonVolver;

    public MovimientoHandler(Movimiento direccion, VistaTablero vistaTablero,
        Juego juego, Button volver, ContenedorPrincipal contenedorPrincipal)
    {
        this.direccion = direccion;
        this.vistaTablero = vistaTablero;
        this.juego = juego;
        this.botonVolver = volver;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    public void handle(ActionEvent actionEvent)
    {
    	try
    	{
    		juego.jugadorActual().mover(direccion);
    		botonVolver.setDisable(true);
            int movRestantes = juego.jugadorActual()
                .getAlgoformerElegido().getMovimientosRestantes();
            if (movRestantes < 0)
            	movRestantes = 0;
            new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/" +
                "mover.mp3").play();
            vistaTablero.actualizar();
            chequearGanador(juego);
    	}

    	catch (PosicionInvalidaException e)
    	{
    		crearError("ERROR", "Movimiento invalido", "Fin del tablero");
		}

    	catch (CeldaOcupadaException e)
    	{
    		crearError("ERROR", "Movimiento invalido",
    		    "Esa celda ya esta ocupada");
    	}

    	catch (NoHayMasMovimientosException e)
    	{
    		crearError("ERROR", "Imposible moverse",
    		    "Se acabaron los movimientos por turno del algoformer");
	    }
    }
}

