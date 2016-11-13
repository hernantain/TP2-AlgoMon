package modelo;


public abstract class Ataque {

	protected int cantidad;
	protected Tipo tipo;
	protected int danio;

	public abstract boolean atacar(Algomon algomon);
}
