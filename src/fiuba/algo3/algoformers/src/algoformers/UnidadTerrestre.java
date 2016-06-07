package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.Celda;

public class UnidadTerrestre extends UnidadAlterna {

	public UnidadTerrestre (int ataque, int velocidad, int distAtaque){
		super(ataque, velocidad, distAtaque);
	}

	public int getCostoDeEntrada(Celda destino)
	{
	    return destino.getCostoDeEntrada(this);
	}
}
