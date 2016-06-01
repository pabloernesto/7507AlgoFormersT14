package fiuba.algo3.algoformers.modelo;

import java.util.List;
import java.util.ArrayList;

public class Equipo {
	
	// El capitan es el primero de la lista.
	private ArrayList<AlgoFormer> listaAlgoFormer;
	
	public Equipo(List<String> listaArchivos){
		for(String archivo : listaArchivos)
			listaAlgoFormer.add(new AlgoFormer(archivo));
	}

	public AlgoFormer getCapitan() {
		return listaAlgoFormer.get(0);
	}

	public ArrayList<AlgoFormer> getListaAlgoFormer() {
		return listaAlgoFormer;
	}
	
	public AlgoFormer get(String nombreDelAlgoFormer)
	{
	    for (AlgoFormer af : listaAlgoFormer)
	    {
	        if (af.getNombre().equals(nombreDelAlgoFormer))
	            return af;
	    }
	    throw new RuntimeException();
	}
}
