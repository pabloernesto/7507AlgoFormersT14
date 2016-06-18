package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.escenario.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

	public class Aplicacion extends Application {

	    public static void main(String[] args) {
	        launch(args);
	    }

	    @Override
	    public void start(final Stage stage) throws Exception {
	    	
	    	Tablero tablero = Tablero.getInstance();
	        stage.setTitle("Juego Algoformers");
	        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage,tablero); //, algoformer);
	        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
	        /*
	        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
	        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
	        */
	        ContenedorReglas contenedorReglas = new ContenedorReglas(stage, escenaJuego);
	        Scene escenaReglas = new Scene(contenedorReglas, 640, 480);
	        
	        Bienvenida contenedorBienvenidos = new Bienvenida(stage, escenaReglas);
	        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);


	        stage.setScene(escenaBienvenidos);
	        stage.setFullScreen(true);
	        stage.setFullScreenExitHint("");

	        stage.show();

	    }

}
