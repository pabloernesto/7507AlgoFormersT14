package fiuba.algo3.algoformers.algoformers;

import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Tablero;

import fiuba.algo3.algoformers.excepciones.FueraDeAlcanceException;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;

public abstract class AlgoFormer {

	protected String nombre;
	protected int vida;
	protected int movimientosRestantes;
	
	protected Forma formaActiva;
	protected Forma formaInactiva;

	public AlgoFormer (String nombre, int vida, UnidadHumanoide formaHumanoide,
			UnidadAlterna formaAlterna)
	{
		this.nombre = nombre;
		this.vida = vida;
		formaActiva = formaHumanoide;
		formaInactiva = formaAlterna;
		reiniciarMovimientosRestantes();
	}

	public abstract void recibirDanio (AutoBot autobot, int ataque);
	
	public abstract void recibirDanio (Decepticon decepticon, int ataque);
	
	public abstract void atacarAlgoformer (AlgoFormer algoformerAtacado);
	
	public void transformarse (){
		Unidad auxiliar = estadoActivo;
		estadoActivo = estadoInactivo;
		estadoInactivo = auxiliar;
		reiniciarMovimientosRestantes();
	}
	
	public void moverse (Movimiento direccion){
		Tablero.getInstance().moverAlgoformer(this, direccion);
	}
	
	public void entrarACelda (Celda celda){
		int costoEntrada = estadoActivo.getCostoDeEntrada(celda);
		if (costoEntrada > movimientosRestantes)
			throw new NoHayMasMovimientosException();
		movimientosRestantes -= costoEntrada;
		celda.recibirAlgoformer(this);
	}
	
	public void atacar (AlgoFormer algoformerAtacado){
		if (Tablero.getInstance().distanciaEntreAlgoformers(this, algoformerAtacado) > getDistAtaque())
			throw new FueraDeAlcanceException();
		atacarAlgoformer(algoformerAtacado);
	}
	
	public Unidad getEstadoActivo (){
		return formaActiva;
	}
	
	public int getAtaque (){
		return formaActiva.getAtaque();
	}
	
	public int getDistAtaque (){
		return formaActiva.getDistAtaque();
	}
	
	public int getVelocidad (){
		return formaActiva.getVelocidad();
	}
	
	public int getVida (){
		return vida;
	}
	
	public String getNombre (){
		return nombre;
	}
	
	public int getMovimientosRestantes (){
		return movimientosRestantes;
	}
	
	public void reiniciarMovimientosRestantes (){
		movimientosRestantes = getVelocidad();
	}
	
	public void recibirEfecto(Superficie SuperficieActual){
		this.formaActivo.recibirEfecto(SuperficieActual);
	}
	
}
