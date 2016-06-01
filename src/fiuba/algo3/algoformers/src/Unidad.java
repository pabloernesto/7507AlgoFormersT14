package fiuba.algo3.algoformers.modelo;

public abstract class Unidad{

	protected int ataque;
	protected int velocidad;
	protected int dist_ataque;
	
	public Unidad(int ataque, int velocidad, int dist_ataque){
		this.ataque = ataque;
		this.velocidad = velocidad;
		this.dist_ataque = dist_ataque;
	}
	
	//Metodos para pruebas, no deberian ser llamados en otros lugares que no sean pruebas

	public int getAtaque() {
		return ataque;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getDist_ataque() {
		return dist_ataque;
	}
	
}
