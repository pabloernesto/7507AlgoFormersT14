package fiuba.algo3.algoformers.modelo;

import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.FileNotFoundException;

public class AlgoFormer
{
    Tablero tablero = Tablero.getInstance();

    String nombre;
    int vidaActual;
    int vidaMaxima;
    int movimientoRestante = 8;
    EstadoAF estadoActivo;
    EstadoAF estadoAlterno;
    
    public AlgoFormer(){}

    public AlgoFormer(String nombreDeArchivo)
    {
        FileInputStream fis;
        try {
            fis = new FileInputStream(nombreDeArchivo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
        StreamTokenizer tokenStream =
            new StreamTokenizer(
                new BufferedReader(
                new InputStreamReader(fis)));
        
        // Cargar datos de AlgoFormer
        try {
            tokenStream.nextToken();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        String nombre = tokenStream.sval;

        try {
            tokenStream.nextToken();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        int vida = (int) tokenStream.nval;
        
        // Cargar primer estado
        try {
            tokenStream.nextToken();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        String nombreDelModo = tokenStream.sval;
        ModoAlgoFormer modo = ModoAlgoFormer.get(nombreDelModo);

        try {
            tokenStream.nextToken();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        int ataque = (int) tokenStream.nval;

        try {
            tokenStream.nextToken();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        int velocidad = (int) tokenStream.nval;

        try {
            tokenStream.nextToken();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        int distancia = (int) tokenStream.nval;
        
        EstadoAF estadoInicial =
            new EstadoAF(modo, ataque, distancia, velocidad);

        // Cargar segundo estado
        // Codigo duplicado. Como lo saco?
        try {
            tokenStream.nextToken();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        nombreDelModo = tokenStream.sval;
        modo = ModoAlgoFormer.get(nombreDelModo);

        try {
            tokenStream.nextToken();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        ataque = (int) tokenStream.nval;

        try {
            tokenStream.nextToken();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        velocidad = (int) tokenStream.nval;

        try {
            tokenStream.nextToken();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        distancia = (int) tokenStream.nval;
        
        EstadoAF estadoAlterno =
            new EstadoAF(modo, ataque, distancia, velocidad);
        
        // crear EstadoAF
        this.init(nombre, vida, estadoInicial, estadoAlterno);
    }

    public void init(String nombre, int vida,
        EstadoAF estadoInicial, EstadoAF estadoAlterno)
    {
        this.nombre = nombre;
        vidaMaxima = vida;
        vidaActual = vida;
        estadoActivo = estadoInicial;
        this.estadoAlterno = estadoAlterno;
    }

    public void mover(Movimiento d)
    {
        tablero.mover(d, this);
    }

    public void moverACelda(Celda c)
    {
        int costo = c.getCostoDeEntrada(ModoAlgoFormer.HUMANOIDE);
        if (costo > movimientoRestante)
            throw new RuntimeException();
        movimientoRestante -= costo;
    }
    
    public int getMovimientoRestante()
    {
        return movimientoRestante;
    }
}
