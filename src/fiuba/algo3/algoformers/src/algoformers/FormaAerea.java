package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.superficies.Efecto;

public class FormaAerea extends FormaAlterna {

	public FormaAerea (int ataque, int velocidad, int distAtaque){
		super(ataque, velocidad, distAtaque);
	}

	public void recibirEfectos(AlgoFormer algoformer, Efecto efecto){
	    efecto.afectar(algoformer, this);
	}
}
