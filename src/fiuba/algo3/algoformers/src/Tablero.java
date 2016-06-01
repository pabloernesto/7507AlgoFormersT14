package fiuba.algo3.algoformers.modelo;

import java.util.HashMap;

public class Tablero {
	
		public HashMap <AlgoFormer,Posicion> mapaAlgoformers;
		public HashMap <Posicion,Celda> celdas;
		public static final int ALTO = 20;
		public static final int ANCHO = 60;
		public static Tablero instanciaTablero = null;	
		
		private Tablero()
		{
		    mapaAlgoformers = new HashMap<AlgoFormer,Posicion>();
		    
			this.celdas= new HashMap <Posicion,Celda>();
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
			Tablero.instanciaTablero = null;
		}
		
		/* Cuando comienza el juego se llama a esta funcion */
		public void ColocarAlgoformer (Posicion posicion,AlgoFormer algoformer){
			validarMovimiento(algoformer, posicion);
			this.mapaAlgoformers.put(algoformer,posicion);
			celdas.get(posicion).activarEfecto(algoformer);
		}
		
		public void mover(Movimiento direccion, AlgoFormer algoformer)
		{
			Posicion posicionInicial = this.mapaAlgoformers.get(algoformer);
			Posicion posicionFinal = posicionInicial.sumarMovimiento(direccion);
			
			validarMovimiento(algoformer, posicionFinal);
			algoformer.moverACelda(this.celdas.get(posicionFinal));
			this.mapaAlgoformers.put(algoformer, posicionFinal);
		}

		public void colocarChispaSuprema()
		{
			Posicion medio = new Posicion (ANCHO/2, ALTO/2);
			this.celdas.get(medio).colocarChispaSuprema();
		}
		
		public int devolverExtremoDeAncho(){
			return ANCHO;
		}
		
		public int devolverExtremoDeAlto(){
			return ALTO;
		}
		
		private void validarMovimiento(AlgoFormer algoformer,
		    Posicion posicion)
		{
			if (this.celdas.get(posicion) == null)
				throw new PosicionInvalidaException();
			if (this.mapaAlgoformers.containsValue(posicion))
				throw new CeldaOcupadaException();
		}
		
		public Posicion devolverPosicionAlgoformer (AlgoFormer algoformer){
			return this.mapaAlgoformers.get(algoformer);
		}
		
		public int distanciaEntreAlgoformers(AlgoFormer algoformerAtacante, 
		    AlgoFormer algoformerAtacado)
		{
			Posicion posicionAtacante =
			    this.mapaAlgoformers.get(algoformerAtacante);
			return posicionAtacante.calcularDistanciaCon(
			    this.mapaAlgoformers.get(algoformerAtacado));
		}
}
