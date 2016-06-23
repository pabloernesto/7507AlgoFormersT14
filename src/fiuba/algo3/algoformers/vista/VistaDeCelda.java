package fiuba.algo3.algoformers.vista;

import java.util.HashMap;

import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.bonus.ChispaSuprema;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;

public class VistaDeCelda extends StackPane
{
	
	private static HashMap<String, BackgroundImage> imagenes = null;
	
    public VistaDeCelda(Celda celda)
    {
    	cargarImagenes();
    	
        String tierra = celda.getNombreSuperficieTerrestre();
        String aire = celda.getNombreSuperficieAerea();
        setBackground(tierra + "-" + aire);

        if (celda.estaOcupada())
            this.getChildren().add(new VistaAlgoFormer(celda.getAlgoformer()));
        
        if (celda.contieneChispaSuprema())
            this.getChildren().add(new VistaBonus(new ChispaSuprema()));

        else{
        	this.getChildren().add(new VistaBonus(celda.getBonus()));
        }
    }

    private void setBackground(String nombreImagen)
    {

    	BackgroundImage imagenDeFondo = imagenes.get(nombreImagen);

        this.setBackground(new Background(imagenDeFondo));
    }
    
    private void cargarImagenes(){
    	if (imagenes != null)
    		return;
    	
    	imagenes = new HashMap<String, BackgroundImage>();
    	
    	Image espinasTormenta = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/espinas-tormenta.jpg");
    	Image espinasNebulosa = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/espinas-nebulosa.jpg");
    	Image espinasNubes = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/espinas-nubes.jpg");
    	Image pantanoTormenta = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/pantano-tormenta.jpg");
    	Image pantanoNebulosa = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/pantano-nebulosa.jpg");
    	Image pantanoNubes = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/pantano-nubes.jpg");
    	Image rocosaTormenta = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/rocosa-tormenta.jpg");
    	Image rocosaNebulosa = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/rocosa-nebulosa.jpg");
    	Image rocosaNubes = new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/rocosa-nubes.jpg");
    	
    	BackgroundImage fondoEspinasTormenta = new BackgroundImage(espinasTormenta, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	BackgroundImage fondoEspinasNebulosa = new BackgroundImage(espinasNebulosa, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	BackgroundImage fondoEspinasNubes = new BackgroundImage(espinasNubes, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	BackgroundImage fondoPantanoTormenta = new BackgroundImage(pantanoTormenta, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	BackgroundImage fondoPantanoNebulosa = new BackgroundImage(pantanoNebulosa, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	BackgroundImage fondoPantanoNubes = new BackgroundImage(pantanoNubes, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	BackgroundImage fondoRocosaTormenta = new BackgroundImage(rocosaTormenta, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	BackgroundImage fondoRocosaNebulosa = new BackgroundImage(rocosaNebulosa, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	BackgroundImage fondoRocosaNubes = new BackgroundImage(rocosaNubes, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	
    	imagenes.put("espinas-tormenta", fondoEspinasTormenta);
    	imagenes.put("espinas-nebulosa", fondoEspinasNebulosa);
    	imagenes.put("espinas-nubes", fondoEspinasNubes);
    	imagenes.put("pantano-tormenta", fondoPantanoTormenta);
    	imagenes.put("pantano-nebulosa", fondoPantanoNebulosa);
    	imagenes.put("pantano-nubes", fondoPantanoNubes);
    	imagenes.put("rocosa-tormenta", fondoRocosaTormenta);
    	imagenes.put("rocosa-nebulosa", fondoRocosaNebulosa);
    	imagenes.put("rocosa-nubes", fondoRocosaNubes);
    }
}

