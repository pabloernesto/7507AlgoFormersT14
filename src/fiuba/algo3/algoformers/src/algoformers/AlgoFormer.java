package fiuba.algo3.algoformers.algoformers;


import fiuba.algo3.algoformers.escenario.*;

import fiuba.algo3.algoformers.excepciones.FueraDeAlcanceException;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;

public abstract class AlgoFormer {

	protected String nombre;
	protected int vida;
	protected int movimientosRestantes;
	
	protected Forma estadoActivo;
	protected Forma estadoInactivo;

	public AlgoFormer (String nombre, int vida, FormaHumanoide formaHumanoide,
			FormaAlterna formaAlterna)
	{
		this.nombre = nombre;
		this.vida = vida;
		estadoActivo = formaHumanoide;
		estadoInactivo = formaAlterna;
		reiniciarMovimientosRestantes();
	}

	public abstract void recibirDanio (AutoBot autobot, int ataque);
	
	public abstract void recibirDanio (Decepticon decepticon, int ataque);
	
	public abstract void atacarAlgoformer (AlgoFormer algoformerAtacado);
	
	public void transformarse (){
		Forma auxiliar = estadoActivo;
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

	public void atacar(AlgoFormer algoformerAtacado)
	{
	    int distancia =
	        Tablero.getInstance()
	               .distanciaEntreAlgoformers(this, algoformerAtacado);

		int alcance = getDistAtaque();

		if (distancia > alcance)
			throw new FueraDeAlcanceException();

		atacarAlgoformer(algoformerAtacado);
	}
	
	public Forma getEstadoActivo (){
		return estadoActivo;
	}
	
	public int getAtaque (){
		return estadoActivo.getAtaque();
	}
	
	public int getDistAtaque (){
		return estadoActivo.getDistAtaque();
	}
	
	public int getVelocidad (){
		return estadoActivo.getVelocidad();
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
	//	movimientosRestantes = getVelocidad();
	}


	public void recibirEfecto(Pantano pantano) {
	//	this.estadoActivo.recibirEfecto(pantano);	
	}

	public void recibirEfecto(Rocosa rocosa) {		
	//
	}
	
	
	public void recibirEfecto(Espinas espinas) {
	//	this.vida=(this.vida*95/100);
	}
	
	public void recibirEfecto(Nube nube) {
	}
	
	public void recibirEfecto(NebulosaDeAndromeda nebulosa) {
	//	this.estadoActivo.recibirEfecto(nebulosa);
	}
	
	public void recibirEfecto(TormentaPsionica tormenta){
	//	this.estadoActivo.recibirEfecto(tormenta);			
	}
	
	
	
}
