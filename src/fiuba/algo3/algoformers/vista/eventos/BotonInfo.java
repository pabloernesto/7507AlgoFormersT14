package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import javafx.scene.control.Button;

public class BotonInfo extends Button{

	private AlgoFormer algoformer;
	
	public BotonInfo(AlgoFormer algoformer){
		super();
		this.algoformer = algoformer;
	}
	
	public AlgoFormer getAlgoformer(){
		return algoformer;
	}
}
