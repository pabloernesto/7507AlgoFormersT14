
package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.efectos.*;
import fiuba.algo3.algoformers.factories.FormaFactory;
import fiuba.algo3.algoformers.juego.Juego;

public class FormaHumanoide extends Forma {

	public FormaHumanoide (int ataque, int velocidad, int distAtaque, FormaFactory formaFactory){
		super(ataque, velocidad, distAtaque, formaFactory);
	}
	
	public Forma transformarse() {
		return formaFactory.crearFormaAlterna();
	}

	
	@Override
	public void afectarCon(AlgoFormer algoformer, EfectoNebulosa efecto){
		
	}
	
	@Override
	public void afectarCon(AlgoFormer algoformer, EfectoPantano efecto){
		algoformer.afectarConEfectoPantanoFormaHumanoide(efecto);
	}
	
	@Override
	public void afectarCon(AlgoFormer algoformer, EfectoTormenta efecto){
	}
	
	@Override
	public void afectarCon(AlgoFormer algoformer, EfectoEspinas efecto){
		algoformer.afectarConEfectoEspinas();
	}
	
	public void afectarCon(AlgoFormer algoformer, EfectoChispa efecto){
		Juego.chispaCapturada();
	}
	
    public String nombre()
    {
        return "Humanoide";
    }
}
