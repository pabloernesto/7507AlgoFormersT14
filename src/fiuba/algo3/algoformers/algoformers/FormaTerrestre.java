package fiuba.algo3.algoformers.algoformers;


public class FormaTerrestre extends FormaAlterna {

	public FormaTerrestre (int ataque, int velocidad, int distAtaque){
		super(ataque, velocidad, distAtaque);
	}

	public void recibirEfectos(AlgoFormer algoformer, Efecto efecto){
	    efecto.afectar(algoformer, this);
	}
}