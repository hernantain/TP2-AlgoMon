package modelo;

public class AtaqueConEfectoDormir extends AtaqueEspecial{
	public AtaqueConEfectoDormir(Ataque ataqueADecorar) {
		super(ataqueADecorar);
	}
	
	public boolean atacar(Algomon algomon) {
		efectoSecundario(algomon);
		return super.atacar(algomon);
	}

	public void efectoSecundario(Algomon algomonAfectado) {
		algomonAfectado.cambiarEstado(new EstadoDormido(algomonAfectado));
	}

}
