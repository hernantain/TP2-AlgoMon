package Elementos;

import Algomones.Algomon;

public class SuperPocion extends Elemento {
	private int vidaACurar = 40;
	
	public SuperPocion() {
		nombre = "Super Pocion";
	}
	
	public void aplicarA(Algomon algomon) {
		algomon.curarse(vidaACurar);
	}
}
