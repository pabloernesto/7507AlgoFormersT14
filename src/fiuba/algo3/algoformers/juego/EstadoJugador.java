package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public abstract class EstadoJugador
{
	public abstract void atacar(Jugador j, AlgoFormer atacado);
	public abstract void mover(Jugador j, Movimiento direccion);
	public abstract void combinar(Jugador j);
	public abstract void transformar(Jugador j);
    
    public void elegirAlgoFormer(Jugador j, String nombre)
    {
        j._elegirAlgoFormer(nombre);
    }
}

