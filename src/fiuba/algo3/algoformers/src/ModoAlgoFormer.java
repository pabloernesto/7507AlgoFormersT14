package fiuba.algo3.algoformers.modelo;

import java.util.Map;
import java.util.HashMap;

public enum ModoAlgoFormer
{
    HUMANOIDE("humanoide"), TERRESTRE("terrestre"), AEREO("aereo");
    
    private String nombre;
    
    ModoAlgoFormer(String n)
    {
        nombre = n;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    private static final Map<String, ModoAlgoFormer> table
        = new HashMap<String, ModoAlgoFormer>();

    static {
        for(ModoAlgoFormer maf : ModoAlgoFormer.values())
            table.put(maf.getNombre(), maf);
    }

    public static ModoAlgoFormer get(String nombre)
    {
        return table.get(nombre);
    }
}
