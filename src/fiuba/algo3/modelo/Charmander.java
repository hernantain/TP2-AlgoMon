package modelo;

public class Charmander extends Algomon{
	
	public Charmander(){
		tipo = new TipoFuego();
		vida = new Vida(170);
		ataques.add(new Brasas());
		ataques.add(new Fogonazo());
		ataques.add(new AtaqueRapido());
	}
	
	

}
