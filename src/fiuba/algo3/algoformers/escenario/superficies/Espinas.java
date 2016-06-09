package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class Espinas extends SuperficieTerrestre{
	
	@Override
    public void afectar(AlgoFormer algoformer) {
        algoformer.ubicarseEnSuperficie(this);
    }

}