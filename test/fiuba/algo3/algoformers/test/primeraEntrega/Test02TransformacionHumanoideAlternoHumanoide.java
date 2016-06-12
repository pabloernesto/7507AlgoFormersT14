package fiuba.algo3.algoformers.test.primeraEntrega;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.RocasYNubesFactory;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class Test02TransformacionHumanoideAlternoHumanoide {

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
	
	@Test
	public void test01OptimusPuedeTransformarseEnAlternoYVolverATransformarseAHumanoide(){
		Posicion posicion = new Posicion(5,5);
		optimus = autobotFactory.crearOptimusPrime();
		tablero.colocarAlgoformer(optimus, posicion);
		assertEquals(optimus.getAtaque(), 50);
		optimus.transformarse();
		assertEquals(optimus.getAtaque(), 15);
		optimus.transformarse();
		assertEquals(optimus.getAtaque(), 50);
	}
	
	@Test
	public void test02BumblebeePuedeTransformarseEnAlternoYVolverATransformarseAHumanoide(){
		Posicion posicion = new Posicion(5,5);
		bumblebee = autobotFactory.crearBumblebee();
		tablero.colocarAlgoformer(bumblebee, posicion);
		assertEquals(bumblebee.getAtaque(), 40);
		bumblebee.transformarse();
		assertEquals(bumblebee.getAtaque(), 20);
		bumblebee.transformarse();
		assertEquals(bumblebee.getAtaque(), 40);
	}
	
	@Test
	public void test03RatchetPuedeTransformarseEnAlternoYVolverATransformarseAHumanoide(){
		Posicion posicion = new Posicion(5,5);
		ratchet = autobotFactory.crearRatchet();
		tablero.colocarAlgoformer(ratchet, posicion);
		assertEquals(ratchet.getAtaque(), 5);
		ratchet.transformarse();
		assertEquals(ratchet.getAtaque(), 35);
		ratchet.transformarse();
		assertEquals(ratchet.getAtaque(), 5);
	}
	
	@Test
	public void test04MegatronPuedeTransformarseEnAlternoYVolverATransformarseAHumanoide(){
		Posicion posicion = new Posicion(5,5);
		megatron = decepticonFactory.crearMegatron();
		tablero.colocarAlgoformer(megatron, posicion);
		assertEquals(megatron.getAtaque(), 10);
		megatron.transformarse();
		assertEquals(megatron.getAtaque(), 55);
		megatron.transformarse();
		assertEquals(megatron.getAtaque(), 10);
	}
	
	@Test
	public void test05BonecrusherPuedeTransformarseEnAlternoYVolverATransformarseAHumanoide(){
		Posicion posicion = new Posicion(5,5);
		bonecrusher = decepticonFactory.crearBonecrusher();
		tablero.colocarAlgoformer(bonecrusher, posicion);
		assertEquals(bonecrusher.getVelocidad(), 1);
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getVelocidad(), 8);
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getVelocidad(), 1);
	}
	
	@Test
	public void test06FrenzyPuedeTransformarseEnAlternoYVolverATransformarseAHumanoide(){
		Posicion posicion = new Posicion(5,5);
		frenzy = decepticonFactory.crearFrenzy();
		tablero.colocarAlgoformer(frenzy, posicion);
		assertEquals(frenzy.getAtaque(), 10);
		frenzy.transformarse();
		assertEquals(frenzy.getAtaque(), 25);
		frenzy.transformarse();
		assertEquals(frenzy.getAtaque(), 10);
	}
}
