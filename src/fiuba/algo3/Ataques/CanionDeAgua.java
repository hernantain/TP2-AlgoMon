package Ataques;

import Tipos.TipoAgua;

public class CanionDeAgua extends AtaqueSimple {

	public CanionDeAgua(){
		nombre = "Canion de Agua";
		tipo = new TipoAgua();
		potencia = new Potencia(20);
		cantidad = 8;
	}
}
