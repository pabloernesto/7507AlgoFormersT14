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
    public VistaDeCelda(Celda celda)
    {
        String tierra = celda.getNombreSuperficieTerrestre();
        String aire = celda.getNombreSuperficieAerea();
        setBackground(tierra + "-" + aire + ".jpg");

        if (celda.estaOcupada())
            this.getChildren().add(new VistaAlgoFormer(celda.getAlgoformer()));
    }

    private void setBackground(String nombreImagen)
    {
        Image imagen =
            new Image("file:src/fiuba/algo3/algoformers/vista/" +
                "imagenes/escenario/" + nombreImagen);
        BackgroundImage imagenDeFondo =
            new BackgroundImage(imagen, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        this.setBackground(new Background(imagenDeFondo));
    }
}

