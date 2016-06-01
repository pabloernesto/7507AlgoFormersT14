package fiuba.algo3.algoformers.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV_Parser
{
	/* Devuelve un arrayList con tres listas de Strings:
	 * 1: Nombre,Vida,TipoAlterno
	 * 2: Ataque,Velocidad,Distancia (humanoide)
	 * 3: Ataque,Velocidad,Distancia (alterno)
	 * El que recibe tiene que convertir a int los datos que son numeros
	 */
    public static ArrayList<String[]> csvToArraysOfStrings(String nombreDeArchivo)
        throws IOException
    {
    	FileReader reader = null;
		try {
			reader = new FileReader(nombreDeArchivo);
		} catch (FileNotFoundException e) {
			throw new IOException();
		}
        
        BufferedReader bReader = new BufferedReader(reader);
        ArrayList<String[]> outp = new ArrayList<String[]>();
        
        String linea;
        while ((linea = bReader.readLine()) != null)
        {
        	String[] campos = linea.split(",");
        	outp.add(campos);
        }
        bReader.close();
        return outp;   
    }

}
