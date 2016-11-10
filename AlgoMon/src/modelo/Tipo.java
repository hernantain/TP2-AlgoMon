package modelo;
import java.util.HashMap;

public abstract class Tipo {
	
	HashMap<Integer,Double> relacionEntreTipos = new HashMap<Integer,Double>();
	int constante;
	
	public double conTipo(Tipo tipo) {
		return relacionEntreTipos.get(tipo.getConstante());
	}
	
	protected int getConstante(){
		return constante;
	}
}
