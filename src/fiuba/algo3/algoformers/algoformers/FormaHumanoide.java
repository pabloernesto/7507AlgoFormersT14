
package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.factories.FormaFactory;

public class FormaHumanoide extends Forma {

	public FormaHumanoide (int ataque, int velocidad, int distAtaque, FormaFactory formaFactory){
		super(ataque, velocidad, distAtaque, formaFactory);
	}
	
	public Forma transformarse() {
		return formaFactory.crearFormaAlterna();
	}

	
	@Override
	public void afectarConEfectoNebulosa(AlgoFormer algoformer){
		
	}
	
	@Override
	public void afectarConEfectoPantano(AlgoFormer algoformer){
		algoformer.afectarConEfectoPantanoFormaHumanoide();
	}
	
	@Override
	public void afectarConEfectoTormenta(AlgoFormer algoformer){
	}
	
	@Override
	public void afectarConEfectoEspinas(AlgoFormer algoformer){
		algoformer.afectarConEfectoEspinas();
	}
	
}
