package modelo;

import java.util.ArrayList;

public class Jugador {

	private ArrayList<Algomon> algomones = new ArrayList<Algomon>();	//Lista de los algomones 
	private Algomon algomonActivo;	 
	private Jugador oponente;
	
	public void setAlgomon(Algomon unAlgomon){
		algomones.add(unAlgomon);
	}
	
	public void setOponente(Jugador contrincante){
		oponente = contrincante;
	}
	
	public void setAlgomonActivo(){				//Por el momento no la usamos, pero mas adelante, cuando querramos cambiar el algomon 
												// en juego, la vamos a usar.
	}
	
	public Algomon getAlgomonActivo(){
		return algomones.get(0);			//Por el momento solo hacemos las pruebas con un algomon
	}										//y nos devuelve el unico en la lista
	
	public void realizarAccion(AccionDeJugador accion){
		accion.accionar();					//Se pasa la accion(atacar,cambiar o usar elemento)a realizar y se ejecuta el metodo accionar
	}

	public Jugador getOponente() {
		return oponente; 
	}
}