package modelo;

public class AtaqueConEfectoQuemar extends AtaqueEspecial{
	public AtaqueConEfectoQuemar(Ataque ataqueADecorar) {
		super(ataqueADecorar);
	}
	
	public boolean atacar(Algomon algomon) {
		efectoSecundario(algomon);
		return super.atacar(algomon);
	}

	public void efectoSecundario(Algomon algomonAfectado) {
		algomonAfectado.cambiarEstado(new EstadoQuemado(algomonAfectado));
	}

}
