package fiuba.algo3.algoformers.vista;

import fiuba.algo3.algoformers.juego.Juego;
import fiuba.algo3.algoformers.vista.eventos.AplicacionOnKeyPressEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

// Imports para juego rocas y nubes.
import fiuba.algo3.algoformers.escenario.Tablero;
import fiuba.algo3.algoformers.factories.RocasYNubesFactory;

	public class Aplicacion extends Application {

	    public static void main(String[] args) {
	        launch(args);
	    }

	    @Override
	    public void start(final Stage stage) throws Exception {
	        Tablero.setGeneradorDeCeldas(new RocasYNubesFactory());
	    	
	    	AudioClip audioIntro = new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/musicaFondo.mp3");
	        audioIntro.setCycleCount(2);
	        audioIntro.play();
	        
	        BarraDeMenu barraMenu = new BarraDeMenu(stage, audioIntro);
	    	
	    	Juego juego = new Juego();
	        stage.setTitle("Juego Algoformers");
	        ContenedorPrincipal contenedorPrincipal = 
	        		new ContenedorPrincipal(stage, juego, barraMenu);
	        Scene escenaJuego = 
	        		new Scene(contenedorPrincipal, 640, 480);
	        
	        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = 
	        		new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
	        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
	        
	        ContenedorEleccionJugador contenedorEleccion = 
	        		new ContenedorEleccionJugador(stage, escenaJuego, juego, contenedorPrincipal);
	        Scene escenaEleccion = 
	        		new Scene(contenedorEleccion, 640, 480);
	        escenaEleccion.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
	        
	        ContenedorReglas contenedorReglas = 
	        		new ContenedorReglas(stage, escenaEleccion);
	        Scene escenaReglas = new Scene(contenedorReglas, 640, 480);
	        escenaReglas.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
	        
	        Bienvenida contenedorBienvenidos = 
	        		new Bienvenida(stage, barraMenu, audioIntro, escenaReglas);
	        Scene escenaBienvenidos = 
	        		new Scene(contenedorBienvenidos, 640, 480);
	        escenaBienvenidos.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
	        
	        stage.setScene(escenaBienvenidos);
	        stage.setFullScreen(true);
	        stage.setFullScreenExitHint("");

	        stage.show();
	        
	    }

}
