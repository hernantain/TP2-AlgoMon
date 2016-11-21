package Acciones;

import Algomones.Algomon;
import Ataques.Ataque;

public class Atacar extends AccionDeJugador {
	
	protected Algomon algomonDeJugador;
	protected Algomon algomonDelContrincante;
	protected Ataque ataque;

	public Atacar(Algomon miAlgomon, Ataque unAtaque, Algomon otroAlgomon){
		algomonDeJugador = miAlgomon;
		algomonDelContrincante = otroAlgomon;
		ataque = unAtaque;
	}
	@Override
	public boolean accionar() {
		return algomonDeJugador.atacarACon(algomonDelContrincante, ataque);
	}

}
