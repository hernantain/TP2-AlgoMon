package modelo;

public class Chansey extends Algomon{
	
	public Chansey(){
		tipo = new TipoNormal();
		vida = vidaMax = 130;
		ataques.put("Canto", new Canto());
		ataques.put("Latigo Cepa", new LatigoCepa());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
	
	

}
