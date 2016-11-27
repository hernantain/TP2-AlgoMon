package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Acciones.Atacar;
import Acciones.CambiarAlgomonActivo;
import Acciones.UsarElemento;
import Algomones.*;
import Ataques.AtaqueConEfectoDormir;
import Ataques.AtaqueConEfectoQuemar;
import Ataques.AtaqueRapido;
import Ataques.Canto;
import Ataques.Fogonazo;
import Elementos.Pocion;
import modelo.AlgomonRepetidoExcepcion;
import modelo.Jugador;
import modelo.LimiteDeAlgomonesAlcanzadoExcepcion;
import modelo.Turno;

public class SupuestosTest {
	
	@Test
	public void test01CadaJugadorEligeTresAlgomones() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		
		boolean sePudoElegirCuartoAlgomon = true;
				
		Jigglypuff jigglypuff = new Jigglypuff();
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		Chansey chansey_1 = new Chansey();
				
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		
		jugador1.setAlgomon(jigglypuff);
		jugador2.setAlgomon(bulbasaur);
		
		jugador1.setAlgomon(rattata);
		jugador2.setAlgomon(squirtle);

		jugador1.setAlgomon(charmander);
		jugador2.setAlgomon(chansey);
		
		//No deberia poder realizarse
		try {
			jugador1.setAlgomon(chansey_1);
		} catch (LimiteDeAlgomonesAlcanzadoExcepcion e) {
			sePudoElegirCuartoAlgomon = false;
		}
		
		assertFalse(sePudoElegirCuartoAlgomon);
	}
	
	@Test
	public void test02LosJugadoresNoPuedenTenerAlgomonesRepetidos() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		
		boolean sePudoElegirAlgomonRepetido = true;
				
		Jigglypuff jigglypuff = new Jigglypuff();
		Chansey chanseyRepetido = new Chansey();
				
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		
		jugador1.setAlgomon(jigglypuff);
		jugador2.setAlgomon(bulbasaur);
		
		jugador1.setAlgomon(chansey);
		jugador2.setAlgomon(squirtle);

		//jugador 1 no deberia poder volver a elegir un Chansey
		try{
			jugador1.setAlgomon(chanseyRepetido);
		} catch (AlgomonRepetidoExcepcion e) {
			sePudoElegirAlgomonRepetido = false;
		}
		
		assertFalse(sePudoElegirAlgomonRepetido);
	}
	
	@Test
	public void test03AlgomonQuemadoNoSeQuemaEnElBanco() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Charmander());
		jugador2.setAlgomon(new Squirtle());
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Bulbasaur());
		jugador1.setAlgomon(new Rattata());
		jugador2.setAlgomon(new Chansey());
		Turno turno = new Turno(jugador1, jugador2);
		
		// Charmander ataca con Fogonazo, por lo tanto, Squirtle pasa a estar quemado.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle es cambiado por Bulbasaur.
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), new Bulbasaur()));
		
		// Charmander ataca a Bulbasaur.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Bulbasaur ataca a Charmander.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Charmander ataca a Bulbasaur.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Bulbasaur ataca a Charmander.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Charmander ataca a Bulbasaur.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle vuelve reemplazando a Bulbasaur.
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), new Squirtle()));
		
		// Mientras estuvo en el banco Squirtle no recibio danio por estar quemdado, por lo tanto conserva su vida.
		assertEquals(turno.jugadorNoActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test04AlgomonDormidoNoSeDespiertaEnElBanco() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Squirtle());
		jugador1.setAlgomon(new Charmander());
		jugador2.setAlgomon(new Bulbasaur());
		jugador1.setAlgomon(new Rattata());
		jugador2.setAlgomon(new Chansey());
		Turno turno = new Turno(jugador1, jugador2);
		
		// Jigglypuff ataca con Canto y Squirtle pasa a estar dormido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle es cambiado por Bulbasaur.
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), new Bulbasaur()));
		
		// Jigglypuff ataca a Bulbasaur.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Se le aplica una pocion a Bulbasaur.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new Pocion()));
		
		// Jigglypuff ataca a Bulbasaur.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Se le aplica una pocion a Bulbasaur.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new Pocion()));
		
		// Jigglypuff ataca a Bulbasaur.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Se le aplica una pocion a Bulbasaur.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new Pocion()));
		
		// Jigglypuff ataca a Bulbasaur.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle vuelve reemplazando a Bulbasaur.
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), new Squirtle()));
		
		// Jigglypuff ataca a Squirtle.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle intenta atacar a Jigglypuff pero se encuentra dormido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Como Squirtle estaba dormido y no pudo atacar, Jigglypuff conserva su vida.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);		
	}
}
