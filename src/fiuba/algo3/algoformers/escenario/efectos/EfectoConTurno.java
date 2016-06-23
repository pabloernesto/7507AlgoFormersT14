package fiuba.algo3.algoformers.escenario.efectos;

public abstract class EfectoConTurno extends Efecto {

	protected int turnosRestantes;

	public void restarTurnos() {
		this.turnosRestantes--;
	}

	public int getTurnos() {
		return turnosRestantes;
	}
}
