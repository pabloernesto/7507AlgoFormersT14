
package fiuba.algo3.algoformers.algoformers;



public class FormaHumanoide extends Forma {

	public FormaHumanoide (int ataque, int velocidad, int distAtaque){
		super(ataque, velocidad, distAtaque);
	}

	
	@Override
	public void afectarConEfectoNebulosa(AlgoFormer algoFormer){
		
	}
	
	@Override
	public void afectarConEfectoPantano(AlgoFormer algoformer){
		algoformer.afectarConEfectoPantanoFormaHumanoide();
	}
	
	@Override
	public void afectarConEfectoTormenta(AlgoFormer algoFormer){
	}
	
	@Override
	public void afectarConEfectoEspinas(AlgoFormer algoformer){
		algoformer.afectarConEfectoEspinas();
	}
	
}
