package fiuba.algo3.algoformers.escenario;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.bonus.*;
import fiuba.algo3.algoformers.escenario.superficies.*;
import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;

public class Celda {
	
	private AlgoFormer algoformer;
    private SuperficieTerrestre suelo;
    private SuperficieAerea cielo;
    private Bonus bonus;
    private Bonus chispa;
	

	public Celda (SuperficieTerrestre suelo, SuperficieAerea cielo){
		algoformer = null;
		this.suelo = suelo;
		this.cielo = cielo;
		this.bonus = new BonusNulo();
		this.chispa = new BonusNulo();
	}
	
	public void recibirAlgoformer (AlgoFormer algoformer){
		if (this.algoformer != null)
			throw new CeldaOcupadaException();
		this.algoformer = algoformer;
		suelo.afectar(algoformer);
		cielo.afectar(algoformer);
		bonus.afectar(algoformer);
		bonus = new BonusNulo();
		chispa.afectar(algoformer);
	}
	
	public AlgoFormer getAlgoformer (){
		return algoformer;
	}
	
	public boolean estaOcupada (){
		return algoformer != null;
	}
	
	public void colocarChispaSuprema (){
		chispa = new ChispaSuprema();
	}
	
	public boolean contieneChispaSuprema (){
		return chispa.getClass() != BonusNulo.class;
	}

	public void desocuparCelda (){
		algoformer = null;
	}
	
	public void setBonus(Bonus bonus){
		this.bonus = bonus;
	}

    public Bonus getBonus()
    {
        return bonus;
    }

	public String getNombreSuperficieTerrestre(){
		return suelo.getNombre();
	}
	
	public String getNombreSuperficieAerea(){
		return cielo.getNombre();
	}
	
	//Metodos para pruebas+
	public SuperficieTerrestre getSuperficieTerrestre() {
		return suelo;
	}
	
	public SuperficieAerea getSuperficieAerea() {
		return cielo;
	}
	
}
