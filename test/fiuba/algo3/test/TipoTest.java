package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Tipo;
import modelo.TipoAgua;
import modelo.TipoFuego;
import modelo.TipoNormal;
import modelo.TipoPlanta;

public class TipoTest {

	@Test
	public void test01PlantaConAgua() {
		Tipo planta = new TipoPlanta();
		Tipo agua = new TipoAgua();
		assertEquals(2.0, planta.vs(agua), 0.001D);
	}
	
	@Test
	public void test02PlantaConFuego() {
		Tipo planta = new TipoPlanta();
		Tipo fuego = new TipoFuego();
		assertEquals(0.5, planta.vs(fuego), 0.001D);
	}
	
	@Test
	public void test03PlantaConNormal() {
		Tipo planta = new TipoPlanta();
		Tipo normal = new TipoNormal();
		assertEquals(1.0, planta.vs(normal), 0.001D);
	}
	
	@Test
	public void test04PlantaConPlanta() {
		Tipo planta1 = new TipoPlanta();
		Tipo planta2 = new TipoPlanta();
		assertEquals(0.5, planta1.vs(planta2), 0.001D);
	}
	
	@Test
	public void test05FuegoConAgua() {
		Tipo fuego = new TipoFuego();
		Tipo agua = new TipoAgua();
		assertEquals(0.5, fuego.vs(agua), 0.001D);
	}
	
	@Test
	public void test06FuegoConPlanta() {
		Tipo fuego = new TipoFuego();
		Tipo planta = new TipoPlanta();
		assertEquals(2.0, fuego.vs(planta), 0.001D);
	}
	
	@Test
	public void test07FuegoConNormal() {
		Tipo fuego = new TipoFuego();
		Tipo normal = new TipoNormal();
		assertEquals(1.0, fuego.vs(normal), 0.001D);
	}
	
	@Test
	public void test08FuegoConFuego() {
		Tipo fuego1 = new TipoFuego();
		Tipo fuego2 = new TipoFuego();
		assertEquals(0.5, fuego1.vs(fuego2), 0.001D);
	}
	
	@Test
	public void test09AguaConPlanta() {
		Tipo agua = new TipoAgua();
		Tipo planta = new TipoPlanta();
		assertEquals(0.5, agua.vs(planta), 0.001D);
	}
	
	@Test
	public void test10AguaConFuego() {
		Tipo agua = new TipoAgua();
		Tipo fuego = new TipoFuego();
		assertEquals(2.0, agua.vs(fuego), 0.001D);
	}
	
	@Test
	public void test11AguaConNormal() {
		Tipo agua = new TipoAgua();
		Tipo normal = new TipoNormal();
		assertEquals(1.0, agua.vs(normal), 0.001D);
	}
	
	@Test
	public void test12AguaConAgua() {
		Tipo agua1 = new TipoAgua();
		Tipo agua2 = new TipoAgua();
		assertEquals(0.5, agua1.vs(agua2), 0.001D);
	}
	
	@Test
	public void test13NormalConAgua() {
		Tipo normal = new TipoNormal();
		Tipo agua = new TipoAgua();
		assertEquals(1.0, normal.vs(agua), 0.001D);
	}
	
	@Test
	public void test14NormalConFuego() {
		Tipo normal = new TipoNormal();
		Tipo fuego = new TipoFuego();
		assertEquals(1.0, normal.vs(fuego), 0.001D);
	}
	
	@Test
	public void test15NormalConPlanta() {
		Tipo normal = new TipoNormal();
		Tipo planta = new TipoPlanta();
		assertEquals(1.0, normal.vs(planta), 0.001D);
	}
	
	@Test
	public void test16NormalConNormal() {
		Tipo normal1 = new TipoNormal();
		Tipo normal2 = new TipoNormal();
		assertEquals(1.0, normal1.vs(normal2), 0.001D);
	}
	
	

}
