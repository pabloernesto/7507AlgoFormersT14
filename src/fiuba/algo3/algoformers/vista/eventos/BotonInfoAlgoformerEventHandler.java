package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BotonInfoAlgoformerEventHandler
    implements EventHandler<ActionEvent>
{
    private AlgoFormer algoformer;
    private ContenedorPrincipal contenedor;

    public BotonInfoAlgoformerEventHandler(AlgoFormer algoformer,
        ContenedorPrincipal contenedor)
    {
        this.algoformer = algoformer;
        this.contenedor = contenedor;
    }

    public void handle(ActionEvent event)
    {
        String info = "Vida: " + String.valueOf(algoformer.getVida()) + "\n";
        info += "Ataque: " + String.valueOf(algoformer.getAtaque()) + "\n";
        info += "Movimientos restantes: " +
            String.valueOf(algoformer.getMovimientosRestantes()) + "\n";
        info += "Distancia ataque: " +
            String.valueOf(algoformer.getDistAtaque()) + "\n";

        contenedor.infoPanel.setMensaje(info);
    }
}

