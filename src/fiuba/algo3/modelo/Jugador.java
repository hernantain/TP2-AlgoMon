package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import Acciones.AccionDeJugador;
import Algomones.Algomon;
import Elementos.Elemento;
import Elementos.Pocion;
import Elementos.Restaurador;
import Elementos.SuperPocion;
import Elementos.Vitamina;

public class Jugador {
	
	private int cantidadDeAlgomonesASeleccionar = 3; 
	private ArrayList<Algomon> algomones = new ArrayList<Algomon>();	//Lista de los algomones 
	private HashMap<Elemento, Integer> elementos = new HashMap<Elemento, Integer>();
	private Algomon algomonActivo;	 
	private Jugador oponente;
	private String nombreJugador;
	
	public Jugador(String nombre) {
		this.setElementosIniciales();
		nombreJugador = nombre;
	}
	
	private void setElementosIniciales() {
		elementos.put(new Pocion(), 4);
		elementos.put(new SuperPocion(), 2);
		elementos.put(new Vitamina(), 5);
		elementos.put(new Restaurador(), 3);
	}

	public void setAlgomon(Algomon unAlgomon){
		if (algomones.size() == cantidadDeAlgomonesASeleccionar) {
			throw new LimiteDeAlgomonesAlcanzadoExcepcion();
		}
		else if (algomones.contains(unAlgomon)) {
			throw new AlgomonRepetidoExcepcion();
		}
		algomones.add(unAlgomon);
		if (algomones.size() == 1) {
			setAlgomonActivo(unAlgomon);
		}
	}
	
	public void setOponente(Jugador contrincante){
		oponente = contrincante;
	}
	
	public void setAlgomonActivo(Algomon unAlgomon){				//Por el momento no la usamos, pero mas adelante, cuando querramos cambiar el algomon 
		algomonActivo = unAlgomon;
	}
	
	public Algomon getAlgomonActivo(){
		return algomonActivo;			//Por el momento solo hacemos las pruebas con un algomon
	}										//y nos devuelve el unico en la lista
	
	public boolean realizarAccion(AccionDeJugador accion){
		return accion.accionar();			//Se pasa la accion(atacar,cambiar o usar elemento)a realizar y se ejecuta el metodo accionar
	}

	public Jugador getOponente() {
		return oponente; 
	}
	
	public boolean usarElemento(Elemento elementoRecibido) {

		for(Elemento elementoAlmacenado : elementos.keySet()) {
			if (elementoAlmacenado.getClass().equals(elementoRecibido.getClass())) {
				elementoAlmacenado.aplicarA(algomonActivo);
				int cantidad = elementos.get(elementoAlmacenado);
				elementos.put(elementoAlmacenado, cantidad-1);
				return true;
			}
		}
		return false;
	}
	
	public boolean elementoAgotado(Elemento elementoAVerificar){
		for(Elemento elementoAlmacenado : elementos.keySet()) {
			if (elementoAlmacenado.getClass().equals(elementoAVerificar.getClass())){
				if( elementos.get(elementoAlmacenado) == 0){
					return true;
				}
			}
		}
		return false;
	}

	public boolean cambiarAlgomonActivo(Algomon algomonEntrante) {
		for (int i = 0; i < algomones.size(); i++) {
			if (algomones.get(i).equals(algomonEntrante)) {
				this.setAlgomonActivo(algomones.get(i));
				return true;
			}
		}
		return false;
	}
	
	public String getNombre(){
		return nombreJugador;
	}

	public ArrayList<Elemento> elementos(){
		ArrayList<Elemento> elementosADevolver = new ArrayList<Elemento>();
		for (Elemento elementoAlmacenado : elementos.keySet()){
			elementosADevolver.add(elementoAlmacenado);
		}
		return elementosADevolver;
	}
	
	public ArrayList<Algomon> algomones() {
		return algomones;
	}

	public boolean algomonesVivos() {
		for (Algomon algomon : algomones){
			if (algomon.estaVivo()){
				return true;
			}
		}
		return false;
	}
}