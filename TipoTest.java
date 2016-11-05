import static org.junit.Assert.*;

import org.junit.Test;

public class TipoTest {

	@Test
	public void test() {
		TipoAgua agua = new TipoAgua();
		TipoPlanta planta = new TipoPlanta();
		assertEquals(2.0, planta.conTipo(agua), 0.001D);
	}

}
