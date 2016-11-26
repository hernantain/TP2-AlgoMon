package Acciones;

import Algomones.Algomon;
import Algomones.AlgomonDebilitadoExcepcion;
import Ataques.Ataque;

public class Atacar extends AccionDeJugador {
	
	protected Algomon algomonDeJugador;
	protected Algomon algomonDelContrincante;
	protected Ataque ataque;

	public Atacar(Algomon miAlgomon, Ataque unAtaque, Algomon otroAlgomon){
		if (!miAlgomon.estaVivo()) {
			throw new AlgomonDebilitadoExcepcion();
		}
		algomonDeJugador = miAlgomon;
		algomonDelContrincante = otroAlgomon;
		ataque = unAtaque;
	}
	@Override
	public boolean accionar() {
		if (algomonDeJugador.setEstrategiaAtaque(ataque)){
			return algomonDeJugador.atacarA(algomonDelContrincante);
		}
		return false;
	}

}
