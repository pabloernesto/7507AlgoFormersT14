package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.vista.eventos.OpcionMinimizarHandler;
import fiuba.algo3.algoformers.vista.eventos.OpcionPantallaCompletaHandler;
import fiuba.algo3.algoformers.vista.eventos.OpcionSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;



public class BarraDeMenu extends MenuBar {
	
    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
    MenuItem opcionMinimizar = new MenuItem("Minimizar");

    public BarraDeMenu(Stage stage) {

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuInformacion = new Menu("Informacion");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAbrir = new MenuItem("Abrir");
        MenuItem opcionInformacion = new MenuItem("Informacion");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler(stage);
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionInformacionEventHandler opcionInformacionHandler = new OpcionInformacionEventHandler(stage);
        opcionInformacion.setOnAction(opcionInformacionHandler);

        OpcionPantallaCompletaHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaHandler(stage, opcionPantallaCompleta,this);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        

        OpcionMinimizarHandler opcionMinimizarHandler = new OpcionMinimizarHandler(stage, opcionMinimizar,this);
        opcionMinimizar.setOnAction(opcionMinimizarHandler);

        opcionPantallaCompleta.setDisable(true);

        opcionMinimizar.setDisable(false);
        
        menuArchivo.getItems().addAll(opcionAbrir, new SeparatorMenuItem(), opcionSalir);
        menuInformacion.getItems().addAll(opcionInformacion);
        menuVer.getItems().addAll(opcionPantallaCompleta,opcionMinimizar);

        this.getMenus().addAll(menuArchivo, menuVer, menuInformacion);
    }

    public void aplicacionMaximizada(Boolean estaMaximizada) {
        opcionPantallaCompleta.setDisable(estaMaximizada);
        opcionMinimizar.setDisable(!estaMaximizada);
    }

}
