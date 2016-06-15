package fiuba.algo3.algoformers.juego;

import java.util.Observable;
import java.util.Observer;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.factories.AlgoFormerFactory;

public class Jugador implements Observer
{
	EstadoJugador estado = new EstadoJugador_Activo();
	protected List<AlgoFormer> equipo;
	protected AlgoFormer algoformerActual;
	
	public Jugador(AlgoFormerFactory factory)
	{
	    equipo = factory.crearEquipo();
 	}
	
	public void elegirAlgoFormer(String nombre){
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
	
	void setEstado(EstadoJugador e)
	{
	    estado = e;
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
	
	public void transformar()
	{
	    estado.transformar(this);
	}
	
	/* Jugador es observador de ControlDeTurnos */
	public void update(Observable o, Object arg)
	{
	    if (arg == this)
	        setEstado(new EstadoJugador_Activo());
	    
	    else
	        setEstado(new EstadoJugador_Inactivo());
	}
}

