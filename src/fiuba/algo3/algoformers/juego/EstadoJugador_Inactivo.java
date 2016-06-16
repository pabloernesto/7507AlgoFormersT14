package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class EstadoJugador_Inactivo extends EstadoJugador
{
	public void atacar(Jugador j, AlgoFormer atacado)
	{
		throw new RuntimeException("No es tu turno.");
	}
	
	public void mover(Jugador j, Movimiento direccion)
	{
		throw new RuntimeException("No es tu turno.");
	}
	
	public void combinar(Jugador j)
	{
		throw new RuntimeException("No es tu turno.");
	}
	
	public void transformar(Jugador j)
	{
		throw new RuntimeException("No es tu turno.");
	}

    public void terminarTurno(Jugador j)
    {
        throw new RuntimeException("No es tu turno.");
    }
}

