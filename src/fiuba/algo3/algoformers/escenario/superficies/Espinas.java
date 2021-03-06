package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;
import fiuba.algo3.algoformers.escenario.efectos.EfectoEspinas;

public class Espinas extends SuperficieTerrestre{
	
	@Override
    public void afectar(AlgoFormer algoformer) {
        algoformer.ubicarseEnSuperficie(this);
    }
	
	@Override
	public Efecto getEfecto() {
		return new EfectoEspinas();
	}
	
	@Override
	public String getNombre() {
		return "espinas";
	}


}