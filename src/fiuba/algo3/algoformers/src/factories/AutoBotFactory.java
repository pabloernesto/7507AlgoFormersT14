package fiuba.algo3.algoformers.factories;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.UnidadAerea;
import fiuba.algo3.algoformers.algoformers.UnidadHumanoide;
import fiuba.algo3.algoformers.algoformers.UnidadTerrestre;

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
		UnidadHumanoide optimusHumanoide = new UnidadHumanoide(50, 2, 2); //Ataque, velocidad, distanciaAtaque
		UnidadTerrestre optimusTerrestre = new UnidadTerrestre(15, 5, 4);
		AutoBot optimus = new AutoBot("Optimus Prime", 500, optimusHumanoide, optimusTerrestre);
		return optimus;
	}
	
	public AutoBot crearBumblebee (){
		UnidadHumanoide bumblebeeHumanoide = new UnidadHumanoide(40, 2, 1);
		UnidadTerrestre bumblebeeTerrestre = new UnidadTerrestre(20, 5, 3);
		AutoBot bumblebee = new AutoBot("Bumblebee", 350, bumblebeeHumanoide, bumblebeeTerrestre);
		return bumblebee;
	}
	
	public AutoBot crearRatchet (){
		UnidadHumanoide ratchetHumanoide = new UnidadHumanoide(5, 1, 5);
		UnidadAerea ratchetAereo = new UnidadAerea(35, 8, 2);
		AutoBot ratchet = new AutoBot("Ratchet", 150, ratchetHumanoide, ratchetAereo);
		return ratchet;
	}
	
}