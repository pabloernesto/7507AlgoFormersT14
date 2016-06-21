package fiuba.algo3.algoformers.vista.eventos;

import java.util.ArrayList;
import java.util.List;

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

	//No se acomodan bien los strings, hay que ponerlos de alguna forma que se vean mejor
	public void handle(ActionEvent event) {
		//Si el contenedor ya tiene tres cajas, borrar la ultima
		List<Label> listaEtiquetas = new ArrayList<Label>();
		Label nombre = new Label(algoformer.getNombre());
    	Label vida = new Label("Vida: " + String.valueOf(algoformer.getVida()));
    	Label ataque = new Label("Ataque: " + String.valueOf(algoformer.getAtaque()));
    	Label movimientosRestantes = new Label("\nMovimientos restantes: " + String.valueOf(algoformer.getMovimientosRestantes()));
    	Label distAtaque = new Label("Distancia ataque: " + String.valueOf(algoformer.getDistAtaque()));
    	listaEtiquetas.add(nombre);
    	listaEtiquetas.add(vida);
    	listaEtiquetas.add(ataque);
    	listaEtiquetas.add(movimientosRestantes);
    	listaEtiquetas.add(distAtaque);
    	for (Label etiqueta : listaEtiquetas)
    		etiqueta.setTextFill(Color.web("#FF0000"));
		HBox info = new HBox();
		info.getChildren().addAll(listaEtiquetas);
		contenedor.getChildren().add(info);
	}
	
	
}
