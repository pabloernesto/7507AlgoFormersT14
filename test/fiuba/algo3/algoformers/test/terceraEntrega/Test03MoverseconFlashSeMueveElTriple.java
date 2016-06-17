package fiuba.algo3.algoformers.test.terceraEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.bonus.Flash;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.BonusNuloFactory;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;

public class Test03MoverseconFlashSeMueveElTriple {

	Tablero tablero;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private AlgoFormer optimus;
	
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
	public void test01MoverseConFlashEnHumanoideSeMueveElTriplePorTresTurnos(){
		optimus = autobotFactory.crearOptimusPrime();
		int velocidadAnterior = optimus.getVelocidad();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.setBonusEnCelda(new Posicion(2, 1), new Flash());
		int velocidadActual;
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA); //Agarra el bonus
		}
		assertEquals(velocidadAnterior, velocidadActual); //Hace efecto a partir del proximo turno
		
		optimus.finalizarTurno(); //Primer turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual);
	
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.ABAJO);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual);
		
		optimus.finalizarTurno(); //Tercer turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.IZQUIERDA);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual);
		
		optimus.finalizarTurno(); //Cuarto turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.ARRIBA);
		}
		assertEquals(velocidadAnterior, velocidadActual); //Al cuarto turno ya no hace efecto
	}
	
	@Test
	public void test02AgarrarDosFlashEnHumanoideSoloHaceEfectoLaPrimeraVez(){
		optimus = autobotFactory.crearOptimusPrime();
		int velocidadAnterior = optimus.getVelocidad();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.setBonusEnCelda(new Posicion(2, 1), new Flash());
		int velocidadActual;
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA); //Agarra el bonus
		}
		assertEquals(velocidadAnterior, velocidadActual); //Hace efecto a partir del proximo turno
		
		optimus.finalizarTurno(); //Primer turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual);
		
		Posicion posicionAlgoformer = tablero.getPosicionAlgoformer(optimus);
		Posicion posicionNuevoFlash = posicionAlgoformer.sumarMovimiento(Movimiento.ABAJO);
		tablero.setBonusEnCelda(posicionNuevoFlash, new Flash());
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ABAJO); //Agarra otro flash, pero no hace efecto
	
		optimus.finalizarTurno(); //Tercer turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.ABAJO);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual);
		
		optimus.finalizarTurno(); //Cuarto turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.IZQUIERDA);
		}
		assertEquals(velocidadAnterior, velocidadActual); //Al cuarto turno ya no hace efecto
	}
	
	@Test
	public void test03MoverseConFlashEnAlternoSeMueveElTriplePorTresTurnos(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		int velocidadAnterior = optimus.getVelocidad();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.setBonusEnCelda(new Posicion(2, 1), new Flash());
		int velocidadActual;
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA); //Agarra el bonus
		}
		assertEquals(velocidadAnterior, velocidadActual); //Hace efecto a partir del proximo turno
		
		optimus.finalizarTurno(); //Primer turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual);
	
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.ABAJO);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual);
		
		optimus.finalizarTurno(); //Tercer turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.IZQUIERDA);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual);
		
		optimus.finalizarTurno(); //Cuarto turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.ARRIBA);
		}
		assertEquals(velocidadAnterior, velocidadActual); //Al cuarto turno ya no hace efecto
	}
	
	@Test
	public void test04AgarrarDosFlashEnAlternoSoloHaceEfectoLaPrimeraVez(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		int velocidadAnterior = optimus.getVelocidad();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.setBonusEnCelda(new Posicion(2, 1), new Flash());
		int velocidadActual;
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA); //Agarra el bonus
		}
		assertEquals(velocidadAnterior, velocidadActual); //Hace efecto a partir del proximo turno
		
		optimus.finalizarTurno(); //Primer turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual);
		
		Posicion posicionAlgoformer = tablero.getPosicionAlgoformer(optimus);
		Posicion posicionNuevoFlash = posicionAlgoformer.sumarMovimiento(Movimiento.ABAJO);
		tablero.setBonusEnCelda(posicionNuevoFlash, new Flash());
		
		optimus.finalizarTurno(); //Segundo turno
		optimus.iniciarTurno();
		optimus.moverse(Movimiento.ABAJO); //Agarra otro flash, pero no hace efecto
	
		optimus.finalizarTurno(); //Tercer turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.ABAJO);
		}
		assertEquals(velocidadAnterior * 3, velocidadActual);
		
		optimus.finalizarTurno(); //Cuarto turno
		optimus.iniciarTurno();
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.IZQUIERDA);
		}
		assertEquals(velocidadAnterior, velocidadActual); //Al cuarto turno ya no hace efecto
	}
	
	@Test
	public void test05AgarrarFlashEnHumanoideYTransformarseHacePerderElBonus(){
		optimus = autobotFactory.crearOptimusPrime();
		optimus.transformarse();
		int velocidadAlternaOriginal = optimus.getVelocidad();
		optimus.transformarse();
		tablero.colocarAlgoformer(optimus, new Posicion(1, 1));
		tablero.setBonusEnCelda(new Posicion(1, 2), new Flash());
		optimus.moverse(Movimiento.ABAJO);
		
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		optimus.transformarse();
		
		optimus.finalizarTurno();
		optimus.iniciarTurno();
		int velocidadActual;
		for (velocidadActual = 0 ; optimus.getMovimientosRestantes() != 0 ; velocidadActual++){
			optimus.moverse(Movimiento.DERECHA);
		}
		assertEquals(velocidadAlternaOriginal, velocidadActual);
	}
	
	
}