package fiuba.algo3.vista;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Jugador;

public class PantallaDeGanador {
	Jugador jugador;
	Stage stage;

	public PantallaDeGanador(Stage stagePrincipal, Jugador jugadorGanador) {
		stage = stagePrincipal;
		jugador = jugadorGanador;
	}
	
	public void cambiarVista(){
		Label label = new Label(jugador.getNombre());
		
		VBox layout = new VBox();
		layout.getChildren().addAll(label);		
		Scene scene = new Scene(layout,1100,600);
		
		stage.setScene(scene);
		stage.setMaximized(false);
		stage.setMaximized(true);
	}

}
