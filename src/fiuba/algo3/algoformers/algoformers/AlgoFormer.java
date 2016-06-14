package fiuba.algo3.algoformers.algoformers;


import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.escenario.*;
import fiuba.algo3.algoformers.escenario.bonus.BurbujaInmaculada;
import fiuba.algo3.algoformers.escenario.bonus.DobleCanion;
import fiuba.algo3.algoformers.escenario.bonus.Flash;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;
import fiuba.algo3.algoformers.escenario.efectos.EfectoBurbuja;
import fiuba.algo3.algoformers.escenario.efectos.EfectoDobleCanion;
import fiuba.algo3.algoformers.escenario.efectos.EfectoEspinas;
import fiuba.algo3.algoformers.escenario.efectos.EfectoFlash;
import fiuba.algo3.algoformers.escenario.efectos.EfectoNebulosa;
import fiuba.algo3.algoformers.escenario.efectos.EfectoPantano;
import fiuba.algo3.algoformers.escenario.efectos.EfectoTormenta;
import fiuba.algo3.algoformers.escenario.superficies.*;
import fiuba.algo3.algoformers.excepciones.*;

public abstract class AlgoFormer {


	protected String nombre;
	public int vida;
	protected int movimientosRestantes;
	protected List<Efecto> efectosActivos;
	protected List<Efecto> efectosABorrar;
	protected Forma estadoActivo;
	protected Forma estadoInactivo;

	public AlgoFormer (String nombre, int vida, FormaHumanoide formaHumanoide,FormaAlterna formaAlterna){
		this.nombre = nombre;
		this.vida = vida;
		estadoActivo = formaHumanoide;
		estadoInactivo = formaAlterna;
		reiniciarMovimientosRestantes();
		efectosActivos = new ArrayList<Efecto>();
		efectosABorrar = new ArrayList<Efecto>();
	}

	public abstract void recibirDanio (AutoBot autobot, int ataque);
	
	public abstract void recibirDanio (Decepticon decepticon, int ataque);
	
	/* Este metodo se define como abstracto y se implementa por duplicado
	   en Autobot y Decepticon. Esto permite que el AlgoFormer llame al
	   recibirDanio correcto del AlgoFormer atacado.
	   
	   Si esto no se hiciese así, el AlgoFormer intentaría llamar a
	   recibirDanio con un argumento de tipo AlgoFormer, en lugar de Autobot
	   o Decepticon. */
	public abstract void enviarRecibirDanio(AlgoFormer algoformerAtacado);
	
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

		enviarRecibirDanio(algoformerAtacado);
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
	
	public void finalizarTurno(){
		List<Efecto> aux = new ArrayList<Efecto>(efectosActivos);
		for (Efecto efecto: aux){
			efecto.desafectar(this);
		}
		borrarEfectos();
	}
	
	public boolean afectadoPor(Efecto efecto) {
		return efectosActivos.contains(efecto);
	}
	
	public void borrarEfectos() {
		efectosActivos.removeAll(efectosABorrar);
	}
	
	public void ubicarseEnSuperficie(Rocosa rocosa) {		
	}

	public void ubicarseEnSuperficie(Pantano pantano) {
		Efecto efecto = pantano.getEfecto();
		efecto.afectar(this);
	}
	
	public void ubicarseEnSuperficie(Espinas espinas) {
		Efecto efecto = espinas.getEfecto();
		efecto.afectar(this);
	}
	
	public void ubicarseEnSuperficie(Nube nube) {
	}
	
	public void ubicarseEnSuperficie(NebulosaDeAndromeda nebulosa) {
		Efecto efecto = nebulosa.getEfecto();
		if (!afectadoPor(efecto))
			efectosActivos.add(efecto);
		efecto.afectar(this);
	}
	
	public void ubicarseEnSuperficie(TormentaPsionica tormenta){
		Efecto efecto = tormenta.getEfecto();
		recibirEfectoPorTurnos(efecto);
	}
	
	public void recibirBonus(DobleCanion dobleCanion) {
		Efecto efecto = dobleCanion.getEfecto();
		recibirEfectoPorTurnos(efecto);
	}
	
	public void recibirBonus(Flash flash) {
		Efecto efecto = flash.getEfecto();
		recibirEfectoPorTurnos(efecto);
	}
	
	public void recibirBonus(BurbujaInmaculada burbuja) {
		Efecto efecto = burbuja.getEfecto();
		recibirEfectoPorTurnos(efecto);
	}
	
	private void recibirEfectoPorTurnos(Efecto efecto){
		if (!afectadoPor(efecto)){
			efectosActivos.add(efecto);
			efecto.afectar(this);
		}
	}
	
	
	public void afectarseCon(EfectoEspinas efecto){
		estadoActivo.afectarConEfectoEspinas(this);
	}
	
	public void afectarseCon(EfectoPantano efecto) {
		estadoActivo.afectarConEfectoPantano(this);
	}
	
	public void afectarseCon(EfectoTormenta efecto){
		estadoActivo.afectarConEfectoTormenta(this);
	}
	
	public void afectarseCon(EfectoNebulosa efecto){
		estadoActivo.afectarConEfectoNebulosa(this);
		if (efecto.getTurnos() == 0)
			efectosABorrar.add(efecto);
	}
	
	public void afectarseCon(EfectoDobleCanion efecto) {
		estadoActivo.afectarConEfectoDobleCanion(this);
		if (efecto.getTurnos() == 0)
			efectosABorrar.add(efecto);
	}
	
	public void afectarseCon(EfectoFlash efecto) {
		estadoActivo.afectarConEfectoFlash(this);
		if (efecto.getTurnos() == 0)
			efectosABorrar.add(efecto);
	}

	public void afectarseCon(EfectoBurbuja efecto) {
		estadoActivo.afectarConEfectoBurbuja(this);
		if (efecto.getTurnos() == 0)
			efectosABorrar.add(efecto);
			
	}
	
	public void desafectarseDe(EfectoDobleCanion efecto){
		estadoActivo.desafectarseDeEfectoDobleCanion(this);
	}
	
	public void desafectarseDe(EfectoFlash efecto){
		estadoActivo.desafectarseDeEfectoFlash(this);
	}
	
	
	
	public void afectarConEfectoNebulosa(){
		movimientosRestantes = 0;
	}
	
	public void afectarConEfectoPantanoFormaHumanoide() {
		movimientosRestantes = 0;
	}

	public void afectarConEfectoPantanoFormaTerrestre() {
		movimientosRestantes--;
	}

	public void afectarConEfectoEspinas() {
		vida = vida * 95 / 100;
	}
	
	
	//Metodos para pruebas
	
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
