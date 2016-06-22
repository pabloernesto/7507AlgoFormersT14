package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class BotonMoverEventHandler implements EventHandler<ActionEvent>{
	
	private VistaTablero vistaTablero;
	private Juego juego;
	private HBox contenedor;
	
	public BotonMoverEventHandler(VistaTablero vistaTablero, Juego juego, HBox contenedor){
		this.vistaTablero = vistaTablero;
		this.juego = juego;
		this.contenedor = contenedor;
	}

	public void handle(ActionEvent event) {
		HBox botonesDireccion = new HBox();
		GridPane matrizBotones = new GridPane();
		Button arriba = new Button("||");
		Button abajo = new Button("||");
		Button derecha = new Button("->");
		Button izquierda = new Button("<-");
		Button arribaDerecha = new Button("|-");
		Button arribaIzquierda = new Button("-|");
		Button abajoDerecha = new Button("|_");
		Button abajoIzquierda = new Button("_|");
		
		
		matrizBotones.add(arriba, 1, 0);
		matrizBotones.add(abajo, 1, 2);
		matrizBotones.add(derecha, 2, 1);
		matrizBotones.add(izquierda, 0, 1);
		matrizBotones.add(arribaDerecha, 2, 0);
		matrizBotones.add(arribaIzquierda, 0, 0);
		matrizBotones.add(abajoIzquierda, 0, 2);
		matrizBotones.add(abajoDerecha, 2, 2);
		
		botonesDireccion.getChildren().add(matrizBotones);
		contenedor.getChildren().set(1, botonesDireccion);
	}
	
	

}
