package test;
import static org.junit.Assert.*;

import org.junit.Test;

import modelo.AtaqueRapido;
import modelo.LatigoCepa;
import modelo.Squirtle;

public class AtaqueTest {

	@Test
	public void testAtaqueLatigoCepaBajaLaVidaDeAlgomon() {
		LatigoCepa latigo = new LatigoCepa();
		Squirtle squirtle = new Squirtle();
		latigo.atacar(squirtle);
		assertEquals(120.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testAtaqueAtaqueRapidoBajaLaVidaDeAlgomon() {
		AtaqueRapido ataque = new AtaqueRapido();
		Squirtle squirtle = new Squirtle();
		ataque.atacar(squirtle);
		assertEquals(140.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testAtaqueUsadoMasQueSuCantidadEsFalse() {
		LatigoCepa latigo = new LatigoCepa();
		Squirtle squirtle = new Squirtle();
		for (int x = 0; x < 10; x++){
			latigo.atacar(squirtle);
		}
		assertEquals(false, latigo.atacar(squirtle));
	}
	
	@Test
	public void testAtaqueEntreAlgomones() {
		Squirtle squirtle1 = new Squirtle();
		Squirtle squirtle2 = new Squirtle();
		squirtle1.atacarACon(squirtle2, "Burbuja");
		squirtle1.atacarACon(squirtle2, "Canion de Agua");
		squirtle1.atacarACon(squirtle2, "Ataque Rapido");
		assertEquals(125.0, squirtle2.vida(), 0.001D);
	}

}
