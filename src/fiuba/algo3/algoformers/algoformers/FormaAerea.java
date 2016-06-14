
package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.factories.FormaFactory;

public class FormaAerea extends FormaAlterna {

	public FormaAerea (int ataque, int velocidad, int distAtaque, FormaFactory formaFactory){
		super(ataque, velocidad, distAtaque, formaFactory);
	}

	@Override
	public void afectarConEfectoNebulosa(AlgoFormer algoformer){
		algoformer.afectarConEfectoNebulosa();
	}

	@Override
	public void afectarConEfectoPantano(AlgoFormer algoformer){
	}
	
	@Override
	public void afectarConEfectoTormenta(AlgoFormer algoFormer){
		this.ataque = this.ataque*60/100;
	}
	
	@Override
	public void afectarConEfectoEspinas(AlgoFormer algoFormer){
	}
	
}