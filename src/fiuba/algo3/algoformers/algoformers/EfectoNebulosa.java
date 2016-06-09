package fiuba.algo3.algoformers.algoformers;

public class EfectoNebulosa extends EfectoTemporal {

	public EfectoNebulosa(){
		turnosRestantes = 3;
	}
	
	public void afectar(AlgoFormer algoformer, FormaHumanoide estadoActivo) {
	}

	public void afectar(AlgoFormer algoformer, FormaTerrestre estadoActivo) {
	}

	public void afectar(AlgoFormer algoformer, FormaAerea estadoActivo) {
		algoformer.restarMovimientosRestantes(algoformer.getMovimientosRestantes());
		turnosRestantes -= 1;
		if (turnosRestantes < 1)
			algoformer.borrarEfecto(this);
	}

}