package fiuba.algo3.algoformers.algoformers;

public class EfectoPantano extends Efecto {
 
	@Override
	public void afectar(AlgoFormer algoformer) {
		algoformer.afectarseCon(this);		
	}

	


}
