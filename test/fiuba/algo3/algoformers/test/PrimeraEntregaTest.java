package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;

import fiuba.algo3.algoformers.modelo.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Movimiento;
import fiuba.algo3.algoformers.modelo.NoHayMasMovimientosException;
import fiuba.algo3.algoformers.modelo.Posicion;
import fiuba.algo3.algoformers.modelo.Tablero;
import fiuba.algo3.algoformers.modelo.UnidadHumanoide;
import fiuba.algo3.algoformers.modelo.UnidadTerrestre;

public class PrimeraEntregaTest {
	
	@Test
	public void test01AColocarTransformerHumanoideMoverYVerificarPosicion(){
		Tablero.borrarInstancia();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer algoformer = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
		Posicion posicion = new Posicion(5,5);
		tablero.ColocarAlgoformer(posicion,algoformer);
		algoformer.mover(Movimiento.ARRIBA);
		Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
		assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(nuevaPosicion));
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test01BTransformerHumanoideNoPuedeMoverseMasVecesQueSuVelocidad(){
		Tablero.borrarInstancia();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer algoformer = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
		Posicion posicion = new Posicion(5,5);
		tablero.ColocarAlgoformer(posicion,algoformer);
		algoformer.mover(Movimiento.ARRIBA);
		Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
		assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(nuevaPosicion));
		algoformer.mover(Movimiento.ARRIBA);
		nuevaPosicion = nuevaPosicion.sumarMovimiento(Movimiento.ARRIBA);
		assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(nuevaPosicion));
		algoformer.mover(Movimiento.ARRIBA);
	}

	@Test
	public void test02TransformarseEnAlternoYVolverATransformarseAHumanoide(){
		UnidadTerrestre unidadTerrestre = new UnidadTerrestre(5, 5, 5); // ataque velocidad distAtaque
		UnidadHumanoide unidadHumanoide = new UnidadHumanoide(5, 5, 5); // ataque velocidad distAtaque
		
		Tablero.borrarInstancia();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer algoformer = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
		Posicion posicion = new Posicion(5,5);
		tablero.ColocarAlgoformer(posicion,algoformer);
		assertEquals(algoformer.getEstado().getClass(), unidadHumanoide.getClass());
		
		algoformer.transformarse();
		assertEquals(algoformer.getEstado().getClass(), unidadTerrestre.getClass());
		
		algoformer.transformarse();
		assertEquals(algoformer.getEstado().getClass(), unidadHumanoide.getClass());
	}
	
	@Test
	public void test03AColocarTransformerModoAlternoMoverYVerificarPosicion(){
		Tablero.borrarInstancia();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer algoformer = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
		algoformer.transformarse();
		Posicion posicion = new Posicion(5,5);
		tablero.ColocarAlgoformer(posicion,algoformer);
		algoformer.mover(Movimiento.ARRIBA);
		Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
		assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(nuevaPosicion));
	}
	
	@Test(expected=NoHayMasMovimientosException.class)
	public void test03BTransformerModoAlternoNoPuedeMoverseMasVecesQueSuVelocidad(){
		Tablero.borrarInstancia();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer algoformer = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
		algoformer.transformarse();
		Posicion posicion = new Posicion(5,5);
		tablero.ColocarAlgoformer(posicion, algoformer);
		for (int i = 0 ; i < algoformer.getEstado().getVelocidad() + 1; i++){
			algoformer.mover(Movimiento.ARRIBA);
			posicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
			assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(posicion));
		}
	}

	/*@Test
	public void test05TransformersSePuedenAtacarSoloSiEstanEnRango(){
		AlgoFormer autobot = new AlgoFormer("ALGOFORMER DEL TIPO AUTOBOT");
		AlgoFormer decepticon = new AlgoFormer("ALGOF DEL TIPO DECEPTICON");
		Tablero tablero = Tablero.getInstance();
		
		//Se pueden atacar
		Posicion posicion= new Posicion(5,5);
		tablero.ColocarAlgoformer (posicion,autobot);
		
		posicion= new Posicion(5,6);
		tablero.ColocarAlgoformer (posicion,decepticon);
		
		//ATACAR Y VERIFICAR CAMBIO EN LA VIDA 
		
		//No se pueden atacar
		posicion= new Posicion(5,5);
		tablero.ColocarAlgoformer (posicion,autobot);
		
		posicion= new Posicion(5,20);
		tablero.ColocarAlgoformer (posicion,decepticon);
		
		//ATACAR Y VERIFICAR Q NO CAMBIARON SU VIDA
		
	}*/
}