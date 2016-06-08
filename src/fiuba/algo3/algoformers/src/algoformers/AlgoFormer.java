package fiuba.algo3.algoformers.algoformers;


import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.escenario.*;
import fiuba.algo3.algoformers.escenario.superficies.Efecto;
import fiuba.algo3.algoformers.escenario.superficies.EfectoTemporal;
import fiuba.algo3.algoformers.excepciones.FueraDeAlcanceException;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;

public abstract class AlgoFormer {

	protected String nombre;
	protected int vida;
	protected int movimientosRestantes;
	protected List<EfectoTemporal> efectosActivos;
	
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
		efectosActivos = new ArrayList<EfectoTemporal>();
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
		if (movimientosRestantes < 1)
			throw new NoHayMasMovimientosException();
		movimientosRestantes -= 1;
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
		movimientosRestantes = getVelocidad();
	}
	
	public void setVida(int nuevaVida){
		vida = nuevaVida;
	}
	
	public void setAtaque(int nuevoAtaque){
		estadoActivo.setAtaque(nuevoAtaque);
	}
	
	public void restarMovimientosRestantes(int movimientosRestantes) {
		this.movimientosRestantes -= movimientosRestantes;
	}

	public void recibirEfectos(Efecto efecto) {
		estadoActivo.recibirEfectos(this, efecto);
	}
	
	public void recibirEfectos(EfectoTemporal efecto) {
		agregarEfecto(efecto);
		estadoActivo.recibirEfectos(this, efecto);
	}
	
	public void agregarEfecto(EfectoTemporal efecto) {
		if (!efectosActivos.contains(efecto))
			efectosActivos.add(efecto);
	}
	
	public void iniciarTurno(){
		reiniciarMovimientosRestantes();
		List<EfectoTemporal> aux = copiarEfectosActivos();
		for (EfectoTemporal efecto: aux){
			recibirEfectos(efecto);
		}
	}
	
	private List<EfectoTemporal> copiarEfectosActivos(){
		List<EfectoTemporal> aux = new ArrayList<EfectoTemporal>();
		for (EfectoTemporal efecto: efectosActivos)
			aux.add(efecto);
		return aux;
	}
	
	public void borrarEfecto(EfectoTemporal efecto) {
		efectosActivos.remove(efecto);
	}
}
