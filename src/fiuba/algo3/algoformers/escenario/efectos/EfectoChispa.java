package fiuba.algo3.algoformers.escenario.efectos;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class EfectoChispa extends Efecto{

	public void afectar(AlgoFormer algoformer) {
		algoformer.afectarseCon(this);
	}

	public void desafectar(AlgoFormer algoformer) {
	}

}
