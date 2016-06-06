package fiuba.algo3.algoformers.escenario;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Unidad;
import fiuba.algo3.algoformers.algoformers.UnidadAerea;
import fiuba.algo3.algoformers.algoformers.UnidadHumanoide;
import fiuba.algo3.algoformers.algoformers.UnidadTerrestre;

import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;

public class Celda {
	
	private AlgoFormer algoformer;
	private boolean contieneChispaSuprema;
	public Superficie superficie;

	public Celda (Superficie superficie){
		this.algoformer = null;
		this.contieneChispaSuprema = false;
		this.superficie = superficie; 
	}
	
	public void recibirAlgoformer (AlgoFormer algoformer){
		if (this.algoformer != null)
			throw new CeldaOcupadaException();
		this.algoformer = algoformer;
		algoformer.recibirEfecto(this.superficie);
	}
	
	public AlgoFormer getAlgoformer (){
		return algoformer;
	}
	
	public boolean estaOcupada (){
		return algoformer != null;
	}
	
	public void colocarChispaSuprema (){
		contieneChispaSuprema = true;
	}
	
	public boolean contieneChispaSuprema (){
		return contieneChispaSuprema;
	}

	public int getCostoDeEntrada (UnidadHumanoide algoformer)
	{
		return 1;
	}

	public int getCostoDeEntrada (UnidadTerrestre algoformer)
	{
		return 1;
	}

	public int getCostoDeEntrada (UnidadAerea algoformer)
	{
		return 1;
	}
	
	public Superficie devolverSuperficie(){
		return this.superficie;
	}


	public void desocuparCelda (){
		algoformer = null;
	}

}
