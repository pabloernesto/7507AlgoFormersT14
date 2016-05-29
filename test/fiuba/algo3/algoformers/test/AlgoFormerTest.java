package fiuba.algo3.algoformers.test;

import fiuba.algo3.algoformers.modelo.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Tablero;
import fiuba.algo3.algoformers.modelo.Direccion;

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
        af.mover(Direccion.DERECHA);
        verify(tablero).mover(Direccion.DERECHA);
    }
}
