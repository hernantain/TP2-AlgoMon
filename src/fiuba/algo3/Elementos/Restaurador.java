package Elementos;

import Algomones.Algomon;
import Estado.EstadoDormido;
import Estado.EstadoQuemado;

public class Restaurador extends Elemento {
	
	public Restaurador() {
		nombre = "Restaurador";
	}
	
	public void aplicarA(Algomon algomon) {
		algomon.quitarEstado(new EstadoDormido(algomon));
		algomon.quitarEstado(new EstadoQuemado(algomon));
	}
}
