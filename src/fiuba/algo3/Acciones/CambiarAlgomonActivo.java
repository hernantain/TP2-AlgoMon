package Acciones;

import Algomones.Algomon;
import modelo.Jugador;

public class CambiarAlgomonActivo extends AccionDeJugador {
	
	Jugador jugadorActivo;
	Algomon algomonEntrante;
	
	public CambiarAlgomonActivo(Jugador jugadorActivo, Algomon algomonEntrante) {
		if (jugadorActivo.getAlgomonActivo() == algomonEntrante) {
			throw new AlgomonNoPuedeCambiarsePorSiMismoExcepcion();
		}
		this.jugadorActivo = jugadorActivo;
		this.algomonEntrante = algomonEntrante;
	}
	
	public boolean accionar() {
		return this.jugadorActivo.cambiarAlgomonActivo(this.algomonEntrante);
	}

}
