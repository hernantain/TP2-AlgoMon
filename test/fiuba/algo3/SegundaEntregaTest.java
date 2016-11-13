package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.*;

public class SegundaEntregaTest {

	//PUNTO 1 DE LA ENTREGA
	
		@Test
		public void test01JigglypuffAtacaConCantoYElOponenteNoPuedeAtacarPrimerTurno() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Jigglypuff());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Canto", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Brasas", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Jigglypuff conserva toda la vida ya que Charmander no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test02JigglypuffAtacaConCantoYElOponenteNoPuedeAtacarSegundoTurno() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Jigglypuff());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Canto", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Brasas", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Brasas", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Jigglypuff conserva toda la vida ya que Charmander no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test03JigglypuffAtacaConCantoYElOponenteNoPuedeAtacarTercerTurno() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Jigglypuff());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Canto", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Brasas", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Brasas", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Brasas", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Jigglypuff conserva toda la vida ya que Charmander no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test04JigglypuffAtacaConCantoYElOponentePuedeAtacarCuartoTurno() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Jigglypuff());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Canto", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Brasas", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Brasas", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Brasas", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se despertó y ahora puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Brasas", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Jigglypuff recibió el ataque rápido de Charmander.
			assertEquals(114.0, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test05ChanseyAtacaConCantoYElOponenteNoPuedeAtacarPrimerTurno() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Chansey());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Canto", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Chansey conserva toda la vida ya que Rattata no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test06ChanseyAtacaConCantoYElOponenteNoPuedeAtacarSegundoTurno() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Chansey());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Canto", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Chansey conserva toda la vida ya que Rattata no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test07ChanseyAtacaConCantoYElOponenteNoPuedeAtacarTercerTurno() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Chansey());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Canto", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Chansey conserva toda la vida ya que Rattata no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test08ChanseyAtacaConCantoYElOponentePuedeAtacarCuartoTurno() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Chansey());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Canto", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se despertó y ahora puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Chansey recibió el ataque rápido de Rattata.
			assertEquals(120.0, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		
		//PUNTO 5 DE LA ENTREGA
		
		@Test
		public void test09CharmanderAtacaConFogonazoARattata() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Charmander());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Rattata un danio de 2 puntos por ser un Algomon de tipo normal.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Fogonazo", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Rattata realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 17 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 2 + 17 = 19, 170 - 19 = 151
			assertEquals(151.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test10CharmanderAtacaConFogonazoABulbasaur() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Charmander());
			jugador2.setAlgomon(new Bulbasaur());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Bulbasaur un danio de 4 puntos por ser un Algomon de tipo planta.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Fogonazo", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Bulbasaur realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 14 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 4 + 14 = 18, 140 - 18 = 122
			assertEquals(122.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test11CharmanderAtacaConFogonazoASquirtle() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Charmander());
			jugador2.setAlgomon(new Squirtle());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Squirtle un danio de 1 punto por ser un Algomon de tipo agua.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Fogonazo", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Squirtle realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 15 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 1 + 15 = 16, 150 - 16 = 134
			assertEquals(134.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test11RattataAtacaConFogonazoACharmander() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Rattata());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Charmander un danio de 1 punto por ser un Algomon de tipo fuego.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Fogonazo", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Charmander realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 17 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 1 + 17 = 18, 170 - 18 = 152
			assertEquals(152.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test12RattataAtacaConFogonazoAChansey() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Rattata());
			jugador2.setAlgomon(new Chansey());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Chansey un danio de 2 puntos por ser un Algomon de tipo normal.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Fogonazo", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Chansey realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 13 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 2 + 13 = 15, 130 - 15 = 115
			assertEquals(115.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test13RattataAtacaConFogonazoAJigglypuff() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Rattata());
			jugador2.setAlgomon(new Jigglypuff());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Jigglypuff un danio de 2 puntos por ser un Algomon de tipo normal.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Fogonazo", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Jigglypuff realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 13 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 2 + 13 = 15, 130 - 15 = 115
			assertEquals(115.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test14RattataAtacaConFogonazoAJigglypuffEfectoALargoPlazo() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			jugador1.setAlgomon(new Rattata());
			jugador2.setAlgomon(new Jigglypuff());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Jigglypuff un danio de 2 puntos por ser un Algomon de tipo normal.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Fogonazo", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Jigglypuff realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 13 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Rattata ataca con Ataque Rapido infringiendole 10 puntos de daño adicionales a Jigglypuff.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Jigglypuff realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 13 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), "Ataque Rapido", turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 2 + 13 + 10 + 13 = 38, 130 - 38 = 92
			assertEquals(92.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
}
