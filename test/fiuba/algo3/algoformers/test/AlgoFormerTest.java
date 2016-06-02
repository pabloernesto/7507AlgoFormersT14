package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import fiuba.algo3.algoformers.modelo.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Celda;
import fiuba.algo3.algoformers.modelo.NoHayMasMovimientosException;

public class AlgoFormerTest {

    AlgoFormer af;

    @Before
    public void setUp()
    {
        af = new AlgoFormer();
    }

	@Test
	public void testCrearUnAlgoFormerNoEsNull(){
		AlgoFormer algoformer = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
		assertNotNull(algoformer);
	}
	
	@Test
	public void testAlgoformerSeCreaCorrectamenteSegunArchivo(){
		AlgoFormer algoformer = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
		assertEquals(algoformer.getNombre(), "Optimus Prime");
		assertEquals(algoformer.getVida(), 500);
		assertEquals(algoformer.getAtaque(), 50);
		assertEquals(algoformer.getVelocidad(), 2);
		assertEquals(algoformer.getDist_ataque(), 2);
		assertEquals(algoformer.getEstadoInactivo().getAtaque(), 15);
		assertEquals(algoformer.getEstadoInactivo().getVelocidad(), 4);
		assertEquals(algoformer.getEstadoInactivo().getDist_ataque(), 5);
	}

    @Test
    public void testMoverACeldaReduceMovimientoRestante()
    {
        int movimientoInicial = af.getMovimientoRestante();
        Celda c = new Celda(); 
        af.moverACelda(c);
        
        assertTrue(af.getMovimientoRestante() < movimientoInicial);
    }
    
    @Test(expected=NoHayMasMovimientosException.class)
    public void testMoverACeldaMasVecesQueVelocidadLanzaExcepcion()
    {
        Celda c = new Celda();
    	af.moverACelda(c);
        af.moverACelda(c);
        //af (algoformer) se crea con velocidad = 1
    }
    
    @Test(expected=NoHayMasMovimientosException.class)
    public void testMoverACeldaReduceMovimientoYLanzaExcepcionSiNoHayMasMovimiento()
    {
    	AlgoFormer algoformer = new AlgoFormer("/home/travis/build/pabloernesto/7507AlgoFormersT14/recursos/optimus.txt");
        int movimientoInicial = algoformer.getMovimientoRestante();
        Celda c = new Celda();
        algoformer.moverACelda(c);
        assertTrue(af.getMovimientoRestante() < movimientoInicial);
        algoformer.moverACelda(c);
        algoformer.moverACelda(c);
    }
    
}
