package fiuba.algo3.algoformers.algoformers;

public class EfectoTormenta extends Efecto{

	@Override
	public void afectar(AlgoFormer algoformer) {
		algoformer.afectarseCon(this);		
	}

	

}
