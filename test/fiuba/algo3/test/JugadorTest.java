package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Algomones.Charmander;
import modelo.*;

public class JugadorTest {

	@Test
	public void test01JugadorAgregaAlgomon() {
		Jugador jugador1 = new Jugador();
		Charmander charmander = new Charmander();
		jugador1.setAlgomon(charmander);
		
		assertEquals(charmander, jugador1.getAlgomonActivo());
	}
	
	
	@Test
	public void test02JugadorEstableceOponenete() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setOponente(jugador2);
		
		assertEquals(jugador2, jugador1.getOponente());
	}
}
