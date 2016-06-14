package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.efectos.EfectoBurbuja;
import fiuba.algo3.algoformers.excepciones.FuegoAmigoException;

public class Decepticon extends AlgoFormer{

	
	public Decepticon (String nombre, int vida, Forma estado){
		super(nombre, vida, estado);
	}
	
	public void recibirDanio (AutoBot autobot, int ataque){
		if (!afectadoPor(new EfectoBurbuja()))
			vida -= ataque;
	}

	public void recibirDanio (Decepticon decepticon, int ataque){
		throw new FuegoAmigoException();
	}

	public void enviarRecibirDanio(AlgoFormer algoformerAtacado){
		algoformerAtacado.recibirDanio(this, getAtaque());
	}

}
