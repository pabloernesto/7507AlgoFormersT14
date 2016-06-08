package fiuba.algo3.algoformers.escenario;

import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;

public class RocasYNubesFactory extends CeldaFactory {

	public Celda getCelda()
	{
	    return new Celda(new Rocosa(), new Nube());
	}

}

