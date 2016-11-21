package Algomones;

public class Vida {
	
	private int vidaMaxima;
	private int vidaActual;
	private boolean debilitado;
	
	public Vida(int vidaInicial) {
		this.vidaMaxima = this.vidaActual = vidaInicial;
		this.debilitado = false;
	}

	public void disminuir(int danio) {
		int vidaRestante = vidaActual - danio;
		if (vidaRestante <= 0){
			vidaActual = 0;
			debilitado = true;
		}
		vidaActual = vidaRestante;		
	}

	public void aumentar(int cantidadACurarse) {
		int vidaResultante = vidaActual + cantidadACurarse;
		if (vidaResultante >= vidaMaxima) {
			vidaActual = vidaMaxima;
		} else {
			vidaActual = vidaResultante;
		}		
	}
	
	public int actual() {
		return vidaActual;
	}

	public int maxima() {
		return vidaMaxima;
	}
	
}
