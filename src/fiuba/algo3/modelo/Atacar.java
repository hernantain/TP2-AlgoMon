package modelo;

public class Atacar extends AccionDeJugador {
	
	protected Algomon algomonDeJugador;
	protected Algomon algomonDelContrincante;
	protected String ataque;

	public Atacar(Algomon miAlgomon, String unAtaque, Algomon otroAlgomon){
		algomonDeJugador = miAlgomon;
		algomonDelContrincante = otroAlgomon;
		ataque = unAtaque;
	}
	@Override
	public boolean accionar() {
		return algomonDeJugador.atacarACon(algomonDelContrincante, ataque);
	}

}
