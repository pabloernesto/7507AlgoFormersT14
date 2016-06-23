package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.escenario.bonus.Bonus;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaBonus extends ImageView
{
    public VistaBonus(Bonus bonus)
    {
        setImage(new Image("file:src/fiuba/algo3/algoformers/vista/" +
            "imagenes/bonus/" + bonus.nombre() + ".png"));

        setFitWidth(35);
        setFitHeight(35);
    }
}

