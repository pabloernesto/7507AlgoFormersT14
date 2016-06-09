package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class JugadorDecepticons extends Jugador {

	public JugadorDecepticons (){
		super();
	}
	
	public void inicializarEquipo() {
		factory = new DecepticonFactory();
		equipo = factory.crearEquipo();
	}

}