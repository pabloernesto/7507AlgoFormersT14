package fiuba.algo3.algoformers.modelo;

public class NebulosaDeAndromeda extends SuperficieAerea{
	
	@Override
    public void afectar(AlgoFormer algoformer) {
        algoformer.recibirEfecto(this);
    }

}
