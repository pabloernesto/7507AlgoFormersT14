package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

public class EfectoTormenta extends Efecto {

	public void afectar(AlgoFormer algoformer, FormaHumanoide estadoActivo) {
	}
	
	public void afectar(AlgoFormer algoformer, FormaTerrestre estadoActivo) {
	}

	public void afectar(AlgoFormer algoformer, FormaAerea estadoActivo) {
		int ataque = algoformer.getAtaque();
		int nuevoAtaque = ataque /100 * 60;
		algoformer.setAtaque(nuevoAtaque);
	}

}
