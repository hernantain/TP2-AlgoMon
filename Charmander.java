
public class Charmander extends Algomon{
	
	public Charmander(){
		tipo = new TipoFuego();
		vida = 170.0;
		ataques.put("Brasas", new Brasas());
		// Acá falta el ataque Fogonazo que todavía no es necesario
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}

}
