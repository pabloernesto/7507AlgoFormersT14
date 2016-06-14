package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

public class FormaOptimusFactory implements FormaFactory{

	@Override
	public FormaHumanoide crearFormaHumanoide() {
		return new FormaHumanoide(50, 2, 2, this);
	}

	@Override
	public FormaAlterna crearFormaAlterna() {
		return new FormaTerrestre(15, 5, 4, this);
	}

}
