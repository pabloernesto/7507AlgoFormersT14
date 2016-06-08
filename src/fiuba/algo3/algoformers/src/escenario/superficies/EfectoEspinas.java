package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.FormaAerea;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;

public class EfectoEspinas extends Efecto{

	public void afectar(AlgoFormer algoformer, FormaHumanoide forma) {
		int vida = algoformer.getVida();
		int nuevaVida = calcularNuevaVida(vida);
		algoformer.setVida(nuevaVida);
	}

	public void afectar(AlgoFormer algoformer, FormaTerrestre forma) {
		int vida = algoformer.getVida();
		int nuevaVida = calcularNuevaVida(vida);
		algoformer.setVida(nuevaVida);
	}
	
	public void afectar(AlgoFormer algoformer, FormaAerea forma) {	
	}
	
	private int calcularNuevaVida(int vidaActual)
	{
	    return vidaActual * 95 / 100;
	}

}
