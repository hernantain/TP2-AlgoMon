package modelo;


public abstract class Ataque {

	protected int cantidad;
	protected Tipo tipo;
	protected int danio;

	protected abstract boolean atacar(Algomon algomon);
}
