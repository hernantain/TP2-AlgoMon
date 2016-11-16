package modelo;

public abstract class Tipo {
	
	public abstract double vs(Tipo tipo);
	public abstract double vs(TipoAgua tipo);
	public abstract double vs(TipoFuego tipo);
	public abstract double vs(TipoNormal tipo);
	public abstract double vs(TipoPlanta tipo);
}
