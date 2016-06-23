package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class EstadoJugador_Moviendo extends EstadoJugador
{
	public void atacar(Jugador jugador, AlgoFormer atacado)
	{
		throw new RuntimeException("Estas moviendo");
	}
	
	public void mover(Jugador jugador, Movimiento direccion)
	{
		jugador.algoformerActual.moverse(direccion);
	}
	
	public void combinar(Jugador jugador)
	{
		throw new RuntimeException("Estas moviendo");
	}
	
	public void descombinar(Jugador jugador)
	{
		throw new RuntimeException("Estas moviendo");
	}
	
	public void transformar(Jugador jugador)
	{
		throw new RuntimeException("Estas moviendo");
	}
	
    public void elegirAlgoFormer(Jugador jugador, String nombre)
    {
		throw new RuntimeException("Estas moviendo");
    }
    
    
}

