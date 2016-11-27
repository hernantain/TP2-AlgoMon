package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Acciones.Atacar;
import Acciones.CambiarAlgomonActivo;
import Acciones.UsarElemento;
import Algomones.Bulbasaur;
import Algomones.Chansey;
import Algomones.Charmander;
import Algomones.Jigglypuff;
import Algomones.Rattata;
import Algomones.Squirtle;
import Ataques.AtaqueConEfectoDormir;
import Ataques.AtaqueConEfectoQuemar;
import Ataques.AtaqueRapido;
import Ataques.Canto;
import Ataques.Fogonazo;
import Elementos.Vitamina;
import modelo.*;

public class EstadosSimultaneosTest {

	@Test
	public void test01AlgomonDormidoYQuemadoNoPuedeAtacar(){
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
		// Squirtle intenta atacar pero no puede por estar dormido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Jigglypuff es cambiado por Charmander.
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), new Charmander()));
		// Squirtle intenta atacar pero no puede por estar dormido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Charmander ataca con Fogonazo, por lo tanto, Squirtle pasa a estar quemado.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle intenta atacar pero no puede por estar dormido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Al no haber podido atacar, Squirtle no le causo ningun danio a Charmander.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test02AlgomonDormidoYQuemadoSeQuema(){
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
		// Squirtle intenta atacar pero no puede por estar dormido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Jigglypuff es cambiado por Charmander.
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), new Charmander()));
		// Squirtle intenta atacar pero no puede por estar dormido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Charmander ataca con Fogonazo, por lo tanto, Squirtle pasa a estar quemado y recibe un punto de danio.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Al intentar atacar, Squirtle recibe de danio un 10% de su vida (15 puntos).
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// 1 + 15 = 16; 150 - 16 = 134.
		assertEquals(134.0, turno.jugadorNoActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test03AlgomonQuemadoYDormidoNoPuedeAtacar(){
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
		// Squirtle ataca a Charmander con Ataque Rapido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Charmander es cambiado por Jigglypuff.
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), new Jigglypuff()));
		// Se le aplica una vitamina a Squirlte.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new Vitamina()));
		
		// Jigglypuff ataca con Canto y Squirtle pasa a estar dormido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle intenta atacar pero no puede por estar dormido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Al no haber podido atacar, Squirtle no le causo ningun danio a Jigglypuff.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void test04AlgomonQuemadoYDormidoSeQuema(){
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Charmander());
		jugador2.setAlgomon(new Squirtle());
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Bulbasaur());
		jugador1.setAlgomon(new Rattata());
		jugador2.setAlgomon(new Chansey());
		Turno turno = new Turno(jugador1, jugador2);
		
		// Charmander ataca con Fogonazo, por lo tanto, Squirtle pasa a estar quemado y recibe un punto de danio.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Al atacar, Squirtle recibe de danio un 10% de su vida (15 puntos).
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Charmander es cambiado por Jigglypuff.
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), new Jigglypuff()));
		// Al atacar, Squirtle recibe de danio un 10% de su vida (15 puntos).
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Jigglypuff ataca con Canto y Squirtle pasa a estar dormido.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		// Squirtle intenta atacar pero no puede por estar dormido y recibe de danio un 10% de su vida (15 puntos).
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// 1 + 15 + 15 + 15 = 46; 150 - 46 = 104.
		assertEquals(104.0, turno.jugadorNoActivo().getAlgomonActivo().vida(), 0.001D);
	}
}
