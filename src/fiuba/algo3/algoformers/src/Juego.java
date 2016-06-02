package fiuba.algo3.algoformers.modelo;

import java.util.List;
import java.util.ArrayList;
import fiuba.algo3.algoformers.modelo.Tablero;
import fiuba.algo3.algoformers.modelo.Posicion;
import fiuba.algo3.algoformers.modelo.Movimiento;

public class Juego {

	Tablero tablero = Tablero.getInstance();
	private Equipo equipoActual;
	private Equipo equipoInactivo;
	private String archivo1 = "/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt";
	private String archivo2 = "/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/bumblebee.txt";
	private String archivo3 = "/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/ratchet.txt";
	private String archivo4 = "/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/megatron.txt";
	private String archivo5 = "/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/frenzy.txt";
	private String archivo6 = "/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/bonecrusher.txt";
	
	public void inicializarJuego() {
		
		List<String> autobots = new ArrayList<String>();
		autobots.add(archivo1);
		autobots.add(archivo2);
		autobots.add(archivo3);
		List<String> decepticons = new ArrayList<String>();
		autobots.add(archivo4);
		autobots.add(archivo5);
		autobots.add(archivo6);
		
		Equipo equipo1 = new Equipo(autobots);
		Equipo equipo2 =  new Equipo(decepticons);
		if (Math.random() < 0.5){
			equipoActual = equipo1;
			equipoInactivo = equipo2;
		} else {
			equipoActual = equipo2;
			equipoInactivo = equipo1;
		}		
		
		ubicarEquipos();
		ubicarChispa();
		
		Equipo equipoGanador = cicloPrincipal();
		}
	//Fin del juego.

	public Equipo cicloPrincipal(){
		boolean hayGanador = false;
		while(!hayGanador){
			hayGanador = turnoEquipo(equipoActual);
			swap();
		}
		return equipoInactivo;
	}

	public void ubicarEquipos(){
		//Meto grupo de primer equipo a la izq del mapa
		Posicion posicion = new Posicion(0, tablero.devolverExtremoDeAlto()/2-1);
		for(AlgoFormer algoformer : equipoActual.getListaAlgoFormer()){
			posicion.sumarMovimiento(Movimiento.ABAJO);
			tablero.ColocarAlgoformer(posicion, algoformer);
		}	

		//Meto grupo del otro equipo a la der del mapa
		posicion = new Posicion(tablero.devolverExtremoDeAncho(), tablero.devolverExtremoDeAlto()/2-1);
		for(AlgoFormer algoformer : equipoInactivo.getListaAlgoFormer()){
			posicion.sumarMovimiento(Movimiento.ABAJO);
			tablero.ColocarAlgoformer(posicion, algoformer);
		}
	}
	
	public void ubicarChispa()
	{
		tablero.colocarChispaSuprema();
	}
	
	public boolean turnoEquipo(Equipo equipo){
		
		return true;
		
		/*1.equipo decide elegir algoformer
			preguntaralgoformerquehacer(){
				1.mover	
					(mostrar lugares disponibles)
				2.atacar
					(mostrar si podes atacar y dsp atacar o perder turno)
				3.combinarse
					(chequea rangos.)
			}
			finalizarTurno(); //capaz sirve para hacer efectos de bonus o superficies. sino borrar.
		return true;*/
	}
	
	public void swap(){
		Equipo equipoAux = equipoActual;
		equipoActual = equipoInactivo;
		equipoInactivo = equipoAux;
	}
}
