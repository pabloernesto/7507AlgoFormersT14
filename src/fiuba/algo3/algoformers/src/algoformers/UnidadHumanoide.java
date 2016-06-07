package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.Celda;

public class UnidadHumanoide extends Unidad {

	public UnidadHumanoide (int ataque, int velocidad, int distAtaque){
		super(ataque, velocidad, distAtaque);
	}

	public int getCostoDeEntrada(Celda destino)
	{
	    return destino.getCostoDeEntrada(this);
	}
}
