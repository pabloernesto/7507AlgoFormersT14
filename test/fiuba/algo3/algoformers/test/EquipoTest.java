package fiuba.algo3.algoformers.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import fiuba.algo3.algoformers.modelo.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Equipo;

public class EquipoTest {

	@Test
	public void testEquipoGetCapitanDevuelveAlPrimeroDeLaLista(){
		ArrayList<AlgoFormer> listaAlgoformer = new ArrayList<AlgoFormer>();
		AlgoFormer capitan = new AlgoFormer();
		listaAlgoformer.add(capitan);
		listaAlgoformer.add(new AlgoFormer());
		listaAlgoformer.add(new AlgoFormer());
		Equipo equipo = new Equipo(listaAlgoformer);
		assertTrue(capitan == equipo.getCapitan());
	}
}
