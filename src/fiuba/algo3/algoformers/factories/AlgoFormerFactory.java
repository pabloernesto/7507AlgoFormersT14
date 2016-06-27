package fiuba.algo3.algoformers.factories;

import java.util.List;
import fiuba.algo3.algoformers.algoformers.AlgoFormer;

public interface AlgoFormerFactory {

	public List<AlgoFormer> crearEquipo();
	
	public AlgoFormer crearCombinado(List<AlgoFormer> integrantes);

	public abstract String getNombreFactory();
}
