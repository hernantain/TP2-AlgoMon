package modelo;

import Acciones.AccionDeJugador;
import Algomones.Algomon;
import Algomones.AlgomonDebilitadoExcepcion;

public class Turno {

	private Jugador jugadorActivo;  //Es el jugador que le corresponde jugar
	private Jugador jugador1;
	private Jugador jugador2;       //Los 2 jugadores del juego
	
	public Turno(Jugador player1, Jugador player2) {
		jugadorActivo = player1;   //Esto hay que implmentarlo al azar, despues vemos como.
		jugador1 = player1;
		jugador2 = player2;
		jugador1.setOponente(jugador2);
		jugador2.setOponente(jugador1);
	}
	
	public boolean jugar(AccionDeJugador accion){ //Al jugador que le corresponde jugar se le pasa la accion correspondiente
		try{
			boolean resultado = jugadorActivo.realizarAccion(accion);
			if( !jugadorActivo.getAlgomonActivo().estadoEsDormido()){ //VER QUE PASA SI ALGOMN ACTIVO DOMRIDO Y EL DEL BANCO TMB
				for (Algomon algomon: jugadorActivo.algomones()){
					if( algomon.estadoEsDormido()){
						algomon.efectoDeEstado();
					}
				}
			}
			cambiarJugador();
			return resultado;
		} catch (AlgomonDebilitadoExcepcion e){    //Cada vez que se realiza una accion, cambia el jugador activo.
			cambiarJugador();
			throw new AlgomonDebilitadoExcepcion();
		}
		
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
}
