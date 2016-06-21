package fiuba.algo3.algoformers.escenario.bonus;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;
import fiuba.algo3.algoformers.escenario.efectos.EfectoBurbuja;

public class BurbujaInmaculada implements Bonus{

	@Override
	public void afectar(AlgoFormer algoformer) {
		algoformer.recibirBonus(this);
	}

	@Override
	public Efecto getEfecto() {
		return new EfectoBurbuja();
	}

    public String nombre()
    {
        return "burbuja";
    }
}

