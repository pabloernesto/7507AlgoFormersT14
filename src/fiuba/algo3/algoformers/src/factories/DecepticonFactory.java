package fiuba.algo3.algoformers.factories;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.UnidadAerea;
import fiuba.algo3.algoformers.algoformers.UnidadHumanoide;
import fiuba.algo3.algoformers.algoformers.UnidadTerrestre;

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
		UnidadHumanoide megatronHumanoide = new UnidadHumanoide(10, 1, 3);
		UnidadAerea megatronAereo = new UnidadAerea(55, 8, 2);
		Decepticon megatron = new Decepticon("Megatron", 550, megatronHumanoide, megatronAereo);
		return megatron;
	}
	
	public Decepticon crearBonecrusher (){
		UnidadHumanoide bonecrusherHumanoide = new UnidadHumanoide(30, 1, 3);
		UnidadTerrestre bonecrusherTerrestre = new UnidadTerrestre(30, 8, 3);
		Decepticon bonecrusher = new Decepticon("Bonecrusher", 200, bonecrusherHumanoide, bonecrusherTerrestre);
		return bonecrusher;
	}
	
	public Decepticon crearFrenzy (){
		UnidadHumanoide frenzyHumanoide = new UnidadHumanoide(10, 2, 5);
		UnidadTerrestre frenzyAereo = new UnidadTerrestre(25, 6, 2);
		Decepticon frenzy = new Decepticon("Frenzy", 400, frenzyHumanoide, frenzyAereo);
		return frenzy;
	}
	
}