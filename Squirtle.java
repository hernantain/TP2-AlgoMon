package modelo;

public class Squirtle extends Algomon {

	public Squirtle(){
		tipo = new TipoAgua();
		vida = 150;
		ataques.put("Burbuja", new Burbuja());
		ataques.put("Cañon de Agua", new CanionDeAgua());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
	
	
}
