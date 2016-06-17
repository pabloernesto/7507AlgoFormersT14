package fiuba.algo3.algoformers.algoformers;

import java.util.List;

import fiuba.algo3.algoformers.excepciones.CombinadoNoPuedeTransformarseException;

public class Superion extends AutoBot {

	List<AlgoFormer> integrantes;

	public Superion (Forma forma, List<AlgoFormer> integrantes){
		super("Superion", 0, forma);
		this.integrantes = integrantes;
		establecerVida();
	}

	private void establecerVida() {
		int vida = 0;
		for (AlgoFormer algoformer : integrantes)
			vida += algoformer.getVida();
		this.vida = vida;
	}
	
	public List<AlgoFormer> devolverIntegrantes(){
		return integrantes;
	}
	
	public void transformarse (){
		throw new CombinadoNoPuedeTransformarseException();
	}
}
