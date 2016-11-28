package Controlador;

import fiuba.algo3.vista.Pantalla;
import fiuba.algo3.vista.PantallaInicio;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonVolverAInicioHandle implements EventHandler<MouseEvent> {

	PantallaInicio pantallaInicio;
	Pantalla pantallaActual;
	
	public BotonVolverAInicioHandle(Pantalla miPantallaActual, PantallaInicio miPantallaInicio){
		pantallaInicio = miPantallaInicio;
		pantallaActual = miPantallaActual;
	}
	
	public void handle(MouseEvent event) {
		pantallaActual.cambiarVista(pantallaInicio);
	}

}
