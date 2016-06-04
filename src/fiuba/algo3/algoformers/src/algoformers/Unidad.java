package fiuba.algo3.algoformers.algoformers;

public abstract class Unidad {

	protected int ataque;
	protected int velocidad;
	protected int distAtaque;
	
	public Unidad (int ataque, int velocidad, int distAtaque){
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
	
}