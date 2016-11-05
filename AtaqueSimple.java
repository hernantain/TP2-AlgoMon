
public class AtaqueSimple extends Ataque {
	
	double daño;
	
	public boolean atacar(Algomon algomon){
		if (cantidad > 0){
			algomon.recibirAtaque(daño*(tipo.conTipo(algomon.getTipo())));
			cantidad --;
			return true;
		}
		return false;
	}

}
