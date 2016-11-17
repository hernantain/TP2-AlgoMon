package modelo;

abstract class AtaqueEspecial implements Ataque{
	protected Ataque ataqueADecorar;

	public AtaqueEspecial(Ataque ataqueADecorar) {
		this.ataqueADecorar = ataqueADecorar;
	}

	public boolean atacar(Algomon algomon) {
		return ataqueADecorar.atacar(algomon);
	}

}
