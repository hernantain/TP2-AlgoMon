package modelo;

public class Chansey extends Algomon{
	
	public Chansey(){
		tipo = new TipoNormal();
		vida  = new Vida(130);
		ataques.add(new AtaqueConEfectoDormir(new Canto()));
		ataques.add(new LatigoCepa());
		ataques.add(new AtaqueRapido());
	}
	
	

}
