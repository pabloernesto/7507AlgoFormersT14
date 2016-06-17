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
		Tablero tablero = Tablero.getInstance();
		if (jugador.equipo.size() < 3)
			throw new EquipoIncompletoException();
		AlgoFormer capitan = jugador.equipo.get(0);
		for (AlgoFormer algoformer: jugador.equipo){
			int distancia = tablero.distancia(capitan, algoformer);
			if (distancia > 2)
				throw new AlgoformerMuyLejosException();
		}
		AlgoFormer combinado = jugador.algoformerFactory.crearCombinado(jugador.equipo);
		List<AlgoFormer> nuevoEquipo = new ArrayList<AlgoFormer>();
		nuevoEquipo.add(combinado);
		Posicion posicionCombinado = tablero.getPosicionAlgoformer(capitan);
		for (AlgoFormer algoformer : jugador.equipo)
			tablero.borrarAlgoformer(algoformer);
		tablero.colocarAlgoformer(combinado, posicionCombinado);
		jugador.equipo = nuevoEquipo;
		jugador.combinado = true;
	}
	
	public void descombinar(Jugador jugador)
	{
		if (!jugador.combinado)
			throw new NoEstaCombinadoException();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer combinado = jugador.equipo.get(0);
		Posicion posicionCombinado = tablero.getPosicionAlgoformer(combinado);
		List<Posicion> posicionesDisponibles = tablero.posicionesAdyacentesLibres(posicionCombinado);
		if (posicionesDisponibles.size() < 3)
			throw new SinLugarParaDescombinarseException();
		List<AlgoFormer> nuevoEquipo = combinado.devolverIntegrantes();
		jugador.equipo = nuevoEquipo;
		tablero.borrarAlgoformer(combinado);
		int posicion = 0;
		for (AlgoFormer algoformer : jugador.equipo){
			tablero.colocarAlgoformer(algoformer, posicionesDisponibles.get(posicion));
			posicion++;
		}
		jugador.combinado = false;
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

