package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;

public class RocasYNubesFactory implements CeldaFactory {

	public Celda getCelda()
	{
	    return new Celda(new Rocosa(), new Nube());
	}

}

