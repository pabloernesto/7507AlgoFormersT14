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
	protected List<Efecto> efectosAEliminar;

	public AlgoFormer (String nombre, int vida, FormaHumanoide formaHumanoide,FormaAlterna formaAlterna){
		this.nombre = nombre;
		this.vida = vida;
		estadoActivo = formaHumanoide;
		estadoInactivo = formaAlterna;
		reiniciarMovimientosRestantes();
		efectosActivos = new ArrayList<Efecto>();
		efectosAEliminar=new ArrayList<Efecto>();
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
	
	

	
	public void iniciarTurno(){
		reiniciarMovimientosRestantes();
		List<Efecto> aux = new ArrayList<Efecto>(efectosActivos);
		for (Efecto efecto: aux){
			efecto.afectar(this);
		}
	}
	
	public void borrarEfectos() {
		efectosActivos.removeAll(efectosAEliminar);
	}


	public void ubicarseEnSuperficie(Pantano pantano) {
		EfectoPantano efectoPantano = new EfectoPantano();
		efectoPantano.afectar(this);
	}

	public void ubicarseEnSuperficie(Rocosa rocosa) {		
	}
	
	
	public void ubicarseEnSuperficie(Espinas espinas) {
		EfectoEspinas efectoEspinas = new EfectoEspinas();
		efectoEspinas.afectar(this);
	}
	

	public void ubicarseEnSuperficie(Nube nube) {
	}
	
	public void ubicarseEnSuperficie(NebulosaDeAndromeda nebulosa) {
		EfectoNebulosa efectoNebulosa = new EfectoNebulosa();
		if (!afectadoPor(efectoNebulosa))
			this.efectosActivos.add(efectoNebulosa);
		efectoNebulosa.afectar(this);
	}
	
	public void ubicarseEnSuperficie(TormentaPsionica tormenta){
		EfectoTormenta efectoTormenta = new EfectoTormenta();
		if (!afectadoPor(efectoTormenta)){
			this.efectosActivos.add(efectoTormenta);
			efectoTormenta.afectar(this);
		}
	}

	public boolean afectadoPor(Efecto efecto) {
		return this.efectosActivos.contains(efecto);
	}
	
	public void afectarseCon(EfectoEspinas efecto){
		this.estadoActivo.afectarConEfectoEspinas(this);
	}

	public void afectarseCon(EfectoNebulosa efecto){
		(this.estadoActivo).afectarConEfectoNebulosa(this);
		if (efecto.getTurnos()==0)
			efectosActivos.remove(efecto);
	}
	
	public void afectarConEfectoNebulosa(){
		this.movimientosRestantes=0;
	}

	public void afectarseCon(EfectoPantano efectoPantano) {
		(this.estadoActivo).afectarConEfectoPantano(this);
	}

	public void afectarConEfectoPantanoFormaHumanoide() {
		this.movimientosRestantes=0;
	}

	public void afectarConEfectoPantanoFormaTerrestre() {
		this.movimientosRestantes--;
	}
	
	public void afectarseCon(EfectoTormenta efectoTormenta){
		this.estadoActivo.afectarConEfectoTormenta(this);
	}

	public void afectarConEfectoEspinas() {
		this.vida = this.vida*95/100;
	}

	
	public boolean atributosSonIguales(AlgoFormer otroAlgoformer){
		if (this.getAtaque() != otroAlgoformer.getAtaque())
			return false;
		if (this.getDistAtaque() != otroAlgoformer.getDistAtaque())
			return false;
		if (this.getNombre() != otroAlgoformer.getNombre())
			return false;
		if (this.getVelocidad() != otroAlgoformer.getVelocidad())
			return false;
		if (this.getVida() != otroAlgoformer.getVida())
			return false;
		return true;
	}
}