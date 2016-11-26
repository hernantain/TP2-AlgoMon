package Acciones;

import Algomones.AlgomonDebilitadoExcepcion;
import Elementos.Elemento;
import modelo.Jugador;

public class UsarElemento extends AccionDeJugador {
	
	protected Jugador jugadorActivo;
	protected Elemento elementoDelJugador;
	
	public UsarElemento(Jugador jugador, Elemento elemento) {
		if (!jugador.getAlgomonActivo().estaVivo()) {
			throw new AlgomonDebilitadoExcepcion();
		}
		jugadorActivo = jugador;
		elementoDelJugador = elemento;
	}

	public boolean accionar() {
		return jugadorActivo.usarElemento(elementoDelJugador);
	}

}
