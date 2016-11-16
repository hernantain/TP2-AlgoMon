package modelo;

public class Rattata extends Algomon {

	public Rattata(){
		tipo = new TipoNormal();
		vida = new Vida(170);
		ataques.put("Burbuja", new Burbuja());
		ataques.put("Ataque Rapido", new AtaqueRapido());
		ataques.put("Fogonazo", new Fogonazo());
	}
	
}
