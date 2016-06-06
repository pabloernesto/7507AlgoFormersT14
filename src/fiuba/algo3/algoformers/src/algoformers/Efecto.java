package fiuba.algo3.algoformers.modelo;

public class Efecto {
	
	public int duracionEfecto=null;
	public String nombreEfecto;
	
	public Efecto(TormentaPsionica efectoDeSuperficie){
		this.nombreEfecto = "tormentaPsionica";
	}
	
	public Efecto (NebulosaDeAndromeda  efectoDeSuperficie){
		this.duracionEfecto = 3;
		this.nombreEfecto = "nebulosaDeAndromeda";
	}
	
	/*
	public Efecto (Bonus bonus){
		this.duracionEfecto= bonus.obtenerDuracion();
		this.nombreEfecto= bonus.obtenerNombre();
	}
	*/
	
	public void actualizarEfecto(){
		if (this.duracionEfecto)
			this.duracionEfecto--;
	}
	
	public int devolverDuracionEfecto(){
		return this.duracionEfecto;
	}
}
