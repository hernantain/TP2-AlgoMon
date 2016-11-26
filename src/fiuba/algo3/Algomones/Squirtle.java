package Algomones;

import Ataques.AtaqueRapido;
import Ataques.Burbuja;
import Ataques.CanionDeAgua;
import Estado.EstadoNormal;
import Tipos.TipoAgua;

public class Squirtle extends Algomon {

	public Squirtle(){
		nombre = "Squirtle";
		tipo = new TipoAgua();
		vida = new Vida(150);
		estados.add(new EstadoNormal());
		ataques.add(new Burbuja());
		ataques.add(new CanionDeAgua());
		ataques.add(new AtaqueRapido());
	}
	
	
}
