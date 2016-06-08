package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

public abstract class Efecto {

	public abstract void afectar(AlgoFormer algoformer, FormaHumanoide estadoActivo);
	
	public abstract void afectar(AlgoFormer algoformer, FormaTerrestre estadoActivo);
	
	public abstract void afectar(AlgoFormer algoformer, FormaAerea estadoActivo);
}