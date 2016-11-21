package Algomones;

import Ataques.AtaqueRapido;
import Ataques.Chupavidas;
import Ataques.LatigoCepa;
import Tipos.TipoPlanta;

public class Bulbasaur extends Algomon{
	
	public Bulbasaur(){
		tipo = new TipoPlanta();
		vida = new Vida(140);
		ataques.add(new Chupavidas(this));
		ataques.add(new LatigoCepa());
		ataques.add(new AtaqueRapido());
	}
	
}
