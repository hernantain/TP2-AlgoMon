package Acciones;

import Algomones.Algomon;
import modelo.Jugador;

public class CambiarAlgomonActivo extends AccionDeJugador {
	
	Jugador jugadorActivo;
	Algomon algomonEntrante;
	
	public CambiarAlgomonActivo(Jugador jugadorActivo, Algomon algomonEntrante) {
		this.jugadorActivo = jugadorActivo;
		this.algomonEntrante = algomonEntrante;
	}
	
	public boolean accionar() {
		return this.jugadorActivo.cambiarAlgomonActivo(this.algomonEntrante);
	}

}
