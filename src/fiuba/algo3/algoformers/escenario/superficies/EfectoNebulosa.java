package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class EfectoNebulosa extends EfectoConTurno {

	public EfectoNebulosa(){
		this.turnosRestantes = 2;
	}
	
	@Override
	public void afectar(AlgoFormer algoformer) {
		algoformer.afectarseCon(this);
		restarTurnos();
	}




}