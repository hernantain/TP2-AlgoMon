package modelo;

public class EstadoQuemado extends Estado {

	protected Algomon miAlgomon;
	
	public EstadoQuemado(Algomon algomon){
		miAlgomon = algomon;
	}
	
	@Override
	public void activarEfectoEspecial() {
		miAlgomon.recibirAtaque(miAlgomon.getVidaMax()/10);
	}

	@Override
	public void pasoTurno() {
		return;
	}

}
