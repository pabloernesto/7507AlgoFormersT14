package fiuba.algo3.algoformers.modelo;

import java.util.ArrayList;

public class Equipo {
	//EL CAPITAN SIEMPRE VA A SER EL PRIMERO DE LA LISTA.
	private ArrayList<AlgoFormer> listaAlgoFormer;
	
	/*	private AlgoFormer capitan;
	private AlgoFormer subordinadoA;
	private AlgoFormer subordinadoB;
	
	public Equipo(String archivoCapitan, String archivoSubordinadoA, String archivoSubordinadoB){
		//Equipo le pasa los nombres de archivo al constructor de AlgoFormer
		capitan = new AlgoFormer(archivoCapitan);
		subordinadoA = new AlgoFormer(archivoSubordinadoA);
		subordinadoB = new AlgoFormer(archivoSubordinadoB);	
	}*/
	public Equipo(ArrayList<String> listaArchivos){
		for(String archivo : listaArchivos)
			listaAlgoFormer.add(new AlgoFormer(archivo));
	}
	public AlgoFormer getCapitan(){
		return listaAlgoFormer.get(0);
	}
	public ArrayList<AlgoFormer> getListaAlgoFormer(){
		return listaAlgoFormer;
	}
	public AlgoFormer elegirAlgoformer(){
		AlgoFormer algoformer = new AlgoFormer("algo");//regvisar este metodo!
		return algoformer;
	}
}
