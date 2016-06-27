package fiuba.algo3.algoformers.vista;

import java.util.HashMap;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaAlgoFormer
{
    private static HashMap<String, Image> imagenes =
        new HashMap<String, Image>();

    private AlgoFormer algoformer;

    public VistaAlgoFormer(AlgoFormer algoformer)
    {
        this.algoformer = algoformer;
    }

    public ImageView imageView()
    {
        ImageView vista = new ImageView(imagen(algoformer.getNombre() +
            algoformer.nombreEstadoActivo()));

        vista.setFitWidth(60);
        vista.setFitHeight(60);

        return vista;
    }

    private Image imagen(String nombreImagen)
    {
        if (!imagenes.keySet().contains(nombreImagen))
            imagenes.put(nombreImagen,
                new Image("file:src/fiuba/algo3/algoformers/vista/imagenes/" +
                    "algoformers/" + nombreImagen + ".jpg"));

        return imagenes.get(nombreImagen);
    }
}

