package fiuba.algo3.algoformers.modelo;

public abstract class SuperficieAerea implements Superficie {
	
	@Override
    public void afectar(AlgoFormer algoformer) {
        algoformer.recibirEfecto(this);
    }

}
