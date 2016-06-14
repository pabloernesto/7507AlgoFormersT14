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

	public void ubicarseEnSuperficie(Pantano pantano) {
		Efecto efecto = pantano.getEfecto();
		efecto.afectar(this);
	}

	public void ubicarseEnSuperficie(Rocosa rocosa) {		
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
		if (!afectadoPor(efecto)){
			efectosActivos.add(efecto);
			efecto.afectar(this);
		}
	}
	
	
	public boolean afectadoPor(Efecto efecto) {
		return efectosActivos.contains(efecto);
	}
	
	
	public void afectarseCon(EfectoEspinas efecto){
		estadoActivo.afectarConEfectoEspinas(this);
	}

	public void afectarseCon(EfectoNebulosa efecto){
		estadoActivo.afectarConEfectoNebulosa(this);
		if (efecto.getTurnos() == 0)
			efectosActivos.remove(efecto);
	}
	
	public void afectarseCon(EfectoPantano efecto) {
		estadoActivo.afectarConEfectoPantano(this);
	}
	
	public void afectarseCon(EfectoTormenta efecto){
		estadoActivo.afectarConEfectoTormenta(this);
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
