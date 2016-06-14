package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;

public interface Superficie{
	
	public void afectar(AlgoFormer algoformer);
	
	public Efecto getEfecto();

}