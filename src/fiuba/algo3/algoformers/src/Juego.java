/*package fiuba.algo3.algoformers.modelo;

import java.util.ArrayList;
import fiuba.algo3.algoformers.modelo.Tablero;
import fiuba.algo3.algoformers.modelo.Posicion;
import fiuba.algo3.algoformers.modelo.Movimiento;

public class Juego {
	public Tablero tablero = Tablero.getInstance();
	private Equipo equipoActual;
	private Equipo equipoInactivo;
	private AlgoFormer algoformerActual;	
	
	public void jugar() {
		
		ArrayList<String> listaArchivosAutobots = new ArrayList<String>();
		ArrayList<String> listaArchivosDecepticons = new ArrayList<String>();
		
		Equipo equipoTurnoActual = new Equipo(listaArchivosDecepticons);
		Equipo otroEquipo =  new Equipo(listaArchivosAutobots);
		ChispaSuprema chispaSuprema =  new ChispaSuprema();
		
		
		//DECIDIR POR RANDOM EL EQUIPO TURNO ACTUAL;
		
		//Equipo equipoJuegaPrimero = random(uno,dos);
		
		//this.equipoactual = equipojuegaoruneri
				
		
		ubicarEquipos(equipoTurnoActual, otroEquipo);
		ubicarChispa(chispaSuprema);
		
		boolean hayGanador = false;
		while(!hayGanador){
			hayGanador = turnoEquipo(equipoTurnoActual);
			swap(equipoTurnoActual,otroEquipo);
		}	
	//Fin del juego.
	}

	public void ubicarEquipos(Equipo equipoActual, Equipo otroEquipo){
		//Meto grupo de autobots a la izq del mapa
		Posicion posicion = new Posicion(0,0);
		for(AlgoFormer algoformer : equipoActual.getListaAlgoFormer()){
			posicion.sumarMovimiento(Movimiento.ABAJO);
			tablero.ColocarAlgoformer(posicion, algoformer);
		}	

		//Meto grupo de decepticons a la der del mapa
		posicion = new Posicion(60,0);
		for(AlgoFormer algoformer : otroEquipo.getListaAlgoFormer()){
			posicion.sumarMovimiento(Movimiento.ABAJO);
			tablero.ColocarAlgoformer(posicion, algoformer);
		}	
	}
	
	public void ubicarChispa(ChispaSuprema chispa){
		tablero.colocarChispaSuprema(chispa);
	}
	
	public boolean turnoEquipo(Equipo equipo){
		
	
		1.equipo decide elegir algoformer
			preguntaralgoformerquehacer(){
				1.mover	
					(mostrar lugares disponibles)
				2.atacar
					(mostrar si podes atacar y dsp atacar o perder turno)
				3.combinarse
					(chequea rangos.)
			}
			finalizarTurno(); //capaz sirve para hacer efectos de bonus o superficies. sino borrar.
		return true;
	}
	
	public void swap(Equipo equipoActual, Equipo otroEquipo){
		Equipo equipoAux = equipoActual;
		equipoActual = otroEquipo;
		otroEquipo = equipoAux;
	}

}*/