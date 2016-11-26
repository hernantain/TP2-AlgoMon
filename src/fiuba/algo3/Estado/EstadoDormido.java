package Estado;

import Algomones.Algomon;

public class EstadoDormido extends Estado {
	protected Algomon miAlgomon;
	protected int tiempoDormido = 2;
	
	public EstadoDormido(Algomon algomon){
		miAlgomon = algomon;
		nombre = "Estado Dormido";
	}
	
	@Override
	public void efecto() {
		if (tiempoDormido > 0) {
			tiempoDormido --;
			throw new EstadoDormidoExcepcion();
		} else {
			throw new FinEstadoDormidoExcepcion();
		}
	}
	
	@Override
	public String nombre() {
		return this.nombre;
	}
	
	@Override
	public boolean equals(Estado estado) {
		if (this.nombre() == estado.nombre()) {
			return true;
		}
		return false;
	}

}
