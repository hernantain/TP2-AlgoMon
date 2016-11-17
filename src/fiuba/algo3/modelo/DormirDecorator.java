package modelo;

public class DormirDecorator extends AtaqueDecorator{
	public DormirDecorator(Ataque ataqueADecorar) {
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
