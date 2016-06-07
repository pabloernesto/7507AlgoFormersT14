package fiuba.algo3.algoformers.escenario;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Forma;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;

public class Celda {
	
	private AlgoFormer algoformer;
	private boolean contieneChispaSuprema;

	public Celda (){
		algoformer = null;
		contieneChispaSuprema = false;
	}
	
	public void recibirAlgoformer (AlgoFormer algoformer){
		if (this.algoformer != null)
			throw new CeldaOcupadaException();
		this.algoformer = algoformer;
		activarEfectos(this.algoformer.getEstadoActivo());
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

	public int getCostoDeEntrada (FormaHumanoide algoformer)
	{
		return 1;
	}

	public int getCostoDeEntrada (FormaTerrestre algoformer)
	{
		return 1;
	}

	public int getCostoDeEntrada (FormaAerea algoformer)
	{
		return 1;
	}

	private void activarEfectos (Forma algoformer){
		
	}

	public void desocuparCelda (){
		algoformer = null;
	}

}
