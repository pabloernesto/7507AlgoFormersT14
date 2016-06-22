package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BotonInfoAlgoformerEventHandler implements EventHandler<ActionEvent>{

	private AlgoFormer algoformer;
	private HBox contenedor;
	
	public BotonInfoAlgoformerEventHandler(AlgoFormer algoformer, HBox contenedor){
		this.algoformer = algoformer;
		this.contenedor = contenedor;
	}

	public void handle(ActionEvent event) {
		//Si el contenedor tiene 3 elementos, entonces ya se pidio info de otro algoformer
		//hay que borrarla, si no se ve mal
		if (contenedor.getChildren().size() > 2)
			contenedor.getChildren().remove(2);
		String vida = "Vida: " + String.valueOf(algoformer.getVida());
		String ataque = "\nAtaque: " + String.valueOf(algoformer.getAtaque());
		String movRestantes = "\nMovimientos restantes: " + String.valueOf(algoformer.getMovimientosRestantes());
		String distAtaque = "\nDistancia ataque: " + String.valueOf(algoformer.getDistAtaque());
		String informacion = vida + ataque + movRestantes + distAtaque;
    	Label etiqueta = new Label(informacion);
    	etiqueta.setTextFill(Color.web("#FF0000"));
		HBox info = new HBox(etiqueta);
		contenedor.getChildren().add(info);
	}
	
	
}
