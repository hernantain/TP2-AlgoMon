package modelo;
import java.util.HashMap;

public abstract class Tipo {
	
	HashMap<String,Double> relacionEntreTipos = new HashMap<String,Double>();
	String id;
	
	public double conTipo(Tipo tipo) {
		return relacionEntreTipos.get(tipo.getConstante());
	}
	
	protected String getConstante(){
		return id;
	}
}
