package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

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
