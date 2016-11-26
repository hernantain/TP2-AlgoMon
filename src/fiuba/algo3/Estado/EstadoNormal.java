package Estado;

public class EstadoNormal extends Estado {

	public EstadoNormal(){
		nombre = "Estado Normal";
	}	
	
	@Override
	public void efecto() {
		return;
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
