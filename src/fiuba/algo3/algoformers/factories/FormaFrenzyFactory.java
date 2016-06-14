package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

public class FormaFrenzyFactory implements FormaFactory{

	@Override
	public FormaHumanoide crearFormaHumanoide() {
		return new FormaHumanoide(10, 2, 5, this);
	}

	@Override
	public FormaAlterna crearFormaAlterna() {
		return new FormaTerrestre(25, 6, 2, this);
	}

}
