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
	}	
	/*public boolean turnoEquipo(Equipo equipo){
		
		Scanner ingreso = new Scanner(System.in);
		
		System.out.println("Eliga el algoformer a utilizar");
		ArrayList<AlgoFormer> listaAlgoformer = equipo.getListaAlgoFormer();
		for(int i =0; i< listaAlgoformer.size(); i++ )
			System.out.println("\n" + i + ". " + listaAlgoformer.get(i).getNombre());
			
		System.out.println("\nEleccion: ");
		int eleccion = ingreso.nextInt();
		
		AlgoFormer algoformerActual = equipo.get(listaAlgoformer.get(eleccion).getNombre());
		System.out.println("\nElegiste" + eleccion + algoformerActual.getNombre());
		
		
		System.out.println("\nQue decide hacer?");
		System.out.println("\n1. Mover");
		System.out.println("\n2. Atacar");
		System.out.println("\n3. Transformarse");
		System.out.println("\n4. Combinarse");
		System.out.println("\nEleccion: ");
		eleccion = ingreso.nextInt();

		switch(eleccion){
		case 1:
			//aca se podria pedir la cantidad de movimientos posibles y hacer un bucle.
			System.out.println("\nPara donde me muevo?");
			System.out.println("\n1. Abajo Izquierda");
			System.out.println("\n2. Abajo"); 
			System.out.println("\n3. Abajo Derecha");
			System.out.println("\n4. Izquierda");
			System.out.println("\n6. Derecha");
			System.out.println("\n7. Arriba Izquierda"); 
			System.out.println("\n8. Arriba"); 
			System.out.println("\n9. Arriba Derecha");
			
			System.out.println("\nEleccion: ");
			eleccion = ingreso.nextInt();
			switch(eleccion){// NO VERIFICO CUANTAS VECES PUEDO MOVERME
				case 1: 
					algoformerActual.mover(Movimiento.ABAJO_IZQUIERDA);
					break;
				case 2: 
					algoformerActual.mover(Movimiento.ABAJO);
					break;
				case 3: 
					algoformerActual.mover(Movimiento.ABAJO_DERECHA);
					break;
				case 4: 
					algoformerActual.mover(Movimiento.IZQUIERDA);
					break;
				case 6: 
					algoformerActual.mover(Movimiento.DERECHA);
					break;
				case 7: 
					algoformerActual.mover(Movimiento.ARRIBA_IZQUIERDA);
					break;
				case 8: 
					algoformerActual.mover(Movimiento.ARRIBA);
					break;
				case 9: 
					algoformerActual.mover(Movimiento.ARRIBA_DERECHA);
					break;
				default:
					System.out.println("QUE HACES??????? PERDES EL TURNO POR DESPISTADO!"); //esto se deberia manejar de otra manera, onda que vuelva a ingresar la eleccion de moverse.
			}
			break;
			
		case 2:
			//mostrar lista de algoformers disponibles para atacar y hacer la lista de PRINTS y otro switch.
			algoformerActual.atacar();
			break;
		case 3:
			algoformerActual.transformarse();
			break;
		case 4: 
			algoformerActual.combinarse();
			break;
		default:
			System.out.println("QUE HACES??????? PERDES EL TURNO POR DESPISTADO!"); //esto se deberia manejar repetiendo el turno del jugador.
		}
		return chequearGanador();
	}
	public boolean chequearGanador(){
		//chequea que la chispa ya no exista o que algoformers no tengan vida
		return false;
	}*/
	
	
	public void swap(){
		Equipo equipoAux = equipoActual;
		equipoActual = equipoInactivo;
		equipoInactivo = equipoAux;
	}
}
