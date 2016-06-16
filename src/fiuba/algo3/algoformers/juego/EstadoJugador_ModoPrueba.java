package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class EstadoJugador_ModoPrueba extends EstadoJugador
{
	public void atacar(Jugador jugador, AlgoFormer atacado)
	{
		jugador.algoformerActual.atacar(atacado);
	}
	
	public void mover(Jugador jugador, Movimiento direccion)
	{
		jugador.algoformerActual.moverse(direccion);
	}
	
	public void combinar(Jugador jugador)
	{
	    throw new RuntimeException("No implementado.");
	}
	
	public void transformar(Jugador jugador)
	{
		jugador.algoformerActual.transformarse();
	}

    public void terminarTurno(Jugador jugador)
    {
        throw new RuntimeException("No disponible en modo prueba.");
    }
}

