package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class Nube extends SuperficieAerea{

	@Override
    public void afectar(AlgoFormer algoformer) {
		algoformer.ubicarseEnSuperficie(this);
    }

}