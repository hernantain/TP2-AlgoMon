package Estado;

import Algomones.Algomon;

public class EstadoQuemado extends Estado {

	protected Algomon miAlgomon;
	
	public EstadoQuemado(Algomon algomon){
		miAlgomon = algomon;
	}
	
	@Override
	public void efecto() {
		miAlgomon.recibirAtaque(miAlgomon.getVidaMax()/10);
	}


}
