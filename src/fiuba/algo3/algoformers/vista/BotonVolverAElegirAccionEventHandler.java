package fiuba.algo3.algoformers.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVolverAElegirAccionEventHandler implements EventHandler<ActionEvent> {

	ContenedorPrincipal contenedorPrincipal;
	
	public BotonVolverAElegirAccionEventHandler(ContenedorPrincipal contenedorPrincipal) {
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(ActionEvent event) {
		contenedorPrincipal.setBotoneraAcciones();
		
	}

}
