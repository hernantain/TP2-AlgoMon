package Ataques;

import Algomones.Algomon;

public class AtaqueConEfectoChuparVidas extends AtaqueEspecial{
	
	Algomon miAlgomon;
	
	public AtaqueConEfectoChuparVidas(Ataque ataqueADecorar, Algomon algomonOrigen) {
		super(ataqueADecorar);
		miAlgomon = algomonOrigen;
	}
	
	public boolean atacar(Algomon algomon) {
		if (super.atacar(algomon)) {
			efectoSecundario(algomon);
			return true;
		}
		return false;
	}

	public void efectoSecundario(Algomon algomonDaniado) {
		miAlgomon.curarse((ataqueADecorar.danioRealizado(algomonDaniado))* 30 / 100);
	}
	
	public void aumentarCantidadDeAtaque(int cantidadAAumentar) {
		ataqueADecorar.aumentarCantidadDeAtaque(cantidadAAumentar);
	}
	
	public String nombre() {
		return ataqueADecorar.nombre();
	}
	
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
	
	public int getCantidad() {
		return ataqueADecorar.getCantidad();
	}
}
