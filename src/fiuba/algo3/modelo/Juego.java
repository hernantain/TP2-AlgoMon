package modelo;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Turno turno;
	//private Turno turno2;
	
	public Juego(Jugador player1, Jugador player2){
		jugador1 = player1;
		turno = new Turno(jugador1,jugador2);
		//turno2 = new Turno(jugador2);
	}
	
	

}
