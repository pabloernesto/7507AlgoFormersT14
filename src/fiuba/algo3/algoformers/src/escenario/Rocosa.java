package fiuba.algo3.algoformers.modelo;

public class Rocosa extends SuperficieTerrestre{
	
	@Override
    public void afectar(AlgoFormer algoformer) {
        algoformer.recibirEfecto(this);
    }

}
