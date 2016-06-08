package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public abstract class Superficie {
	
	protected Efecto efecto;
	
	public void aplicarEfectos(AlgoFormer algoformer) {
		algoformer.recibirEfectos(efecto);
	}
}