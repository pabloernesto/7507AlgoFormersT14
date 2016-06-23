package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.juego.*;
import fiuba.algo3.algoformers.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent>{

	private ContenedorPrincipal contenedorPrincipal;
	private Jugador jugadorAtacante;
	Juego juego;
	
	public BotonAtacarEventHandler(Juego juego, ContenedorPrincipal contenedor)
	{
		this.contenedorPrincipal = contenedor;
		this.juego = juego;
        this.jugadorAtacante = juego.jugadorActual();
    }
	
	
	@Override
	public void handle(ActionEvent event){
		this.contenedorPrincipal.setMensajeConsola(jugadorAtacante.getNombre() + " va a atacar con "
												+ jugadorAtacante.getAlgoformerElegido().getNombre());
		contenedorPrincipal.setBotoneraAtaque();
	}
	


}
