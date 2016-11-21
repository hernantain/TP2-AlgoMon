package Elementos;

import Algomones.Algomon;
import Estado.EstadoNormal;

public class Restaurador extends Elemento {
	
	public void aplicarA(Algomon algomon) {
		algomon.cambiarEstado(new EstadoNormal());
	}
}
