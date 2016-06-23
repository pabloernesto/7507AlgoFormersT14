package fiuba.algo3.algoformers.vista;

import java.util.HashMap;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaAlgoFormer extends ImageView
{
	
	private static HashMap<String, Image> imagenes = null;
	
    public VistaAlgoFormer(AlgoFormer algoformer)
    {
    	cargarImagenes();
    	
    	setImage(imagenes.get(algoformer.getNombre() + algoformer.nombreEstadoActivo()));

        setFitWidth(60);
        setFitHeight(60);
    }
    
    private void cargarImagenes(){
    	if (imagenes != null)
    		return;
    	imagenes = new HashMap<String, Image>();
    	
    	Image optimusHumanoide = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/Optimus PrimeHumanoide.jpg");
    	Image optimusAlterno = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/Optimus PrimeAlterno.jpg");
    	Image bumblebeeHumanoide = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/bumblebeeHumanoide.jpg");
    	Image bumblebeeAlterno = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/bumblebeeAlterno.jpg");
    	Image ratchetHumanoide = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/ratchetHumanoide.jpg");
    	Image ratchetAlterno = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/ratchetAlterno.jpg");
    	Image megatronHumanoide = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/megatronHumanoide.jpg");
    	Image megatronAlterno = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/megatronAlterno.jpg");
    	Image bonecrusherHumanoide = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/bonecrusherHumanoide.jpg");
    	Image bonecrusherAlterno = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/bonecrusherAlterno.jpg");
    	Image frenzyHumanoide = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/frenzyHumanoide.jpg");
    	Image frenzyAlterno = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/frenzyAlterno.jpg");
    	Image superion = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/superionAlterno.jpg");
    	Image menasor = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/algoformers/menasorAlterno.jpg");
    	
    	imagenes.put("Optimus PrimeHumanoide", optimusHumanoide);
    	imagenes.put("Optimus PrimeAlterno", optimusAlterno);
    	imagenes.put("BumblebeeHumanoide", bumblebeeHumanoide);
    	imagenes.put("BumblebeeAlterno", bumblebeeAlterno);
    	imagenes.put("RatchetHumanoide", ratchetHumanoide);
    	imagenes.put("RatchetAlterno", ratchetAlterno);
    	imagenes.put("MegatronHumanoide", megatronHumanoide);
    	imagenes.put("MegatronAlterno", megatronAlterno);
    	imagenes.put("BonecrusherHumanoide", bonecrusherHumanoide);
    	imagenes.put("BonecrusherAlterno", bonecrusherAlterno);
    	imagenes.put("FrenzyHumanoide", frenzyHumanoide);
    	imagenes.put("FrenzyAlterno", frenzyAlterno);
    	imagenes.put("SuperionAlterno", superion);
    	imagenes.put("MenasorAlterno", menasor);
    }
}

