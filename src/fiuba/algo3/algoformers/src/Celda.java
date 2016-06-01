package fiuba.algo3.algoformers.modelo;

public class Celda {

	private AlgoFormer algoformer = null;
	private boolean contieneChispaSuprema = false;
	
	public Celda() {}
	
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
    
    public void colocarChispaSuprema()
    {
        contieneChispaSuprema = true;
    }
    
    public boolean contieneChispaSuprema()
    {
        return contieneChispaSuprema;
    }
}
