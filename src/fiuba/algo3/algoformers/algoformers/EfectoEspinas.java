package fiuba.algo3.algoformers.algoformers;

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
