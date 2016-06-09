package fiuba.algo3.algoformers.escenario;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.superficies.*;
import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;

public class Celda {
	
	private AlgoFormer algoformer;
	private boolean contieneChispaSuprema;

    private SuperficieTerrestre suelo;
    private SuperficieAerea cielo;
	

	public Celda (SuperficieTerrestre suelo, SuperficieAerea cielo){
		algoformer = null;
		contieneChispaSuprema = false;
		this.suelo = suelo;
		this.cielo = cielo;
	}
	
	public void recibirAlgoformer (AlgoFormer algoformer){
		if (this.algoformer != null)
			throw new CeldaOcupadaException();
		this.algoformer = algoformer;
		this.suelo.afectar(algoformer);
		this.cielo.afectar(algoformer);
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
	
	
	//Metodos para pruebas+
	public SuperficieTerrestre getSuperficieTerrestre() {
		return suelo;
	}
	
	public SuperficieAerea getSuperficieAerea() {
		return cielo;
	}
}
