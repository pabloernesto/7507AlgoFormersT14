package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.Celda;

public class UnidadAerea extends UnidadAlterna {

	public UnidadAerea (int ataque, int velocidad, int distAtaque)
	{
		super(ataque, velocidad, distAtaque);
	}
	
	public int getCostoDeEntrada(Celda destino)
	{
	    return destino.getCostoDeEntrada(this);
	}
}
