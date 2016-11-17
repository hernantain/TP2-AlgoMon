package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.*;

public class DormirDecoratorTest {
	@Test
	public void test01JigglypuffAtacaConCantoYElOponenteNoPuedeAtacarPrimerTurno() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Squirtle());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Jigglypuff conserva toda la vida ya que Squirtle no lo pudo atacar por encontrarse dormido.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test02JigglypuffAtacaConCantoYElOponenteNoPuedeAtacarSegundoTurno() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Squirtle());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Jigglypuff conserva toda la vida ya que Squirtle no lo pudo atacar por encontrarse dormido.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test03JigglypuffAtacaConCantoYElOponenteNoPuedeAtacarTercerTurno() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Squirtle());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Jigglypuff conserva toda la vida ya que Squirtle no lo pudo atacar por encontrarse dormido.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test04JigglypuffAtacaConCantoYElOponentePuedeAtacarCuartoTurno() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Squirtle());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se desperto y ahora puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Jigglypuff recibio el ataque rapido de Squirtle.
		assertEquals(120.0, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test05ChanseyAtacaConCantoYElOponenteNoPuedeAtacarPrimerTurno() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Chansey());
		jugador2.setAlgomon(new Squirtle());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Chansey conserva toda la vida ya que Squirtle no lo pudo atacar por encontrarse dormido.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test06ChanseyAtacaConCantoYElOponenteNoPuedeAtacarSegundoTurno() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Chansey());
		jugador2.setAlgomon(new Squirtle());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Chansey conserva toda la vida ya que Squirtle no lo pudo atacar por encontrarse dormido.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test07ChanseyAtacaConCantoYElOponenteNoPuedeAtacarTercerTurno() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Chansey());
		jugador2.setAlgomon(new Squirtle());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Chansey conserva toda la vida ya que Squirtle no lo pudo atacar por encontrarse dormido.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test08ChanseyAtacaConCantoYElOponentePuedeAtacarCuartoTurno() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Chansey());
		jugador2.setAlgomon(new Squirtle());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se encuentra dormido y no puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle se desperto y ahora puede atacar.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Chansey recibio el ataque rapido de Squirtle.
		assertEquals(120.0, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
}
