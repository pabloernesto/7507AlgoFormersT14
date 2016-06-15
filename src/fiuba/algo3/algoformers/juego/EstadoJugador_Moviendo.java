package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class EstadoJugador_Moviendo extends EstadoJugador
{
	public void atacar(Jugador j, AlgoFormer atacado)
	{
		throw new RuntimeException("Estas moviendo");
	}
	
	/* Como dejo de moverme!? */
	public void mover(Jugador j, Movimiento direccion)
	{
		j.algoformerActual.moverse(direccion);
	}
	
	public void combinar(Jugador j)
	{
		throw new RuntimeException("Estas moviendo");
	}
	
	public void transformar(Jugador j)
	{
		throw new RuntimeException("Estas moviendo");
	}
}

