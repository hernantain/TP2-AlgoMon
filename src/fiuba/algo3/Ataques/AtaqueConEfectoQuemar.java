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
		algomonAfectado.agregarEstado(new EstadoQuemado(algomonAfectado));
	}

	public void aumentarCantidadDeAtaque(int cantidadAAumentar) {
		ataqueADecorar.aumentarCantidadDeAtaque(cantidadAAumentar);
	}

	@Override
	public String nombre() {
		return ataqueADecorar.nombre();
	}

	@Override
	public boolean equals(Ataque ataque) {
		if( ataque.getClass().equals(this.getClass())){
			return true;
		}
		return false;
	}
	
	@Override
	public int danioRealizado(Algomon algomonAtacado) {
		return ataqueADecorar.danioRealizado(algomonAtacado);
	}
	
	@Override
	public boolean agotado() {
		return ataqueADecorar.agotado();
	}


}
