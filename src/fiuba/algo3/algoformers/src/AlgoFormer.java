package fiuba.algo3.algoformers.modelo;

import java.io.IOException;
import java.util.ArrayList;

public class AlgoFormer
{
	Tablero tablero = Tablero.getInstance();
    private String nombre;
    private int vida;
    private int movimientoRestante;
    private Unidad estado;
    private Unidad estadoInactivo;
 

    //Constructor auxiliar para pruebas de otras clases
    public AlgoFormer()
    {
    	movimientoRestante = 1;
    }
	public AlgoFormer(String nombreDeArchivo)
    {
        this.init(nombreDeArchivo);
    }

    public void init(String nombreDeArchivo)
    {
    	
    	ArrayList<String[]> especificaciones = null;
		try {
			especificaciones = CSV_Parser.csvToArraysOfStrings(nombreDeArchivo);
		} catch (IOException e) {
			//Atrapar prueba --> que hacer en caso de que falle?
		}
    	
		//especificaciones.get(i) es la linea i del archivo, separado por comas
		//especificaciones.get(i)[x] es el campo x de la linea i del archivo
    	this.nombre = especificaciones.get(0)[0];
    	this.vida = Integer.parseInt(especificaciones.get(0)[1]);
    	this.movimientoRestante = Integer.parseInt(especificaciones.get(1)[1]);
    	String tipoAlterno = especificaciones.get(0)[2];
    	int[] valoresAlgoformer = new int[3];
    	
    	convertirANumeros(especificaciones.get(1), valoresAlgoformer);
    	this.estado = crearUnidad("Humanoide", valoresAlgoformer[0], valoresAlgoformer[1], valoresAlgoformer[2]);
        
    	convertirANumeros(especificaciones.get(2), valoresAlgoformer);
        this.estadoInactivo = crearUnidad(tipoAlterno, valoresAlgoformer[0], valoresAlgoformer[1], valoresAlgoformer[2]);
    }
    
    private void convertirANumeros(String[] especificaciones, int[] valoresAlgoformer){
    	for (int i = 0 ; i < 3 ; i++){
    		valoresAlgoformer[i] = Integer.parseInt(especificaciones[i]);
    	}
    }

    
    private Unidad crearUnidad(String tipo, int ataque, int velocidad, int dist_ataque){
    	Unidad unidad = null;
    	switch(tipo){
    	case "Humanoide":
    		unidad = new UnidadHumanoide(ataque, velocidad, dist_ataque);
    		break;
        case "Terrestre":
         	unidad = new UnidadTerrestre(ataque, velocidad, dist_ataque);
         	break;
        case "Aerea":
         	unidad = new UnidadAerea(ataque, velocidad, dist_ataque);
         	break;
         	}
         return unidad;
	}
    
    public void transformarse(){
    	Unidad auxiliar = this.estado;
    	this.estado = this.estadoInactivo;
    	this.estadoInactivo = auxiliar;
    	this.movimientoRestante = this.estado.getVelocidad();
    }
    
    public void mover(Movimiento d)
    {
        tablero.mover(d, this);
    }
    
    public void moverACelda(Celda c)
    {
        int costo = c.getCostoDeEntrada(this.estado);
        if (costo > movimientoRestante)
            throw new NoHayMasMovimientosException();
        movimientoRestante -= costo;
        c.setAlgoformer(this);
    }
    
    public void terminarTurno(){
    	this.movimientoRestante = this.estado.getVelocidad();
    }
    
    public int getMovimientoRestante()
    {
        return movimientoRestante;
    }
    
    //Metodos para pruebas, no deberian ser llamados en otros lugares que no sean pruebas
	public String getNombre() {
		return nombre;
	}
	
	public int getVida(){
		return vida;
	}

	public Unidad getEstado() {
		return estado;
	}

	public Unidad getEstado_inactivo() {
		return estadoInactivo;
	}
    
}
