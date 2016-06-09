package fiuba.algo3.algoformers.algoformers;


public abstract class Forma {

	protected int ataque;
	protected int velocidad;
	protected int distAtaque;
	protected int movimientosRestantes;
	

	public abstract void recibirEfectos(AlgoFormer algoformer, Efecto efecto);
	
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


	public void setAtaque(int nuevoAtaque){
		ataque = nuevoAtaque;
	}
	
}

