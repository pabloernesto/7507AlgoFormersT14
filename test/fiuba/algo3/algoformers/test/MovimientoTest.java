package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;
import org.junit.Test;
import fiuba.algo3.algoformers.escenario.Movimiento;

public class MovimientoTest {

	
	@Test
	public void testMovimientoARRIBASeReprentaCon_0_Menos1(){
		assertEquals(0, Movimiento.ARRIBA.getMovimientoEnX());
		assertEquals(-1, Movimiento.ARRIBA.getMovimientoEnY());
	}
	
	@Test
	public void testMovimientoDERECHASeReprentaCon_1_0(){
		assertEquals(1, Movimiento.DERECHA.getMovimientoEnX());
		assertEquals(0, Movimiento.DERECHA.getMovimientoEnY());
	}
	
	@Test
	public void testMovimientoIZQUIERDASeReprentaCon_Menos1_0(){
		assertEquals(-1, Movimiento.IZQUIERDA.getMovimientoEnX());
		assertEquals(0, Movimiento.IZQUIERDA.getMovimientoEnY());
	}
	
	@Test
	public void testMovimientoABAJOSeReprentaCon_0_1(){
		assertEquals(0, Movimiento.ABAJO.getMovimientoEnX());
		assertEquals(1, Movimiento.ABAJO.getMovimientoEnY());
	}
	
	@Test
	public void testMovimientoARRIBA_DERECHASeReprentaCon_1_Menos1(){
		assertEquals(1, Movimiento.ARRIBA_DERECHA.getMovimientoEnX());
		assertEquals(-1, Movimiento.ARRIBA_DERECHA.getMovimientoEnY());
	}
	
	@Test
	public void testMovimientoARRIBA_IZQUIERDASeReprentaCon_Menos1_Menos1(){
		assertEquals(-1, Movimiento.ARRIBA_IZQUIERDA.getMovimientoEnX());
		assertEquals(-1, Movimiento.ARRIBA_IZQUIERDA.getMovimientoEnY());
	}
	
	@Test
	public void testMovimientoABAJO_DERECHASeReprentaCon_1_1(){
		assertEquals(1, Movimiento.ABAJO_DERECHA.getMovimientoEnX());
		assertEquals(1, Movimiento.ABAJO_DERECHA.getMovimientoEnY());
	}
	
	@Test
	public void testMovimientoABAJO_IZQUIERDASeReprentaCon_Menos1_1(){
		assertEquals(-1, Movimiento.ABAJO_IZQUIERDA.getMovimientoEnX());
		assertEquals(1, Movimiento.ABAJO_IZQUIERDA.getMovimientoEnY());
	}
	
}
