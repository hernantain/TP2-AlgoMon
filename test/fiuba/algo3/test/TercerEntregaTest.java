package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import Ataques.AtaqueRapido;
import Ataques.Canto;
import Ataques.LatigoCepa;
import Elementos.Pocion;
import Elementos.Restaurador;
import Elementos.SuperPocion;
import Elementos.Vitamina;
import modelo.*;

public class TercerEntregaTest {

// Punto 1 y 2: Se inicia una partida con dos jugadores y cada uno puede elegir sus cuatro algomones.
// Cada jugador tiene la opcion de atacar con el algomon activo y de elegir el ataque.
	
	@Test
	public void iniciarPartidaElegirAlgomonesYAtacar() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		jugador1.setAlgomon(jigglypuff);
		jugador1.setAlgomon(rattata);
		jugador1.setAlgomon(charmander);

		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		jugador2.setAlgomon(bulbasaur);
		jugador2.setAlgomon(squirtle);
		jugador2.setAlgomon(chansey);
		
		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new LatigoCepa(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		assertEquals(jugador1.getAlgomonActivo().vida(), 115, 0.001D);
		assertEquals(jugador2.getAlgomonActivo().vida(), 130, 0.001D);
	}
	
// Punto 3: Cada jugador tiene la opcion de cambiar al algomon activo.
	
	@Test
	public void elPrimerAlgomonElegidoEsElActivo() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("12");
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Charmander charmander = new Charmander();
		jugador1.setAlgomon(jigglypuff);
		jugador1.setAlgomon(charmander);

		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		jugador2.setAlgomon(bulbasaur);
		jugador2.setAlgomon(squirtle);

		assertEquals(jugador1.getAlgomonActivo(), jigglypuff);
		assertEquals(jugador2.getAlgomonActivo(), bulbasaur);
	}
	
	@Test
	public void cambiarAlgomonActivo() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Charmander charmander = new Charmander();
		jugador1.setAlgomon(jigglypuff);
		jugador1.setAlgomon(charmander);

		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		jugador2.setAlgomon(bulbasaur);
		jugador2.setAlgomon(squirtle);

		Turno turno = new Turno(jugador1, jugador2);
		turno.jugar(new CambiarAlgomonActivo(jugador1, charmander));
		turno.jugar(new CambiarAlgomonActivo(jugador2, squirtle));

		assertEquals(jugador1.getAlgomonActivo(), charmander);
		assertEquals(jugador2.getAlgomonActivo(), squirtle);
	}
	
	@Test 
	public void cambiarAlgomonActivoMultiplesVeces() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		jugador1.setAlgomon(jigglypuff);
		jugador1.setAlgomon(rattata);
		jugador1.setAlgomon(charmander);


		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		jugador2.setAlgomon(bulbasaur);
		jugador2.setAlgomon(squirtle);
		jugador2.setAlgomon(chansey);

		Turno turno = new Turno(jugador1, jugador2);
		
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), charmander));
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), squirtle));

		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), rattata));
		turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(), chansey));

		assertEquals(jugador1.getAlgomonActivo(), rattata);
		assertEquals(jugador2.getAlgomonActivo(), chansey);
	}
	
// Puntos 4, 5 y 6: Cada jugador tiene la opcion de aplicarle un elemento a su algomon activo,
// cada uno de los elementos realiza el efecto especificado sobre el algomon al que se lo aplica
// y se cambia de turno despues de que un jugador realice una accion.
	
	@Test
	public void jugadoresAplicanPociones() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Charmander());
		Turno turno = new Turno(jugador1, jugador2);

		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));

		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));

		// Se le aplica a Jigglypuff, que ya habia recibido 20 puntos de danio, una pocion.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new Pocion()));
		
		//Se le aplica a Charmander, que tambien recibio 20 de danio, una pocion.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new Pocion()));


		// Como la pocion recupera 20 puntos, Jigglypuff vuelve a tener su vida al maximo.
		assertEquals(turno.jugadorNoActivo().getAlgomonActivo().getVidaMax(), turno.jugadorNoActivo().getAlgomonActivo().vida(), 0.001D);
		
		// Charmander tambien vuelve a tener su vida al maximo.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void jugadoresAplicanSuperPociones() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Charmander());
		Turno turno = new Turno(jugador1, jugador2);

		
		//Jugadores se atacan.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));

		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));

		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		// Se le aplica a Jigglypuff, que ya habia recibido 40 puntos de danio, una superpocion.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new SuperPocion()));
		
		//Se le aplica a Charmander, que tambien recibio 40 de danio, una pocion.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new SuperPocion()));


		// Como la pocion recupera 40 puntos, Jigglypuff vuelve a tener su vida al maximo.
		assertEquals(turno.jugadorNoActivo().getAlgomonActivo().getVidaMax(), turno.jugadorNoActivo().getAlgomonActivo().vida(), 0.001D);
		
		// Charmander tambien vuelve a tener su vida al maximo.
		assertEquals(turno.jugadorActivo().getAlgomonActivo().getVidaMax(), turno.jugadorActivo().getAlgomonActivo().vida(), 0.001D);
	}
	
	@Test
	public void JugadoresAplicanRestauradores() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		jugador1.setAlgomon(new Jigglypuff());
		jugador2.setAlgomon(new Chansey());
		Turno turno = new Turno(jugador1, jugador2);
			
		//Jigglypuff usa Canto.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueConEfectoDormir(new Canto()), turno.jugadorActivo().getOponente().getAlgomonActivo()));
		
		//Chansey usa Restaurador.
		turno.jugar(new UsarElemento(turno.jugadorActivo(), new Restaurador()));
		
		//Jigglypuff ataca normal.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));

		//Chansey puede atacar porque uso restaurador.
		turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), new AtaqueRapido(), turno.jugadorActivo().getOponente().getAlgomonActivo()));

		//Jigglypuff sufrio danio porque Chansey pudo atacar, porque uso restaurador..
		assertEquals(jugador1.getAlgomonActivo().vida(), 120, 0.001D);
	}
	
	@Test
	public void jugadoresAplicanVitamina() {
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
