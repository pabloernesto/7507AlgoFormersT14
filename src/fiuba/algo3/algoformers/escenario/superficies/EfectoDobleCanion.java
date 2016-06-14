package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class EfectoDobleCanion extends EfectoConTurno{

	public EfectoDobleCanion(){
		this.turnosRestantes = 4;
	}
	
	@Override
	public void afectar(AlgoFormer algoformer) {
		restarTurnos();
		algoformer.afectarseCon(this);
	}
	
	@Override
	public void desafectar(AlgoFormer algoformer) {
		algoformer.desafectarseDe(this);
	}

}