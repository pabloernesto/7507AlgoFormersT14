package fiuba.algo3.algoformers.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import org.mockito.*;
import static org.mockito.Mockito.*;

import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.algoformers.AlgoFormer;

import java.util.List;
import java.lang.NullPointerException;

public class JugadorTest
{
    @Mock protected AlgoFormer algoformerActual;
    @InjectMocks Jugador jugador;
    
    @Before
    public void setUp()
    {
        jugador = new Jugador(new AutoBotFactory());
    }
    
    @Test(expected = NullPointerException.class)
    public void testAtacarSinElegirAlgoFormerCausaExcepcion()
    {
        jugador = new Jugador(new AutoBotFactory());

        List<AlgoFormer> equipo = jugador.getListaAlgoformers();
        jugador.atacar(equipo.get(0));
	}
	
	@Test
    public void testAtacarHaceQueElAlgoFormerActualAtaque()
    {
        jugador.elegirAlgoFormer("Optimus Prime");
        MockitoAnnotations.initMocks(this);
        
        AlgoFormer objetivo = jugador.getListaAlgoformers().get(0);
        jugador.atacar(objetivo);
        
        verify(algoformerActual).atacar(objetivo);
	}
}

