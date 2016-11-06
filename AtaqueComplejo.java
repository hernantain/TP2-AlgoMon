package algomon;

public abstract class AtaqueComplejo extends Ataque {
	
	private int daño;

	public boolean atacar(Algomon algomon) {
		if (cantidad == 0){
			return false;
		}
		algomon.recibirAtaque((int) (daño*(tipo.conTipo(algomon.getTipo()))));
		this.efectoComplejo(algomon);
		return true;
	}
	
	protected abstract void efectoComplejo(Algomon algomonAfectado);
}
