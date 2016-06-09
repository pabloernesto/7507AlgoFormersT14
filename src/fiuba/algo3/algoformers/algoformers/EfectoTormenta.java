package fiuba.algo3.algoformers.algoformers;

public class EfectoTormenta extends Efecto{

	public void afectar(AlgoFormer algoformer, FormaHumanoide estadoActivo) {
	}
	
	public void afectar(AlgoFormer algoformer, FormaTerrestre estadoActivo) {
	}

	public void afectar(AlgoFormer algoformer, FormaAerea estadoActivo) {
			int ataque = algoformer.getAtaque();
			int nuevoAtaque = ataque * 60 / 100;
			algoformer.setAtaque(nuevoAtaque);
	}
	

}
