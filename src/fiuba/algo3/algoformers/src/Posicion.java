package fiuba.algo3.algoformers.modelo;

/** Representa una posicion de dos coordenadas */
public class Posicion {
	private int x;
	private int y;
	
	public Posicion(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/** Crea y devuelve una nueva posicion, que es el resultado de mover la posicion respecto del movimiento recibido */
	public Posicion sumarMovimiento(Movimiento movimiento){
		Posicion nuevaPosicion = new Posicion(this.x,this.y);
		nuevaPosicion.x += movimiento.getMovimientoEnX();
		nuevaPosicion.y += movimiento.getMovimientoEnY();
		return nuevaPosicion;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public int calcularDistanciaCon(Posicion unaPosicion)
	{
	    int distanciaX = Math.abs(x - unaPosicion.x);
	    int distanciaY = Math.abs(y - unaPosicion.y);
		return (Math.max(distanciaX, distanciaY));
	}	
}
