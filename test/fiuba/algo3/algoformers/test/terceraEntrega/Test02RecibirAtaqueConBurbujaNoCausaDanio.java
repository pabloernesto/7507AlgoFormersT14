package fiuba.algo3.algoformers.test.terceraEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.bonus.BurbujaInmaculada;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;

public class Test02RecibirAtaqueConBurbujaNoCausaDanio {

	Tablero tablero;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer optimus;
	private AlgoFormer megatron;
	
	@Before
	public void setUp(){
		Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
		tablero = Tablero.getInstance();
	}
	
	@After
	public void tearDown(){
		Tablero.reiniciarTablero();
	}
	
	@Test
	public void test01RecibirAtaqueConBurbujaEnHumanoideNoCausaDanioPorDosTurnos(){
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		int vidaAnterior = optimus.getVida();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new BurbujaInmaculada());
		optimus.moverse(Movimiento.ABAJO);
		
		optimus.finalizarTurno(); //Primer turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior, optimus.getVida());
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior, optimus.getVida());
		
		optimus.finalizarTurno(); //Tercer turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior - megatron.getAtaque(), optimus.getVida()); //Al tercer turno ya no hace efecto
	}
	
	@Test
	public void test02AgarrarDosBurbujasEnHumanoideSoloHaceEfectoLaPrimeraVez(){
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		int vidaAnterior = optimus.getVida();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new BurbujaInmaculada());
		tablero.setBonusEnCelda(new Posicion(2, 1), new BurbujaInmaculada());
		optimus.moverse(Movimiento.ABAJO);
		
		optimus.finalizarTurno(); //Primer turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior, optimus.getVida());
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ARRIBA_DERECHA); //Agarra otra burbuja, pero no hace efecto
		megatron.atacar(optimus);
		assertEquals(vidaAnterior, optimus.getVida());
		
		optimus.finalizarTurno(); //Tercer turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior - megatron.getAtaque(), optimus.getVida()); //Al tercer turno ya no hace efecto
	}
	
	@Test
	public void test03RecibirAtaqueConBurbujaEnAlternoNoCausaDanioPorDosTurnos(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		megatron = decepticonFactory.crearMegatron();
		int vidaAnterior = optimus.getVida();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new BurbujaInmaculada());
		optimus.moverse(Movimiento.ABAJO);
		
		optimus.finalizarTurno(); //Primer turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior, optimus.getVida());
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior, optimus.getVida());
		
		optimus.finalizarTurno(); //Tercer turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior - megatron.getAtaque(), optimus.getVida()); //Al tercer turno ya no hace efecto
	}
	
	@Test
	public void test04AgarrarDosBurbujasEnAlternoSoloHaceEfectoLaPrimeraVez(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		megatron = decepticonFactory.crearMegatron();
		int vidaAnterior = optimus.getVida();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new BurbujaInmaculada());
		tablero.setBonusEnCelda(new Posicion(2, 1), new BurbujaInmaculada());
		optimus.moverse(Movimiento.ABAJO);
		
		optimus.finalizarTurno(); //Primer turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior, optimus.getVida());
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ARRIBA_DERECHA); //Agarra otra burbuja, pero no hace efecto
		megatron.atacar(optimus);
		assertEquals(vidaAnterior, optimus.getVida());
		
		optimus.finalizarTurno(); //Tercer turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior - megatron.getAtaque(), optimus.getVida()); //Al tercer turno ya no hace efecto
	}
}
