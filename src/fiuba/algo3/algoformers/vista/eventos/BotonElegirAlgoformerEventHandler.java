package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.juego.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonElegirAlgoformerEventHandler implements EventHandler<ActionEvent>{

	private Jugador jugador;
	private AlgoFormer algoformer;
	
	public BotonElegirAlgoformerEventHandler(Jugador jugador, AlgoFormer algoformer) {
        this.jugador = jugador;
        this.algoformer = algoformer;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.elegirAlgoformer(algoformer);
        //Hacer que cambien los botones que se muestran abajo del tablero
    }
}
