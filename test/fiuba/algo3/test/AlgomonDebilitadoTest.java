package test;


import static org.junit.Assert.*;

import org.junit.Test;

import Algomones.*;
import Ataques.*;
import Elementos.Pocion;
import modelo.*;
import Acciones.*;

public class AlgomonDebilitadoTest {

	@Test
	public void test01JugadorConAlgomonRecienDebilitadoNoPuedeAtacar() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Charmander());
		jugador2.setAlgomon(new Bulbasaur());
		Turno turno = new Turno(jugador1, jugador2);
		boolean sePudoAtacar = true;
		
		//Bulbasaur queda con 108 de vida. Charmander 163.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));

		//Bulbasaur queda con 76 de vida. Charmander 156.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Bulbasaur queda con 44 de vida. Charmander 149.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Bulbasaur queda con 12 de vida. Charmander 142.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Bulbasaur queda debilitado.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		//Este ataque no debería poder hacerse.
			try {
				turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			} catch (AlgomonDebilitadoExcepcion e) {
				sePudoAtacar = false;
			}
		assertFalse(sePudoAtacar);
	}
	
	@Test
	public void test02JugadorConAlgomonDebilitadoNoPuedeUsarElemento() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Charmander());
		jugador2.setAlgomon(new Bulbasaur());
		Turno turno = new Turno(jugador1, jugador2);
		boolean sePudoUsarElemento = true;
		
		//Bulbasaur queda con 108 de vida. Charmander 163.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));

		//Bulbasaur queda con 76 de vida. Charmander 156.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Bulbasaur queda con 44 de vida. Charmander 149.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Bulbasaur queda con 12 de vida. Charmander 142.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Bulbasaur queda debilitado.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		//Este elemento no debería poder usarse.
			try {
				turno.jugar(new UsarElemento(turno.jugadorActivo(), new Pocion()));
			} catch (AlgomonDebilitadoExcepcion e) {
				sePudoUsarElemento = false;
			}
		assertFalse(sePudoUsarElemento);
	}
	
	@Test
	public void test03JugadorConAlgomonDebilitadoPuedeCambiarAlgomon() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Charmander());
		jugador2.setAlgomon(new Bulbasaur());
		Algomon squirtle = new Squirtle();
		jugador2.setAlgomon(squirtle);
		Turno turno = new Turno(jugador1, jugador2);
		
		//Bulbasaur queda con 108 de vida. Charmander 163.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));

		//Bulbasaur queda con 76 de vida. Charmander 156.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Bulbasaur queda con 44 de vida. Charmander 149.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Bulbasaur queda con 12 de vida. Charmander 142.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Bulbasaur queda debilitado.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//El algomon debilitado puede ser reemplazado.
		try {
			turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), new Squirtle()));
		} catch (AlgomonDebilitadoExcepcion e) {
			throw new AlgomonDebilitadoExcepcion();
		}
		assertEquals(jugador2.getAlgomonActivo(), squirtle);
	}
}
