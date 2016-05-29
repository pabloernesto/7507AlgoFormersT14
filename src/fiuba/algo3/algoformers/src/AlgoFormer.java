package fiuba.algo3.algoformers.modelo;

public class AlgoFormer
{
    Tablero tablero = Tablero.getUniqueInstance();
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
    public void mover(Direccion d)
    {
        tablero.mover(d);
    }
}
