package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class EfectoBurbuja extends EfectoConTurno{

	public EfectoBurbuja(){
		this.turnosRestantes = 3;
	}
	
	@Override
	public void afectar(AlgoFormer algoformer) {
		restarTurnos();
		algoformer.afectarseCon(this);
	}
	
	@Override
	public void desafectar(AlgoFormer algoformer){
	}

}