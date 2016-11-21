package test;

import Acciones.Atacar;
import Acciones.UsarElemento;
import Algomones.Charmander;
import Algomones.Jigglypuff;
import Ataques.AtaqueConEfectoDormir;
import Ataques.AtaqueRapido;
import Ataques.Canto;
import Elementos.Pocion;
import Elementos.Vitamina;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;

public class ElementosTest {
	
	@Test
	public void test01SeLeAplicaUnaPocionAJigglypuff() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
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
		assertEquals(turno.jugadorNoActivo().getAlgomonActivo().getVidaMax(), turno.jugadorNoActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void testSeleAplicaUnaVitaminaAJigglypuff() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Charmander());
		Turno turno = new Turno(jugador1, jugador2);
		
		//Jigglypuff usa Canto una vez.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Jigglypuff usa Canto dos veces.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
	
		//Jigglypuff usa Canto tres veces.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Jigglypuff usa Canto cuatro veces.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Jigglypuff usa Canto cinco veces.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Jigglypuff usa Canto seis veces y lo agota.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Jigglypuff usa una Vitamina.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new Vitamina()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));

		//Jigglypuff puede volver a usar Canto.
		assertTrue(turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo())));
	}
}
