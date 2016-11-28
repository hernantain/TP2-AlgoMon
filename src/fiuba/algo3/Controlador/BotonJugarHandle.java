package Controlador;

import fiuba.algo3.vista.PantallaInicio;
import fiuba.algo3.vista.PantallaJugadores;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BotonJugarHandle implements EventHandler<MouseEvent> {

	PantallaInicio pantallaInicio;
	Stage stage;
	
	public BotonJugarHandle(PantallaInicio miPantalla, Stage stagePrincipal){
		pantallaInicio = miPantalla;
		stage = stagePrincipal;
	}
	
	public void handle(MouseEvent event) {
		PantallaJugadores pantallaJugadores = new PantallaJugadores(stage, pantallaInicio);
		pantallaInicio.cambiarVista(pantallaJugadores);
	}


}
