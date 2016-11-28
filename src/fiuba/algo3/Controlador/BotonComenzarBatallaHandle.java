package Controlador;

import fiuba.algo3.vista.PantallaDeLucha;
import fiuba.algo3.vista.PantallaDeSeleccionDeAlgomones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Turno;

public class BotonComenzarBatallaHandle implements EventHandler<ActionEvent>{

	PantallaDeSeleccionDeAlgomones pantallaDeAlgomones;
	Stage stage;
	Turno turno;
	Jugador jugador1, jugador2;
	
	public BotonComenzarBatallaHandle(PantallaDeSeleccionDeAlgomones pantalla, Stage st, Turno t, Jugador j1, Jugador j2){
		pantallaDeAlgomones = pantalla;
		stage = st;
		turno = t;
		jugador1 = j1;
		jugador2 = j2;
	}
	@Override
	public void handle(ActionEvent event) {
		PantallaDeLucha pantallaLucha = new PantallaDeLucha(stage, turno, jugador1, jugador2);
		//pantallaDeAlgomones.cambiarVista(pantallaLucha);
		//CAMBIAR PANTALLA DE LUCHA QUE IMPLEMENTE PANTALLA
	}

}
