package Estado;

import Algomones.Algomon;

public class EstadoDormido extends Estado {
	protected Algomon miAlgomon;
	protected int tiempoDormido = 2;
	
	public EstadoDormido(Algomon algomon){
		miAlgomon = algomon;
	}
	
	private void pasoTurno(){
		if (tiempoDormido == 0){
			miAlgomon.cambiarEstado(new EstadoNormal());  
			return;
		}
		tiempoDormido --;
	}
	
	@Override
	public void efecto() { //Viene de atacarAcon() en Algomon.
		pasoTurno();			//Es la manera de hacerle saber a estado dormido que paso el tiempo
		throw new EstadoDormidoExcepcion();
	}

}
