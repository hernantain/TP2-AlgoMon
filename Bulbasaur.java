package modelo;

public class Bulbasaur extends Algomon{
	
	public Bulbasaur(){
		tipo = new TipoPlanta();
		vida = 140;
		// Acá falta el ataque Chupavidas que todavía no es necesario
		ataques.put("Latigo Cepa", new LatigoCepa());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
	
}
