package fiuba.algo3.algoformers.modelo;

public class EstadoAF
{
    ModoAlgoFormer modo;
    int ataque;
    int distanciaDeAtaque;
    int velocidad;
    
    public EstadoAF(ModoAlgoFormer modo, int ataque, int distanciaDeAtaque,
        int velocidad)
    {
        this.modo = modo;
        this.ataque = ataque;
        this.distanciaDeAtaque = distanciaDeAtaque;
        this.velocidad = velocidad;
    }
    
    public ModoAlgoFormer getModo()
    {
        return modo;
    }

    public int getAtaque()
    {
        return ataque;
    }

    public int getDistanciaDeAtaque()
    {
        return distanciaDeAtaque;
    }

    public int getVelocidad()
    {
        return velocidad;
    }
}
