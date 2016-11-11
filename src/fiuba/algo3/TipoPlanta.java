package modelo;

public class TipoPlanta extends Tipo {
	
	public TipoPlanta(){
		id = "Tipo Planta";
		relacionEntreTipos.put("Tipo Fuego", 0.5);
		relacionEntreTipos.put("Tipo Agua", 2.0);
		relacionEntreTipos.put("Tipo Planta", 0.5);
		relacionEntreTipos.put("Tipo Normal", 1.0);
	}

}
