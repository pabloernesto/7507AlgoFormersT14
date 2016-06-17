package fiuba.algo3.algoformers.algoformers;

import java.util.List;

import fiuba.algo3.algoformers.excepciones.CombinadoNoPuedeTransformarseException;

public class Menasor extends Decepticon {

	List<AlgoFormer> integrantes;

	public Menasor (Forma forma, List<AlgoFormer> integrantes){
		super("Menasor", 0, forma);
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
