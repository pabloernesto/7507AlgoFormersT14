package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.eventos.AplicacionOnKeyPressEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

	public class Aplicacion extends Application {

	    public static void main(String[] args) {
	        launch(args);
	    }

	    @Override
	    public void start(final Stage stage) throws Exception {
	    	
	    	AudioClip audioIntro = new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/musicaFondo.mp3");
	        audioIntro.setCycleCount(2);
	        audioIntro.play();
	        
	        BarraDeMenu menuBar = new BarraDeMenu(stage, audioIntro);
	    	
	    	Juego juego = new Juego();
	        stage.setTitle("Juego Algoformers");
	        ContenedorPrincipal contenedorPrincipal = 
	        		new ContenedorPrincipal(stage, juego, menuBar);
	        Scene escenaJuego = 
	        		new Scene(contenedorPrincipal, 640, 480);
	        
	        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = 
	        		new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
	        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
	        
	        ContenedorEleccionJugador contenedorEleccion = 
	        		new ContenedorEleccionJugador(stage, escenaJuego, juego, contenedorPrincipal);
	        Scene escenaEleccion = 
	        new Scene(contenedorEleccion, 640, 480);
	        
	        ContenedorReglas contenedorReglas = 
	        		new ContenedorReglas(stage, escenaEleccion);
	        Scene escenaReglas = new Scene(contenedorReglas, 640, 480);
	        
	        Bienvenida contenedorBienvenidos = 
	        		new Bienvenida(stage, escenaReglas);
	        Scene escenaBienvenidos = 
	        		new Scene(contenedorBienvenidos, 640, 480);
	        
	        stage.setScene(escenaBienvenidos);
	        stage.setFullScreen(true);
	        stage.setFullScreenExitHint("");

	        stage.show();
	        
	    }

}
