package modelo;

public class Canto extends AtaqueEspecial{

	public Canto(){
		danio = 0;
		cantidad = 6;
		tipo = new TipoNormal();
	}
	@Override
	protected void efectoSecundario(Algomon algomonAfectado) {
		algomonAfectado.cambiarEstado(new EstadoDormido(algomonAfectado));
	}

}
