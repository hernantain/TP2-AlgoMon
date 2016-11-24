package vista;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import modelo.*;


public class Inicio extends Application {
	
	public static void main(String [] args){
		launch(args);
	}
	
	Scene scene;
	Jugador jugador1,jugador2;
	Button botonSalir, botonPonerSonido, botonSacarSonido;
	VBox root;
	
	@Override
	public void start(Stage stagePrincipal) throws Exception {
		
		//PANTALLA INICIAL
		Label mensaje = new Label();
		mensaje.setText("TP2 - AlgoMon");
		mensaje.setStyle("-fx-font: 45 arial;"
						+"-fx-text-fill: #ff0000;"
						+"-fx-opacity: 1000;"
						+"-fx-vpos: top;");
		
		String mediaFile = "src/sonidos/Pokemon.mp3";
		
		Media media = new Media(new File(mediaFile).toURI().toString());
		
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		//mediaPlayer.play();
		mediaPlayer.setVolume(0.1);
		MediaView mediaView = new MediaView(mediaPlayer);
		
		
		Button botonJugar = new Button();
		botonJugar.setText("Jugar");
		botonJugar.setStyle("-fx-font: 22 arial; -fx-base: #0014f4;"
						+   "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		botonJugar.setPrefSize(300, 70);
		
		botonSacarSonido = new Button();
		botonSacarSonido.setText("Silenciar"); //ME TIENE LOS HUEVOS LLENOS LA CANCIONSITA
		botonSacarSonido.setStyle("-fx-font: 22 arial; -fx-base: #0014f4;"
						+   "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		botonSacarSonido.setPrefSize(300, 70);
		botonSacarSonido.setOnAction(e->{
			mediaPlayer.stop();
			root.getChildren().clear();
			root.getChildren().addAll(mensaje,botonJugar, botonPonerSonido,botonSalir,mediaView);
		});
		
		botonPonerSonido = new Button();
		botonPonerSonido.setText("Sonido"); //ME TIENE LOS HUEVOS LLENOS LA CANCIONSITA
		botonPonerSonido.setStyle("-fx-font: 22 arial; -fx-base: #0014f4;"
						+   "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		botonPonerSonido.setPrefSize(300, 70);
		botonPonerSonido.setOnAction(e->{
			mediaPlayer.play();
			root.getChildren().clear();
			root.getChildren().addAll(mensaje,botonJugar, botonSacarSonido,botonSalir,mediaView);
		});
		
		
		botonSalir = new Button();
		botonSalir.setText("Salir");
		botonSalir.setStyle("-fx-font: 22 arial; -fx-base: #ff0000;"
						   +"-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		botonSalir.setOnAction(e-> stagePrincipal.close());
		botonSalir.setPrefSize(300, 70);
		
		root = new VBox(30);
		root.setAlignment(Pos.CENTER_LEFT);
		root.getChildren().addAll(mensaje,botonJugar, botonSacarSonido,botonSalir,mediaView);
		
		
		root.setStyle("-fx-background-image: url('file:src/imagenes/fondo10.jpg');"
					+ "-fx-background-position: 50% 50%;"
					+ "-fx-background-size: cover;");
		
		Scene scene = new Scene(root,1100,600);
		
		stagePrincipal.setTitle("TP2 - AlgoMon");
		stagePrincipal.setScene(scene);
		stagePrincipal.show();
		stagePrincipal.setFullScreen(true);
		
		
		botonJugar.setOnAction(e-> {
			PantallaJugadores segunda = new PantallaJugadores(stagePrincipal,scene);
			segunda.cambiarVista();
		});		
	}
}
