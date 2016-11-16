package modelo;

import java.util.ArrayList;

public abstract class Algomon {
	
	protected Vida vida;
	protected ArrayList<Ataque> ataques = new ArrayList<Ataque>();
	protected boolean vivo = true;
	protected Tipo tipo;
	protected Estado estado = new EstadoNormal();

	public boolean atacarACon(Algomon otroAlgomon, Ataque ataque){
		try {
			estado.consecuencia(); 				//Esta implementado en cada estado. 
		} catch (EstadoDormidoExcepcion e){		//En el caso de dormido, no ataca y en quemado, se reduce el 10% de su vida original
			return false;
		}
		for (int i = 0; i < ataques.size(); i++) {
			if (ataques.get(i).getClass().equals(ataque.getClass())) {
				return ataques.get(i).atacar(otroAlgomon);
			}
		}
		throw new NoTieneElAtaqueExcepcion();
	}
	
	protected void recibirAtaque(int danio){
		vida.disminuir(danio);
	}
	
	public void curarse(int cantidadACurarse) {
		vida.aumentar(cantidadACurarse);
	}
	
	public double vida(){//ESTE METODO LO CREE PARA LOS TEST BASICAMENTE
						//DESPUES VEMOS DE SACARLO O NO PORQUE CAPAZ SIRVE PARA LA INTERFAZ GRAFICA
		return vida.actual();
	}
	
	public Tipo getTipo(){
		return tipo;
	}
	
	public void cambiarEstado(Estado nuevoEstado){
		estado = nuevoEstado;
	}

	public int getVidaMax() {
		return vida.maxima();
	}

}
