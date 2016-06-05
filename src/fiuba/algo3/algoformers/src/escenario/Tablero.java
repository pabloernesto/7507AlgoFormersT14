package fiuba.algo3.algoformers.escenario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;
import fiuba.algo3.algoformers.excepciones.PosicionInvalidaException;

public class Tablero {

	private ArrayList<Posicion> posicionesCeldasOcupadas;
	private HashMap <Posicion,Celda> celdas;
	private final int ANCHO = 60;
	private final int ALTO = 20;
	private static Tablero instanciaTablero = null;
	
	private Tablero (){
	    posicionesCeldasOcupadas = new ArrayList<Posicion>();
	    
		celdas = new HashMap <Posicion,Celda>();
		for (int i=1 ; i<=ANCHO ; i++){
			for (int j=1 ; j<=ALTO ; j++)
				/* Asumo todas las celdas se crean iguales por ahora, luego podemos poner algo que
				 * haga cosas random para crear celdas con distintos efectos */
				celdas.put(new Posicion(i,j), new Celda());
		}
	}
	
	public static Tablero getInstance (){
		if (instanciaTablero == null)
			instanciaTablero = new Tablero();
		return instanciaTablero;
	}
	
	public static void reiniciarTablero (){
		instanciaTablero = null;
	}
	
	public void colocarAlgoformer (AlgoFormer algoformer, Posicion posicion){
		validarMovimiento(algoformer, posicion);
		celdas.get(posicion).recibirAlgoformer(algoformer);
		posicionesCeldasOcupadas.add(posicion);
	}
	
	public void moverAlgoformer (AlgoFormer algoformer, Movimiento direccion){
		Posicion posicionInicial = getPosicionAlgoformer(algoformer);
		Posicion posicionFinal = posicionInicial.sumarMovimiento(direccion);
		validarMovimiento(algoformer, posicionFinal);
		algoformer.entrarACelda(celdas.get(posicionFinal));
		Collections.replaceAll(posicionesCeldasOcupadas, posicionInicial, posicionFinal);
	}
	
	public Posicion getPosicionAlgoformer (AlgoFormer algoformer){
		Posicion posicionAlgoformer = null;
		for (Posicion posicion: posicionesCeldasOcupadas){
			if (celdas.get(posicion).getAlgoformer().equals(algoformer))
				posicionAlgoformer=posicion;
			}
		return posicionAlgoformer;
	}
	
	public void colocarChispaSuprema(){
		Posicion medio = new Posicion (ANCHO/2, ALTO/2);
		celdas.get(medio).colocarChispaSuprema();
	}
	
	public Posicion getPosicionChispaSuprema(){
		Posicion posicion = null;
		for (int i=1 ; i<=ANCHO ; i++) {
			for (int j=1 ; j<=ALTO ; j++) {
				posicion = new Posicion (i,j);
				if (celdas.get(posicion).contieneChispaSuprema())
					return posicion;
				posicion = null;
			}
		}
		return posicion;
	}
	
	public boolean posicionEstaOcupada(Posicion posicion){
		return celdas.get(posicion).estaOcupada();
	}

	public boolean posicionContieneChispaSuprema(Posicion posicion){
		return celdas.get(posicion).contieneChispaSuprema();
	}
	
	public int distanciaEntreAlgoformers(AlgoFormer algoformer1, AlgoFormer algoformer2){
			Posicion posicionAlgoformer1 = getPosicionAlgoformer(algoformer1);
			Posicion posicionAlgoformer2 = getPosicionAlgoformer(algoformer2);
			return posicionAlgoformer1.calcularDistanciaCon(posicionAlgoformer2);
		}
	
	public int getExtremoDeAncho(){
		return ANCHO;
	}
	
	public int getExtremoDeAlto(){
		return ALTO;
	}
	
	private void validarMovimiento (AlgoFormer algoformer, Posicion posicion){
		if (celdas.get(posicion) == null)
			throw new PosicionInvalidaException();
		if (posicionesCeldasOcupadas.contains(posicion))
			throw new CeldaOcupadaException();
	}
	

	//Metodos para pruebas//
	
	public Posicion getMedio(){
		return new Posicion(ANCHO/2, ALTO/2);
	}

}
