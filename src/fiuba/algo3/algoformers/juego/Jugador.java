package fiuba.algo3.algoformers.juego;

import java.util.List;
import java.util.ArrayList;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.escenario.Posicion;
import fiuba.algo3.algoformers.factories.AlgoFormerFactory;

public class Jugador
{
	private EstadoJugador estado = new EstadoJugador_ModoPrueba();
    private Juego juego;
	List<AlgoFormer> equipo;
	AlgoFormer algoformerActual;
	AlgoFormerFactory algoformerFactory;
	public boolean combinado = false;
	String nombre;
	
	public Jugador(AlgoFormerFactory factory, String nombre)
	{
	    equipo = factory.crearEquipo();
	    algoformerFactory = factory;
	    this.nombre = nombre;
 	}

    public void elegirAlgoFormer(AlgoFormer algoformer){
        elegirAlgoFormer(algoformer.getNombre());
    }

    public void elegirAlgoFormer(String nombre)
    {
        estado.elegirAlgoFormer(this, nombre);
    }

    void _elegirAlgoFormer(String nombre)
    {
        AlgoFormer algoformerElegido = null;
        for (AlgoFormer algoformer : equipo){
            if (algoformer.getNombre().equals(nombre))
                algoformerElegido = algoformer;
        }
        if (algoformerElegido == null){
            System.out.println("El algoformer no existe"); //Cambiar por excepcion?
        }
        algoformerActual = algoformerElegido;
    }
    
	public List<AlgoFormer> getListaAlgoformers (){
		return equipo;
	}
	
	public void setEstado(EstadoJugador nuevoEstado)
	{
	    estado = nuevoEstado;
	}
	
	public void atacar(AlgoFormer atacado)
	{
	    estado.atacar(this, atacado);
	}
	
	public void mover(Movimiento direccion)
	{
	    estado.mover(this, direccion);
	}
	
	public void combinar()
	{
	    estado.combinar(this);
	}
	
	public void descombinar()
	{
		estado.descombinar(this);
	}
	
	public void transformar()
	{
	    estado.transformar(this);
	}
	
    public void terminarTurno()
    {
        estado.terminarTurno(this);
    }
	
    public void iniciarTurno()
    {
        for (AlgoFormer algoformer : equipo)
            algoformer.iniciarTurno();
        
        estado.iniciarTurno(this);
    }

    void _terminarTurno()
    {
        for (AlgoFormer algoformer : equipo)
            algoformer.finalizarTurno();
        
        juego.terminarTurno();
    }
    
    void setJuego(Juego juego)
    {
        this.juego = juego;
    }

    void _combinar()
    {
        Tablero tablero = Tablero.getInstance();

        AlgoFormer combinacion = algoformerFactory.crearCombinado(equipo);
        Posicion posicionCapitan = tablero.getPosicionAlgoformer(equipo.get(0));

        for (AlgoFormer algoformer : equipo)
            tablero.borrarAlgoformer(algoformer);
        tablero.colocarAlgoformer(combinacion, posicionCapitan);

        equipo = new ArrayList<AlgoFormer>();
        equipo.add(combinacion);

        combinado = true;
    }

    void _descombinar()
    {
        AlgoFormer superion = equipo.get(0);
        int vidaSuperion = superion.getVida();
        Tablero tablero = Tablero.getInstance();
        List<Posicion> posicionesDisponibles =
            tablero.movimientosValidos(superion);
        
        equipo = superion.devolverIntegrantes();
        for (AlgoFormer algoformer : equipo)
        	algoformer.borrarTodosLosEfectos();
        tablero.borrarAlgoformer(superion);
        int vidaIntegrantes = vidaSuperion / equipo.size();
        // Ubicar el nuevo equipo en el tablero
        int posicion = 0;
        for (AlgoFormer algoformer : equipo){
            tablero.colocarAlgoformer(algoformer, posicionesDisponibles.get(posicion));
            posicion++;
            algoformer.setVida(vidaIntegrantes);
        }
        
        combinado = false;
    }
    
    public AlgoFormer getAlgoformerElegido(){
    	return algoformerActual;
    }
    
    public String getNombre(){
    	return nombre;
    }

	public String getEquipo() {
		return algoformerFactory.getNombreFactory();
	}
}

