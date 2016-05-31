package fiuba.algo3.algoformers.test;

import fiuba.algo3.algoformers.modelo.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Tablero;
import fiuba.algo3.algoformers.modelo.Movimiento;
import fiuba.algo3.algoformers.modelo.Celda;
import fiuba.algo3.algoformers.modelo.ModoAlgoFormer;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;

public class AlgoFormerTest
{
    @Mock private Tablero tablero;
//    @Mock private File archivo;
    @InjectMocks private AlgoFormer af;

    @Before
    public void setUp()
    {
        af = new AlgoFormer();
        MockitoAnnotations.initMocks(this);
    }
/*
    @Test
    public void testInitLeeEspecificacion()
    {
    }
*/
    @Test
    public void testMoverPasaSuArgumentoATablero()
    {
        af.mover(Movimiento.DERECHA);
        verify(tablero).mover(Movimiento.DERECHA, af);
    }

    @Test
    public void testMoverACeldaPideACeldaSuCostoDeEntrada()
    {
        Celda c = mock(Celda.class);
        af.moverACelda(c);
        verify(c).getCostoDeEntrada(ModoAlgoFormer.HUMANOIDE);
    }

    @Test(expected = RuntimeException.class)
    public void testMoverACeldaFallaSiCostoDeEntradaEsDemasiadoAlto()
    {
        // Crear una celda que tiene un costo de entrada prohibitivo.
        Celda c = mock(Celda.class);
        when(
            c.getCostoDeEntrada(ModoAlgoFormer.HUMANOIDE)
        ).thenReturn(20000);    // It's over 9000!!!
        af.moverACelda(c);
    }
}
