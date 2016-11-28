package Controlador;

import fiuba.algo3.vista.PantallaInicio;
import fiuba.algo3.vista.PantallaReglas;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BotonReglasHandle implements EventHandler<MouseEvent> {

	PantallaInicio pantallaInicio;
	Stage stage;
	
	public BotonReglasHandle(PantallaInicio miPantalla, Stage stagePrincipal){
		pantallaInicio = miPantalla;
		stage = stagePrincipal;
	}
	
	public void handle(MouseEvent event) {
		PantallaReglas pantallaReglas = new PantallaReglas(stage, pantallaInicio);
		pantallaInicio.cambiarVista(pantallaReglas);
	}


}
