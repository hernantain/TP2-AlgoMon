package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.*;
import Ataques.*;
import Acciones.*;
import Algomones.*;

public class SegundaEntregaTest {

	//PUNTO 1 DE LA ENTREGA
	
		@Test
		public void test01JigglypuffAtacaConCantoYElOponenteNoPuedeAtacarPrimerTurno() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Jigglypuff());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Jigglypuff conserva toda la vida ya que Charmander no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test02JigglypuffAtacaConCantoYElOponenteNoPuedeAtacarSegundoTurno() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Jigglypuff());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Jigglypuff conserva toda la vida ya que Charmander no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test03JigglypuffAtacaConCantoYElOponenteNoPuedeAtacarTercerTurno() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Jigglypuff());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Jigglypuff conserva toda la vida ya que Charmander no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test04JigglypuffAtacaConCantoYElOponentePuedeAtacarCuartoTurno() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Jigglypuff());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Charmander se desperto y ahora puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Jigglypuff recibio el ataque rapido de Charmander.
			assertEquals(114.0, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test05ChanseyAtacaConCantoYElOponenteNoPuedeAtacarPrimerTurno() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Chansey());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Chansey conserva toda la vida ya que Rattata no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test06ChanseyAtacaConCantoYElOponenteNoPuedeAtacarSegundoTurno() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Chansey());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Chansey conserva toda la vida ya que Rattata no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test07ChanseyAtacaConCantoYElOponenteNoPuedeAtacarTercerTurno() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Chansey());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Chansey conserva toda la vida ya que Rattata no lo pudo atacar por encontrarse dormido.
			assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test08ChanseyAtacaConCantoYElOponentePuedeAtacarCuartoTurno() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Chansey());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se encuentra dormido y no puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			// Rattata se desperto y ahora puede atacar.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			// Chansey recibio el ataque rapido de Rattata.
			assertEquals(120.0, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
		}
		
	//PUNTO 2 DE LA ENTREGA
		
		@Test
		public void test09BulbasaurAtacaConChupavidasACharmanderYHaceDanio() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Bulbasaur());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar bulbasaurAtacaConChupavidasACharmander = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			turno.jugar(bulbasaurAtacaConChupavidasACharmander);
			
			//vidaMax de Charmander (170) - danio de chupavidas (15 * 0,5 = 7).
			assertEquals(163, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
			
		}
		
		@Test
		public void test10BulbasaurConVidaLlenaAtacaConChupavidasACharmanderYSeCuraCero() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Bulbasaur());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar bulbasaurAtacaConChupavidasACharmander = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			turno.jugar(bulbasaurAtacaConChupavidasACharmander);

			//vidaMax de Bulbasaur (140) se mantiene.
			assertEquals(140, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
			
		}
		
		@Test
		public void test11BulbasaurConDanioRecibidoAtacaConChupavidasACharmanderYSeCuraParcial() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Charmander());
			jugador2.setAlgomon(new Bulbasaur());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar charmanderAtacaConBrasasABulbasaur = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Brasas(), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//vida de Bulbasaur (140) - danio de Brasas (16 * 2) = 108.
			turno.jugar(charmanderAtacaConBrasasABulbasaur);

			Atacar bulbasaurAtacaConChupavidasACharmander = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//danio hecho a Charmander = 15 * 0.5 = 7.
			turno.jugar(bulbasaurAtacaConChupavidasACharmander);

			//Bulbasaur se cura un 30% de 7. vida de Bulbasaur = 108 + 2 = 110.
			assertEquals(110, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
		}
		
	//PUNTO 3 DE LA ENTREGA
		
		@Test
		public void test12BulbasaurAtacaConChupavidasASquirtleYHaceDanio() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Bulbasaur());
			jugador2.setAlgomon(new Squirtle());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar bulbasaurAtacaConChupavidasASquirtle = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			turno.jugar(bulbasaurAtacaConChupavidasASquirtle);
			
			//vidaMax de Squirtle (150) - danio de chupavidas (15 * 2 = 30).
			assertEquals(120, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
			
		}
		
		@Test
		public void test13BulbasaurConVidaLlenaAtacaConChupavidasASquirtleYSeCuraCero() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Bulbasaur());
			jugador2.setAlgomon(new Squirtle());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar bulbasaurAtacaConChupavidasASquirtle = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			turno.jugar(bulbasaurAtacaConChupavidasASquirtle);

			//vidaMax de Bulbasaur (140) se mantiene.
			assertEquals(140, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
			
		}

		@Test
		public void test14BulbasaurConDanioRecibidoAtacaConChupavidasASquirtleYSeCuraParcial() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Squirtle());
			jugador2.setAlgomon(new Bulbasaur());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar squirtleAtacaConAtaqueRapidoABulbasaur = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//vida de Bulbasaur (140) - danio de AtaqueRapido (10 * 1.0) = 140.
			turno.jugar(squirtleAtacaConAtaqueRapidoABulbasaur);

			Atacar bulbasaurAtacaConChupavidasASquirtle = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//danio hecho a Squirtle = 15 * 2 = 30.
			turno.jugar(bulbasaurAtacaConChupavidasASquirtle);

			//Bulbasaur se cura un 30% de 30. vida de Bulbasaur = 130 + 9 = 139.
			assertEquals(139, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test15BulbasaurConDanioRecibidoAtacaConChupavidasASquirtleYSeCuraATope() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Squirtle());
			jugador2.setAlgomon(new Bulbasaur());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar squirtleAtacaConBurbujaABulbasaur = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Burbuja(), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//vida de Bulbasaur (140) - danio de Burbuja (10 * 0.5) = 135.
			turno.jugar(squirtleAtacaConBurbujaABulbasaur);

			Atacar bulbasaurAtacaConChupavidasASquirtle = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//danio hecho a Squirtle = 15 * 2 = 30.
			turno.jugar(bulbasaurAtacaConChupavidasASquirtle);

			//Bulbasaur se cura un 30% de 30. vida de Bulbasaur = 135 + 9 = 140 (tope).
			assertEquals(140, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
		}
		
	//PUNTO 4 DE LA ENTREGA
		
		@Test
		public void test16BulbasaurAtacaConChupavidasAChanseyYHaceDanio() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Bulbasaur());
			jugador2.setAlgomon(new Chansey());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar bulbasaurAtacaConChupavidasAChansey = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			turno.jugar(bulbasaurAtacaConChupavidasAChansey);
			
			//vidaMax de Chansey (130) - danio de chupavidas (15 * 1.0 = 15).
			assertEquals(115, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
			
		}
		
		@Test
		public void test17BulbasaurConVidaLlenaAtacaConChupavidasAChanseyYSeCuraCero() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Bulbasaur());
			jugador2.setAlgomon(new Chansey());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar bulbasaurAtacaConChupavidasAChansey = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			turno.jugar(bulbasaurAtacaConChupavidasAChansey);

			//vidaMax de Bulbasaur (140) se mantiene.
			assertEquals(140, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
			
		}
		
		@Test
		public void test18BulbasaurConDanioRecibidoAtacaConChupavidasAChanseyYSeCuraParcial() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Chansey());
			jugador2.setAlgomon(new Bulbasaur());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar chanseyAtacaConLatigoCepaABulbasaur = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//vida de Bulbasaur (140) - danio de Latigo Cepa (15 * 0.5) = 133.
			turno.jugar(chanseyAtacaConLatigoCepaABulbasaur);

			Atacar bulbasaurAtacaConChupavidasAChansey = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//danio hecho a Chansey = 15 * 1 = 15.
			turno.jugar(bulbasaurAtacaConChupavidasAChansey);

			//Bulbasaur se cura un 30% de 15. vida de Bulbasaur = 133 + 4 = 137.
			assertEquals(137, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
		}
				
		@Test
		public void test19BulbasaurAtacaConChupavidasAJigglypuffYHaceDanio() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Bulbasaur());
			jugador2.setAlgomon(new Jigglypuff());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar bulbasaurAtacaConChupavidasAJigglypuff = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			turno.jugar(bulbasaurAtacaConChupavidasAJigglypuff);
			
			//vidaMax de Jigglypuff (130) - danio de chupavidas (15 * 1.0 = 15).
			assertEquals(115, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
			
		}

		@Test
		public void test20BulbasaurConVidaLlenaAtacaConChupavidasAJigglypuffYSeCuraCero() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Bulbasaur());
			jugador2.setAlgomon(new Jigglypuff());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar bulbasaurAtacaConChupavidasAJigglypuff = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			turno.jugar(bulbasaurAtacaConChupavidasAJigglypuff);

			//vidaMax de Bulbasaur (140) se mantiene.
			assertEquals(140, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
			
		}
		
		@Test
		public void test21BulbasaurConDanioRecibidoAtacaConChupavidasAJigglypuffYSeCuraParcial() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Jigglypuff());
			jugador2.setAlgomon(new Bulbasaur());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar jigglypuffAtacaConAtaqueRapidoABulbasaur = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//vida de Bulbasaur (140) - danio de Ataque Rapido (10 * 1.0) = 130.
			turno.jugar(jigglypuffAtacaConAtaqueRapidoABulbasaur);

			Atacar bulbasaurAtacaConChupavidasAJigglypuff = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//danio hecho a Jiglypuff = 15 * 1.0 = 15.
			turno.jugar(bulbasaurAtacaConChupavidasAJigglypuff);

			//Bulbasaur se cura un 30% de 15. vida de Bulbasaur = 130 + 4 = 134.
			assertEquals(134, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
		}
		
		@Test
		public void test22BulbasaurAtacaConChupavidasARattataYHaceDanio() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Bulbasaur());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar bulbasaurAtacaConChupavidasARattata = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			turno.jugar(bulbasaurAtacaConChupavidasARattata);
			
			//vidaMax de Rattata (170) - danio de chupavidas (15 * 1.0 = 15).
			assertEquals(155, turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
			
		}
		
		@Test
		public void test23BulbasaurConVidaLlenaAtacaConChupavidasARattataYSeCuraCero() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Bulbasaur());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar bulbasaurAtacaConChupavidasARattata = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			turno.jugar(bulbasaurAtacaConChupavidasARattata);

			//vidaMax de Bulbasaur (140) se mantiene.
			assertEquals(140, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
			
		}
		
		@Test
		public void test24BulbasaurConDanioRecibidoAtacaConChupavidasARattataYSeCuraParcial() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Rattata());
			jugador2.setAlgomon(new Bulbasaur());
			Turno turno = new Turno(jugador1, jugador2);
			
			Atacar rattataAtacaConAtaqueRapidoABulbasaur = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//vida de Bulbasaur (140) - danio de AtaqueRapido (10 * 1.0) = 130.
			turno.jugar(rattataAtacaConAtaqueRapidoABulbasaur);

			Atacar bulbasaurAtacaConChupavidasARattata = new Atacar(turno.jugadorActivo().getAlgomonActivo(), new Chupavidas(turno.jugadorActivo().getAlgomonActivo()), turno.jugadorActivo().getOponente().getAlgomonActivo());
			//danio hecho a Rattata = 15 * 1.0 = 15.
			turno.jugar(bulbasaurAtacaConChupavidasARattata);

			//Bulbasaur se cura un 30% de 15. vida de Bulbasaur = 130 + 4 = 134.
			assertEquals(134, turno.jugadorActivo().getOponente().getAlgomonActivo().vida(), 0.001D);
		}
		
		//PUNTO 5 DE LA ENTREGA
		
		@Test
		public void test25CharmanderAtacaConFogonazoARattata() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Charmander());
			jugador2.setAlgomon(new Rattata());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Rattata un danio de 2 puntos por ser un Algomon de tipo normal.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Rattata realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 17 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 2 + 17 = 19, 170 - 19 = 151
			assertEquals(151.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test26CharmanderAtacaConFogonazoABulbasaur() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Charmander());
			jugador2.setAlgomon(new Bulbasaur());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Bulbasaur un danio de 4 puntos por ser un Algomon de tipo planta.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Bulbasaur realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 14 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 4 + 14 = 18, 140 - 18 = 122
			assertEquals(122.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test27CharmanderAtacaConFogonazoASquirtle() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Charmander());
			jugador2.setAlgomon(new Squirtle());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Squirtle un danio de 1 punto por ser un Algomon de tipo agua.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Squirtle realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 15 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 1 + 15 = 16, 150 - 16 = 134
			assertEquals(134.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test28RattataAtacaConFogonazoACharmander() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Rattata());
			jugador2.setAlgomon(new Charmander());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Charmander un danio de 1 punto por ser un Algomon de tipo fuego.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Charmander realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 17 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 1 + 17 = 18, 170 - 18 = 152
			assertEquals(152.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test29RattataAtacaConFogonazoAChansey() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Rattata());
			jugador2.setAlgomon(new Chansey());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Chansey un danio de 2 puntos por ser un Algomon de tipo normal.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Chansey realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 13 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 2 + 13 = 15, 130 - 15 = 115
			assertEquals(115.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test30RattataAtacaConFogonazoAJigglypuff() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Rattata());
			jugador2.setAlgomon(new Jigglypuff());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Jigglypuff un danio de 2 puntos por ser un Algomon de tipo normal.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Jigglypuff realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 13 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 2 + 13 = 15, 130 - 15 = 115
			assertEquals(115.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
		@Test
		public void test31RattataAtacaConFogonazoAJigglypuffEfectoALargoPlazo() {
			Jugador jugador1 = new Jugador("PEPE");
			Jugador jugador2 = new Jugador("PEPE");
			jugador1.setAlgomon(new Rattata());
			jugador2.setAlgomon(new Jigglypuff());
			Turno turno = new Turno(jugador1, jugador2);
			
			//Fogonazo le causa a Jigglypuff un danio de 2 puntos por ser un Algomon de tipo normal.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoQuemar(new Fogonazo()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Jigglypuff realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 13 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Rattata ataca con Ataque Rapido infringiendole 10 puntos de danio adicionales a Jigglypuff.
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Como Jigglypuff realizo una accion(ataco), fogonazo activo su efecto secundario y le saco 13 de vida (10% de su vida max)
			turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
			
			//Total: 2 + 13 + 10 + 13 = 38, 130 - 38 = 92
			assertEquals(92.0, turno.jugadorNoActivo().getAlgomonActivo().vida(),0.001D);
		}
		
}
