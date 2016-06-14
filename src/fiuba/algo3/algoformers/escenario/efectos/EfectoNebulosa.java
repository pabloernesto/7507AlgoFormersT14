package fiuba.algo3.algoformers.escenario.efectos;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class EfectoNebulosa extends EfectoConTurno {

	public EfectoNebulosa(){
		this.turnosRestantes = 3;
	}
	
	@Override
	public void afectar(AlgoFormer algoformer) {
		restarTurnos();
		algoformer.afectarseCon(this);
	}

	@Override
	public void desafectar(AlgoFormer algoformer) {
	}

}