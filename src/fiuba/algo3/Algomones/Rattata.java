package Algomones;

import Ataques.AtaqueConEfectoQuemar;
import Ataques.AtaqueRapido;
import Ataques.Burbuja;
import Ataques.Fogonazo;
import Estado.EstadoNormal;
import Tipos.TipoNormal;

public class Rattata extends Algomon {

	public Rattata(){
		nombre = "Rattata";
		tipo = new TipoNormal();
		vida = new Vida(170);
		estados.add(new EstadoNormal());
		ataques.add(new Burbuja());
		ataques.add(new AtaqueRapido());
		ataques.add(new AtaqueConEfectoQuemar(new Fogonazo()));
	}
	
}
