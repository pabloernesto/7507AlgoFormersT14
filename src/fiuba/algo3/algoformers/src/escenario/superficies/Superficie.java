package fiuba.algo3.algoformers.escenario.superficies;

import fiuba.algo3.algoformers.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.algoformers.FormaHumanoide;
import fiuba.algo3.algoformers.algoformers.FormaTerrestre;
import fiuba.algo3.algoformers.algoformers.FormaAerea;

public abstract class Superficie {

    public abstract void aplicarEfectos(AlgoFormer af,
        FormaHumanoide formaActual);

    public abstract void aplicarEfectos(AlgoFormer af,
        FormaTerrestre formaActual);

    public abstract void aplicarEfectos(AlgoFormer af, FormaAerea formaActual);

    public int costoDeEntrada(FormaHumanoide formaActual)
    {
        return 1;
    }

    public int costoDeEntrada(FormaTerrestre formaActual)
    {
        return 1;
    }

    public int costoDeEntrada(FormaAerea formaActual)
    {
        return 1;
    }
}

