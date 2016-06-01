package fiuba.algo3.algoformers.test;

import fiuba.algo3.algoformers.modelo.ModoAlgoFormer;

import junit.framework.Assert;
import org.junit.Test;

public class ModoAlgoFormerTest
{
    @Test
    public void testHumanoideEnMinusculas()
    {
        Assert.assertEquals(ModoAlgoFormer.HUMANOIDE,
            ModoAlgoFormer.get("humanoide"));
    }
}
