package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.efectos.*;
import fiuba.algo3.algoformers.factories.FormaFactory;

public class FormaTerrestre extends FormaAlterna {

	public FormaTerrestre (int ataque, int velocidad, int distAtaque, FormaFactory formaFactory){
		super(ataque, velocidad, distAtaque, formaFactory);
	}

	@Override
	public void afectarCon(AlgoFormer algoformer, EfectoPantano efecto){
		algoformer.afectarConEfectoPantanoFormaTerrestre();
	}
	
	@Override
	public void afectarCon(AlgoFormer algoFormer, EfectoTormenta efecto){
	}
	
	@Override
	public void afectarCon(AlgoFormer algoFormer, EfectoNebulosa efecto){	
	}
	
	@Override
	public void afectarCon(AlgoFormer algoformer, EfectoEspinas efecto){
		algoformer.afectarConEfectoEspinas();
	}
	
	
}