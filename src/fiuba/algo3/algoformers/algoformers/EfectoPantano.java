package fiuba.algo3.algoformers.algoformers;

public class EfectoPantano extends Efecto {

	
	public void afectar(AlgoFormer algoformer, FormaHumanoide estadoActivo) {
		algoformer.restarMovimientosRestantes(algoformer.getMovimientosRestantes());
	}

	public void afectar(AlgoFormer algoformer, FormaTerrestre estadoActivo) {
		algoformer.restarMovimientosRestantes(1);
	}

	public void afectar(AlgoFormer algoformer, FormaAerea estadoActivo) {
	}

}
