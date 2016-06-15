package fiuba.algo3.algoformers.test.primeraEntrega;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.excepciones.FuegoAmigoException;
import fiuba.algo3.algoformers.excepciones.FueraDeAlcanceException;
import fiuba.algo3.algoformers.factories.*;

public class Test05Atacar {
	
private Tablero tablero;
	
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer optimus;
	private AlgoFormer ratchet;
	private AlgoFormer megatron;
	private AlgoFormer frenzy;
	
	@Before
	public void setUp(){
		Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
		Tablero.setGeneradorDeBonus(new BonusNuloFactory());
		tablero = Tablero.getInstance();
	}
	
	@After
	public void tearDown(){
		Tablero.reiniciarTablero();
	}
	
	@Test
	public void test01AutoBotPuedeAtacarDecepticonEstandoEnRango(){
		Posicion posicion = new Posicion(5,5);
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		tablero.colocarAlgoformer(optimus, posicion);
		posicion = new Posicion(5,6);
		tablero.colocarAlgoformer(megatron, posicion);
		
		int vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(megatron.getVida(), vidaAnterior - optimus.getAtaque());
	}
	
	@Test(expected=FueraDeAlcanceException.class)
	public void test02AutoBotNoPuedeAtacarDecepticonEstandoFueraDeRango(){
		Posicion posicion = new Posicion(5,5);
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		tablero.colocarAlgoformer(optimus, posicion);
		posicion = new Posicion(15,15);
		tablero.colocarAlgoformer(megatron, posicion);
		
		int vidaAnterior = megatron.getVida();
		try{
			optimus.atacar(megatron);
		} catch (FueraDeAlcanceException e){
			assertEquals(megatron.getVida(), vidaAnterior);
			throw e;
		}
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void test03AutoBotNoPuedeAtacarOtroAutobotEstandoEnRango(){
		Posicion posicion = new Posicion(5,5);
		optimus = autobotFactory.crearOptimusPrime();
		ratchet = autobotFactory.crearRatchet();
		tablero.colocarAlgoformer(optimus, posicion);
		posicion = new Posicion(5,6);
		tablero.colocarAlgoformer(ratchet, posicion);
		
		int vidaAnterior = ratchet.getVida();
		try{
			optimus.atacar(ratchet);
		} catch (FuegoAmigoException e){
			assertEquals(ratchet.getVida(), vidaAnterior);
			throw e;
		}
	}
	
	@Test(expected=FueraDeAlcanceException.class)
	public void test04AutoBotNoPuedeAtacarOtroAutobotEstandoFueraDeRango(){
		Posicion posicion = new Posicion(5,5);
		optimus = autobotFactory.crearOptimusPrime();
		ratchet = autobotFactory.crearRatchet();
		tablero.colocarAlgoformer(optimus, posicion);
		posicion = new Posicion(15,15);
		tablero.colocarAlgoformer(ratchet, posicion);
		
		int vidaAnterior = ratchet.getVida();
		try{
			optimus.atacar(ratchet);
		} catch (FueraDeAlcanceException e){
			assertEquals(ratchet.getVida(), vidaAnterior);
			throw e;
		}
	}
	
	//Ahora atacan los decepticon
	
	@Test
	public void test05DecepticonPuedeAtacarAutoBotEstandoEnRango(){
		Posicion posicion = new Posicion(5,5);
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		tablero.colocarAlgoformer(optimus, posicion);
		posicion = new Posicion(5,6);
		tablero.colocarAlgoformer(megatron, posicion);
		
		int vidaAnterior = optimus.getVida();
		megatron.atacar(optimus);
		assertEquals(optimus.getVida(), vidaAnterior - megatron.getAtaque());
	}
	
	@Test(expected=FueraDeAlcanceException.class)
	public void test06DecepticonNoPuedeAtacarAutoBotEstandoEnRango(){
		Posicion posicion = new Posicion(5,5);
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		tablero.colocarAlgoformer(optimus, posicion);
		posicion = new Posicion(15,15);
		tablero.colocarAlgoformer(megatron, posicion);
		
		int vidaAnterior = optimus.getVida();
		try{
			megatron.atacar(optimus);
		} catch (FueraDeAlcanceException e){
			assertEquals(optimus.getVida(), vidaAnterior);
			throw e;
		}
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void test07DecepticonNoPuedeAtacarOtroDecepticonEstandoEnRango(){
		Posicion posicion = new Posicion(5,5);
		megatron = decepticonFactory.crearMegatron();
		frenzy = decepticonFactory.crearFrenzy();
		tablero.colocarAlgoformer(megatron, posicion);
		posicion = new Posicion(5,6);
		tablero.colocarAlgoformer(frenzy, posicion);
		
		int vidaAnterior = frenzy.getVida();
		try{
			megatron.atacar(frenzy);
		} catch (FuegoAmigoException e){
			assertEquals(frenzy.getVida(), vidaAnterior);
			throw e;
		}
	}
	
	@Test(expected=FueraDeAlcanceException.class)
	public void test08DecepticonNoPuedeAtacarOtroDecepticonEstandoFueraDeRango(){
		Posicion posicion = new Posicion(5,5);
		megatron = decepticonFactory.crearMegatron();
		frenzy = decepticonFactory.crearFrenzy();
		tablero.colocarAlgoformer(megatron, posicion);
		posicion = new Posicion(15,15);
		tablero.colocarAlgoformer(frenzy, posicion);
		
		int vidaAnterior = frenzy.getVida();
		try{
			megatron.atacar(frenzy);
		} catch (FueraDeAlcanceException e){
			assertEquals(frenzy.getVida(), vidaAnterior);
			throw e;
		}
	}

}
