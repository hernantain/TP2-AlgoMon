package modelo;

public class Charmander extends Algomon{
	
	public Charmander(){
		tipo = new TipoFuego();
		vida = new Vida(170);
		ataques.put("Brasas", new Brasas());
		ataques.put("Fogonazo", new Fogonazo());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
	
	

}
