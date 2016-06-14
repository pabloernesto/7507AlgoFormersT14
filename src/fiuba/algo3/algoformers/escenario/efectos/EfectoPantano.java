package fiuba.algo3.algoformers.escenario.efectos;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class EfectoPantano extends Efecto {
 
	@Override
	public void afectar(AlgoFormer algoformer) {
		algoformer.afectarseCon(this);		
	}

	@Override
	public void desafectar(AlgoFormer algoformer) {
	}
	
}
