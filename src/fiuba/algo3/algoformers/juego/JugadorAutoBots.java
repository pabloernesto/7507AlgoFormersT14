package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.factories.AutoBotFactory;

public class JugadorAutoBots extends Jugador {

	public JugadorAutoBots (){
		super();
	}
	
	public void inicializarEquipo() {
		factory = new AutoBotFactory();
		equipo = factory.crearEquipo();
	}

}
