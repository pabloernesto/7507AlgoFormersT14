package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.vista.eventos.OpcionInformacionEventHandler;
import fiuba.algo3.algoformers.vista.eventos.OpcionVentanaHandler;
import fiuba.algo3.algoformers.vista.eventos.OpcionPantallaCompletaHandler;
import fiuba.algo3.algoformers.vista.eventos.OpcionSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
    MenuItem opcionVentana = new MenuItem("Vista Ventana");

    public BarraDeMenu(Stage stage){
        Menu menuArchivo = nuevoMenuArchivo(stage);
        Menu menuVer = nuevoMenuVer(stage);
        Menu menuInformacion = nuevoMenuInformacion(stage);

        this.getMenus().addAll(menuArchivo, menuVer, menuInformacion);
    }

    private Menu nuevoMenuArchivo(Stage stage){
        Menu menu = new Menu("Archivo");
        MenuItem opcionAbrir = new MenuItem("Abrir");
        MenuItem opcionSalir = new MenuItem("Salir");
        menu.getItems()
            .addAll(opcionAbrir, new SeparatorMenuItem(), opcionSalir);

        EventHandler<ActionEvent> opcionSalirHandler = new OpcionSalirEventHandler(stage);
        opcionSalir.setOnAction(opcionSalirHandler);

        return menu;
    }

    private Menu nuevoMenuVer(Stage stage){
        Menu menu = new Menu("Ver");
        menu.getItems().addAll(opcionPantallaCompleta, opcionVentana);

        EventHandler<ActionEvent> opcionPantallaCompletaHandler =
            new OpcionPantallaCompletaHandler(stage, opcionPantallaCompleta,
                this);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        opcionPantallaCompleta.setDisable(true);

        EventHandler<ActionEvent> opcionVentanaHandler =
            new OpcionVentanaHandler(stage, opcionVentana, this);
        opcionVentana.setOnAction(opcionVentanaHandler);
        opcionVentana.setDisable(false);

        return menu;
    }

    private Menu nuevoMenuInformacion(Stage stage){
        Menu menu = new Menu("Informacion");
        MenuItem opcionInformacion = new MenuItem("Informacion");
        menu.getItems().addAll(opcionInformacion);

        EventHandler<ActionEvent> opcionInformacionHandler =
            new OpcionInformacionEventHandler(stage);
        opcionInformacion.setOnAction(opcionInformacionHandler);

        return menu;
    }

    public void aplicacionMaximizada(Boolean estaMaximizada) {
        opcionPantallaCompleta.setDisable(estaMaximizada);
        opcionVentana.setDisable(!estaMaximizada);
    }
}

