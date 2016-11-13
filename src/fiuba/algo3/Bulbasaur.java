package modelo;

public class Bulbasaur extends Algomon{
	
	public Bulbasaur(){
		tipo = new TipoPlanta();
		vida = vidaMax = 140;
		ataques.put("Chupavidas", new Chupavidas(this));
		ataques.put("Latigo Cepa", new LatigoCepa());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
	
}
