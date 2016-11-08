package modelo;


public abstract class Ataque {

	int cantidad;
	Tipo tipo;
	
	public abstract boolean atacar(Algomon algomon);
}
