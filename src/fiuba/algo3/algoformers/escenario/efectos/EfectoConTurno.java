package fiuba.algo3.algoformers.escenario.efectos;

public abstract class EfectoConTurno extends Efecto {

	protected int turnosRestantes;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + turnosRestantes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	public void restarTurnos() {
		this.turnosRestantes--;
	}

	public int getTurnos() {
		return turnosRestantes;
	}
}
