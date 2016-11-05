
public class Chansey extends Algomon{
	
	public Chansey(){
		tipo = new TipoNormal();
		vida = 130.0;
		// Acá falta el ataque Canto que todavía no es necesario
		ataques.put("Latigo cepa", new LatigoCepa());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}

}
