package Ataques;

import Tipos.TipoFuego;

public class Brasas extends AtaqueSimple{
	
	public Brasas(){
		nombre = "Brasas";
		tipo = new TipoFuego();
		potencia = new Potencia(16);
		cantidad = 10;
	}
}