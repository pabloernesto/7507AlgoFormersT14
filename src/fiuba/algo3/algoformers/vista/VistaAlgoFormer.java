package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaAlgoFormer extends ImageView
{
    public VistaAlgoFormer(AlgoFormer algoformer)
    {
        setImage(new Image("file:src/fiuba/algo3/algoformers/vista/" +
            "imagenes/algoformers/" + "optimus.jpg"));
    }
}

