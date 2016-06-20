package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.escenario.Celda;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;

public class VistaDeCelda extends StackPane
{
    public VistaDeCelda(Celda c)
    {
        BackgroundImage imagenDeFondo;

        Image imagen = 
            new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/rocoso-nubes.jpg",
                80, 80, true, true);
        imagenDeFondo = 
            new BackgroundImage(imagen, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        this.setBackground(new Background(imagenDeFondo));
    }
}

