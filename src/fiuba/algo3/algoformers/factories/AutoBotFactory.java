package fiuba.algo3.algoformers.factories;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.Forma;
import fiuba.algo3.algoformers.algoformers.Superion;

public class AutoBotFactory implements AlgoFormerFactory{

	public AutoBotFactory (){
	}
	
	public List<AlgoFormer> crearEquipo() {
		List<AlgoFormer> equipo = new ArrayList<AlgoFormer>();
		equipo.add(crearOptimusPrime());
		equipo.add(crearBumblebee());
		equipo.add(crearRatchet());
		return equipo;
	}
	
	public AutoBot crearOptimusPrime (){
		FormaFactory formaFactory = new FormaOptimusFactory();
		Forma forma = formaFactory.crearFormaHumanoide();
		AutoBot optimus = new AutoBot("Optimus Prime", 500, forma);
		return optimus;
	}
	
	public AutoBot crearBumblebee (){
		FormaFactory formaFactory = new FormaBumblebeeFactory();
		Forma forma = formaFactory.crearFormaHumanoide();
		AutoBot bumblebee = new AutoBot("Bumblebee", 350, forma);
		return bumblebee;
	}
	
	public AutoBot crearRatchet (){
		FormaFactory formaFactory = new FormaRatchetFactory();
		Forma forma = formaFactory.crearFormaHumanoide();
		AutoBot ratchet = new AutoBot("Ratchet", 150, forma);
		return ratchet;
	}
	
	public AutoBot crearCombinado(List<AlgoFormer> integrantes) {
		FormaFactory formaFactory = new FormaSuperionFactory();
		Forma forma = formaFactory.crearFormaAlterna();
		Superion superion = new Superion(forma, integrantes);
		return superion;
	}
	
	@Override
	public String getNombreFactory(){
		return "autobot";
	}
	
}