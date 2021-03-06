package fiuba.algo3.algoformers.factories;

import fiuba.algo3.algoformers.escenario.Celda;
import fiuba.algo3.algoformers.escenario.superficies.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CeldaRandomFactory implements CeldaFactory {

    private Random generador;

    public CeldaRandomFactory()
    {
        generador = new Random();
    }
    
    public CeldaRandomFactory(long randomGeneratorSeed)
    {
        generador = new Random(randomGeneratorSeed);
    }

	public Celda getCelda()
	{
	    return new Celda(sueloAleatorio(), cieloAleatorio());
	}
	
	private SuperficieTerrestre sueloAleatorio()
	{
		List<SuperficieTerrestre> opciones = new ArrayList<SuperficieTerrestre>();
		opciones.add(new Rocosa());
		opciones.add(new Pantano());
		opciones.add(new Espinas());
		int eleccion = generador.nextInt(3);
		return opciones.get(eleccion);
	}
	
	private SuperficieAerea cieloAleatorio()
	{
		List<SuperficieAerea> opciones = new ArrayList<SuperficieAerea>();
		opciones.add(new Nube());
		opciones.add(new NebulosaDeAndromeda());
		opciones.add(new TormentaPsionica());
		int eleccion = generador.nextInt(3);
		return opciones.get(eleccion);
	}

}

