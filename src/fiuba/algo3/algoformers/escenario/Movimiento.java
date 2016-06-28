package fiuba.algo3.algoformers.escenario;

public enum Movimiento {
	
	ARRIBA(0,-1,"norte"), ABAJO(0,1,"sur"), DERECHA(1,0,"este"), IZQUIERDA(-1,0,"oeste"),
	ARRIBA_DERECHA(1,-1,"noreste"), ARRIBA_IZQUIERDA(-1,-1,"noroeste"),
	ABAJO_DERECHA(1,1,"sureste"), ABAJO_IZQUIERDA(-1,1,"suroeste");
	
	private int movEnX;
	private int movEnY;
	private String flecha;
	
	private Movimiento (int movEnX, int movEnY, String flecha){
		this.movEnX = movEnX;
		this.movEnY = movEnY;
		this.flecha = flecha;
	}
	
	public int getMovimientoEnX (){
		return movEnX;
	}

	public int getMovimientoEnY (){
		return movEnY;
	}

    public String flecha()
    {
        return flecha;
    }
}
