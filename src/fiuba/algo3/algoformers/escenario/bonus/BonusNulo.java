package fiuba.algo3.algoformers.escenario.bonus;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;

public class BonusNulo implements Bonus{

	@Override
	public void afectar(AlgoFormer algoformer) {
	}

	@Override
	public Efecto getEfecto() {
		return null;
	}

}
