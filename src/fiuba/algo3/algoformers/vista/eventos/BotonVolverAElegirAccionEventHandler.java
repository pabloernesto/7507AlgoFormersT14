package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;

public class BotonVolverAElegirAccionEventHandler implements EventHandler<ActionEvent> {

	ContenedorPrincipal contenedorPrincipal;
	HBox contenedorEtiqueta;
	
	public BotonVolverAElegirAccionEventHandler(ContenedorPrincipal contenedorPrincipal) {
		this.contenedorPrincipal = contenedorPrincipal;
		HBox contenedorAbajo = (HBox) contenedorPrincipal.getBottom();
		contenedorEtiqueta = (HBox) contenedorAbajo.getChildren().get(2);
	}

	@Override
	public void handle(ActionEvent event) {
		contenedorPrincipal.setBotoneraAcciones();
		HBox contenedorAbajo = (HBox) contenedorPrincipal.getBottom();
		contenedorAbajo.getChildren().set(2, contenedorEtiqueta);
	}

}
