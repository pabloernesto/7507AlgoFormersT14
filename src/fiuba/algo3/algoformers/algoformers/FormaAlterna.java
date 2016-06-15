package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.factories.FormaFactory;

public abstract class FormaAlterna extends Forma {
	
	public FormaAlterna (int ataque, int velocidad, int distAtaque, FormaFactory formaFactory){
		super(ataque, velocidad, distAtaque, formaFactory);
	}
	
	public Forma transformarse() {
		return formaFactory.crearFormaHumanoide();
	}
	
	public void afectarConEfectoChispa(AlgoFormer algoFormer){
	}
	
}