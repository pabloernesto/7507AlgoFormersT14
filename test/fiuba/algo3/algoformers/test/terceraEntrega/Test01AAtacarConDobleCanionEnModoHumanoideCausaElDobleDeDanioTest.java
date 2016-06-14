package fiuba.algo3.algoformers.test.terceraEntrega;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.bonus.DobleCanion;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;

public class Test01AAtacarConDobleCanionEnModoHumanoideCausaElDobleDeDanioTest {

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
	public void test01AtacarConDobleCanionCausaDobleDeDanioPorTresTurnos(){
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		int ataqueAnterior = optimus.getAtaque();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new DobleCanion());
		optimus.moverse(Movimiento.ABAJO);
		
		optimus.finalizarTurno(); //Primer turno
		optimus.iniciarTurno();
		int vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnterior - ataqueAnterior * 2, megatron.getVida());
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnterior - ataqueAnterior * 2, megatron.getVida());
		
		optimus.finalizarTurno(); //Tercer turno
		optimus.iniciarTurno();
		vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnterior - ataqueAnterior * 2, megatron.getVida());
		
		optimus.finalizarTurno(); //Al cuarto turno ya le saca el ataque normal
		optimus.iniciarTurno();
		vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnterior - ataqueAnterior, megatron.getVida());
	}
	
	@Test
	public void test02AtacarConDobleCanionCausaDobleDeDanioPorTresTurnos(){
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		int ataqueAnterior = optimus.getAtaque();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new DobleCanion());
		tablero.setBonusEnCelda(new Posicion(2, 1), new DobleCanion());
		optimus.moverse(Movimiento.ABAJO);
		
		optimus.finalizarTurno(); //Primer turno
		optimus.iniciarTurno();
		int vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnterior - ataqueAnterior * 2, megatron.getVida());
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ARRIBA_DERECHA); //Agarra otro dobleCanion, pero no le hace efecto
		
		optimus.finalizarTurno(); //Tercer turno
		optimus.iniciarTurno();
		vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnterior - ataqueAnterior * 2, megatron.getVida());
		
		optimus.finalizarTurno(); //Al cuarto turno ya le saca el ataque normal
		optimus.iniciarTurno();
		vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnterior - ataqueAnterior, megatron.getVida());
	}
}
