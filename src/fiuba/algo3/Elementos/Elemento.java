package Elementos;

import Algomones.Algomon;

public abstract class Elemento {
	protected String nombre;
	public abstract void aplicarA(Algomon algomon);
	public String nombre(){
		return nombre;
	}
	
}
