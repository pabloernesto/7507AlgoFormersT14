package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.Celda;

public abstract class Forma {

	protected int ataque;
	protected int velocidad;
	protected int distAtaque;
	
	public Forma (int ataque, int velocidad, int distAtaque){
		this.ataque = ataque;
		this.velocidad = velocidad;
		this.distAtaque = distAtaque;
	}
	
	public int getAtaque (){
		return ataque;
	}
	
	public int getVelocidad (){
		return velocidad;
	}
	
	public int getDistAtaque (){
		return distAtaque;
	}
	
	public abstract int getCostoDeEntrada(Celda destino);
	
	public abstract void aplicarEfectos(Celda destino, AlgoFormer algoformer);

}

