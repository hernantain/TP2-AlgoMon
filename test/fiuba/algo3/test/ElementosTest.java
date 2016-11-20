package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.*;

public class ElementosTest {
	
	@Test
	public void test01SeLeAplicaUnaPocionAJigglypuff() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Charmander());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Se le aplica a Jigglypuff (que ya habia recibido 20 puntos de danio) una pocion.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new Pocion()));
		
		// Como la pocion recupera 20 puntos, Jigglypuff vuelve a tener su vida al maximo.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorNoActivo().getAlgomonActivo().vida(), 0.001D);
	}
}
