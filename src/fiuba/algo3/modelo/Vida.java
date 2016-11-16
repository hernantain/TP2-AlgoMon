package modelo;

public class Vida {
	
	private int vidaMaxima;
	private int vidaActual;
	private boolean debilitado;
	
	public Vida(int vidaInicial) {
		this.vidaMaxima = this.vidaActual = vidaInicial;
		this.debilitado = false;
	}

	public void recibirDanio(int danio) {
		int vidaRestante = vidaActual - danio;
		if (vidaRestante <= 0){
			vidaActual = 0;
			debilitado = true;
		}
		vidaActual = vidaRestante;		
	}

	public void recibirCuracion(int cantidadACurarse) {
		int vidaResultante = vidaActual + cantidadACurarse;
		if (vidaResultante >= vidaMaxima) {
			vidaActual = vidaMaxima;
		} else {
			vidaActual = vidaResultante;
		}		
	}
	
	public int getActual() {
		return vidaActual;
	}

	public int getMaxima() {
		return vidaMaxima;
	}
	
}
