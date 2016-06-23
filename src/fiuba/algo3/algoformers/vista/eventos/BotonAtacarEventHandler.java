package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.*;
import fiuba.algo3.algoformers.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedorPrincipal;
	Jugador jugadorAtacante;
	
	public BotonAtacarEventHandler(Jugador jugadorAtacante,ContenedorPrincipal contenedor)
	{
		this.contenedorPrincipal = contenedor;
        this.jugadorAtacante = jugadorAtacante;
    }
	
	
	@Override
	public void handle(ActionEvent event){
		this.contenedorPrincipal.setMensajeConsola(jugadorAtacante.getNombre() + "va a atacar con "
				+jugadorAtacante.getAlgoformerElegido().getNombre());
		contenedorPrincipal.setBotoneraAtaque();
	}
	


}
