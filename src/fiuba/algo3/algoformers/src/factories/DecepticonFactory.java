package fiuba.algo3.algoformers.factories;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

public class DecepticonFactory implements AlgoFormerFactory {

	public DecepticonFactory (){
	}
	
	public List<AlgoFormer> crearEquipo(){
		List<AlgoFormer> equipo = new ArrayList<AlgoFormer>();
		equipo.add(crearMegatron());
		equipo.add(crearBonecrusher());
		equipo.add(crearFrenzy());
		return equipo;
	}
	
	public Decepticon crearMegatron (){
		FormaHumanoide megatronHumanoide = new FormaHumanoide(10, 1, 3);
		FormaAerea megatronAereo = new FormaAerea(55, 8, 2);
		Decepticon megatron = new Decepticon("Megatron", 550, megatronHumanoide, megatronAereo);
		return megatron;
	}
	
	public Decepticon crearBonecrusher (){
		FormaHumanoide bonecrusherHumanoide = new FormaHumanoide(30, 1, 3);
		FormaTerrestre bonecrusherTerrestre = new FormaTerrestre(30, 8, 3);
		Decepticon bonecrusher = new Decepticon("Bonecrusher", 200, bonecrusherHumanoide, bonecrusherTerrestre);
		return bonecrusher;
	}
	
	public Decepticon crearFrenzy (){
		FormaHumanoide frenzyHumanoide = new FormaHumanoide(10, 2, 5);
		FormaTerrestre frenzyAereo = new FormaTerrestre(25, 6, 2);
		Decepticon frenzy = new Decepticon("Frenzy", 400, frenzyHumanoide, frenzyAereo);
		return frenzy;
	}
	
}