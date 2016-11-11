package modelo;

import java.util.HashMap;

public abstract class Algomon {
	
	protected int vidaMax;
	protected int vida;
	protected HashMap<String, Ataque> ataques = new HashMap<String, Ataque>();
	protected boolean vivo = true;
	protected Tipo tipo;
	protected Estado estado = new EstadoNormal();
	
	public boolean atacarACon(Algomon otroAlgomon, String ataque){
		return ataques.get(ataque).atacar(otroAlgomon);
	}
	
	protected void recibirAtaque(int danio){
		int vidaRestante = vida - danio;
		if (vidaRestante <= 0){
			vida = 0;
			vivo = false;
			return;
		}
		vida = vidaRestante;
	}
	
	public double vida(){//ESTE METODO LO CREE PARA LOS TEST BASICAMENTE
						//DESPUES VEMOS DE SACARLO O NO PORQUE CAPAZ SIRVE PARA LA INTERFAZ GRAFICA
		return vida;
	}
	
	public Tipo getTipo(){
		return tipo;
	}
	
	public void cambiarEstado(Estado nuevoEstado){
		estado = nuevoEstado;
	}

	public int getVidaMax() {
		return vidaMax;
	}

}
