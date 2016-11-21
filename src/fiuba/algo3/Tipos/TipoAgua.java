package Tipos;

public class TipoAgua extends Tipo {

	@Override
	public double vs(Tipo tipo) {
		return tipo.vs(this);
	}

	@Override
	public double vs(TipoAgua tipo) {
		return 0.5;
	}

	@Override
	public double vs(TipoFuego tipo) {
		return 0.5;
	}

	@Override
	public double vs(TipoNormal tipo) {
		return 1.0;
	}

	@Override
	public double vs(TipoPlanta tipo) {
		return 2.0;
	}



}
