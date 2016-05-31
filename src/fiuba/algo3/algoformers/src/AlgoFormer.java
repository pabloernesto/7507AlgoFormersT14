package fiuba.algo3.algoformers.modelo;

public class AlgoFormer
{
    Tablero tablero = Tablero.getInstance();
    ModoAlgoFormer modoActual;
    int movimientoRestante = 8;
//    File especificacionAF;
    public AlgoFormer(){}
    public AlgoFormer(String nombreDeArchivo){}
/*    
    public AlgoFormer(String nombreDeArchivo)
    {
        especificacionAF = new File(nombreDeArchivo);
        this.init();
    }

    public void init()
    {
        // leer especificacionAF y cargar datos
    }
*/
    public void mover(Movimiento d)
    {
        tablero.mover(d, this);
    }

    public void moverACelda(Celda c)
    {
        int costo = c.getCostoDeEntrada(ModoAlgoFormer.HUMANOIDE);
        if (costo > movimientoRestante)
            throw new RuntimeException();
        movimientoRestante -= costo;
    }
    
    public int getMovimientoRestante()
    {
        return movimientoRestante;
    }
}
