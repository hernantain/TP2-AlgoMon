package modelo;

public class Rattata extends Algomon {

	public Rattata(){
		tipo = new TipoNormal();
		vida = new Vida(170);
		ataques.add(new Burbuja());
		ataques.add(new AtaqueRapido());
		ataques.add(new QuemarDecorator(new Fogonazo()));
	}
	
}
