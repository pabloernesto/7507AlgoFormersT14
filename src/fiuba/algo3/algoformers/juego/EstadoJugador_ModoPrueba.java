package fiuba.algo3.algoformers.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.excepciones.AlgoformerMuyLejosException;
import fiuba.algo3.algoformers.excepciones.EquipoIncompletoException;
import fiuba.algo3.algoformers.excepciones.NoEstaCombinadoException;
import fiuba.algo3.algoformers.excepciones.SinLugarParaDescombinarseException;
import fiuba.algo3.algoformers.excepciones.YaEstaCombinadoException;

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
		if (jugador.combinado)
			throw new YaEstaCombinadoException();
		
		if (jugador.equipo.size() < 3)
			throw new EquipoIncompletoException();
		
		Tablero tablero = Tablero.getInstance();
		AlgoFormer capitan = jugador.equipo.get(0);
		for (AlgoFormer algoformer: jugador.equipo){
			int distancia = tablero.distancia(capitan, algoformer);
			if (distancia > 2)
				throw new AlgoformerMuyLejosException();
		}
		
        jugador._combinar();
	}
	
    public void descombinar(Jugador jugador)
    {
        if (!jugador.combinado)
            throw new NoEstaCombinadoException();

        AlgoFormer superion = jugador.getListaAlgoformers().get(0);
        if (Tablero.getInstance().movimientosValidos(superion).size() < 3)
            throw new SinLugarParaDescombinarseException();

        jugador._descombinar();
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

