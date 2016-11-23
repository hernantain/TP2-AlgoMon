package Ataques;

import Algomones.Algomon;
import Tipos.Tipo;

public class AtaqueSimple implements Ataque {
	protected int cantidad;
	protected Tipo tipo;
	protected Potencia potencia;
	protected String nombre;
	
	public boolean atacar(Algomon algomon){
		if (cantidad > 0){
			algomon.recibirAtaque(this.danioRealizado(algomon));
			cantidad --;
			return true;
		}
		return false;
	}

	public void aumentarCantidadDeAtaque(int cantidadAAumentar) {
		cantidad = cantidad + cantidadAAumentar;
	}

	@Override
	public String nombre() {
		return nombre;
	}

	@Override
	public boolean equals(Ataque ataque) {
		if( ataque.getClass().equals(this.getClass())){
			return true;
		}
		return false;
	}
	
	public int danioRealizado(Algomon algomonAtacado){
		return potencia.calcularPotencia(tipo, algomonAtacado.getTipo());
	}
	
}
