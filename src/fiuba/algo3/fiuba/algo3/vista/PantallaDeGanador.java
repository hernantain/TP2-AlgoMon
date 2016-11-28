package fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		Label labelGanador = new Label("¡" + jugador.getNombre() + " ha ganado el juego!");
		labelGanador.setStyle("-fx-font: 45 arial; -fx-text-fill: #ff0000;");
		
		Button finalizarJuego = new Button("Finalizar Juego");
		finalizarJuego.getStyleClass().add("botonSalir");
		finalizarJuego.setOnAction(e->stage.close());
		
		Button volverAJugar = new Button("Volver a jugar");
		
		VBox layout = new VBox(50);
		layout.getChildren().addAll(labelGanador,volverAJugar,finalizarJuego);	
		layout.setAlignment(Pos.CENTER_LEFT);
		layout.setStyle("-fx-background-image: url('file:src/imagenes/fondoGanador.jpg');"
					   +"-fx-background-size: cover;");
		
		Scene sceneFinal = new Scene(layout,1100,600);
		sceneFinal.getStylesheets().add("file:src/fiuba/algo3/fiuba/algo3/vista/vista.css");
		stage.setScene(sceneFinal);
		stage.setMaximized(false);
		stage.setMaximized(true);
	}
}