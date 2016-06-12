package fiuba.algo3.algoformers.test.primeraEntrega;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.*;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;

public class Test03MoverAlterno {
	
	private Tablero tablero;
	
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer optimus;
	private AlgoFormer ratchet;
	private AlgoFormer bumblebee;

	private AlgoFormer megatron;
	private AlgoFormer bonecrusher;
	private AlgoFormer frenzy;
	
	@Before
	public void setUp(){
		Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
		tablero = Tablero.getInstance();
	}
	
	@After
	public void tearDown(){
		Tablero.reiniciarTablero();
	}

	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test01ColocarOptimusHumanoideMoverYVerificarPosicion(){
		Posicion posicion = new Posicion(5,5);
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		tablero.colocarAlgoformer(optimus, posicion);
		for (int i = 0 ; i < optimus.getVelocidad() ; i++){
			optimus.moverse(Movimiento.ABAJO);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
			assertTrue(tablero.getPosicionAlgoformer(optimus).equals(posicion));
		}
		try {
			optimus.moverse(Movimiento.ABAJO);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test02ColocarBumblebeeHumanoideMoverYVerificarPosicion(){
		Posicion posicion = new Posicion(5,5);
		bumblebee = autobotFactory.crearBumblebee();
		bumblebee.transformarse();
		tablero.colocarAlgoformer(bumblebee, posicion);
		for (int i = 0 ; i < bumblebee.getVelocidad() ; i++){
			bumblebee.moverse(Movimiento.ABAJO);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
			assertTrue(tablero.getPosicionAlgoformer(bumblebee).equals(posicion));
		}
		try {
			bumblebee.moverse(Movimiento.ABAJO);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test03ColocarRatchetHumanoideMoverYVerificarPosicion(){
		Posicion posicion = new Posicion(5,5);
		ratchet = autobotFactory.crearRatchet();
		ratchet.transformarse();
		tablero.colocarAlgoformer(ratchet, posicion);
		for (int i = 0 ; i < ratchet.getVelocidad() ; i++){
			ratchet.moverse(Movimiento.ABAJO);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
			assertTrue(tablero.getPosicionAlgoformer(ratchet).equals(posicion));
		}
		try {
			ratchet.moverse(Movimiento.ABAJO);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test04ColocarMegatronHumanoideMoverYVerificarPosicion(){
		Posicion posicion = new Posicion(5,5);
		megatron = decepticonFactory.crearMegatron();
		megatron.transformarse();
		tablero.colocarAlgoformer(megatron, posicion);
		for (int i = 0 ; i < megatron.getVelocidad() ; i++){
			megatron.moverse(Movimiento.ABAJO);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
			assertTrue(tablero.getPosicionAlgoformer(megatron).equals(posicion));
		}
		try {
			megatron.moverse(Movimiento.ABAJO);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test05ColocarBonecrusherHumanoideMoverYVerificarPosicion(){
		Posicion posicion = new Posicion(5,5);
		bonecrusher = decepticonFactory.crearBonecrusher();
		bonecrusher.transformarse();
		tablero.colocarAlgoformer(bonecrusher, posicion);
		for (int i = 0 ; i < bonecrusher.getVelocidad() ; i++){
			bonecrusher.moverse(Movimiento.ABAJO);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
			assertTrue(tablero.getPosicionAlgoformer(bonecrusher).equals(posicion));
		}
		try {
			bonecrusher.moverse(Movimiento.ABAJO);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test06ColocarFrenzyHumanoideMoverYVerificarPosicion(){
		Posicion posicion = new Posicion(5,5);
		frenzy = decepticonFactory.crearFrenzy();
		frenzy.transformarse();
		tablero.colocarAlgoformer(frenzy, posicion);
		for (int i = 0 ; i < frenzy.getVelocidad() ; i++){
			frenzy.moverse(Movimiento.ABAJO);
			posicion = posicion.sumarMovimiento(Movimiento.ABAJO);
			assertTrue(tablero.getPosicionAlgoformer(frenzy).equals(posicion));
		}
		try {
			frenzy.moverse(Movimiento.ABAJO);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}

}
