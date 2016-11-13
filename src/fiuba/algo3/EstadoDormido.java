package modelo;

public class EstadoDormido extends Estado {
	protected Algomon miAlgomon;
	protected int tiempoDormido = 2;
	
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
	public void consecuencia() { //Viene de atacarAcon() en Algomon.
		pasoTurno();			//Es la manera de hacerle saber a estado dormido que paso el tiempo
		throw new EstadoDormidoExcepcion();
	}

}
