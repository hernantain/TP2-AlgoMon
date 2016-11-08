package modelo;

public class TipoAgua extends Tipo {

	public TipoAgua(){
		constante = 2;
		relacionEntreTipos.put(1, 2.0);
		relacionEntreTipos.put(2, 0.5);
		relacionEntreTipos.put(3, 0.5);
		relacionEntreTipos.put(4, 1.0);
	}

}
