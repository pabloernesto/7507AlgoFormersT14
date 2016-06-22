package fiuba.algo3.algoformers.algoformers;


import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.escenario.*;
import fiuba.algo3.algoformers.escenario.bonus.BurbujaInmaculada;
import fiuba.algo3.algoformers.escenario.bonus.ChispaSuprema;
import fiuba.algo3.algoformers.escenario.bonus.DobleCanion;
import fiuba.algo3.algoformers.escenario.bonus.Flash;
import fiuba.algo3.algoformers.escenario.efectos.ContenedorDeEfecto;
import fiuba.algo3.algoformers.escenario.efectos.Efecto;
import fiuba.algo3.algoformers.escenario.efectos.EfectoBurbuja;
import fiuba.algo3.algoformers.escenario.efectos.EfectoChispa;
import fiuba.algo3.algoformers.escenario.efectos.EfectoConTurno;
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
	protected Forma estado;
	protected int movimientosRestantes;
	protected List<Efecto> efectosActivos;
	protected List<Efecto> efectosABorrar;
	
	public AlgoFormer (String nombre, int vida, Forma estado){
		this.nombre = nombre;
		this.vida = vida;
		this.estado = estado;
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
	
	public abstract List<AlgoFormer> devolverIntegrantes();
	
	public void transformarse (){
		estado = estado.transformarse();
		reiniciarMovimientosRestantes();
		efectosActivos.clear();
		efectosABorrar.clear();
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
	               .distancia(this, algoformerAtacado);

		int alcance = getDistAtaque();

		if (distancia > alcance)
			throw new FueraDeAlcanceException();

		enviarRecibirDanio(algoformerAtacado);
	}
	
	public void reiniciarMovimientosRestantes (){
		movimientosRestantes = getVelocidad();
	}
	
	public boolean estaVivo() {
		return vida > 0;
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
	
	public void borrarTodosLosEfectos(){
		efectosActivos = new ArrayList<Efecto>();
		efectosABorrar = new ArrayList<Efecto>();
	}
	
	
	public void ubicarseEnSuperficie(Rocosa superficie) {		
	}
	
	public void ubicarseEnSuperficie(Nube superficie) {
	}

	public void ubicarseEnSuperficie(Pantano superficie) {
		recibirEfectoInstantaneo(superficie);
	}
	
	public void ubicarseEnSuperficie(Espinas superficie) {
		recibirEfectoInstantaneo(superficie);
	}
	
	public void ubicarseEnSuperficie(NebulosaDeAndromeda superficie) {
		Efecto efecto = superficie.getEfecto();
		if (!afectadoPor(efecto))
			efectosActivos.add(efecto);
		efecto.afectar(this);
	}
	
	public void ubicarseEnSuperficie(TormentaPsionica superficie){
		recibirEfectoPorTurnos(superficie);
	}
	
	public void recibirBonus(DobleCanion bonus) {
		recibirEfectoPorTurnos(bonus);
	}
	
	public void recibirBonus(Flash bonus) {
		Efecto efecto = bonus.getEfecto();
		if (!afectadoPor(efecto)){
			efectosActivos.add(efecto);
		}
	}
	
	public void recibirBonus(BurbujaInmaculada bonus) {
		recibirEfectoPorTurnos(bonus);
	}
	
	public void recibirBonus(ChispaSuprema bonus){
		recibirEfectoPorTurnos(bonus);
	}
	
	private void recibirEfectoPorTurnos(ContenedorDeEfecto contenedor){
		Efecto efecto = contenedor.getEfecto();
		if (!afectadoPor(efecto)){
			efectosActivos.add(efecto);
			efecto.afectar(this);
		}
	}
	
	private void recibirEfectoInstantaneo(ContenedorDeEfecto contenedor){
		Efecto efecto = contenedor.getEfecto();
		efecto.afectar(this);
	}
	
	
	public void afectarseCon(EfectoEspinas efecto){
		estado.afectarCon(this, efecto);
	}
	
	public void afectarseCon(EfectoPantano efecto) {
		estado.afectarCon(this, efecto);
	}
	
	public void afectarseCon(EfectoTormenta efecto){
		estado.afectarCon(this, efecto);
	}
	
	public void afectarseCon(EfectoNebulosa efecto){
		estado.afectarCon(this, efecto);
		chequearEfectoAgotado(efecto);
	}
	
	public void afectarseCon(EfectoDobleCanion efecto) {
		estado.afectarCon(this, efecto);
		chequearEfectoAgotado(efecto);
	}
	
	public void afectarseCon(EfectoFlash efecto) {
		estado.afectarCon(this, efecto);
		chequearEfectoAgotado(efecto);
	}

	public void afectarseCon(EfectoBurbuja efecto) {
		estado.afectarCon(this, efecto);
		chequearEfectoAgotado(efecto);
	}
	
	public void afectarseCon(EfectoChispa efecto){
		estado.afectarCon(this, efecto);
	}
	
	private void chequearEfectoAgotado(EfectoConTurno efecto){
		if (efecto.getTurnos() == 0)
			efectosABorrar.add(efecto);
	}
	
	
	public void desafectarseDe(EfectoDobleCanion efecto){
		estado.desafectarseDe(this, efecto);
	}
	
	public void desafectarseDe(EfectoFlash efecto){
		movimientosRestantes = movimientosRestantes / 3;
	}
	
	
	
	public void afectarConEfectoNebulosa(){
		movimientosRestantes = 0;
	}
	
	public void afectarConEfectoPantanoFormaHumanoide(EfectoPantano efecto) {
		if (!afectadoPor(efecto)){
			efectosActivos.add(efecto);
		}
		movimientosRestantes = 0;
	}

	public void afectarConEfectoPantanoFormaTerrestre() {
		movimientosRestantes--;
	}

	public void afectarConEfectoEspinas() {
		vida = vida * 95 / 100;
	}
	
	public void afectarseConEfectoFlash() {
		movimientosRestantes = movimientosRestantes * 3;
	}
	
	
	//Metodos para pruebas
	
	public Forma getEstadoActivo (){
		return estado;
	}
	
	public int getAtaque (){
		return estado.getAtaque();
	}
	
	public int getDistAtaque (){
		return estado.getDistAtaque();
	}
	
	public int getVelocidad (){
		return estado.getVelocidad();
	}
	
	public int getVida (){
		return vida;
	}
	
	public void setVida(int vida){
		this.vida = vida;
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

    public String nombreEstadoActivo()
    {
        return getEstadoActivo().nombre();
    }
}

