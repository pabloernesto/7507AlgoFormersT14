package fiuba.algo3.algoformers.escenario;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Forma;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

import fiuba.algo3.algoformers.escenario.superficies.Superficie;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.escenario.superficies.Nubes;

import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;

public class Celda {
	
	private AlgoFormer algoformer;
	private boolean contieneChispaSuprema;

    private Superficie suelo;
    private Superficie cielo;

	public Celda ()
	{
		algoformer = null;
		contieneChispaSuprema = false;
		suelo = new Rocosa();
		cielo = new Nubes();
	}
	
	public void recibirAlgoformer (AlgoFormer algoformer){
		if (this.algoformer != null)
			throw new CeldaOcupadaException();
		this.algoformer = algoformer;
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

	public void desocuparCelda (){
		algoformer = null;
	}

    public Superficie superficie(FormaHumanoide formaActual)
    {
        return suelo;
    }

    public Superficie superficie(FormaTerrestre formaActual)
    {
        return suelo;
    }

    public Superficie superficie(FormaAerea formaActual)
    {
        return cielo;
    }
}
