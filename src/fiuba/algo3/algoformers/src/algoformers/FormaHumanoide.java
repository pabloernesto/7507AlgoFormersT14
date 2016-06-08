package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.superficies.Efecto;

public class FormaHumanoide extends Forma {

	public FormaHumanoide (int ataque, int velocidad, int distAtaque){
		super(ataque, velocidad, distAtaque);
	}

	public void recibirEfectos(AlgoFormer algoformer, Efecto efecto){
	    efecto.afectar(algoformer, this);
	}
}

