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

public class EstadoJugador_Activo extends EstadoJugador
{
	public void atacar(Jugador jugador, AlgoFormer atacado)
	{
		jugador.algoformerActual.atacar(atacado);
        jugador.setEstado(new EstadoJugador_Inactivo());
		jugador._terminarTurno();
	}
	
	public void mover(Jugador jugador, Movimiento direccion)
	{
		jugador.setEstado(new EstadoJugador_Moviendo());
		jugador.mover(direccion);
	}
	
	public void transformar(Jugador jugador)
	{
		jugador.algoformerActual.transformarse();
        jugador.setEstado(new EstadoJugador_Inactivo());
		jugador._terminarTurno();
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
        jugador.setEstado(new EstadoJugador_Combinando());
        terminarTurno(jugador);
	}
	
	public void descombinar (Jugador jugador){
		if (!jugador.combinado)
			throw new NoEstaCombinadoException();
		
		Tablero tablero = Tablero.getInstance();
		AlgoFormer combinado = jugador.equipo.get(0);
		Posicion posicionCombinado = tablero.getPosicionAlgoformer(combinado);
		List<Posicion> posicionesDisponibles =
		    tablero.posicionesAdyacentesLibres(posicionCombinado);
		if (posicionesDisponibles.size() < 3)
			throw new SinLugarParaDescombinarseException();
		
		jugador.equipo = combinado.devolverIntegrantes();;
		tablero.borrarAlgoformer(combinado);
		int posicion = 0;
		for (AlgoFormer algoformer : jugador.equipo){
			tablero.colocarAlgoformer(
			    algoformer,
			    posicionesDisponibles.get(posicion));
			posicion++;
		}
		
		jugador.combinado = false;
        jugador.setEstado(new EstadoJugador_Inactivo());
		terminarTurno(jugador);
	}
}

