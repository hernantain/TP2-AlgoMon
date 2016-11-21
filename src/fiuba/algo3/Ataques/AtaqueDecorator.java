package Ataques;

import Algomones.Algomon;

abstract class AtaqueDecorator implements Ataque{
	protected Ataque ataqueADecorar;

	public AtaqueDecorator(Ataque ataqueADecorar) {
		this.ataqueADecorar = ataqueADecorar;
	}
	
	public boolean atacar(Algomon algomon) {
		return ataqueADecorar.atacar(algomon);
	}

	public void aumentarCantidadDeAtaque(int cantidadAAumentar) {
		ataqueADecorar.aumentarCantidadDeAtaque(cantidadAAumentar);
	}
}
