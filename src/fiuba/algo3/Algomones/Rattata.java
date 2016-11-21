package Algomones;

import Ataques.AtaqueConEfectoQuemar;
import Ataques.AtaqueRapido;
import Ataques.Burbuja;
import Ataques.Fogonazo;
import Tipos.TipoNormal;

public class Rattata extends Algomon {

	public Rattata(){
		nombre = "Rattata";
		tipo = new TipoNormal();
		vida = new Vida(170);
		ataques.add(new Burbuja());
		ataques.add(new AtaqueRapido());
		ataques.add(new AtaqueConEfectoQuemar(new Fogonazo()));
	}
	
}
