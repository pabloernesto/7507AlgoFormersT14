package fiuba.algo3.algoformers.vista.eventos;

import java.util.List;

import fiuba.algo3.algoformers.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

public class BotonAceptarEventHandler implements EventHandler<ActionEvent>{

	private TextField texto;
    private Label etiqueta;
    private List<String> nombresJugadores;
    private Juego juego;
    private Scene proximaEscena;
    private Stage stage;
    private Text jugador;

    public BotonAceptarEventHandler(TextField texto, Label etiqueta, Text jugador, List<String> nombresJugadores,Juego juego, Scene proxima, Stage stage) {
        this.texto = texto;
        this.etiqueta = etiqueta;
        this.nombresJugadores = nombresJugadores;
        this.juego = juego;
        this.stage = stage;
        this.jugador = jugador;
        proximaEscena = proxima;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    	if (texto.getText().trim().equals("")){
            etiqueta.setText("Debe ingresar un texto");
            etiqueta.setTextFill(Color.web("#FF0000")); // Rojo
        }
    	else if (nombresJugadores.contains(texto.getText())){
    		etiqueta.setText("Ese nombre ya esta en uso. Elija otro");
        	etiqueta.setTextFill(Color.web("#FF0000"));
    	}
    	else {
        	nombresJugadores.add(texto.getText());
        	if (nombresJugadores.size() == 2){
        		juego.crearJugadores(nombresJugadores.get(0), nombresJugadores.get(1));
        		stage.setScene(proximaEscena);
        		stage.setFullScreenExitHint("");
                stage.setFullScreen(true);
        	}
			texto.setText("");
			texto.setFocusTraversable(false);
			texto.setPromptText("Ingrese su nombre");
			etiqueta.setText("");
			jugador.setText("Jugador Decepticons");
			AudioClip audioBoton = new AudioClip("file:src/fiuba/algo3/algoformers/sonidos/boton2.mp3");
			 audioBoton.play();
			}
    }
}
