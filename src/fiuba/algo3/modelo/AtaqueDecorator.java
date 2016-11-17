package modelo;

abstract class AtaqueDecorator implements Ataque{
	protected Ataque ataqueADecorar;

	public AtaqueDecorator(Ataque ataqueADecorar) {
		this.ataqueADecorar = ataqueADecorar;
	}

	public boolean atacar(Algomon algomon) {
		return ataqueADecorar.atacar(algomon);
	}

}
