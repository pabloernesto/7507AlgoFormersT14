package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class NebulosaDeAndromeda extends SuperficieAerea{
	
	public void aplicarEfectos(AlgoFormer algoformer) {
		algoformer.recibirEfectos(new EfectoNebulosa());
	}

}