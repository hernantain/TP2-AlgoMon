package Controlador;

import fiuba.algo3.vista.Alerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.NombreVacioExcepcion;

public class BotonIngresoNombreHandle implements EventHandler<ActionEvent> {

	Scene nuevaEscena;
	Stage stage;
	TextField casilla;
	Jugador jugador;
	
	public BotonIngresoNombreHandle(Stage stagePrincipal, Scene scene, TextField miCasilla, Jugador miJugador){
		nuevaEscena = scene;
		stage = stagePrincipal;
		casilla = miCasilla;
		jugador = miJugador;
	}
	
	public void handle(ActionEvent event) {
		try{
			jugador = new Jugador(casilla.getText());
			stage.setScene(nuevaEscena);
			stage.setFullScreen(true);
		   }catch (NombreVacioExcepcion ex){
			   new Alerta("Ingrese un nombre", stage);			   
		   }
	}
	
}
