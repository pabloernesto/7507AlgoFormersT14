package fiuba.algo3.algoformers.vista;

import java.util.HashMap;

import fiuba.algo3.algoformers.escenario.bonus.Bonus;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaBonus extends ImageView
{
	
	private static HashMap<String, Image> imagenes = null;
	
    public VistaBonus(Bonus bonus)
    {
    	cargarImagenes();
    	
    	setImage(imagenes.get(bonus.nombre()));

        setFitWidth(35);
        setFitHeight(35);
    }
    
    private void cargarImagenes(){
    	if (imagenes != null)
    		return;
    	imagenes = new HashMap<String, Image>();
    	
    	Image canion = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/bonus/dobleCanion.png");
    	Image flash = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/bonus/flash.png");
    	Image burbuja = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/bonus/burbuja.png");
    	Image chispa = new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/bonus/chispaSuprema.png");
    	
    	imagenes.put("dobleCanion", canion);
    	imagenes.put("flash", flash);
    	imagenes.put("burbuja", burbuja);
    	imagenes.put("chispaSuprema", chispa);
    }
}

