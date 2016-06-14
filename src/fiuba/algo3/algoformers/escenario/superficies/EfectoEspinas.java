package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class EfectoEspinas extends Efecto{

	public void afectar(AlgoFormer algoformer){
		algoformer.afectarseCon(this);
	}

	@Override
	public void desafectar(AlgoFormer algoformer) {
	}
	
}
