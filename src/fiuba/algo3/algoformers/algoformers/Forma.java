package fiuba.algo3.algoformers.algoformers;


public abstract class Forma {

	protected int ataque;
	protected int velocidad;
	protected int distAtaque;
	protected int movimientosRestantes;
	

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
	
	public void setVelocidad(int nuevaVelocidad) {
		velocidad = nuevaVelocidad;
	}
	
	public void afectarConEfectoDobleCanion(AlgoFormer algoformer){
		setAtaque(getAtaque() * 2);
	}
	
	public void afectarConEfectoFlash(AlgoFormer algoformer){
		algoformer.afectarseConEfectoFlash();
	}

	public void afectarConEfectoBurbuja(AlgoFormer algoFormer){
	}
	
	public void desafectarseDeEfectoDobleCanion(AlgoFormer algoFormer) {
		setAtaque(getAtaque() / 2);
	}
	

	public abstract void afectarConEfectoNebulosa(AlgoFormer algoFormer);

	public abstract void afectarConEfectoPantano(AlgoFormer algoFormer);

	public abstract void afectarConEfectoTormenta(AlgoFormer algoFormer);

	public abstract void afectarConEfectoEspinas(AlgoFormer algoFormer);
	
}

