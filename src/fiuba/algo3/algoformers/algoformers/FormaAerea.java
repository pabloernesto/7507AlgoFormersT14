
package fiuba.algo3.algoformers.algoformers;

public class FormaAerea extends FormaAlterna {

	public FormaAerea (int ataque, int velocidad, int distAtaque){
		super(ataque, velocidad, distAtaque);
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