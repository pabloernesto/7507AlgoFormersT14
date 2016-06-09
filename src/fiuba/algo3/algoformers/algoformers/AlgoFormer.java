package fiuba.algo3.algoformers.algoformers;


import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.escenario.*;
import fiuba.algo3.algoformers.escenario.superficies.*;
import fiuba.algo3.algoformers.excepciones.*;

public abstract class AlgoFormer {


	protected String nombre;
	public int vida;
	protected int movimientosRestantes;
	protected List<Efecto> efectosActivos;
	
	protected Forma estadoActivo;
	protected Forma estadoInactivo;

	public AlgoFormer (String nombre, int vida, FormaHumanoide formaHumanoide,FormaAlterna formaAlterna){
		this.nombre = nombre;
		this.vida = vida;
		estadoActivo = formaHumanoide;
		estadoInactivo = formaAlterna;
		reiniciarMovimientosRestantes();
		efectosActivos = new ArrayList<Efecto>();
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

	public void atacar(AlgoFormer algoformerAtacado){
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
		if (!efectosActivos.contains(efecto)){
			efectosActivos.add(efecto);
			estadoActivo.recibirEfectos(this, efecto);
		}
	}
	
	public void iniciarTurno(){
		reiniciarMovimientosRestantes();
		List<Efecto> aux = new ArrayList<Efecto>(efectosActivos);
		for (Efecto efecto: aux){
			recibirEfectos(efecto);
		}
	}
	
	public void borrarEfecto(EfectoTemporal efecto) {
		efectosActivos.remove(efecto);
	}


	public void ubicarseEnSuperficie(Pantano pantano) {
		EfectoPantano efectoPantano = new EfectoPantano();
		this.recibirEfectos(efectoPantano);
	}

	public void ubicarseEnSuperficie(Rocosa rocosa) {		
	}
	
	
	public void ubicarseEnSuperficie(Espinas espinas) {
		EfectoEspinas efectoEspinas = new EfectoEspinas();
		this.recibirEfectos(efectoEspinas);
	}
	

	public void ubicarseEnSuperficie(Nube nube) {
	}
	
	public void ubicarseEnSuperficie(NebulosaDeAndromeda nebulosa) {
		EfectoNebulosa efectoNebulosa = new EfectoNebulosa();
		this.recibirEfectos(efectoNebulosa);
	}
	
	public void ubicarseEnSuperficie(TormentaPsionica tormenta){
		EfectoTormenta efectoTormenta = new EfectoTormenta();
		if (!afectadoPor(efectoTormenta)){
			this.efectosActivos.add(efectoTormenta);
			this.recibirEfectos(efectoTormenta);
		}
	}

	public boolean afectadoPor(EfectoTormenta efectoTormenta) {
		return this.efectosActivos.contains(efectoTormenta);
	}
	
}