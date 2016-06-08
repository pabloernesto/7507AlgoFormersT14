package fiuba.algo3.algoformers.factories;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.AutoBot;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

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
		FormaHumanoide optimusHumanoide = new FormaHumanoide(50, 2, 2); //Ataque, velocidad, distanciaAtaque
		FormaTerrestre optimusTerrestre = new FormaTerrestre(15, 5, 4);
		AutoBot optimus = new AutoBot("Optimus Prime", 500, optimusHumanoide, optimusTerrestre);
		return optimus;
	}
	
	public AutoBot crearBumblebee (){
		FormaHumanoide bumblebeeHumanoide = new FormaHumanoide(40, 2, 1);
		FormaTerrestre bumblebeeTerrestre = new FormaTerrestre(20, 5, 3);
		AutoBot bumblebee = new AutoBot("Bumblebee", 350, bumblebeeHumanoide, bumblebeeTerrestre);
		return bumblebee;
	}
	
	public AutoBot crearRatchet (){
		FormaHumanoide ratchetHumanoide = new FormaHumanoide(5, 1, 5);
		FormaAerea ratchetAereo = new FormaAerea(35, 8, 2);
		AutoBot ratchet = new AutoBot("Ratchet", 150, ratchetHumanoide, ratchetAereo);
		return ratchet;
	}
	
}