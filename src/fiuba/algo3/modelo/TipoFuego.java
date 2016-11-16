package modelo;

public class TipoFuego extends Tipo {

	public TipoFuego(){
		id = "Tipo Fuego";
		relacionEntreTipos.put("Tipo Fuego", 0.5);
		relacionEntreTipos.put("Tipo Agua", 0.5);
		relacionEntreTipos.put("Tipo Planta", 2.0);
		relacionEntreTipos.put("Tipo Normal", 1.0);
	}

}
