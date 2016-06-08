package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.excepciones.FriendlyFireException;

public class AutoBot extends AlgoFormer {

	public AutoBot (String nombre, int vida, FormaHumanoide formaHumanoide, FormaAlterna formaAlterna){
		super(nombre, vida, formaHumanoide, formaAlterna);
	}
	
	public void recibirDanio (AutoBot autobot, int ataque){
		throw new FriendlyFireException();
	}
	
	public void recibirDanio(Decepticon decepticon, int ataque){
		vida -= ataque;
	}
	
	public void atacarAlgoformer (AlgoFormer algoformerAtacado){
		algoformerAtacado.recibirDanio(this, getAtaque());
	}
	
}