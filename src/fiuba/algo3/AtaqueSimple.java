package modelo;



public abstract class AtaqueSimple extends Ataque {
	
	int danio;
	
	public boolean atacar(Algomon algomon){
		if (cantidad > 0){
			algomon.recibirAtaque((int) (danio*(tipo.conTipo(algomon.getTipo()))));
			cantidad --;
			return true;
		}
		return false;
	}

}
