package Tipos;

public class TipoNormal extends Tipo {

	@Override
	public double vs(Tipo tipo) {
		return tipo.vs(this);
	}

	@Override
	public double vs(TipoAgua tipo) {
		return 1.0;
	}

	@Override
	public double vs(TipoFuego tipo) {
		return 1.0;
	}

	@Override
	public double vs(TipoNormal tipo) {
		return 1.0;
	}

	@Override
	public double vs(TipoPlanta tipo) {
		return 1.0;
	}
	

	
}
