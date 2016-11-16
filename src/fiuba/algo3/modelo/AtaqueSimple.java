package modelo;

public abstract class AtaqueSimple extends Ataque {
	
	
	public boolean atacar(Algomon algomon){
		if (cantidad > 0){
			algomon.recibirAtaque(potencia.calcularPotencia(tipo, algomon.getTipo()));
			cantidad --;
			return true;
		}
		return false;
	}

}
