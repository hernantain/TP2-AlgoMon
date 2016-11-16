package modelo;

public class EstadoQuemado extends Estado {

	protected Algomon miAlgomon;
	
	public EstadoQuemado(Algomon algomon){
		miAlgomon = algomon;
	}
	
	@Override
	public void consecuencia() {
		miAlgomon.recibirAtaque(miAlgomon.getVidaMax()/10);
	}


}
