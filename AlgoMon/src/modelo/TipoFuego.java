package modelo;

public class TipoFuego extends Tipo {

	public TipoFuego(){
		constante = 1;
		relacionEntreTipos.put(1, 0.5);
		relacionEntreTipos.put(2, 0.5);
		relacionEntreTipos.put(3, 2.0);
		relacionEntreTipos.put(4, 1.0);
	}

}
