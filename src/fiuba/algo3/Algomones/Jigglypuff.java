package Algomones;

import Ataques.AtaqueConEfectoDormir;
import Ataques.AtaqueRapido;
import Ataques.Burbuja;
import Ataques.Canto;
import Estado.EstadoNormal;
import Tipos.TipoNormal;

public class Jigglypuff extends Algomon {

	public Jigglypuff(){
		nombre = "Jigglypuff";
		tipo = new TipoNormal();
		vida = new Vida(130);
		estados.add(new EstadoNormal());
		ataques.add(new Burbuja());
		ataques.add(new AtaqueRapido());
		ataques.add(new AtaqueConEfectoDormir(new Canto()));
	}
	
	
}
