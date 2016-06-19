package fiuba.algo3.algoformers.test.primeraEntrega;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.juego.Jugador;

public class Test04Integracion {
	
	
	@After
	public void tearDown(){
		Tablero.reiniciarTablero();
	}
	
	@Test
	public void test01CrearJuegoConJugadoresAlgoFormersYChispa(){
		Juego juego = new Juego();
		
		assertNotNull(juego);
		
		Tablero tablero = Tablero.getInstance();
		
		juego.crearJugadores("Nombre1", "Nombre2");
		juego.inicializar();
		Jugador jugador1 = juego.jugadorActual();
		Jugador jugador2 = juego.jugadorInactivo();
		
		assertNotNull(jugador1);
		assertNotNull(jugador2);
		
		List<AlgoFormer> equipo1 = jugador1.getListaAlgoformers();
		List<AlgoFormer> equipo2 = jugador2.getListaAlgoformers();
		
		
		//Veo que los algoformers de cada equipo esten juntos
		//Tambien veo que los equipos esten en extremos opuestos
		int alturaMedia = tablero.altura() / 2;
		int ancho = tablero.ancho();
		
		assertTrue(new Posicion(1, alturaMedia).equals
				(tablero.getPosicionAlgoformer(equipo1.get(0))));  //El algoformer del equipo 1 esta en el extremo izquierdo
		
		assertTrue(new Posicion(ancho, alturaMedia).equals
				(tablero.getPosicionAlgoformer(equipo2.get(0))));  //El algoformer del equipo 2 esta en el extremo derecho
		
		assertEquals(ancho - 1,
				tablero.distancia(equipo1.get(0), equipo2.get(0))); //La distancia entre equipos es coherente
																					// con el tablero
		
		//Los algoformers del mismo equipo estan juntos
		assertEquals(1,
				tablero.distancia(equipo1.get(0), equipo1.get(1)));
	        
	    assertEquals(1,
	        	tablero.distancia(equipo1.get(1), equipo1.get(2)));
	        
	    assertEquals(1,
		        tablero.distancia(equipo2.get(0), equipo2.get(1)));
		        
		assertEquals(1,
		        tablero.distancia(equipo2.get(1), equipo2.get(2)));
		
		
		//Veo si esta la chispa
		int cuartoDeAncho = ancho / 4;
		int tresCuartosDeAncho = cuartoDeAncho * 3;
		int cuartoDeAlto = alturaMedia / 2;
		int tresCuartosDeAlto = cuartoDeAlto * 3;
		
		boolean estaLaChispa = false;
		for (int x = cuartoDeAncho ; x <= tresCuartosDeAncho ; x++){
			for (int y = cuartoDeAlto ; y <= tresCuartosDeAlto ; y++){
				Posicion posicion = new Posicion(x, y);
				if (tablero.posicionContieneChispaSuprema(posicion))
					estaLaChispa = true;
			}
		}
		assertTrue(estaLaChispa);
	}

}
