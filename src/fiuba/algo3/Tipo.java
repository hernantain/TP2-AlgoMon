package modelo;
import java.util.HashMap;

public abstract class Tipo {
	
	protected HashMap<String,Double> relacionEntreTipos = new HashMap<String,Double>();
	protected String id;
	
	public double conTipo(Tipo tipo) {
		return relacionEntreTipos.get(tipo.getIdConstante());
	}
	
	protected String getId(){
		return id;
	}
}
