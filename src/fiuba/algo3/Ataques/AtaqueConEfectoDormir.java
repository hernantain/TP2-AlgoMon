package Ataques;

import Algomones.Algomon;
import Estado.EstadoDormido;

public class AtaqueConEfectoDormir extends AtaqueEspecial{
	public AtaqueConEfectoDormir(Ataque ataqueADecorar) {
		super(ataqueADecorar);
	}
	
	public boolean atacar(Algomon algomon) {
		if (super.atacar(algomon)) {
			efectoSecundario(algomon);
			return true;
		}
		return false;
	}

	public void efectoSecundario(Algomon algomonAfectado) {
		algomonAfectado.cambiarEstado(new EstadoDormido(algomonAfectado));
	}
	
	public void aumentarCantidadDeAtaque(int cantidadAAumentar) {
		ataqueADecorar.aumentarCantidadDeAtaque(cantidadAAumentar);
	}
}
