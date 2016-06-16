package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class EstadoJugador_Activo extends EstadoJugador
{
	public void atacar(Jugador j, AlgoFormer atacado)
	{
		j.algoformerActual.atacar(atacado);
		j._terminarTurno();
	}
	
	public void mover(Jugador j, Movimiento direccion)
	{
		j.setEstado(new EstadoJugador_Moviendo());
		j.mover(direccion);
	}
	
	public void combinar(Jugador j)
	{
	    throw new RuntimeException("No implementado.");
	}
	
	public void transformar(Jugador j)
	{
		j.algoformerActual.transformarse();
		j._terminarTurno();
	}
}

