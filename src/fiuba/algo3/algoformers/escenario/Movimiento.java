package fiuba.algo3.algoformers.escenario;

public enum Movimiento {
	
	ARRIBA(0,-1), ABAJO(0,1), DERECHA(1,0), IZQUIERDA(-1,0),
	ARRIBA_DERECHA(1,-1), ARRIBA_IZQUIERDA(-1,-1), ABAJO_DERECHA(1,1), ABAJO_IZQUIERDA(-1,1);
	
	private int movEnX;
	private int movEnY;
	
	private Movimiento (int movEnX, int movEnY){
		this.movEnX = movEnX;
		this.movEnY = movEnY;
	}
	
	public int getMovimientoEnX (){
		return movEnX;
	}

	public int getMovimientoEnY (){
		return movEnY;
	}
	
}