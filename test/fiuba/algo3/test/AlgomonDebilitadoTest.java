package test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Algomones.*;
import Ataques.*;
import modelo.*;
import Acciones.*;

public class AlgomonDebilitadoTest {

	@Test
	public void test01AlgomonDebilitadoNoPuedeAtacar() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Charmander());
		jugador2.setAlgomon(new Bulbasaur());
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
		try{
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		}catch (AlgomonDebilitadoExcepcion e){};
		//Este ataque no debería hacerse, Charmander debería quedar con 142 de vida.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		assertEquals(turno.jugadorActivo().getAlgomonActivo().vida(), 142, 0.001D);
	}
}
