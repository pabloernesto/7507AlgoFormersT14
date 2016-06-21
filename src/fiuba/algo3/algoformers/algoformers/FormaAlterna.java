package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.efectos.EfectoChispa;
import fiuba.algo3.algoformers.factories.FormaFactory;

public abstract class FormaAlterna extends Forma {

	public FormaAlterna (int ataque, int velocidad, int distAtaque, FormaFactory formaFactory){
		super(ataque, velocidad, distAtaque, formaFactory);
	}
	
	public Forma transformarse() {
		return formaFactory.crearFormaHumanoide();
	}
	
	public void afectarCon(AlgoFormer algoFormer, EfectoChispa efecto){
	}

    public String nombre()
    {
        return "Alterno";
    }
}
