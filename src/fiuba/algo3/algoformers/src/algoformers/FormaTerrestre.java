package fiuba.algo3.algoformers.modelo;

public class FormaTerrestre extends Forma {

	public FormaTerrestre(int ataque, int velocidad, int distAtaque){
		super(ataque, velocidad, distAtaque);
	}

	public int getCostoDeEntrada(Celda destino)
	{
	    return destino.getCostoDeEntrada(this);
	}

}
