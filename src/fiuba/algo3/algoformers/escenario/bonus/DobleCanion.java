package fiuba.algo3.algoformers.escenario.bonus;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.superficies.Efecto;
import fiuba.algo3.algoformers.escenario.superficies.EfectoDobleCanion;

public class DobleCanion implements Bonus{

	@Override
	public void afectar(AlgoFormer algoformer) {
		algoformer.recibirBonus(this);
	}

	@Override
	public Efecto getEfecto() {
		return new EfectoDobleCanion();
	}

}
