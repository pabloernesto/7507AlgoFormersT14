package fiuba.algo3.algoformers.test;

import org.junit.Test;
import static org.junit.Assert.*;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Posicion;

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
		Posicion nuevaPosicion = posicion.sumarMovimiento(Movimiento.ABAJO);
		Posicion mismaPosicion = new Posicion(1,2);
		assertTrue(nuevaPosicion.equals(mismaPosicion));
	}
	
	@Test
	public void testCalcularDistanciaEntreOrigen_MenosDosUno_EsDos(){
	    Posicion origen = new Posicion(0, 0);
	    Posicion destino = new Posicion(-2, 1);
	    assertEquals(2, origen.calcularDistanciaCon(destino));
	}
}