package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;
import fiuba.algo3.algoformers.escenario.efectos.EfectoTormenta;

public class TormentaPsionica extends SuperficieAerea{
	
	@Override
    public void afectar(AlgoFormer algoformer) {
		algoformer.ubicarseEnSuperficie(this);
    }
	
	@Override
	public Efecto getEfecto() {
		return new EfectoTormenta();
	}

	@Override
	public String getNombre() {
		return "tormenta";
	}

}
