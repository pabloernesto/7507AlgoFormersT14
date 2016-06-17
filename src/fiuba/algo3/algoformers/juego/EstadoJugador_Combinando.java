package fiuba.algo3.algoformers.juego;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class EstadoJugador_Combinando extends EstadoJugador
{
    private int turnosTranscurridos = 0;
    
    public void atacar(Jugador jugador, AlgoFormer atacado) {}
    public void mover(Jugador jugador, Movimiento direccion) {}
    public void combinar(Jugador jugador) {}
    public void transformar(Jugador j) {}
    public void elegirAlgoFormer(Jugador jugador, String nombre){}
    public void descombinar(Jugador jugador){}
    
    public void iniciarTurno (Jugador j)
    {
        if (turnosTranscurridos == 2)
            j.setEstado(new EstadoJugador_Activo());
        
        else
        {
            turnosTranscurridos += 1;
            terminarTurno(j);
        }
    }
}

