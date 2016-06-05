package fiuba.algo3.algoformers.modelo;

public class Espinas extends SuperficieTerrestre{
	@Override
    public void afectar(AlgoFormer algoformer) {
        algoformer.recibirEfecto(this);
    }

}
