package vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.*;


public class Inicio extends Application {
	
	public static void main(String [] args){
		launch(args);
	}
	
	Scene scene;
	Jugador jugador1,jugador2;
	
	@Override
	public void start(Stage stagePrincipal) throws Exception {
		
		//PANTALLA INICIAL
		Label mensaje = new Label();
		mensaje.setText("TP2 - AlgoMon");
		mensaje.setStyle("-fx-font: 45 arial;"
						+"-fx-text-fill: #ff0000;"
						+"-fx-opacity: 1000;"
						+"-fx-vpos: top;");
		
		Button botonJugar = new Button();
		botonJugar.setText("Jugar");
		botonJugar.setStyle("-fx-font: 22 arial; -fx-base: #0014f4;"
						+   "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		botonJugar.setPrefSize(300, 70);
		
		
		Button botonSalir = new Button();
		botonSalir.setText("Salir");
		botonSalir.setStyle("-fx-font: 22 arial; -fx-base: #ff0000;"
						   +"-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		botonSalir.setOnAction(e-> stagePrincipal.close());
		botonSalir.setPrefSize(300, 70);
		
		
		
		VBox root = new VBox(30);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(mensaje,botonJugar,botonSalir);
		
		
		root.setStyle("-fx-background-image: url('file:src/imagenes/fondo.jpg');"
					+ "-fx-background-position: 50% 50%;"
					+ "-fx-background-size: cover;"
					+ "-fx-border-color: red");
		
		Scene scene = new Scene(root,1100,600);
		stagePrincipal.setTitle("TP2 - AlgoMon");
		stagePrincipal.setScene(scene);
		stagePrincipal.show();
		stagePrincipal.setMaximized(true);
		
		botonJugar.setOnAction(e-> {
			PantallaJugadores segunda = new PantallaJugadores(stagePrincipal,scene);
			segunda.cambiarVista();
		});		
	}
}
