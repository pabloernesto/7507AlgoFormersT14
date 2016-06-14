package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.factories.FormaFactory;

public class FormaTerrestre extends FormaAlterna {

	public FormaTerrestre (int ataque, int velocidad, int distAtaque, FormaFactory formaFactory){
		super(ataque, velocidad, distAtaque, formaFactory);
	}

	@Override
	public void afectarConEfectoPantano(AlgoFormer algoformer){
		algoformer.afectarConEfectoPantanoFormaTerrestre();
	}
	
	@Override
	public void afectarConEfectoTormenta(AlgoFormer algoFormer){
	}
	
	@Override
	public void afectarConEfectoNebulosa(AlgoFormer algoFormer){	
	}
	
	@Override
	public void afectarConEfectoEspinas(AlgoFormer algoformer){
		algoformer.afectarConEfectoEspinas();
	}
	
	
}