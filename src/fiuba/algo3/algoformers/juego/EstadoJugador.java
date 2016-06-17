package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public abstract class EstadoJugador
{
	public abstract void atacar(Jugador jugador, AlgoFormer atacado);
	public abstract void mover(Jugador jugador, Movimiento direccion);
	public abstract void combinar(Jugador jugador);
	public abstract void descombinar(Jugador jugador);
	public abstract void transformar(Jugador j);
    
    public void elegirAlgoFormer(Jugador jugador, String nombre)
    {
        jugador._elegirAlgoFormer(nombre);
    }
    
    public void terminarTurno(Jugador jugador)
    {
        jugador._terminarTurno();
    }
    
    public void iniciarTurno(Jugador jugador)
    {
        jugador.setEstado(new EstadoJugador_Activo());
    }
}

