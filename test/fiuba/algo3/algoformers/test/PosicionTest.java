package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;

import fiuba.algo3.algoformers.modelo.Movimiento;
import fiuba.algo3.algoformers.modelo.Posicion;

public class PosicionTest {

	@Test
	public void testDosPosicionesSonIgualesSiRepresentanElMismoLugar(){
		Posicion posicion = new Posicion(1,1);
		Posicion otraPosicion = new Posicion(1,1);
		assertTrue(posicion.equals(otraPosicion));
	}
	
	@Test
	public void testDosPosicionesSonDistintasSiRepresentanDisintasPosiciones(){
		Posicion posicion = new Posicion(1,1);
		Posicion otraPosicion = new Posicion(2,2);
		assertFalse(posicion.equals(otraPosicion));
	}
	
	@Test
	public void testSumarPosicionesDaUnaNuevaPosicionQueEsCorrecta(){
		Posicion posicion = new Posicion(1,1);
		Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ARRIBA);
		Posicion mismaPosicion = new Posicion(1,0);
		assertTrue(nuevaPosicion.equals(mismaPosicion));
	}
}
