package Ataques;

import Algomones.*;
import Estado.EstadoQuemado;

public class QuemarDecorator extends AtaqueDecorator{
	public QuemarDecorator(Ataque ataqueADecorar) {
		super(ataqueADecorar);
	}
	
	public boolean atacar(Algomon algomon) {
		efectoSecundario(algomon);
		return super.atacar(algomon);
	}

	public void efectoSecundario(Algomon algomonAfectado) {
		algomonAfectado.cambiarEstado(new EstadoQuemado(algomonAfectado));
	}

}
