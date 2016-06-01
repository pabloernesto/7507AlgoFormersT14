package fiuba.algo3.algoformers.test;

import org.junit.Assert;
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
    public void test01TableroColocarAlgoformer (){
    	Tablero.borrarInstance();
    	Tablero tablero= Tablero.getInstance();
    	AlgoFormer algoformer= new AlgoFormer();
    	Posicion posicion= new Posicion (0,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	Assert.assertTrue(tablero.devolverPosicionAlgoformer(algoformer)==posicion);
    }
    
    @Test()
    public void test02TableroCalculaDistanciasEntreAlgoformers(){
		Tablero.borrarInstance();
    	Tablero tablero=Tablero.getInstance();
    	AlgoFormer algoformer= new AlgoFormer();
    	AlgoFormer algoformer2= new AlgoFormer();
    	AlgoFormer algoformer3= new AlgoFormer();
    	Posicion posicion= new Posicion (0,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	posicion= new Posicion (1,1);
    	tablero.ColocarAlgoformer (posicion,algoformer2);
    	posicion= new Posicion (1,0);
    	tablero.ColocarAlgoformer (posicion,algoformer3);
    	Assert.assertTrue(tablero.distanciaEntreAlgoformers (algoformer,algoformer2)==1);
    	Assert.assertTrue(tablero.distanciaEntreAlgoformers (algoformer,algoformer3)==1);
    	Assert.assertTrue(tablero.distanciaEntreAlgoformers (algoformer2,algoformer3)==1);
    }
    
    @Test(expected=PosicionInvalidaException.class)
    public void test03TableroColocarAlgoFormerEnPosicionInvalida(){
		Tablero.borrarInstance();
    	Tablero tablero=Tablero.getInstance();
    	AlgoFormer algoformer= new AlgoFormer();
    	Posicion posicion= new Posicion (-1,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    }
    
    @Test(expected=CeldaOcupadaException.class)
    public void test03TableroColocarAlgoFormerEnUnaCeldaOcupada(){
		Tablero.borrarInstance();
    	Tablero tablero=Tablero.getInstance();
    	AlgoFormer algoformer= new AlgoFormer();
    	AlgoFormer algoformer2= new AlgoFormer();
    	Posicion posicion= new Posicion (0,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	tablero.ColocarAlgoformer (posicion,algoformer2);
    }
    @Test()
    public void test04TableroMoverAlgoformer(){
		Tablero.borrarInstance();
    	Tablero tablero=Tablero.getInstance();
    	AlgoFormer algoformer= new AlgoFormer();
    	Posicion posicion= new Posicion (1,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	Assert.assertTrue(tablero.devolverPosicionAlgoformer(algoformer)==posicion);
    	tablero.mover(Movimiento.DERECHA,algoformer);
    	Posicion posicionFinal =posicion.sumarMovimiento(Movimiento.DERECHA);
    	Assert.assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(posicionFinal));
    }
    
    @Test(expected=PosicionInvalidaException.class)
    public void test05TableroMoverAlgoformerPosicionInvalida(){
		Tablero.borrarInstance();
    	Tablero tablero=Tablero.getInstance();
    	AlgoFormer algoformer= new AlgoFormer();
    	Posicion posicion= new Posicion (0,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	Assert.assertTrue(tablero.devolverPosicionAlgoformer(algoformer).equals(posicion));
    	tablero.mover(Movimiento.ARRIBA,algoformer);
    }
    
    @Test(expected=CeldaOcupadaException.class)
    public void test06TableroMoverAlgoformerCeldaOcupada(){
		Tablero.borrarInstance();
    	Tablero tablero=Tablero.getInstance();
    	AlgoFormer algoformer= new AlgoFormer();
    	Posicion posicion= new Posicion (0,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	Assert.assertTrue(tablero.devolverPosicionAlgoformer(algoformer)==posicion);
    	AlgoFormer nuevoAlgoformer= new AlgoFormer();
    	Posicion nuevaPosicion= new Posicion(1,0);
    	tablero.ColocarAlgoformer (nuevaPosicion,nuevoAlgoformer);
    	tablero.mover(Movimiento.IZQUIERDA,nuevoAlgoformer);
    }    
}
