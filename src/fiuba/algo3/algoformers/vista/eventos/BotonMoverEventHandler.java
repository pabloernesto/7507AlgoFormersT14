package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import fiuba.algo3.algoformers.vista.eventos.MovimientoHandler;
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
		
		for (Movimiento movimiento : Movimiento.values())
		{
		    Button boton = new Button(movimiento.flecha());
		    boton.setOnAction(new MovimientoHandler(movimiento, vistaTablero,
		        juego));
	        
	        int posicionHorizontal = movimiento.getMovimientoEnX() + 1;
	        int posicionVertical = movimiento.getMovimientoEnY() + 1;
	        matrizBotones.add(boton, posicionHorizontal, posicionVertical);
		}

		Button terminarTurno = new Button("Terminar turno");

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
