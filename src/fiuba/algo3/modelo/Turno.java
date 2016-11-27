package modelo;

import java.util.Random;

import Acciones.AccionDeJugador;
import Algomones.Algomon;
import Algomones.AlgomonDebilitadoExcepcion;

public class Turno {

	private Jugador jugadorActivo;  //Es el jugador que le corresponde jugar
	private Jugador jugador1;
	private Jugador jugador2;       //Los 2 jugadores del juego
	private Jugador jugadorGanador;
	
	public Turno(Jugador player1, Jugador player2) {
		jugadorActivo = player1;
		jugador1 = player1;
		jugador2 = player2;
		jugador1.setOponente(jugador2);
		jugador2.setOponente(jugador1);
	}
	
	public void activarJugabilidad(){
		Random randomGenerator = new Random();
		if( randomGenerator.nextInt(2) == 0) jugadorActivo = jugador1;
		else jugadorActivo = jugador2;
	}
	
	public boolean jugar(AccionDeJugador accion){ //Al jugador que le corresponde jugar se le pasa la accion correspondiente
		boolean resultado;
		try{
			resultado = jugadorActivo.realizarAccion(accion);
			cambiarJugador();
		} catch (AlgomonDebilitadoExcepcion e){    //Cada vez que se realiza una accion, cambia el jugador activo.
			cambiarJugador();
			resultado = false;
		}
		return resultado;
	}
	
	public void cambiarJugador(){
		if (jugadorActivo == jugador1){
			jugadorActivo = jugador2;
			return;
		}
		jugadorActivo = jugador1;
	}
	
	public Jugador jugadorActivo(){
		return jugadorActivo;
	}
	
	public Jugador jugadorNoActivo(){
		if (jugadorActivo == jugador1) {
			return jugador2;
		} else {
			return jugador1;
		}
	}

	public boolean hayGanador() {
		if( !jugador1.algomonesVivos()){
			jugadorGanador = jugador2;
			return true;
		}
		else if( !jugador2.algomonesVivos()){
			jugadorGanador = jugador1;
			return true;
		}
		else{ return false;}
	}

	public Jugador jugadorGanador() {
		return jugadorGanador;
	}

	public void elegirAlgomon(Algomon algomon) {
		jugadorActivo.setAlgomon(algomon);
		cambiarJugador();
	}
}
