package modelo;

public class Bulbasaur extends Algomon{
	
	public Bulbasaur(){
		tipo = new TipoPlanta();
		vida = 140;
		// Aca falta el ataque Chupavidas que todavia no es necesario
		ataques.put("Latigo Cepa", new LatigoCepa());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
	
}
