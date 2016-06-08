package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

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