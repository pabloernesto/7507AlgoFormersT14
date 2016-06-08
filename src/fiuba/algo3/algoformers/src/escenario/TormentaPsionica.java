package fiuba.algo3.algoformers.escenario;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class TormentaPsionica extends SuperficieAerea{
	@Override
    public void afectar(AlgoFormer algoformer) {
        algoformer.recibirEfecto(this);
    }

}
