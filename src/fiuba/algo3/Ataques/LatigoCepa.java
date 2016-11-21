package Ataques;

import Tipos.TipoPlanta;

public class LatigoCepa extends AtaqueSimple{
	
	public LatigoCepa(){
		nombre = "Latigo Cepa";
		tipo = new TipoPlanta();
		potencia = new Potencia(15);
		cantidad = 10;
	}

}
