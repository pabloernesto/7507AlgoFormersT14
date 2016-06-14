package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

public class FormaBonecrusherFactory implements FormaFactory{

	@Override
	public FormaHumanoide crearFormaHumanoide() {
		return new FormaHumanoide(30, 1, 3, this);
	}

	@Override
	public FormaAlterna crearFormaAlterna() {
		return new FormaTerrestre(30, 8, 3, this);
	}

}
