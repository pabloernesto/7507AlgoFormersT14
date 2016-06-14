package fiuba.algo3.algoformers.escenario.bonus;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;

public interface Bonus {
	
	public void afectar(AlgoFormer algoformer);
	
	public Efecto getEfecto();

}
