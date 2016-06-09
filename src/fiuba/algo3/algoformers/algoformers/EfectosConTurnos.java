package fiuba.algo3.algoformers.algoformers;

//import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public abstract class EfectosConTurnos extends Efecto{

	protected int turnosRestantes;
	
	public EfectosConTurnos(int duracionEnTurnos){
		this.turnosRestantes=duracionEnTurnos;
	}
	
	public void restarUnTurno(){
		turnosRestantes--;
	}
}
