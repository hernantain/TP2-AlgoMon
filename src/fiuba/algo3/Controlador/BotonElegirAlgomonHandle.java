package Controlador;

import Algomones.Algomon;
import fiuba.algo3.vista.PantallaDeSeleccionDeAlgomones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonElegirAlgomonHandle implements EventHandler<ActionEvent>{
	
	Algomon miAlgomon;
	String url;
	PantallaDeSeleccionDeAlgomones pantallaAlgomones;
	
	public BotonElegirAlgomonHandle(PantallaDeSeleccionDeAlgomones pantalla, Algomon algomon, String dir){
		miAlgomon = algomon;
		url = dir;
		pantallaAlgomones = pantalla;
	}

	@Override
	public void handle(ActionEvent event) {
		pantallaAlgomones.agregarImagenDeAlgomonAJugador(miAlgomon, url);
		pantallaAlgomones.modificarFocus();
	}

}
