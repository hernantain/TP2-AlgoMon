package modelo;

public class AtaqueSimple implements Ataque {
	protected int cantidad;
	protected Tipo tipo;
	protected Potencia potencia;
	
	public boolean atacar(Algomon algomon){
		if (cantidad > 0){
			algomon.recibirAtaque(potencia.calcularPotencia(tipo, algomon.getTipo()));
			cantidad --;
			return true;
		}
		return false;
	}

	public void aumentarCantidadDeAtaque(int cantidadAAumentar) {
		cantidad = cantidad + cantidadAAumentar;
	}
	
	
}
