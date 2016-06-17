package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class EstadoJugador_Inactivo extends EstadoJugador
{
	public void atacar(Jugador jugador, AlgoFormer atacado)
	{
		throw new RuntimeException("No es tu turno.");
	}
	
	public void mover(Jugador jugador, Movimiento direccion)
	{
		throw new RuntimeException("No es tu turno.");
	}
	
	public void combinar(Jugador jugador)
	{
		throw new RuntimeException("No es tu turno.");
	}
	
	public void descombinar(Jugador jugador)
	{
		throw new RuntimeException("No es tu turno.");
	}
	
	public void transformar(Jugador jugador)
	{
		throw new RuntimeException("No es tu turno.");
	}

    public void terminarTurno(Jugador jugador)
    {
        throw new RuntimeException("No es tu turno.");
    }
}

