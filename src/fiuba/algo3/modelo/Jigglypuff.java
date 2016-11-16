package modelo;

public class Jigglypuff extends Algomon {

	public Jigglypuff(){
		tipo = new TipoNormal();
		vida = new Vida(130);
		ataques.add(new Burbuja());
		ataques.add(new AtaqueRapido());
		ataques.add(new Canto());
	}
	
	
}
