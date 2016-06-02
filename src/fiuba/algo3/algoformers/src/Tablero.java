package fiuba.algo3.algoformers.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Tablero {

		private ArrayList<Posicion> posicionCeldasOcupadas;
		private HashMap <Posicion,Celda> celdas;
		public static final int ALTO = 20;
		public static final int ANCHO = 60;
		public static Tablero instanciaTablero = null;	
		
		private Tablero()
		{
		    posicionCeldasOcupadas = new ArrayList<Posicion>();
		    
			this.celdas = new HashMap <Posicion,Celda>();
			for (int i=0;i<ANCHO;i++){
				for (int j=0;j<ALTO;j++){
					/* Asumo todas las celdas se crean iguales por ahora, luego podemos poner algo que
					 * haga cosas random para crear celdas con distintos efectos */
					Celda nuevaCelda = new Celda();
					Posicion nuevaPosicion = new Posicion (i,j);
					this.celdas.put (nuevaPosicion,nuevaCelda);
				}
			}
		}

		public static Tablero getInstance (){
			if (instanciaTablero == null)
				instanciaTablero = new Tablero();
			return instanciaTablero;
		}
		
		public Posicion devolverPosicionChispaSuprema(){
			for (int i=0;i<ANCHO;i++) {
				for (int j=0;j<ALTO;j++) {
					Posicion posicion = new Posicion (i,j);
					if (this.celdas.get(posicion).contieneChispaSuprema())
						return posicion;
				}
			}
			throw new RuntimeException();
		}
		
		public static void borrarInstancia(){
			instanciaTablero = null;
		}
		
		/* Cuando comienza el juego se llama a esta funcion */
		public void ColocarAlgoformer (Posicion posicion, AlgoFormer algoformer){
			validarMovimiento(algoformer, posicion);
			celdas.get(posicion).setAlgoformer(algoformer);
			this.posicionCeldasOcupadas.add(posicion);
		}
		
		public void mover(Movimiento direccion, AlgoFormer algoformer)
		{
			Posicion posicionInicial = devolverPosicionAlgoformer(algoformer);
			Posicion posicionFinal = posicionInicial.sumarMovimiento(direccion);
			
			validarMovimiento(algoformer, posicionFinal);
			algoformer.moverACelda(this.celdas.get(posicionFinal));
			Collections.replaceAll(this.posicionCeldasOcupadas,posicionInicial,posicionFinal );;
		}

		public void colocarChispaSuprema()
		{
			Posicion medio = new Posicion (ANCHO/2, ALTO/2);
			this.celdas.get(medio).colocarChispaSuprema();
		}
		
		public int devolverExtremoDeAncho(){
			return ANCHO - 1;
		}
		
		public int devolverExtremoDeAlto(){
			return ALTO - 1;
		}
		
		public boolean posicionEstaOcupada(Posicion posicion){
			return this.celdas.get(posicion).estaOcupada();
		}

		public boolean posicionContieneChispaSuprema(Posicion posicion){
			return this.celdas.get(posicion).contieneChispaSuprema();
		}
		
		private void validarMovimiento(AlgoFormer algoformer,
		    Posicion posicion)
		{
			if (this.celdas.get(posicion) == null)
				throw new PosicionInvalidaException();
			if (this.posicionCeldasOcupadas.contains(posicion))
				throw new CeldaOcupadaException();
		}
		
		public Posicion devolverPosicionAlgoformer (AlgoFormer algoformer){
			Posicion posicionAlgoformer = null;
			for (Posicion posicion: this.posicionCeldasOcupadas){
				if (celdas.get(posicion).getAlgoformer().equals(algoformer))
					posicionAlgoformer=posicion;
				}
			return posicionAlgoformer;
		}
		
		public int distanciaEntreAlgoformers(AlgoFormer algoformerAtacante, 
		    AlgoFormer algoformerAtacado)
		{
			Posicion posicionAtacante =
					devolverPosicionAlgoformer(algoformerAtacante);
			return posicionAtacante.calcularDistanciaCon(
					devolverPosicionAlgoformer(algoformerAtacado));
		}
}