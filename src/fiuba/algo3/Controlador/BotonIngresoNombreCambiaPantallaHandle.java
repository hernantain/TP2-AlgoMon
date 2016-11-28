package Controlador;

import fiuba.algo3.vista.Alerta;
import fiuba.algo3.vista.PantallaDeSeleccionDeAlgomones;
import fiuba.algo3.vista.PantallaJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.NombreVacioExcepcion;

public class BotonIngresoNombreCambiaPantallaHandle implements EventHandler<ActionEvent> {

	PantallaJugadores pantallaJugadores;
	Stage stage;
	Jugador jugador1, jugador2;
	TextField casilla;
	
	public BotonIngresoNombreCambiaPantallaHandle(PantallaJugadores pantallaAnterior,Stage stagePrincipal, Jugador j1, TextField casillaJ2){
		pantallaJugadores = pantallaAnterior;
		jugador1 = j1;
		casilla = casillaJ2;
		stage = stagePrincipal;
	}
	
	public void handle(ActionEvent event) {
		try{
			jugador2 = new Jugador(casilla.getText());
			PantallaDeSeleccionDeAlgomones seleccion = new PantallaDeSeleccionDeAlgomones(stage,jugador1,jugador2);
			pantallaJugadores.cambiarVista(seleccion);
		   }catch (NombreVacioExcepcion ex){
			   new Alerta("Ingrese un nombre", stage);
		   }
	}


}

