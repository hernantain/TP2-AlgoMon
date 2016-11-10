package modelo;

public abstract class AtaqueComplejo extends Ataque {
	
	
	public boolean atacar(Algomon algomon) {
		if (cantidad == 0){
			return false;
		}
		algomon.recibirAtaque((int) (danio*(tipo.conTipo(algomon.getTipo()))));
		this.efectoComplejo(algomon);
		return true;
	}
	
	protected abstract void efectoComplejo(Algomon algomonAfectado);
}
