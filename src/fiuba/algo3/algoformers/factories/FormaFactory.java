package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.algoformers.FormaAlterna;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;

public interface FormaFactory {
	
	public FormaHumanoide crearFormaHumanoide();
	
	public FormaAlterna crearFormaAlterna();

}
