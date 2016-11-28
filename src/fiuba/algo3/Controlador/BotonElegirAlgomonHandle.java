package Controlador;

import java.util.HashMap;

import Algomones.*;
import fiuba.algo3.vista.PantallaDeSeleccionDeAlgomones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonElegirAlgomonHandle implements EventHandler<ActionEvent>{
	
	Algomon miAlgomon;
	String url;
	PantallaDeSeleccionDeAlgomones pantallaAlgomones;
	HashMap<String,Algomon> algomones = new HashMap<String,Algomon>();
	
	public BotonElegirAlgomonHandle(PantallaDeSeleccionDeAlgomones pantalla, Algomon algomon, String dir){
		this.actualizarAlgomones();
		miAlgomon = algomon;
		url = dir;
		pantallaAlgomones = pantalla;
	}

	@Override
	public void handle(ActionEvent event) {
		pantallaAlgomones.agregarImagenDeAlgomonAJugador(algomones.get(miAlgomon.nombre()), url);
		pantallaAlgomones.modificarFocus();
		this.actualizarAlgomones();
	}

	private void actualizarAlgomones() {
		algomones.put("Charmander", new Charmander());
		algomones.put("Squirtle", new Squirtle());
		algomones.put("Bulbasaur", new Bulbasaur());
		algomones.put("Jigglypuff", new Jigglypuff());
		algomones.put("Chansey", new Chansey());
		algomones.put("Rattata", new Rattata());
		
	}

}
