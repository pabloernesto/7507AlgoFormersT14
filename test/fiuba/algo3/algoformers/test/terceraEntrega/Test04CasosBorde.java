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
import fiuba.algo3.algoformers.escenario.bonus.DobleCanion;
import fiuba.algo3.algoformers.escenario.bonus.Flash;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;

public class Test04CasosBorde {

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
	public void test01AlgoformerHumanoideAgarraDobleCanionYFlashYTieneAmbosEfectos(){
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		int ataqueAnterior = optimus.getAtaque();
		int velocidadAnterior = optimus.getVelocidad();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new DobleCanion());
		tablero.setBonusEnCelda(new Posicion(2, 1), new Flash());
		optimus.moverse(Movimiento.ABAJO); //Agarra el canion
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ARRIBA_DERECHA); //Agarra el flash
		
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		int vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnterior - ataqueAnterior * 2, megatron.getVida()); //Prueba de canion
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		int velocidadActual;
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual); //Prueba de flash
	}
	
	@Test
	public void test02AlgoformerAlternoAgarraDobleCanionYFlashYTieneAmbosEfectos(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		megatron = decepticonFactory.crearMegatron();
		int ataqueAnterior = optimus.getAtaque();
		int velocidadAnterior = optimus.getVelocidad();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new DobleCanion());
		tablero.setBonusEnCelda(new Posicion(2, 1), new Flash());
		optimus.moverse(Movimiento.ABAJO); //Agarra el canion
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ARRIBA_DERECHA); //Agarra el flash
		
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		int vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnterior - ataqueAnterior * 2, megatron.getVida()); //Prueba de canion
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		int velocidadActual;
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual); //Prueba de flash
	}
	
	@Test
	public void test03AlgoformerHumanoideAgarraDobleCanionYBurbujaYTieneAmbosEfectos(){
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		int ataqueAnteriorOptimus = optimus.getAtaque();
		int vidaAnteriorOptimus = optimus.getVida();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new DobleCanion());
		tablero.setBonusEnCelda(new Posicion(2, 1), new BurbujaInmaculada());
		optimus.moverse(Movimiento.ABAJO); //Agarra el canion
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ARRIBA_DERECHA); //Agarra la burbuja
		
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		int vidaAnteriorMegatron = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnteriorMegatron - ataqueAnteriorOptimus * 2, megatron.getVida()); //Prueba de canion
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnteriorOptimus, optimus.getVida()); //Prueba de la burbuja
	}
	
	@Test
	public void test04AlgoformerAlternoAgarraDobleCanionYBurbujaYTieneAmbosEfectos(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		megatron = decepticonFactory.crearMegatron();
		int ataqueAnteriorOptimus = optimus.getAtaque();
		int vidaAnteriorOptimus = optimus.getVida();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new DobleCanion());
		tablero.setBonusEnCelda(new Posicion(2, 1), new BurbujaInmaculada());
		optimus.moverse(Movimiento.ABAJO); //Agarra el canion
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ARRIBA_DERECHA); //Agarra la burbuja
		
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		int vidaAnteriorMegatron = megatron.getVida();
		optimus.atacar(megatron);
		assertEquals(vidaAnteriorMegatron - ataqueAnteriorOptimus * 2, megatron.getVida()); //Prueba de canion
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnteriorOptimus, optimus.getVida()); //Prueba de la burbuja
	}
	
	@Test
	public void test05AlgoformerHumanoideAgarraBurbujaYFlashYTieneAmbosEfectos(){
		optimus = autobotFactory.crearOptimusPrime();
		megatron = decepticonFactory.crearMegatron();
		int velocidadAnterior = optimus.getVelocidad();
		int vidaAnterior = optimus.getVida();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new Flash());
		tablero.setBonusEnCelda(new Posicion(2, 1), new BurbujaInmaculada());
		optimus.moverse(Movimiento.ABAJO); //Agarra el flash
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ARRIBA_DERECHA); //Agarra la burbuja
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior, optimus.getVida()); //Prueba de la burbuja
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		int velocidadActual;
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual); //Prueba de flash
	}
	
	@Test
	public void test06AlgoformerAlternoAgarraBurbujaYFlashYTieneAmbosEfectos(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		megatron = decepticonFactory.crearMegatron();
		int velocidadAnterior = optimus.getVelocidad();
		int vidaAnterior = optimus.getVida();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.colocarAlgoformer(megatron, new Posicion(2, 2));
		tablero.setBonusEnCelda(new Posicion(1, 2), new Flash());
		tablero.setBonusEnCelda(new Posicion(2, 1), new BurbujaInmaculada());
		optimus.moverse(Movimiento.ABAJO); //Agarra el flash
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ARRIBA_DERECHA); //Agarra la burbuja
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		megatron.atacar(optimus);
		assertEquals(vidaAnterior, optimus.getVida()); //Prueba de la burbuja
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		int velocidadActual;
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual); //Prueba de flash
	}
}
