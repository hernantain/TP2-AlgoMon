package Algomones;

import Ataques.AtaqueConEfectoChuparVidas;
import Ataques.AtaqueRapido;
import Ataques.Chupavidas;
import Ataques.LatigoCepa;
import Tipos.TipoPlanta;

public class Bulbasaur extends Algomon{
	
	public Bulbasaur(){
		nombre = "Bulbsaur";
		tipo = new TipoPlanta();
		vida = new Vida(140);
		ataques.add(new AtaqueConEfectoChuparVidas(new Chupavidas(), this));
		ataques.add(new LatigoCepa());
		ataques.add(new AtaqueRapido());
	}
	
}
