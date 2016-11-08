package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.TipoAgua;
import modelo.TipoFuego;
import modelo.TipoNormal;
import modelo.TipoPlanta;

public class TipoTest {

	@Test
	public void test01PlantaConAgua() {
		TipoPlanta planta = new TipoPlanta();
		TipoAgua agua = new TipoAgua();
		assertEquals(2.0, planta.conTipo(agua), 0.001D);
	}
	
	@Test
	public void test02PlantaConFuego() {
		TipoPlanta planta = new TipoPlanta();
		TipoFuego fuego = new TipoFuego();
		assertEquals(0.5, planta.conTipo(fuego), 0.001D);
	}
	
	@Test
	public void test03PlantaConNormal() {
		TipoPlanta planta = new TipoPlanta();
		TipoNormal normal = new TipoNormal();
		assertEquals(1.0, planta.conTipo(normal), 0.001D);
	}
	
	@Test
	public void test04PlantaConPlanta() {
		TipoPlanta planta1 = new TipoPlanta();
		TipoPlanta planta2 = new TipoPlanta();
		assertEquals(0.5, planta1.conTipo(planta2), 0.001D);
	}
	
	@Test
	public void test05FuegoConAgua() {
		TipoFuego fuego = new TipoFuego();
		TipoAgua agua = new TipoAgua();
		assertEquals(0.5, fuego.conTipo(agua), 0.001D);
	}
	
	@Test
	public void test06FuegoConPlanta() {
		TipoFuego fuego = new TipoFuego();
		TipoPlanta planta = new TipoPlanta();
		assertEquals(2.0, fuego.conTipo(planta), 0.001D);
	}
	
	@Test
	public void test07FuegoConNormal() {
		TipoFuego fuego = new TipoFuego();
		TipoNormal normal = new TipoNormal();
		assertEquals(1.0, fuego.conTipo(normal), 0.001D);
	}
	
	@Test
	public void test08FuegoConFuego() {
		TipoFuego fuego1 = new TipoFuego();
		TipoFuego fuego2 = new TipoFuego();
		assertEquals(0.5, fuego1.conTipo(fuego2), 0.001D);
	}
	
	@Test
	public void test09AguaConPlanta() {
		TipoAgua agua = new TipoAgua();
		TipoPlanta planta = new TipoPlanta();
		assertEquals(0.5, agua.conTipo(planta), 0.001D);
	}
	
	@Test
	public void test10AguaConFuego() {
		TipoAgua agua = new TipoAgua();
		TipoFuego fuego = new TipoFuego();
		assertEquals(2.0, agua.conTipo(fuego), 0.001D);
	}
	
	@Test
	public void test11AguaConNormal() {
		TipoAgua agua = new TipoAgua();
		TipoNormal normal = new TipoNormal();
		assertEquals(1.0, agua.conTipo(normal), 0.001D);
	}
	
	@Test
	public void test12AguaConAgua() {
		TipoAgua agua1 = new TipoAgua();
		TipoAgua agua2 = new TipoAgua();
		assertEquals(0.5, agua1.conTipo(agua2), 0.001D);
	}
	
	@Test
	public void test13NormalConAgua() {
		TipoNormal normal = new TipoNormal();
		TipoAgua agua = new TipoAgua();
		assertEquals(1.0, normal.conTipo(agua), 0.001D);
	}
	
	@Test
	public void test14NormalConFuego() {
		TipoNormal normal = new TipoNormal();
		TipoFuego fuego = new TipoFuego();
		assertEquals(1.0, normal.conTipo(fuego), 0.001D);
	}
	
	@Test
	public void test15NormalConPlanta() {
		TipoNormal normal = new TipoNormal();
		TipoPlanta planta = new TipoPlanta();
		assertEquals(1.0, normal.conTipo(planta), 0.001D);
	}
	
	@Test
	public void test16NormalConNormal() {
		TipoNormal normal1 = new TipoNormal();
		TipoNormal normal2 = new TipoNormal();
		assertEquals(1.0, normal1.conTipo(normal2), 0.001D);
	}
	
	

}
