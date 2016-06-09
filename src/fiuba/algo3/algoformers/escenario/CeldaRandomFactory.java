package fiuba.algo3.algoformers.escenario;

import fiuba.algo3.algoformers.escenario.superficies.*;

import java.util.Random;

public class CeldaRandomFactory extends CeldaFactory {

    private Random generator;

    public CeldaRandomFactory()
    {
        generator = new Random();
    }
    
    public CeldaRandomFactory(long randomGeneratorSeed)
    {
        generator = new Random(randomGeneratorSeed);
    }

	public Celda getCelda()
	{
	    return new Celda(sueloAleatorio(), cieloAleatorio());
	}
	
	private SuperficieTerrestre sueloAleatorio()
	{
	    switch (generator.nextInt(3))
	    {
	        case 0:
	            return new Rocosa();
	        case 1:
	            return new Pantano();
	        case 2:
	            return new Espinas();
	    }
	    return null;
	}
	
	private SuperficieAerea cieloAleatorio()
	{
	    switch (generator.nextInt(3))
	    {
	        case 0:
	            return new Nube();
	        case 1:
	            return new NebulosaDeAndromeda();
	        case 2:
	            return new TormentaPsionica();
	    }
	    return null;
	}

}

