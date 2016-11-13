package modelo;

public abstract class AtaqueEspecial extends Ataque {
	
	
	public boolean atacar(Algomon algomon) {
		if (cantidad == 0){
			return false;
		}
		algomon.recibirAtaque((int) (danio*(tipo.conTipo(algomon.getTipo()))));
		this.efectoSecundario(algomon);
		return true;
	}
	
	protected abstract void efectoSecundario(Algomon algomonAfectado);
}