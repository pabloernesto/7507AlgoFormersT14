package TP2;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;



public class Tablero {
		/* --------------------------------------------- 
		 * Si vamos a hacer este hashmap de algoformers, las celdas
		 * no deberian saber si estan ocupadas o no, para evitar acoplamiento */
		HashMap <Algoformer,Posicion> MapaAlgoformers;	
		/*---------------------------------------------- */
		HashMap <Posicion,Celda> celdas;
		public static final int ALTO = 60;
		public static final int ANCHO = 20;
		public Tablero instanciaTablero=null;
		/* Para poder hacer un singleton necesito constantes predefinidas, sino solo puedo hacer 
		 * un get instance con parametros que es medio feo, o hacerlo publico nomas */		
		
		private Tablero(){
			this.celdas= new HashMap <Posicion,Celda>();
			for (int i=0;i<ALTO;i++){
				for (int j=0;j<ANCHO;j++){
					/* Asumo todas las celdas se crean iguales por ahora, luego podemos poner algo que
					 * haga cosas random para crear celdas con distintos efectos */
					Celda nuevaCelda = new Celda();
					Posicion nuevaPosicion = new Posicion (i,j);
					this.celdas.put (nuevaPosicion,nuevaCelda);
				}
			}
			/*
			 *	Para colocar los bonuses lo hace el tablero? O es responsabilidad de la celda??
			 *
			Posicion medio = new Posicion (ALTO/2,ANCHO/2);
			this.celdas.get(medio).colocarChispaSuprema();
			
			*/
		}
		
		public Tablero getInstance (){
			if (this.instanciaTablero==null)
				this.instanciaTablero = new Tablero();
			return this.instanciaTablero;
		}
		
		/* Cuando comienza el juego se llama a esta funcion */
		public void ColocarAlgoformer (Posicion posicion,Algoformer algoformer){
			validarMovimiento (algoformer,posicion);
			this.MapaAlgoformers.put(algoformer,posicion);
			algoformer.moverACelda(this.celdas.get(posicion));
		}
		
		public void mover(Direccion direccion,Algoformer algoformer){
			Posicion posicionInicial = this.MapaAlgoformers.get(algoformer);
			Posicion posicionFinal = posicionInicial.sumarMovimiento(direccion);
			validarMovimiento (algoformer,posicionFinal);
			this.MapaAlgoformers.put (algoformer,posicionFinal);
			algoformer.moverACelda(this.celdas.get(posicionFinal));
		}
		
		private void validarMovimiento (Algoformer algoformer,Posicion posicionFinal){;
			if (this.celdas.get(posicionFinal)==null)
				throw new PosicionInvalidaException();
			if (this.MapaAlgoformers.containsValue(posicionFinal))
				throw new CeldaOcupadaException();
		}
		
		public Posicion devolverPosicionAlgoformer (Algoformer algoformer){
			return this.MapaAlgoformers.get(algoformer);
		}
		
		public int distanciaEntreAlgoformers (Algoformer algoformerAtacante,Algoformer algoformerAtacado){
			/* Asumo la clase Posicion tiene un metodo posicion.calcularDistanciaCon(Posicion posicion)*/
			Posicion posicionAtacante = this.MapaAlgoformers.get(algoformerAtacante);
			return posicionAtacante.calcularDistanciaCon(this.MapaAlgoformers.get(algoformerAtacado);
		}
}
