package Ataques;

import Algomones.Algomon;
import Estado.EstadoQuemado;

public class AtaqueConEfectoQuemar extends AtaqueEspecial{
	public AtaqueConEfectoQuemar(Ataque ataqueADecorar) {
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
		algomonAfectado.cambiarEstado(new EstadoQuemado(algomonAfectado));
	}

	public void aumentarCantidadDeAtaque(int cantidadAAumentar) {
		ataqueADecorar.aumentarCantidadDeAtaque(cantidadAAumentar);
	}

}
