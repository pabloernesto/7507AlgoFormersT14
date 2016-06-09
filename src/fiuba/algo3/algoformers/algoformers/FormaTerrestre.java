package fiuba.algo3.algoformers.algoformers;


public class FormaTerrestre extends FormaAlterna {

	public FormaTerrestre (int ataque, int velocidad, int distAtaque){
		super(ataque, velocidad, distAtaque);
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