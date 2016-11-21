package Algomones;

import Ataques.AtaqueConEfectoDormir;
import Ataques.AtaqueRapido;
import Ataques.Canto;
import Ataques.LatigoCepa;
import Tipos.TipoNormal;

public class Chansey extends Algomon{
	
	public Chansey(){
		nombre = "Chansey";
		tipo = new TipoNormal();
		vida  = new Vida(130);
		ataques.add(new AtaqueConEfectoDormir(new Canto()));
		ataques.add(new LatigoCepa());
		ataques.add(new AtaqueRapido());
	}
	
	

}
