package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.Celda;

public class FormaAerea extends FormaAlterna {

	public FormaAerea (int ataque, int velocidad, int distAtaque)
	{
		super(ataque, velocidad, distAtaque);
	}
	
	public int getCostoDeEntrada(Celda destino)
	{
	    return destino.getCostoDeEntrada(this);
	}
}
