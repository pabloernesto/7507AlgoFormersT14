package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaTablero;
import fiuba.algo3.algoformers.vista.eventos.MovimientoHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	private ContenedorPrincipal contenedorPrincipal;
	
	public BotonMoverEventHandler(VistaTablero vistaTablero, Juego juego, HBox contenedor, ContenedorPrincipal contenedorPrincipal){
		this.vistaTablero = vistaTablero;
		this.juego = juego;
		this.contenedor = contenedor;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	public void handle(ActionEvent event) {
		HBox botonesDireccion = new HBox();
		GridPane matrizBotones = new GridPane();
		
		int movimientosRestantes = juego.jugadorActual().getAlgoformerElegido().getMovimientosRestantes();
		Label etiqueta = new Label("Movimientos restantes: " + String.valueOf(movimientosRestantes));
		etiqueta.setFont(Font.font("", FontWeight.BOLD, 16));
		etiqueta.setTextFill(Color.GREEN);
		
		Button volver = new Button("Volver");
		BotonVolverAElegirAccionEventHandler volverHandler = new BotonVolverAElegirAccionEventHandler(contenedorPrincipal);
		volver.setOnAction(volverHandler);
		
		for (Movimiento movimiento : Movimiento.values())
		{
		    Button boton = new Button(movimiento.flecha());
		    boton.setOnAction(new MovimientoHandler(movimiento, vistaTablero,
		        juego, movimientosRestantes, etiqueta, volver, contenedorPrincipal));
	        
	        int posicionHorizontal = movimiento.getMovimientoEnX() + 1;
	        int posicionVertical = movimiento.getMovimientoEnY() + 1;
	        matrizBotones.add(boton, posicionHorizontal, posicionVertical);
		}

		Button terminarTurno = new Button("Terminar turno");
		BotonTerminarTurnoEventHandler terminarTurnoHandler = new BotonTerminarTurnoEventHandler(juego.jugadorActual(), contenedorPrincipal);
		terminarTurno.setOnAction(terminarTurnoHandler);
		
		matrizBotones.add(terminarTurno, 4, 0);
		matrizBotones.add(volver, 4, 2);

		HBox contenedorMovimientos = new HBox(etiqueta);
		contenedor.getChildren().set(2, contenedorMovimientos);
		botonesDireccion.getChildren().addAll(matrizBotones);
		contenedor.getChildren().set(1, botonesDireccion);
	}
	
	

}
