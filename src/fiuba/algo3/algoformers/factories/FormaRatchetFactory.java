package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;

public class FormaRatchetFactory implements FormaFactory{

	@Override
	public FormaHumanoide crearFormaHumanoide() {
		return new FormaHumanoide(5, 1, 5, this);
	}

	@Override
	public FormaAlterna crearFormaAlterna() {
		return new FormaAerea(35, 8, 2, this);
	}

}
