package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class EstadoJugador_Activo extends EstadoJugador
{
	public void atacar(Jugador jugador, AlgoFormer atacado)
	{
		jugador.algoformerActual.atacar(atacado);
		jugador._terminarTurno();
	}
	
	public void mover(Jugador jugador, Movimiento direccion)
	{
		jugador.setEstado(new EstadoJugador_Moviendo());
		jugador.mover(direccion);
	}
	
	public void combinar(Jugador jugador)
	{
	    // TO-DO: LOGICA DE COMBINACION
	    
        jugador.setEstado(new EstadoJugador_Combinando());
        terminarTurno(jugador);
	}
	
	public void transformar(Jugador jugador)
	{
		jugador.algoformerActual.transformarse();
		jugador._terminarTurno();
	}
}

