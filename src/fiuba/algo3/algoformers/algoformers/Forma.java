package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.efectos.*;
import fiuba.algo3.algoformers.factories.FormaFactory;

public abstract class Forma {

	protected int ataque;
	protected int velocidad;
	protected int distAtaque;
	protected int movimientosRestantes;
	protected FormaFactory formaFactory;

	public Forma (int ataque, int velocidad, int distAtaque, FormaFactory formaFactory){
		this.ataque = ataque;
		this.velocidad = velocidad;
		this.distAtaque = distAtaque;
		this.formaFactory = formaFactory;
	}
	
	public abstract Forma transformarse();
	
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
	
	public void afectarCon(AlgoFormer algoformer, EfectoDobleCanion efecto){
		setAtaque(getAtaque() * 2);
	}
	
	public void afectarCon(AlgoFormer algoformer, EfectoFlash efecto){
		algoformer.afectarseConEfectoFlash();
	}

	public void afectarCon(AlgoFormer algoFormer, EfectoBurbuja efecto){
	}
	
	public void desafectarseDe(AlgoFormer algoFormer, EfectoDobleCanion efecto) {
		setAtaque(getAtaque() / 2);
	}
	

	public abstract void afectarCon(AlgoFormer algoFormer, EfectoNebulosa efecto);

	public abstract void afectarCon(AlgoFormer algoFormer, EfectoPantano efecto);

	public abstract void afectarCon(AlgoFormer algoFormer, EfectoTormenta efecto);

	public abstract void afectarCon(AlgoFormer algoFormer, EfectoEspinas efecto);

	public abstract void afectarCon(AlgoFormer algoFormer, EfectoChispa efecto);
	
    public abstract String nombre();
}

