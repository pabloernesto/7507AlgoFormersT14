/*package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;

import fiuba.algo3.algoformers.modelo.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Movimiento;
import fiuba.algo3.algoformers.modelo.Posicion;
import fiuba.algo3.algoformers.modelo.Tablero;
import fiuba.algo3.algoformers.modelo.UnidadHumanoide;
import fiuba.algo3.algoformers.modelo.UnidadTerrestre;

public class PrimeraEntregaTest {
	//3.Se ubica un algoformer humanoide se lo transforma.
		//se verifica que se pueda transformar en ambas direcciones.
	
	@Test
	public void test01ColocarTransformerMoverYVerificarPosicion(){
		AlgoFormer algoformer = new AlgoFormer("MODIFICAR ESTO POR EL NOMBRE DE ARCHIVO DE CUALQUIER TIPO DE ALGOFORMER");
		Tablero tablero = Tablero.getInstance();
		Posicion posicion= new Posicion(5,5);
		tablero.ColocarAlgoformer (posicion,algoformer);
		algoformer.mover(Movimiento.ARRIBA);
		Posicion nuevaPosicion= posicion.sumarMovimiento(Movimiento.ARRIBA);
		assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(nuevaPosicion));
	}
	
	@Test
	public void test02TransformarseEnAlternoYVolverATransformarseAHumanoide(){
		
		UnidadTerrestre unidadTerrestre = new UnidadTerrestre(100, 5, 5, 5); //vida ataque velocidad distAtaque
		UnidadHumanoide unidadHumanoide = new UnidadHumanoide(100, 5, 5, 5); //vida ataque velocidad distAtaque
		AlgoFormer algoformer = new AlgoFormer("ALGOFORMER TIPO TERRESTRE");
		
		algoformer.transformarse();
		assertEquals(algoformer.getEstado().getClass(),unidadTerrestre.getClass());
		
		algoformer.transformarse();
		assertEquals(algoformer.getEstado().getClass(),unidadHumanoide.getClass());
	}
	
	
	
	@Test
	public void test03ColocarTransformerModoAlternoMoverYVerificarPosicion(){
		AlgoFormer algoformer = new AlgoFormer("MODIFICAR ESTO");
		algoformer.transformarse();
		Tablero tablero = Tablero.getInstance();
		Posicion posicion= new Posicion(5,5);
		tablero.ColocarAlgoformer (posicion,algoformer);
		algoformer.mover(Movimiento.ARRIBA);
		Posicion nuevaPosicion= posicion.sumarMovimiento(Movimiento.ARRIBA);
		assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(nuevaPosicion));
	}

	@Test
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
		
		/*******************************************
		
		//No se pueden atacar
		posicion= new Posicion(5,5);
		tablero.ColocarAlgoformer (posicion,autobot);
		
		posicion= new Posicion(5,20);
		tablero.ColocarAlgoformer (posicion,decepticon);
		
		//ATACAR Y VERIFICAR Q NO CAMBIARON SU VIDA
		
	}
}*/