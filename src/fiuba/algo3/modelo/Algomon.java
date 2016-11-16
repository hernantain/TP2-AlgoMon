package modelo;

import java.util.HashMap;

public abstract class Algomon {
	
	protected Vida vida;
	protected HashMap<String, Ataque> ataques = new HashMap<String, Ataque>();
	protected boolean vivo = true;
	protected Tipo tipo;
	protected Estado estado = new EstadoNormal();

	public boolean atacarACon(Algomon otroAlgomon, String ataque){
		try {
			estado.consecuencia(); 				//Esta implementado en cada estado. 
		} catch (EstadoDormidoExcepcion e){		//En el caso de dormido, no ataca y en quemado, se reduce el 10% de su vida original
			return false;
		}
		return ataques.get(ataque).atacar(otroAlgomon);
	}
	
	protected void recibirAtaque(int danio){
		this.vida.recibirDanio(danio);
	}
	
	public void curarse(int cantidadACurarse) {
		this.vida.recibirCuracion(cantidadACurarse);
	}
	
	public double vida(){//ESTE METODO LO CREE PARA LOS TEST BASICAMENTE
						//DESPUES VEMOS DE SACARLO O NO PORQUE CAPAZ SIRVE PARA LA INTERFAZ GRAFICA
		return vida.getActual();
	}
	
	public Tipo getTipo(){
		return tipo;
	}
	
	public void cambiarEstado(Estado nuevoEstado){
		estado = nuevoEstado;
	}

	public int getVidaMax() {
		return vida.getMaxima();
	}

}
