package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class EfectoTormenta extends Efecto{

	@Override
	public void afectar(AlgoFormer algoformer) {
		algoformer.afectarseCon(this);		
	}

	

}
