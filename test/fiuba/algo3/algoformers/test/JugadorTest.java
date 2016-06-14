package fiuba.algo3.algoformers.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import fiuba.algo3.algoformers.juego.Jugador;
import fiuba.algo3.algoformers.factories.AutoBotFactory;
import fiuba.algo3.algoformers.algoformers.AlgoFormer;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;

import java.util.List;
import java.lang.NullPointerException;

public class JugadorTest
{
    Jugador jugador;

    @Before
    public void setUp()
    {
        jugador = new Jugador(new AutoBotFactory());
    }
    
    @Test(expected = NullPointerException.class)
    public void testAtacarSinElegirAlgoFormerCausaExcepcion()
    {
        List<AlgoFormer> equipo = jugador.getListaAlgoformers();
        jugador.atacar(equipo.get(0));
	}
}
