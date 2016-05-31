package fiuba.algo3.algoformers.test;

import org.junit.Assert;
import org.junit.Test;

public class TableroTest
{
    @Test
    public void testVacio()
    {
        Assert.assertTrue(true);
    }
/*
    @Test()
    public void test01TableroColocarAlgoformer (){
    	Tablero tablero= tablero.getInstance();
    	AlgoFormer algoformer= new Algoformer();
    	Posicion posicion= new Posicion (0,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	Assert.assertTrue(tablero.devolverPosicionAlgoformer(algoformer)==posicion);
    }
    
    @Test()
    public void test02TableroCalculaDistanciasEntreAlgoformers(){
    	Tablero tablero=tablero.getInstance();
    	AlgoFormer algoformer= new Algoformer();
    	AlgoFormer algoformer2= new Algoformer();
    	AlgoFormer algoformer3= new Algoformer();
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
    	Tablero tablero=tablero.getInstance();
    	AlgoFormer algoformer= new Algoformer();
    	Posicion posicion= new Posicion (-1,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    }
    
    @Test(expected=CeldaOcupadaException.class)
    public void test03TableroColocarAlgoFormerEnUnaCeldaOcupada(){
    	Tablero tablero=tablero.getInstance();
    	AlgoFormer algoformer= new Algoformer();
    	AlgoFormer algoformer2= new Algoformer();
    	Posicion posicion= new Posicion (0,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	tablero.ColocarAlgoformer (posicion,algoformer2);
    }
    @Test()
    public void test04TableroMoverAlgoformer(){
    	Tablero tablero=tablero.getInstance();
    	AlgoFormer algoformer= new Algoformer();
    	Posicion posicion= new Posicion (1,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	Assert.assertTrue(tablero.devolverPosicionAlgoformer(algoformer)==posicion);
    	Direccion direccion= new Direccion();
    	tablero.mover(direccion,algoformer);
    	Posicion posicionFinal =posicion.sumarMovimiento(direccion);
    	Assert.assertTrue(tablero.devolverPosicionAlgoformer(algoformer)==posicionFinal);
    }
    
    @Test(expected=PosicionInvalidaException.class)
    public void test05TableroMoverAlgoformerPosicionInvalida(){
    	Tablero tablero=tablero.getInstance();
    	AlgoFormer algoformer= new Algoformer();
    	Posicion posicion= new Posicion (0,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	Assert.assertTrue(tablero.devolverPosicionAlgoformer(algoformer)==posicion);
    	Direccion direccion= new Direccion(Abajo);
    	tablero.mover(direccion,algoformer);
    }
    
    @Test(expected=CeldaOcupadaException.class)
    public void test06TableroMoverAlgoformerCeldaOcupada(){
    	Tablero tablero=tablero.getInstance();
    	AlgoFormer algoformer= new Algoformer();
    	Posicion posicion= new Posicion (0,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	Assert.assertTrue(tablero.devolverPosicionAlgoformer(algoformer)==posicion);
    	AlgoFormer algoformer= new Algoformer();
    	Posicion posicion= new Posicion (1,0);
    	tablero.ColocarAlgoformer (posicion,algoformer);
    	Direccion direccion= new Direccion(Arriba);
    	tablero.mover(direccion,algoformer);
    }
*/    
}
