package fiuba.algo3.algoformers.escenario.bonus;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;
import fiuba.algo3.algoformers.escenario.efectos.EfectoChispa;

public class ChispaSuprema implements Bonus{

	public void afectar(AlgoFormer algoformer) {
		algoformer.recibirBonus(this);
	}

	public Efecto getEfecto() {
		return new EfectoChispa();
	}

    public String nombre()
    {
        return "chispaSuprema";
    }
}
