
package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.efectos.*;
import fiuba.algo3.algoformers.factories.FormaFactory;

public class FormaAerea extends FormaAlterna {

	public FormaAerea (int ataque, int velocidad, int distAtaque, FormaFactory formaFactory){
		super(ataque, velocidad, distAtaque, formaFactory);
	}

	@Override
	public void afectarCon(AlgoFormer algoformer, EfectoNebulosa efecto){
		algoformer.afectarConEfectoNebulosa();
	}

	@Override
	public void afectarCon(AlgoFormer algoformer, EfectoPantano efecto){
	}
	
	@Override
	public void afectarCon(AlgoFormer algoFormer, EfectoTormenta efecto){
		this.ataque = this.ataque*60/100;
	}
	
	@Override
	public void afectarCon(AlgoFormer algoFormer, EfectoEspinas efecto){
	}
	
}