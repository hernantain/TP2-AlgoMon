package Elementos;

import Algomones.Algomon;

public class Pocion extends Elemento {
	private int vidaACurar = 20;

	public Pocion (){
		nombre = "Pocion";
	}
	
	public void aplicarA(Algomon algomon) {
		algomon.curarse(vidaACurar);
		algomon.efectoDeEstado();
	}

}
