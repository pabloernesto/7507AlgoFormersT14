package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.excepciones.FuegoAmigoException;

public class AutoBot extends AlgoFormer {

	public AutoBot (String nombre, int vida, FormaHumanoide formaHumanoide, FormaAlterna formaAlterna){
		super(nombre, vida, formaHumanoide, formaAlterna);
	}
	
	public void recibirDanio (AutoBot autobot, int ataque){
		throw new FuegoAmigoException();
	}
	
	public void recibirDanio(Decepticon decepticon, int ataque){
		vida -= ataque;
	}
	
	public void enviarRecibirDanio(AlgoFormer algoformerAtacado){
		algoformerAtacado.recibirDanio(this, getAtaque());
	}
	
}
