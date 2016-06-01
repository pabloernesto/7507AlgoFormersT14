package fiuba.algo3.algoformers.modelo;

public class Celda {

	/* Todo lo que esta comentado por el momento no se necesita, pero ya que estaba lo deje escrito*/
	
	
	/*private Superficie supAire;
	private Superficie supTierra;
	private Bonus bonus;*/
	private AlgoFormer algoformer;
	
	public Celda(/*Superficie supAire, Superficie supTierra*/){
		/*this.supAire = supAire;
		this.supTierra = supTierra;
		this.bonus = null;*/
		this.algoformer = null;
	}
	
	public void setAlgoformer(AlgoFormer algoformer){
		this.algoformer = algoformer;
	}
	
	public AlgoFormer getAlgoformer(){
		return this.algoformer;
	}
	
	public void desocuparCelda(){
		this.algoformer = null;
	}
	
	public boolean estaOcupada(){
		return this.algoformer != null;
	}
	
	
	public int getCostoDeEntrada(Unidad Algoformer)
	{
	    return 1;
	}
	
	public void activarEfecto(AlgoFormer af)
	{
	    ;
    }
	
/*
	public void setBonus(Bonus bonus){
		this.setBonus = bonus;
	}
	
	public Bonus getBonus(){
		return this.bonus;
	}
	
	public void eliminarBonus(){
		this.bonus = null;
	}
	
	public Efecto getEfecto(UnidadTerrestre algoformer){
		
	}
	
	public Efecto getEfecto(UnidadHumanoide algoformer){
		
	}
	
	public Efecto getEfecto(UnidadAerea algoformer){
		
	}
	
	*/
}
