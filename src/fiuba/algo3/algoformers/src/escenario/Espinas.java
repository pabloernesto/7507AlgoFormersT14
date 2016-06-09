package fiuba.algo3.algoformers.escenario;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class Espinas extends SuperficieTerrestre{
	
	@Override
    public void afectar(AlgoFormer algoformer) {
        algoformer.recibirEfecto(this);
    }

}