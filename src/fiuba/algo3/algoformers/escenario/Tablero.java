package fiuba.algo3.algoformers.escenario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.bonus.Bonus;
import fiuba.algo3.algoformers.excepciones.CeldaOcupadaException;
import fiuba.algo3.algoformers.excepciones.PosicionInvalidaException;
import fiuba.algo3.algoformers.factories.BonusFactory;
import fiuba.algo3.algoformers.factories.BonusRandomFactory;
import fiuba.algo3.algoformers.factories.CeldaFactory;
import fiuba.algo3.algoformers.factories.CeldaRandomFactory;

public class Tablero {

	private ArrayList<Posicion> posicionesCeldasOcupadas;
	private HashMap <Posicion,Celda> celdas;
	private final int ANCHO = 40;
	private final int ALTO = 20;
	private static Tablero instanciaTablero = null;
	
	private static CeldaFactory generadorCeldas = new CeldaRandomFactory();
	private static BonusFactory generadorBonus = new BonusRandomFactory();
	
	public static void setGeneradorDeCeldas(CeldaFactory generador){
	    generadorCeldas = generador;
	}
	
	public static void setGeneradorDeBonus(BonusFactory generador){
	    generadorBonus = generador;
	}
	
	
	private Tablero (){
	    posicionesCeldasOcupadas = new ArrayList<Posicion>();
		celdas = new HashMap <Posicion,Celda>();
		for (int i=1 ; i<=ANCHO ; i++){
			for (int j=1 ; j<=ALTO ; j++)
				celdas.put(new Posicion(i,j), generadorCeldas.getCelda());
		}
		colocarBonus();
	}

	private void colocarBonus(){
		Random generador = new Random();
		int cantidadBonus = ANCHO * ALTO / 100 * 20; //El 20% de las celdas tienen bonus
		for (int i = 0 ; i < cantidadBonus ; i++){
			Bonus bonus = generadorBonus.getBonus();
			int x = generador.nextInt(ANCHO);
			int y = generador.nextInt(ALTO);
			setBonusEnCelda(new Posicion(x + 1, y + 1), bonus); //Se le suma 1 porque el numero puede ser 0
																// y las posiciones empiezan en el (1,1)
		}
	}
	
	public static Tablero getInstance (){
		if (instanciaTablero == null)
			instanciaTablero = new Tablero();
		return instanciaTablero;
	}
	
		
	
	public static void reiniciarTablero (){
		instanciaTablero = null;
	}
	
	public void colocarAlgoformer (AlgoFormer algoformer, Posicion posicion){
		validarMovimiento(posicion);
		celdas.get(posicion).recibirAlgoformer(algoformer);
		posicionesCeldasOcupadas.add(posicion);
	}
	
	public void borrarAlgoformer(AlgoFormer algoformer){
		Posicion posicion = getPosicionAlgoformer(algoformer);
		if (posicion == null)
			return;
		celdas.get(posicion).desocuparCelda();
		posicionesCeldasOcupadas.remove(posicion);
	}
	
	public void moverAlgoformer (AlgoFormer algoformer, Movimiento direccion)
	{
        // Validar posicion final
        Posicion posicionInicial = getPosicionAlgoformer(algoformer);
        Posicion posicionFinal = posicionInicial.sumarMovimiento(direccion);
        validarMovimiento(posicionFinal);

        // Entrar a celda
        algoformer.entrarACelda(celdas.get(posicionFinal));

        // Desocupar celda anterior
        Collections.replaceAll(posicionesCeldasOcupadas, posicionInicial,
            posicionFinal);
        this.celdas.get(posicionInicial).desocuparCelda();
	}
	
	public Posicion getPosicionAlgoformer (AlgoFormer algoformer){
		Posicion posicionAlgoformer = null;
		for (Posicion posicion: posicionesCeldasOcupadas){
			if (celdas.get(posicion).getAlgoformer().equals(algoformer))
				posicionAlgoformer=posicion;
			}
		return posicionAlgoformer;
	}
	
	public void colocarChispaSuprema(Posicion posicion){
		celdas.get(posicion).colocarChispaSuprema();
	}
	
	public boolean posicionEstaOcupada(Posicion posicion){
		return celdas.get(posicion).estaOcupada();
	}

	public boolean posicionContieneChispaSuprema(Posicion posicion){
		return celdas.get(posicion).contieneChispaSuprema();
	}
	
    public int distancia(AlgoFormer a, AlgoFormer b)
    {
        Posicion posA = getPosicionAlgoformer(a);
        Posicion posB = getPosicionAlgoformer(b);
        
        return posA.calcularDistanciaCon(posB);
    }
	
	public int ancho(){
		return ANCHO;
	}
	
	public int altura(){
		return ALTO;
	}
	
	public void setBonusEnCelda(Posicion posicion, Bonus bonus){
		celdas.get(posicion).setBonus(bonus);
	}
	
	private void validarMovimiento (Posicion posicion){
		if (celdas.get(posicion) == null)
			throw new PosicionInvalidaException();
		if (posicionesCeldasOcupadas.contains(posicion))
			throw new CeldaOcupadaException();
	}
	
    public List<Posicion> movimientosValidos(AlgoFormer algoformer)
    {
        return movimientosValidos(getPosicionAlgoformer(algoformer));
    }

    public List<Posicion> movimientosValidos(Posicion posicion)
    {
        List<Posicion> posicionesLibres = new ArrayList<Posicion>();

        for (Movimiento movimiento : Movimiento.values()){
            Posicion nuevaPosicion = posicion.sumarMovimiento(movimiento);
            try{
                validarMovimiento(nuevaPosicion);
                posicionesLibres.add(nuevaPosicion);
            } catch (PosicionInvalidaException | CeldaOcupadaException e){
                continue;
            }
        }
        return posicionesLibres;
    }

	//Metodos para pruebas//
	
	public Posicion getMedio(){
		return new Posicion(ANCHO/2, ALTO/2);
	}
	
  	public Celda devolverPrimerCelda() {
  		return celdas.get(new Posicion(1, 1));
  	}

    public Celda getCelda(int x, int y)
    {
        return celdas.get(new Posicion(x,y));
    }
}

