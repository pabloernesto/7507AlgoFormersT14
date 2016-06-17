package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;
import fiuba.algo3.algoformers.excepciones.CombinadoNoTieneFormaHumanoideException;

public class FormaMenasorFactory implements FormaFactory{

	public FormaHumanoide crearFormaHumanoide() {
		throw new CombinadoNoTieneFormaHumanoideException();
	}

	public FormaAlterna crearFormaAlterna() {
		return new FormaTerrestre(115, 2, 2, this);
	}

}