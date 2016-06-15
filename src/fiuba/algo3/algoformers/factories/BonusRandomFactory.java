package fiuba.algo3.algoformers.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fiuba.algo3.algoformers.escenario.bonus.Bonus;
import fiuba.algo3.algoformers.escenario.bonus.BurbujaInmaculada;
import fiuba.algo3.algoformers.escenario.bonus.DobleCanion;
import fiuba.algo3.algoformers.escenario.bonus.Flash;

public class BonusRandomFactory implements BonusFactory{

	public Bonus getBonus() {
		List<Bonus> opciones = new ArrayList<Bonus>();
		opciones.add(new DobleCanion());
		opciones.add(new BurbujaInmaculada());
		opciones.add(new Flash());
		Random generador = new Random();
		int eleccion = generador.nextInt(3);
		return opciones.get(eleccion);
	}

	
}
