package fiuba.algo3.algoformers.juego;

import java.util.List;


import fiuba.algo3.algoformers.algoformers.AlgoFormer;

import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class Juego {

	Tablero tablero;
	private Jugador jugadorActual;
	private Jugador jugadorInactivo;
	
	public Juego() {}
	
	public void inicializar()
	{
		tablero = Tablero.getInstance();
		
		JugadorAutoBots jugadorAutobots = new JugadorAutoBots();
		JugadorDecepticons jugadorDecepticons = new JugadorDecepticons();
		if (Math.random() > 0.5){
			jugadorActual = jugadorAutobots;
			jugadorInactivo = jugadorDecepticons;
		} else {
			jugadorActual = jugadorDecepticons;
			jugadorInactivo = jugadorAutobots;
		}
		
		ubicarAlgoformers();
		ubicarChispaSuprema();
	}
	
	public Jugador jugadorActual()
	{
	    return jugadorActual;
	}

	public Jugador jugadorInactivo()
	{
	    return jugadorInactivo;
	}
	
	private void ubicarAlgoformers()
	{
	    List<AlgoFormer> equipo;
	    Posicion inicio;
	    int medioDelTablero = tablero.altura() / 2;
	    
		inicio = new Posicion(1, medioDelTablero);
	    equipo = jugadorActual.getListaAlgoformers();
		colocarEquipo(equipo, inicio);
	    
		inicio = new Posicion(tablero.ancho(), medioDelTablero);
	    equipo = jugadorInactivo.getListaAlgoformers();
		colocarEquipo(equipo, inicio);
	}
	
	private void ubicarChispaSuprema(){
		tablero.colocarChispaSuprema();
	}

	private void colocarEquipo(List<AlgoFormer> equipo,
	    Posicion inicio)
    {
        Posicion posicion = inicio;
		for(AlgoFormer algoformer : equipo)
		{
			tablero.colocarAlgoformer(algoformer, posicion);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
		}
	}
}
