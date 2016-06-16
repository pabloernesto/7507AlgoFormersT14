package fiuba.algo3.algoformers.juego;

import java.util.Observable;
import java.util.Observer;
import java.util.List;
import java.util.ArrayList;

public class ControlDeTurnos extends Observable
{
    private List jugadores = new ArrayList();
    private int jugadorActual = 0;
    
    public Jugador jugadorActual()
    {
        return (Jugador) jugadores.get(jugadorActual);
    }

    public Jugador jugadorSiguiente()
    {
        return (Jugador) jugadores.get((jugadorActual + 1) % jugadores.size());
    }
    
    public void addObserver(Observer observador)
    {
        super.addObserver(observador);
        jugadores.add(observador);
    }

    public void terminarTurno()
    {
        cambiarJugador();
        setChanged();
        notifyObservers(jugadores.get(jugadorActual));
    }
    
    private void cambiarJugador()
    {
        jugadorActual = (jugadorActual + 1) % jugadores.size();
    }
}

