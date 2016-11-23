package Algomones;

import java.util.ArrayList;

import Ataques.Ataque;
import Ataques.NoTieneElAtaqueExcepcion;
import Estado.Estado;
import Estado.EstadoDormido;
import Estado.EstadoDormidoExcepcion;
import Estado.EstadoNormal;
import Tipos.Tipo;

public abstract class Algomon {
	
	protected Vida vida;
	protected ArrayList<Ataque> ataques = new ArrayList<Ataque>();
	protected boolean vivo = true;
	protected Tipo tipo;
	protected Estado estado = new EstadoNormal();
	protected String nombre;
	protected Ataque ataqueActual;

	public boolean atacarA(Algomon otroAlgomon){
		if (this.efectoDeEstado()){
			return ataqueActual.atacar(otroAlgomon);
		}
		return false;
	}
	
	public boolean setEstrategiaAtaque(Ataque ataque){
		try{
			ataqueActual = this.esAtaqueValido(ataque);
			return true;
		}
		catch(NoTieneElAtaqueExcepcion e){
			return false;
		}
	}
	
	protected Ataque esAtaqueValido(Ataque ataque){
		for (Ataque ataques: ataques){
			if( ataque.equals(ataques)){
				return ataques;
			}
		}
		throw new NoTieneElAtaqueExcepcion();
	}
	
	public void recibirAtaque(int danio){
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
	
	public void aumentarCantidadDeAtaques(int cantidadAAumentar) {
		for(int i=0; i < ataques.size(); i++) {
			ataques.get(i).aumentarCantidadDeAtaque(cantidadAAumentar);
		}
	}
	
	public boolean estadoEsDormido(){
		return estado.getClass().equals(new EstadoDormido(this).getClass());
	}

	public String nombre() {
		return nombre;
	}

	public ArrayList<Ataque> ataques() {
		return ataques;
	}

	public boolean efectoDeEstado() {
		try {
			estado.efecto();
			return true;
		} catch (EstadoDormidoExcepcion e){
			return false;
		}
	}

	public boolean estaVivo() {
		return !vida.agotada();
	}
	

}
