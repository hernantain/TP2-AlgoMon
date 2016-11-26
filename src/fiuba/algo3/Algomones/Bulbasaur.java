package Algomones;

import Ataques.AtaqueConEfectoChuparVidas;
import Ataques.AtaqueRapido;
import Ataques.Chupavidas;
import Ataques.LatigoCepa;
import Estado.EstadoNormal;
import Tipos.TipoPlanta;

public class Bulbasaur extends Algomon{
	
	public Bulbasaur(){
		nombre = "Bulbasaur";
		tipo = new TipoPlanta();
		vida = new Vida(140);
		estados.add(new EstadoNormal());
		ataques.add(new AtaqueConEfectoChuparVidas(new Chupavidas(), this));
		ataques.add(new LatigoCepa());
		ataques.add(new AtaqueRapido());
	}
	
}
