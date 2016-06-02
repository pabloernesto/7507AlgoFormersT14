package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoformers.modelo.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Posicion;
import fiuba.algo3.algoformers.modelo.Tablero;
import fiuba.algo3.algoformers.modelo.PosicionInvalidaException;
import fiuba.algo3.algoformers.modelo.CeldaOcupadaException;
import fiuba.algo3.algoformers.modelo.Movimiento;

public class TableroTest
{
    @Test()
    public void test01TableroColocarAlgoformer(){
    	Tablero.borrarInstancia();
    	Tablero tablero = Tablero.getInstance();
    	AlgoFormer algoformer = new AlgoFormer();
    	Posicion posicion = new Posicion (0,0);
    	tablero.ColocarAlgoformer(posicion, algoformer);
    	assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(posicion));
    }
    
    @Test()
    public void test02TableroCalculaCorrectamenteDistanciasEntreAlgoformers(){
    	Tablero.borrarInstancia();
    	Tablero tablero=Tablero.getInstance();
    	AlgoFormer algoformer = new AlgoFormer();
    	AlgoFormer algoformer2 = new AlgoFormer();
    	AlgoFormer algoformer3 = new AlgoFormer();
    	Posicion posicion = new Posicion(0,0);
    	tablero.ColocarAlgoformer(posicion, algoformer);
    	posicion= new Posicion(1,1);
    	tablero.ColocarAlgoformer(posicion, algoformer2);
    	posicion= new Posicion(1,0);
    	tablero.ColocarAlgoformer (posicion,algoformer3);
    	assertTrue(tablero.distanciaEntreAlgoformers(algoformer, algoformer2)==1);
    	assertTrue(tablero.distanciaEntreAlgoformers(algoformer, algoformer3)==1);
    	assertTrue(tablero.distanciaEntreAlgoformers(algoformer2, algoformer3)==1);
    	assertTrue(tablero.distanciaEntreAlgoformers(algoformer, algoformer)==0);
    }
    
    @Test(expected=CeldaOcupadaException.class)
    public void test03TableroColocarAlgoFormerEnUnaCeldaOcupadaLanzaExcepcion(){
    	Tablero.borrarInstancia();
    	Tablero tablero = Tablero.getInstance();
    	AlgoFormer algoformer = new AlgoFormer();
    	AlgoFormer algoformer2 = new AlgoFormer();
    	Posicion posicion = new Posicion (0,0);
    	tablero.ColocarAlgoformer(posicion, algoformer);
    	tablero.ColocarAlgoformer(posicion, algoformer2);
    }
    
    @Test()
    public void test04TableroMoverAlgoformer(){
    	Tablero.borrarInstancia();
    	Tablero tablero = Tablero.getInstance();
    	AlgoFormer algoformer = new AlgoFormer();
    	Posicion posicion= new Posicion (1,0);
    	tablero.ColocarAlgoformer(posicion, algoformer);
    	tablero.mover(Movimiento.DERECHA, algoformer);
    	Posicion posicionFinal = posicion.sumarMovimiento(Movimiento.DERECHA);
    	assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(posicionFinal));
    }
    
    @Test(expected=PosicionInvalidaException.class)
    public void test05TableroMoverAlgoformerAPosicionInvalidaLanzaExcepcion(){
		Tablero.borrarInstancia();
    	Tablero tablero = Tablero.getInstance();
    	AlgoFormer algoformer = new AlgoFormer();
    	Posicion posicion= new Posicion(0,0);
    	tablero.ColocarAlgoformer(posicion, algoformer);
    	assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(posicion));
    	tablero.mover(Movimiento.ARRIBA,algoformer);
    }
    
    @Test(expected=CeldaOcupadaException.class)
    public void test06TableroMoverAlgoformerCeldaOcupadaLanzaExcepcion(){
    	Tablero.borrarInstancia();
    	Tablero tablero = Tablero.getInstance();
    	AlgoFormer algoformer = new AlgoFormer();
    	Posicion posicion = new Posicion (0,0);
    	tablero.ColocarAlgoformer(posicion, algoformer);
    	AlgoFormer nuevoAlgoformer = new AlgoFormer();
    	Posicion nuevaPosicion = new Posicion(1,0);
    	tablero.ColocarAlgoformer (nuevaPosicion, nuevoAlgoformer);
    	tablero.mover(Movimiento.IZQUIERDA,nuevoAlgoformer);
    }
    
    @Test()
    public void test07tableroAgregarChispaSupremaSeAgregaEnElMedio(){
    	Tablero.borrarInstancia();
    	Tablero tablero = Tablero.getInstance();
    	tablero.colocarChispaSuprema();
    	Posicion medio = new Posicion (60/2, 20/2);
    	assertTrue(tablero.devolverPosicionChispaSuprema().equals(medio));
    }
 
    @Test(expected=PosicionInvalidaException.class)
    public void test08TableroColocarAlgoFormerEnPosicionInvalidaLanzaExcepcion(){
    	Tablero.borrarInstancia();
    	Tablero tablero = Tablero.getInstance();
    	AlgoFormer algoformer = new AlgoFormer();
    	Posicion posicion = new Posicion (-1,0);
    	tablero.ColocarAlgoformer(posicion,algoformer);
    }
    	
    @Test()
    public void test09devolverExtremosDevuelveExtremosCorrectos(){
    	Tablero.borrarInstancia();
    	Tablero tablero = Tablero.getInstance();
    	assertEquals(tablero.devolverExtremoDeAncho(),59);
    	assertEquals(tablero.devolverExtremoDeAlto(),19);
    }
    
    @Test()
    public void test10posicionEstaOcupada(){
    	Tablero.borrarInstancia();
    	Tablero tablero = Tablero.getInstance();
    	Posicion posicion = new Posicion(1,1);
    	assertFalse(tablero.posicionEstaOcupada(posicion));
    	AlgoFormer algoformer = new AlgoFormer();
    	tablero.ColocarAlgoformer(posicion, algoformer);
    	assertTrue(tablero.posicionEstaOcupada(posicion));
    }
}
