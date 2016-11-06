package algomon;



public abstract class AtaqueSimple extends Ataque {
	
	int daño;
	
	public boolean atacar(Algomon algomon){
		if (cantidad > 0){
			algomon.recibirAtaque((int) (daño*(tipo.conTipo(algomon.getTipo()))));
			cantidad --;
			return true;
		}
		return false;
	}

}
