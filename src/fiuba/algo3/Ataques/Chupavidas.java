package Ataques;

import Tipos.TipoPlanta;

public class Chupavidas extends AtaqueSimple {//PREGUNTAR COMO PASARLE EL ALGOMON SIN CAMBIAR EL DECORATOR

	
	public Chupavidas() {
		nombre = "Chupavidas";
		potencia = new Potencia(15);
		cantidad = 8;
		tipo = new TipoPlanta();
	}

}
