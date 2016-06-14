package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

public class FormaBumblebeeFactory implements FormaFactory{

	@Override
	public FormaHumanoide crearFormaHumanoide() {
		return new FormaHumanoide(40, 2, 1, this);
	}

	@Override
	public FormaAlterna crearFormaAlterna() {
		return new FormaTerrestre(20, 5, 3, this);
	}

}
