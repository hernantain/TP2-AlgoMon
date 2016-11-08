package modelo;

public class Charmander extends Algomon{
	
	public Charmander(){
		tipo = new TipoFuego();
		vida = 170;
		ataques.put("Brasas", new Brasas());
		// Aca falta el ataque Fogonazo que todavia no es necesario
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
	
	

}
