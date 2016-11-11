package modelo;

public class EstadoDormido extends Estado {
	protected Algomon miAlgomon;
	protected int tiempoDormido = 3;
	
	public EstadoDormido(Algomon algomon){
		miAlgomon = algomon;
	}
	
	public void pasoTurno(){
		if (tiempoDormido == 0){
			miAlgomon.cambiarEstado(new EstadoNormal());
			return;
		}
		tiempoDormido --;
	}
	
	@Override
	public void activarEfectoEspecial() {
		throw new EstadoDormidoExcepcion();
	}

}
