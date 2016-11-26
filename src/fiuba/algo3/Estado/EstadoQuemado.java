package Estado;

import Algomones.Algomon;

public class EstadoQuemado extends Estado {

	protected Algomon miAlgomon;
	
	public EstadoQuemado(Algomon algomon){
		miAlgomon = algomon;
		nombre = "Estado Quemado";
	}
	
	@Override
	public void efecto() {
		miAlgomon.recibirAtaque(miAlgomon.getVidaMax()/10);
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
