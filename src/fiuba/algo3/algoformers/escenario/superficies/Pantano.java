package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;
import fiuba.algo3.algoformers.escenario.efectos.EfectoPantano;

public class Pantano extends SuperficieTerrestre{
	
	
	@Override
    public void afectar(AlgoFormer algoformer) {
		algoformer.ubicarseEnSuperficie(this);
    }
	
	@Override
	public Efecto getEfecto() {
		return new EfectoPantano();
	}

}
