package modelo;

public class Restaurador extends Elemento {
	
	public void aplicarA(Algomon algomon) {
		algomon.cambiarEstado(new EstadoNormal());
	}
}
