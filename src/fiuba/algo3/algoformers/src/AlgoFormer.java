package fiuba.algo3.algoformers.modelo;

public class AlgoFormer
{
    Tablero tablero = Tablero.getInstance();
    ModoAlgoFormer modoActual;
//    File especificacionAF;
    
    public AlgoFormer(){}
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
        c.getCostoDeEntrada(ModoAlgoFormer.HUMANOIDE);
    }
}
