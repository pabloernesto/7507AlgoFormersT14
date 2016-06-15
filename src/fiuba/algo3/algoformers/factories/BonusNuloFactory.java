package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.escenario.bonus.Bonus;
import fiuba.algo3.algoformers.escenario.bonus.BonusNulo;

public class BonusNuloFactory implements BonusFactory{

	public Bonus getBonus() {
		return new BonusNulo();
	}
}
