package modelo;

public class TipoPlanta extends Tipo {
	
	public TipoPlanta(){
		constante = 3;
		relacionEntreTipos.put(1, 0.5);
		relacionEntreTipos.put(2, 2.0);
		relacionEntreTipos.put(3, 0.5);
		relacionEntreTipos.put(4, 1.0);
	}

}
