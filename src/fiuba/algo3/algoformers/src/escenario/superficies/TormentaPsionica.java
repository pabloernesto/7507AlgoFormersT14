package fiuba.algo3.algoformers.escenario.superficies;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class TormentaPsionica extends SuperficieAerea{
	
	private static List<AlgoFormer> listaAfectados = new ArrayList<AlgoFormer>();
	
	public TormentaPsionica(){
		efecto = new EfectoTormenta();
	}
	
	public void aplicarEfectos(AlgoFormer algoformer){
		if (!listaAfectados.contains(algoformer)){
			algoformer.recibirEfectos(efecto);
			listaAfectados.add(algoformer);
		}
	}

}
