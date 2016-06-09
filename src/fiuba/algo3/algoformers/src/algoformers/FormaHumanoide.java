package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.Superficie;

public class FormaHumanoide extends Forma {

	public FormaHumanoide (int ataque, int velocidad, int distAtaque){
		super(ataque, velocidad, distAtaque);
	}

	public int getCostoDeEntrada(Celda destino)
	{
	    return destino.superficie(this).costoDeEntrada(this);
	}

	public void aplicarEfectos(Celda destino, AlgoFormer algoformer)
	{
	    destino.superficie(this).aplicarEfectos(algoformer, this);
	}
}

