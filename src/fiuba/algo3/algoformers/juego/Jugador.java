package fiuba.algo3.algoformers.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.escenario.Movimiento;
import fiuba.algo3.algoformers.factories.AlgoFormerFactory;

public abstract class Jugador {

	protected AlgoFormerFactory factory;
	protected List<AlgoFormer> equipo;
	protected AlgoFormer algoformerActual;
	
	public Jugador (){
		equipo = new ArrayList<AlgoFormer>();
		inicializarEquipo();
	}
	
	public abstract void inicializarEquipo ();
	
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
	
	public void atacar (AlgoFormer atacado){
		algoformerActual.atacar(atacado);
	}
	
	public void mover (Movimiento direccion){
		algoformerActual.moverse(direccion);
	}
	
	public void combinar (){
	}
	
	public void transformar (){
		algoformerActual.transformarse();
	}
	
	public List<AlgoFormer> getListaAlgoformers (){
		return equipo;
	}
}