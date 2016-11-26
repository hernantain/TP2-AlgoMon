package Estado;

public abstract class Estado {

	protected String nombre;
	
	public abstract String nombre();
	
	public abstract boolean equals(Estado estado);

	public abstract void efecto();
}
