package fiuba.algo3.algoformers.escenario.superficies;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class TormentaPsionica extends SuperficieAerea{
	
	private List<AlgoFormer> listaAfectados;
	
	public TormentaPsionica(){
		efecto = new EfectoTormenta();
		listaAfectados = new ArrayList<AlgoFormer>();
	}
	
	public void aplicarEfectos(AlgoFormer algoformer){
		if (!listaAfectados.contains(algoformer)){
			algoformer.recibirEfectos(efecto);
			listaAfectados.add(algoformer);
		}
	}

}
