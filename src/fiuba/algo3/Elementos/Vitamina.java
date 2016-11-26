package Elementos;

import Algomones.Algomon;

public class Vitamina extends Elemento{
	protected int cantidadAAumentar = 2;
	
	public Vitamina() {
		nombre = "Vitamina";
	}
	
	public void aplicarA(Algomon algomon) {
		algomon.aumentarCantidadDeAtaques(cantidadAAumentar);
		algomon.efectoDeEstado();
	}

}
