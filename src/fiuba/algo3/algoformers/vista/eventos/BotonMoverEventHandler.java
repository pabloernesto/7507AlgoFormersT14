package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
		Button arriba = new Button("↑");
		Button abajo = new Button("↓");
		Button derecha = new Button("→");
		Button izquierda = new Button("←");
		Button arribaDerecha = new Button("↗");
		Button arribaIzquierda = new Button("↖");
		Button abajoDerecha = new Button("↘");
		Button abajoIzquierda = new Button("↙");
		Button terminarTurno = new Button("Terminar turno");
		
		
		matrizBotones.add(arriba, 1, 0);
		matrizBotones.add(abajo, 1, 2);
		matrizBotones.add(derecha, 2, 1);
		matrizBotones.add(izquierda, 0, 1);
		matrizBotones.add(arribaDerecha, 2, 0);
		matrizBotones.add(arribaIzquierda, 0, 0);
		matrizBotones.add(abajoIzquierda, 0, 2);
		matrizBotones.add(abajoDerecha, 2, 2);
		
		int movimientosRestantes = juego.jugadorActual().getAlgoformerElegido().getMovimientosRestantes();
		Label etiqueta = new Label("Movimientos restantes: " + String.valueOf(movimientosRestantes));
		etiqueta.setFont(Font.font("", FontWeight.BOLD, 16));
		etiqueta.setTextFill(Color.GREEN);
		HBox contenedorMovimientos = new HBox(etiqueta);
		contenedor.getChildren().set(2, contenedorMovimientos);
		botonesDireccion.getChildren().addAll(matrizBotones, terminarTurno);
		contenedor.getChildren().set(1, botonesDireccion);
	}
	
	

}
