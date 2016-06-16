package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class EstadoJugador_ModoPrueba extends EstadoJugador
{
	public void atacar(Jugador j, AlgoFormer atacado)
	{
		j.algoformerActual.atacar(atacado);
	}
	
	public void mover(Jugador j, Movimiento direccion)
	{
		j.algoformerActual.moverse(direccion);
	}
	
	public void combinar(Jugador j)
	{
	    throw new RuntimeException("No implementado.");
	}
	
	public void transformar(Jugador j)
	{
		j.algoformerActual.transformarse();
	}

    public void terminarTurno(Jugador j)
    {
        throw new RuntimeException("No disponible en modo prueba.");
    }
}

