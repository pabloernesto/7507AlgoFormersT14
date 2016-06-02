package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;

import fiuba.algo3.algoformers.modelo.AlgoFormer;
import fiuba.algo3.algoformers.modelo.AlgoformerFueraDeAlcanceException;
import fiuba.algo3.algoformers.modelo.Juego;
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
		for (int i = 0 ; i < algoformer.getVelocidad() ; i++){
			algoformer.mover(Movimiento.ARRIBA);
			posicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
			assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(posicion));
		}
		try {
			algoformer.mover(Movimiento.ARRIBA);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}

	@Test
	public void test02TransformarseEnAlternoYVolverATransformarseAHumanoide(){
		Tablero.borrarInstancia();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer algoformer = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
		Posicion posicion = new Posicion(5,5);
		tablero.ColocarAlgoformer(posicion,algoformer);
		assertEquals(algoformer.getEstado().getClass(), UnidadHumanoide.class);
		
		algoformer.transformarse();
		assertEquals(algoformer.getEstado().getClass(), UnidadTerrestre.class);
		
		algoformer.transformarse();
		assertEquals(algoformer.getEstado().getClass(), UnidadHumanoide.class);
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
		for (int i = 0 ; i < algoformer.getEstado().getVelocidad() ; i++){
			algoformer.mover(Movimiento.ARRIBA);
			posicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
			assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(posicion));
		}
		try{
			algoformer.mover(Movimiento.ARRIBA);
		} catch (NoHayMasMovimientosException e){
			assertTrue(tablero.posicionEstaOcupada(posicion));
			throw e;
		}
	}
	
	@Test
	public void test04CrearJuegoDistrubuirAlgoformersYUbicarChispa(){
		Juego juego = new Juego();
		juego.inicializarJuego();
		Tablero tablero = Tablero.getInstance();
		assertTrue(tablero.posicionEstaOcupada(new Posicion(0, tablero.devolverExtremoDeAlto()/2-1)));
		assertTrue(tablero.posicionEstaOcupada(new Posicion(0, tablero.devolverExtremoDeAlto()/2)));
		assertTrue(tablero.posicionEstaOcupada(new Posicion(0, tablero.devolverExtremoDeAlto()/2+1)));
		
		assertTrue(tablero.posicionEstaOcupada(new Posicion(tablero.devolverExtremoDeAncho(), tablero.devolverExtremoDeAlto()/2-1)));
		assertTrue(tablero.posicionEstaOcupada(new Posicion(tablero.devolverExtremoDeAncho(), tablero.devolverExtremoDeAlto()/2)));
		assertTrue(tablero.posicionEstaOcupada(new Posicion(tablero.devolverExtremoDeAncho(), tablero.devolverExtremoDeAlto()/2+1)));
		
		boolean estaChispaSuprema = false;
		for (int x = tablero.devolverExtremoDeAncho() / 3 ; x < (tablero.devolverExtremoDeAncho() / 3) * 2 ; x++){
			for (int y = tablero.devolverExtremoDeAlto() / 3 ; y < (tablero.devolverExtremoDeAlto() / 3) * 2 ; y++){
				Posicion posicion = new Posicion(x,y);
				if (tablero.posicionContieneChispaSuprema(posicion)){
					estaChispaSuprema = true;
					break;
				}
			}
		}
		assertTrue(estaChispaSuprema);
	}

	@Test
	public void test05ATransformersSePuedenAtacarEstandoEnRango(){
		Tablero.borrarInstancia();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer optimus = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
		AlgoFormer megatron = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/megatron.txt");
		
		Posicion posicion = new Posicion(5,5);
		tablero.ColocarAlgoformer(posicion, optimus);
		posicion = new Posicion(5,6);
		tablero.ColocarAlgoformer(posicion, megatron);
		
		int vidaAnterior = megatron.getVida();
		optimus.atacar(megatron);
		assertTrue(megatron.getVida() == vidaAnterior - optimus.getAtaque());
	}
	
	@Test(expected=AlgoformerFueraDeAlcanceException.class)
	public void test05BTransformersNoSePuedenAtacarSiNoEstanEnRango(){
		Tablero.borrarInstancia();
		Tablero tablero = Tablero.getInstance();
		AlgoFormer optimus = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
		AlgoFormer megatron = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/megatron.txt");
		
		Posicion posicion = new Posicion(0,0);
		tablero.ColocarAlgoformer(posicion, optimus);
		posicion = new Posicion(15,15);
		tablero.ColocarAlgoformer(posicion, megatron);
		
		int vidaAnterior = megatron.getVida();
		try{
			optimus.atacar(megatron);
		} catch (AlgoformerFueraDeAlcanceException e){
			assertTrue(megatron.getVida() == vidaAnterior);
			throw e;
		}		
	}
}