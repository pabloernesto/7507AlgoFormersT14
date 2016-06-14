package fiuba.algo3.algoformers.test.segundaEntrega;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.NebulosaDeAndromeda;
import fiuba.algo3.algoformers.escenario.superficies.Nube;
import fiuba.algo3.algoformers.escenario.superficies.Rocosa;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieAerea;
import fiuba.algo3.algoformers.escenario.superficies.SuperficieTerrestre;
import fiuba.algo3.algoformers.excepciones.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.factories.DecepticonFactory;

public class Test08AtravesarNebulosaEnModoAereoLoAtrapa3TurnosTest {

	private Celda celda;
	private Celda otraCelda;
	private AutoBotFactory autobotFactory = new AutoBotFactory();
	private DecepticonFactory decepticonFactory = new DecepticonFactory();
	
	private AlgoFormer ratchet;
	private AlgoFormer megatron;
	

	private SuperficieTerrestre rocosa = new Rocosa();
	private SuperficieAerea nubes = new Nube();
	private SuperficieAerea nebulosa = new NebulosaDeAndromeda();
	
	@Before
	public void setUp(){
		celda = new Celda(rocosa, nebulosa);
		otraCelda = new Celda(rocosa, nubes);
		ratchet = autobotFactory.crearRatchet();
		ratchet.transformarse();
		
		megatron = decepticonFactory.crearMegatron();
		megatron.transformarse();
	}
	
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test01ARatchetAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		ratchet.entrarACelda(celda);
		ratchet.entrarACelda(otraCelda);
	}

	@Test(expected=NoHayMasMovimientosException.class)
	public void test01BRatchetAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		ratchet.entrarACelda(celda);
		ratchet.finalizarTurno();
		ratchet.iniciarTurno();
		ratchet.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test01CRatchetAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		ratchet.entrarACelda(celda);
		ratchet.finalizarTurno();
		ratchet.iniciarTurno();
		ratchet.finalizarTurno();
		ratchet.iniciarTurno();
		ratchet.entrarACelda(otraCelda);
	}
	
	@Test
	public void test01DRatchetAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		ratchet.entrarACelda(celda);
		ratchet.finalizarTurno();
		ratchet.iniciarTurno();
		ratchet.finalizarTurno();
		ratchet.iniciarTurno();
		ratchet.finalizarTurno();
		ratchet.iniciarTurno();
		ratchet.entrarACelda(otraCelda);
	}
	
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test02AMegatronAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		megatron.entrarACelda(celda);
		megatron.entrarACelda(otraCelda);
	}

	@Test(expected=NoHayMasMovimientosException.class)
	public void test02BMegatronAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		megatron.entrarACelda(celda);
		megatron.finalizarTurno();
		megatron.iniciarTurno();
		megatron.entrarACelda(otraCelda);
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test02CMegatronAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		megatron.entrarACelda(celda);
		megatron.finalizarTurno();
		megatron.iniciarTurno();
		megatron.finalizarTurno();
		megatron.iniciarTurno();
		megatron.entrarACelda(otraCelda);
	}
	
	@Test
	public void test02DMegatronAtravesarNebulosaEnModoAereoLoAtrapa3Turnos(){
		megatron.entrarACelda(celda);
		megatron.finalizarTurno();
		megatron.iniciarTurno();
		megatron.finalizarTurno();
		megatron.iniciarTurno();
		megatron.finalizarTurno();
		megatron.iniciarTurno();
		megatron.entrarACelda(otraCelda);
	}
}
