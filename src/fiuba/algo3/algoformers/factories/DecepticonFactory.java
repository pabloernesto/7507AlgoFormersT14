package fiuba.algo3.algoformers.factories;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.Decepticon;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;

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
		FormaFactory formaFactory = new FormaMegatronFactory();
		FormaHumanoide forma = formaFactory.crearFormaHumanoide();
		Decepticon megatron = new Decepticon("Megatron", 550, forma);
		return megatron;
	}
	
	public Decepticon crearBonecrusher (){
		FormaFactory formaFactory = new FormaBonecrusherFactory();
		FormaHumanoide forma = formaFactory.crearFormaHumanoide();
		Decepticon bonecrusher = new Decepticon("Bonecrusher", 200, forma);
		return bonecrusher;
	}
	
	public Decepticon crearFrenzy(){
		FormaFactory formaFactory = new FormaFrenzyFactory();
		FormaHumanoide forma = formaFactory.crearFormaHumanoide();
		Decepticon frenzy = new Decepticon("Frenzy", 400, forma);
		return frenzy;
	}
	
	
	
}