package Algomones;

import java.util.ArrayList;

import Ataques.Ataque;
import Ataques.NoTieneElAtaqueExcepcion;
import Estado.Estado;
import Estado.EstadoDormido;
import Estado.EstadoDormidoExcepcion;
import Estado.EstadoNormal;
import Estado.FinEstadoDormidoExcepcion;
import Tipos.Tipo;

public abstract class Algomon {
	
	protected Vida vida;
	protected ArrayList<Estado> estados = new ArrayList<Estado>();
	protected ArrayList<Ataque> ataques = new ArrayList<Ataque>();
	protected Tipo tipo;
	protected Estado estado = new EstadoNormal();
	protected String nombre;
	protected Ataque ataqueActual;

	@Override
	public boolean equals(Object otroAlgomon){
		if (((Algomon)otroAlgomon).nombre == this.nombre) {
			return true;
		}
		return false;
	}
	
	public boolean atacarA(Algomon otroAlgomon){
		if (this.estaVivo()){
			if (this.efectoDeEstado()){
				return ataqueActual.atacar(otroAlgomon);
			}
			return false;
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
		if(!this.estaVivo()){
			throw new AlgomonDebilitadoExcepcion();
		}
	}
	
	public void curarse(int cantidadACurarse) {
		if (this.estaVivo()){
			vida.aumentar(cantidadACurarse);
		}//VER EL MANEJO DE ALGUNA EXCPECION PARA NO UTILIZAR EL ELEMENTO
	}
	
	public double vida(){//ESTE METODO LO CREE PARA LOS TEST BASICAMENTE
						//DESPUES VEMOS DE SACARLO O NO PORQUE CAPAZ SIRVE PARA LA INTERFAZ GRAFICA
		return vida.actual();
	}
	
	public Tipo getTipo(){
		return tipo;
	}
	
	public void agregarEstado(Estado nuevoEstado) {
		for (Estado estado: estados){
			if (nuevoEstado.equals(estado)){
				return;
			}
		}
		estados.add(nuevoEstado);
	}
	
	public void quitarEstado(Estado estadoAQuitar){
		for (int i=0; i < estados.size(); i++){
			if (estadoAQuitar.equals(estados.get(i))){
				estados.remove(i);
			}
		}
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
		return estado.equals(new EstadoDormido(this));
	}

	public String nombre() {
		return nombre;
	}

	public ArrayList<Ataque> ataques() {
		return ataques;
	}

	public boolean efectoDeEstado() {
		boolean atacar = true;
		boolean quitarEstado = false;
		for (Estado estado: estados) {
			try {
				estado.efecto();
			} catch (EstadoDormidoExcepcion e){
				atacar = false;
			} catch (FinEstadoDormidoExcepcion e){
				atacar = false;
				quitarEstado = true;
			}
		}
		if (quitarEstado) {
			this.quitarEstado(new EstadoDormido(this));
		}
		return atacar;
	}

	public boolean estaVivo() {
		return !vida.agotada();
	}
	

}
