package modelo;


public abstract class Ataque {

	protected int cantidad;
	protected Tipo tipo;
	protected Potencia potencia;

	public abstract boolean atacar(Algomon algomon);
}
