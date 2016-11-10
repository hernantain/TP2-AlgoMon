package modelo;

public class Rattata extends Algomon {

	public Rattata(){
		tipo = new TipoNormal();
		vida = 170;
		ataques.put("Burbuja", new Burbuja());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
	
	
}
