package Elementos;

import Algomones.Algomon;

public class Vitamina extends Elemento{
	protected int cantidadAAumentar = 2;
	
	public void aplicarA(Algomon algomon) {
		algomon.aumentarCantidadDeAtaques(cantidadAAumentar);
	}

}
