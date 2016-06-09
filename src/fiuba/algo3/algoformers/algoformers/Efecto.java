package fiuba.algo3.algoformers.algoformers;

public abstract class Efecto{

	
	
	public abstract void afectar(AlgoFormer algoformer, FormaHumanoide estadoActivo);
	
	public abstract void afectar(AlgoFormer algoformer, FormaTerrestre estadoActivo);
	
	public abstract void afectar(AlgoFormer algoformer, FormaAerea estadoActivo);
	
	@Override
	public int hashCode() {
		int result = 1;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}

}