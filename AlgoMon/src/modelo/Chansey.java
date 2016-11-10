package modelo;

public class Chansey extends Algomon{
	
	public Chansey(){
		tipo = new TipoNormal();
		vida = 130;
		// Aca falta el ataque Canto que todavia no es necesario
		ataques.put("Latigo Cepa", new LatigoCepa());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
	
	

}
