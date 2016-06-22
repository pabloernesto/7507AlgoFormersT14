package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonElegirAlgoformerEventHandler implements EventHandler<ActionEvent>{

	private Jugador jugador;
	private AlgoFormer algoformer;
	private ContenedorPrincipal contenedorPrincipal;
	private BotonInfoAlgoformerEventHandler infoHandler;
	
	public BotonElegirAlgoformerEventHandler(Jugador jugador, AlgoFormer algoformer,
											BotonInfoAlgoformerEventHandler infoHandler, ContenedorPrincipal contenedor) {
        this.jugador = jugador;
        this.algoformer = algoformer;
        this.contenedorPrincipal = contenedor;
        this.infoHandler = infoHandler;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.elegirAlgoformer(algoformer);
        infoHandler.handle(new ActionEvent());
        contenedorPrincipal.setMensajeConsola("eligio a: " + algoformer.getNombre());
        contenedorPrincipal.setBotoneraAcciones();
    }
}
