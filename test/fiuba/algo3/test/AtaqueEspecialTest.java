package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;

public class AtaqueEspecialTest {

	@Test
	public void test01() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Squirtle());
		Turno turno = new Turno(jugador1, jugador2);
		
		//La primera linea corresponde al J1 y a Jigglypuff, la segunda al cambiar de jugador, pasa a Squirtle.
		//Cada vez que se llama a 'jugar', pasa el turno y se cambia de jugador
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Burbuja(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Burbuja(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Burbuja(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Como Squirtle estaba dormido,no le pudo sacar vida a Jigglypuff y su vida sigue siendo la maxima
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test02() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Squirtle());
		Turno turno = new Turno(jugador1, jugador2);
		
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Burbuja(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Burbuja(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Burbuja(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		assertEquals(120, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);

		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Burbuja(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Una vez que pasaron los 3 turnos, squirtle pudo atacar y le saco vida a Jigglypuff
		assertEquals(120, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		
	}
	
	@Test
	public void test03() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setAlgomon(new Charmander());
		jugador2.setAlgomon(new Squirtle());			//Vida de Squirtle 150
		Turno turno = new Turno(jugador1, jugador2);
		
		//Fogonazo activa su efecto especial de sacar el 10% cuando el Algomon afectado realiza una accion(atacar o recibir elemento)
		//Tambien saca 1 de vida pq su danio es 2 y como es tipo fuego con agua saca la mitad.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Como realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 15 de vida (10% de su vida max)
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Burbuja(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Ataque Rapido tiene un danio de 10
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		
		//Total: 1 + 15 + 10 = 26, 150 - 26 = 124
		assertEquals(124, turno.jugadorActivo().getAlgomonActivo().vida(),0.001D);
	}

	@Test
	public void testJigglypuffAgotaCanto() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
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
		
		//Jigglypuff usa Canto seis veces.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//JigglypuffYaNoPuedeUsarCanto.
		assertFalse(turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo())));
	}
	
}
