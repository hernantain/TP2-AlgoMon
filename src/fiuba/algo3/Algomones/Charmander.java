package Algomones;

import Ataques.AtaqueConEfectoQuemar;
import Ataques.AtaqueRapido;
import Ataques.Brasas;
import Ataques.Fogonazo;
import Tipos.TipoFuego;

public class Charmander extends Algomon{
	
	public Charmander(){
		nombre = "Charmander";
		tipo = new TipoFuego();
		vida = new Vida(170);
		ataques.add(new Brasas());
		ataques.add(new AtaqueConEfectoQuemar(new Fogonazo()));
		ataques.add(new AtaqueRapido());
	}
	
	

}
