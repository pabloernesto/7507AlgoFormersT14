package fiuba.algo3.algoformers.modelo;

public class FormaAerea extends Forma {
	

	public FormaAerea(int ataque, int velocidad, int distAtaque)
	{
		super(ataque, velocidad, distAtaque);
	}

	public int getCostoDeEntrada(Celda destino)
	{
	    return destino.getCostoDeEntrada(this);
	}
	
	public void recibirEfecto(Nube SuperficieActual){		
	}
	
	public void recibirEfecto(TormentaPsionica SuperficieActual){
		this.ataque = (this.ataque*4/100);
	}
	
	public void recibirEfecto(NebulosaDeAndromeda SuperficieActual){
	}
	
}
