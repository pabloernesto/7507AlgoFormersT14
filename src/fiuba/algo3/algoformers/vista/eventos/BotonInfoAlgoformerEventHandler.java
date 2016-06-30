package fiuba.algo3.algoformers.vista.eventos;

import fiuba.algo3.algoformers.vista.ContenedorPrincipal;
import fiuba.algo3.algoformers.vista.VistaAlgoFormer;
import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BotonInfoAlgoformerEventHandler
    implements EventHandler<ActionEvent>
{
    private VistaAlgoFormer vistaAlgoFormer;
    private ContenedorPrincipal contenedor;
    private AlgoFormer algoformer;
    
    public BotonInfoAlgoformerEventHandler(AlgoFormer algoformer,
        ContenedorPrincipal contenedor)
    {
        vistaAlgoFormer = new VistaAlgoFormer(algoformer);
        this.contenedor = contenedor;
    }

    public void handle(ActionEvent event)
    {
        contenedor.consola.setMensaje(vistaAlgoFormer.estadisticas());
    }
}

