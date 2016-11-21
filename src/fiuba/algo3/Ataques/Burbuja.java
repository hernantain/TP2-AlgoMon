package Ataques;

import Tipos.TipoAgua;

public class Burbuja extends AtaqueSimple {
	
	public Burbuja(){
		nombre = "Burbuja";
		tipo = new TipoAgua();
		potencia = new Potencia(10);
		cantidad = 15;
	}
}
