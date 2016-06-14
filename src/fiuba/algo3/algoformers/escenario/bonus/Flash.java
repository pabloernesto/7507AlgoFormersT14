package fiuba.algo3.algoformers.escenario.bonus;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.superficies.Efecto;
import fiuba.algo3.algoformers.escenario.superficies.EfectoFlash;

public class Flash implements Bonus{

	@Override
	public void afectar(AlgoFormer algoformer) {
		algoformer.recibirBonus(this);
	}

	@Override
	public Efecto getEfecto() {
		return new EfectoFlash();
	}

}
