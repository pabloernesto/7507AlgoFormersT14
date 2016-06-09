package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.*;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.factories.AutoBotFactory;

public class SegundaEntregaTest {
	
	private Celda celda;
	private AutoBotFactory factory = new AutoBotFactory();
	private AlgoFormer optimus;
	private AlgoFormer ratchet;
	
	private SuperficieTerrestre rocosa = new Rocosa();
	private SuperficieTerrestre pantano = new Pantano();
	private SuperficieTerrestre espinas = new Espinas();
	private SuperficieAerea nubes = new Nube();
	private SuperficieAerea tormenta = new TormentaPsionica();
	private SuperficieAerea nebulosa = new NebulosaDeAndromeda();
	
	@Before
	public void setUp(){
		optimus = factory.crearOptimusPrime();
		ratchet = factory.crearRatchet();
	}
	
	@Test
	public void test01AtravesarRocosaEnModosTerrestresNoCausaProblemas(){
		celda = new Celda(rocosa, nubes);
		int movimientos = optimus.getMovimientosRestantes();
		optimus.entrarACelda(celda);
		assertEquals(movimientos - 1, optimus.getMovimientosRestantes());
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test02NoSePuedeAtravesarPantanoEnModoHumanoide(){
		celda = new Celda(pantano, nubes);
		Celda otraCelda = new Celda(rocosa, nubes);
		assertTrue(optimus.getMovimientosRestantes() > 1);
		optimus.entrarACelda(celda);
		optimus.entrarACelda(otraCelda);
	}
	
	@Test
	public void test03AtravesarPantanoEnModoTerrestreCuestaElDobleQueEnRocosa(){
		celda = new Celda(pantano, nubes);
		optimus.transformarse();
		int movimientos = optimus.getMovimientosRestantes();
		optimus.entrarACelda(celda);
		assertEquals(movimientos - 2, optimus.getMovimientosRestantes());
	}
	
	@Test
	public void test04AtravesarPantanoEnModoAereoNoCausaProblemas(){
		celda = new Celda(pantano, nubes);
		ratchet.transformarse();
		int movimientos = ratchet.getMovimientosRestantes();
		ratchet.entrarACelda(celda);
		assertEquals(movimientos - 1, ratchet.getMovimientosRestantes());
	}
	
	@Test
	public void test05AtravesarEspinasEnModosTerrestresRestaVida(){
		celda = new Celda(espinas, nubes);
		int vida = optimus.getVida();
		optimus.entrarACelda(celda);
		int nuevaVida = optimus.getVida();
		assertEquals(nuevaVida, vida / 100 * 95);
		celda = new Celda(espinas, nubes);
		optimus.transformarse();
		optimus.entrarACelda(celda);
		assertEquals(optimus.getVida(), nuevaVida * 95 / 100);
	}
	
	@Test
	public void test06AtravesarEspinasEnModoAereoNoRestaVida(){
		celda = new Celda(espinas, nubes);
		int vida = ratchet.getVida();
		ratchet.transformarse();
		ratchet.entrarACelda(celda);
		int nuevaVida = ratchet.getVida();
		assertEquals(vida, nuevaVida);
	}
	
	@Test
	public void test07AtravesarNubeEnModoAereoNoCausaProblemas(){
		celda = new Celda(rocosa, nubes);
		ratchet.transformarse();
		int movimientos = ratchet.getMovimientosRestantes();
		ratchet.entrarACelda(celda);
		assertEquals(movimientos - 1, ratchet.getMovimientosRestantes());
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test08AAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		celda = new Celda(rocosa, nebulosa);
		ratchet.transformarse();
		ratchet.entrarACelda(celda);
		celda = new Celda(rocosa, nubes);
		ratchet.entrarACelda(celda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test08BAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		celda = new Celda(rocosa, nebulosa);
		ratchet.transformarse();
		ratchet.entrarACelda(celda);
		ratchet.iniciarTurno();
		celda = new Celda(rocosa, nubes);
		ratchet.entrarACelda(celda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test08CAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		celda = new Celda(rocosa, nebulosa);
		ratchet.transformarse();
		ratchet.entrarACelda(celda);
		ratchet.iniciarTurno();
		ratchet.iniciarTurno();
		celda = new Celda(rocosa, nubes);
		ratchet.entrarACelda(celda);
	}
	
	@Test
	public void test08DAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		celda = new Celda(rocosa, nebulosa);
		ratchet.transformarse();
		ratchet.entrarACelda(celda);
		ratchet.iniciarTurno();
		ratchet.iniciarTurno();
		ratchet.iniciarTurno();
		celda = new Celda(rocosa, nubes);
		ratchet.entrarACelda(celda);
	}
	
	@Test
	public void test09AtravesarTormentaEnModoAereoRestaAtaque(){
		celda = new Celda(rocosa, tormenta);
		ratchet.transformarse();
		int ataqueAnterior = ratchet.getAtaque();
		ratchet.entrarACelda(celda);
		assertEquals(ataqueAnterior * 60 / 100, ratchet.getAtaque());
	}
	
	@Test
	public void test10AtravesarTormentaEnModoAereoRestaAtaqueSoloUnaVez(){
		celda = new Celda(rocosa, tormenta);
		ratchet.transformarse();
		int ataqueAnterior = ratchet.getAtaque();
		ratchet.entrarACelda(celda);
		celda = new Celda(rocosa, tormenta);
		ratchet.entrarACelda(celda);
		assertEquals(ataqueAnterior * 60 / 100, ratchet.getAtaque());
	}

}
