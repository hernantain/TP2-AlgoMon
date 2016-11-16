package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.AtaqueRapido;
import modelo.Brasas;
import modelo.Bulbasaur;
import modelo.Burbuja;
import modelo.Charmander;
import modelo.LatigoCepa;
import modelo.Rattata;
import modelo.Squirtle;

public class AtaqueSimpleTest {

	@Test
	public void testAtaqueTipoPlantaBajaDobleVidaDeAlgomonTipoAgua() {
		LatigoCepa latigo = new LatigoCepa();
		Squirtle squirtle = new Squirtle();
		latigo.atacar(squirtle);
		assertEquals(120.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testAtaqueTipoPlantaBajaNormalVidaDeAlgomonTipoNormal() {
		LatigoCepa latigo = new LatigoCepa();
		Rattata rattata = new Rattata();
		latigo.atacar(rattata);
		assertEquals(155.0, rattata.vida(), 0.001D);
	}

	@Test
	public void testAtaqueTipoPlantaBajaMitadlVidaDeAlgomonTipoFuego() {
		LatigoCepa latigo = new LatigoCepa();
		Charmander charmander = new Charmander();
		latigo.atacar(charmander);
		assertEquals(163.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testAtaqueTipoPlantaBajaMitadlVidaDeAlgomonTipoPlanta() {
		LatigoCepa latigo = new LatigoCepa();
		Bulbasaur bulbasaur = new Bulbasaur();
		latigo.atacar(bulbasaur);
		assertEquals(133.0, bulbasaur.vida(), 0.001D);
	}
	
	@Test
	public void testAtaqueTipoNormalBajaNormalVidaDeAlgomonTipoAgua() {
		AtaqueRapido ataque = new AtaqueRapido();
		Squirtle squirtle = new Squirtle();
		ataque.atacar(squirtle);
		assertEquals(140.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testAtaqueTipoNormalBajaNormalVidaDeAlgomonTipoNormal() {
		AtaqueRapido ataque = new AtaqueRapido();
		Rattata rattata = new Rattata();
		ataque.atacar(rattata);
		assertEquals(160.0, rattata.vida(), 0.001D);
	}	
	
	@Test
	public void testAtaqueTipoNormalBajaNormalVidaDeAlgomonTipoFuego() {
		AtaqueRapido ataque = new AtaqueRapido();
		Charmander charmander = new Charmander();
		ataque.atacar(charmander);
		assertEquals(160.0, charmander.vida(), 0.001D);
	}	
	
	@Test
	public void testAtaqueTipoNormalBajaNormalVidaDeAlgomonTipoPlanta() {
		AtaqueRapido ataque = new AtaqueRapido();
		Bulbasaur bulbasaur = new Bulbasaur();
		ataque.atacar(bulbasaur);
		assertEquals(130.0, bulbasaur.vida(), 0.001D);
	}

	@Test
	public void testAtaqueTipoFuegoBajaDobledVidaDeAlgomonTipoPlanta() {
		Brasas ataque = new Brasas();
		Bulbasaur bulbasaur = new Bulbasaur();
		ataque.atacar(bulbasaur);
		assertEquals(108.0, bulbasaur.vida(), 0.001D);
	}	
	
	@Test
	public void testAtaqueTipoFuegoBajaNormalVidaDeAlgomonTipoNormal() {
		Brasas ataque = new Brasas();
		Rattata rattata = new Rattata();
		ataque.atacar(rattata);
		assertEquals(154.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testAtaqueTipoFuegoBajaMitadVidaDeAlgomonTipoAgua() {
		Brasas ataque = new Brasas();
		Squirtle squirtle = new Squirtle();
		ataque.atacar(squirtle);
		assertEquals(142.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testAtaqueTipoFuegoBajaMitadVidaDeAlgomonTipoFuego() {
		Brasas ataque = new Brasas();
		Charmander charmander = new Charmander();
		ataque.atacar(charmander);
		assertEquals(162.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testAtaqueTipoAguaBajaDobleVidaDeAlgomonTipoFuego() {
		Burbuja ataque = new Burbuja();
		Charmander charmander = new Charmander();
		ataque.atacar(charmander);
		assertEquals(150.0, charmander.vida(), 0.001D);
	}	
	
	@Test
	public void testAtaqueTipoAguaBajaNormalVidaDeAlgomonTipoNormal() {
		Burbuja ataque = new Burbuja();
		Rattata rattata = new Rattata();
		ataque.atacar(rattata);
		assertEquals(160.0, rattata.vida(), 0.001D);
	}	
	
	@Test
	public void testAtaqueTipoAguaBajaMitadVidaDeAlgomonTipoPlanta() {
		Burbuja ataque = new Burbuja();
		Bulbasaur bulbasaur = new Bulbasaur();
		ataque.atacar(bulbasaur);
		assertEquals(135.0, bulbasaur.vida(), 0.001D);
	}	
	
	@Test
	public void testAtaqueTipoAguaBajaMitadVidaDeAlgomonTipoAgua() {
		Burbuja ataque = new Burbuja();
		Squirtle squirtle = new Squirtle();
		ataque.atacar(squirtle);
		assertEquals(145.0, squirtle.vida(), 0.001D);
	}
	
	
}
