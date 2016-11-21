package Ataques;

import Tipos.TipoNormal;

public class Canto extends AtaqueSimple{

	public Canto(){
		nombre = "Canto";
		potencia = new Potencia(0);
		cantidad = 6;
		tipo = new TipoNormal();
	}
}
