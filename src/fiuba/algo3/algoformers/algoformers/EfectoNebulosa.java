package fiuba.algo3.algoformers.algoformers;

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