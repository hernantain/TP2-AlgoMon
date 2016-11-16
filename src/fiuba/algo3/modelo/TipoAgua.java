package modelo;

public class TipoAgua extends Tipo {

	public TipoAgua(){
		id = "Tipo Agua";
		relacionEntreTipos.put("Tipo Fuego", 2.0);
		relacionEntreTipos.put("Tipo Agua", 0.5);
		relacionEntreTipos.put("Tipo Planta", 0.5);
		relacionEntreTipos.put("Tipo Normal", 1.0);
	}

}
