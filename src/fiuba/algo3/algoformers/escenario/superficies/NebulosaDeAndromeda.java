package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;
import fiuba.algo3.algoformers.escenario.efectos.EfectoNebulosa;

public class NebulosaDeAndromeda extends SuperficieAerea{
	
	@Override
    public void afectar(AlgoFormer algoformer) {
		algoformer.ubicarseEnSuperficie(this);
    }
	
	@Override
	public Efecto getEfecto() {
		return new EfectoNebulosa();
	}

}
