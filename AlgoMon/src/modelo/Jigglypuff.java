package modelo;

public class Jigglypuff extends Algomon {

	public Jigglypuff(){
		tipo = new TipoNormal();
		vida = 130;
		ataques.put("Burbuja", new Burbuja());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
	
	
}
