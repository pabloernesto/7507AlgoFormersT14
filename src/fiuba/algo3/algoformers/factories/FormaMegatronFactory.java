package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;

public class FormaMegatronFactory implements FormaFactory{

	@Override
	public FormaHumanoide crearFormaHumanoide() {
		return new FormaHumanoide(10, 1, 3, this);
	}

	@Override
	public FormaAlterna crearFormaAlterna() {
		return new FormaAerea(55, 8, 2, this);
	}

}
