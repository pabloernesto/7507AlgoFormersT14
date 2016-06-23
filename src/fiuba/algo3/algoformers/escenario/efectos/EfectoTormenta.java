package fiuba.algo3.algoformers.escenario.efectos;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public class EfectoTormenta extends Efecto{
	
	private static List<AlgoFormer> afectados = new ArrayList<AlgoFormer>();

	@Override
	public void afectar(AlgoFormer algoformer) {
		if (afectados.contains(algoformer))
			return;
		afectados.add(algoformer);
		algoformer.afectarseCon(this);
	}

	@Override
	public void desafectar(AlgoFormer algoformer) {
	}

}
