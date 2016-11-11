package modelo;

public class TipoNormal extends Tipo {
	
	public TipoNormal(){
		id = "Tipo Normal";
		relacionEntreTipos.put("Tipo Fuego", 1.0);
		relacionEntreTipos.put("Tipo Agua", 1.0);
		relacionEntreTipos.put("Tipo Planta", 1.0);
		relacionEntreTipos.put("Tipo Normal", 1.0);
	}
	
}
