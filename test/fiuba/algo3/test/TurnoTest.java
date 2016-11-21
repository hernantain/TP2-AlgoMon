package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Acciones.Atacar;
import Algomones.Charmander;
import Algomones.Jigglypuff;
import Ataques.AtaqueConEfectoDormir;
import Ataques.Brasas;
import Ataques.Canto;
import modelo.*;

public class TurnoTest {

	@Test
	public void test01TurnoPrimerJugadorAntesDeEmpezar() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Turno turno = new Turno(jugador1, jugador2);
		
		assertEquals(jugador1, turno.jugadorActivo());
	}
	
	@Test
	public void test02NoTurnoSegundoJugadorAntesDeEmpezar() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Turno turno = new Turno(jugador1, jugador2);
		
		assertEquals(jugador2, turno.jugadorNoActivo());
	}
	
	@Test
	public void test03TurnoCambiarJugador() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.cambiarJugador();
		
		assertEquals(jugador2, turno.jugadorActivo());
	}
	
	@Test
	public void test04TurnoPrimerJugadorConJuegoEmpezado() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Charmander());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		assertEquals(jugador1, turno.jugadorActivo());
	}
	
	@Test
	public void test05TurnoSegundoJugadorConJuegoEmpezado() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Charmander());
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		assertEquals(jugador2, turno.jugadorActivo());
	}
}
