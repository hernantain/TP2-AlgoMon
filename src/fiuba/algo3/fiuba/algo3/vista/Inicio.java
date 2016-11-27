package fiuba.algo3.vista;

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
		mensaje.getStyleClass().add("mensaje");
		
		String mediaFile = "src/sonidos/Pokemon.mp3";
		Media media = new Media(new File(mediaFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
		mediaPlayer.setVolume(0.1);
		MediaView mediaView = new MediaView(mediaPlayer);
		
		
		Button botonJugar = new Button();
		botonJugar.setText("Jugar");
		botonJugar.getStyleClass().add("botonJugar");
		botonJugar.setPrefSize(300, 70);
		
		Button botonReglas = new Button();
		botonReglas.setText("Ver Reglamento");
		botonReglas.getStyleClass().add("botonReglas");
		botonReglas.setPrefSize(300, 70);
			
		
		botonSacarSonido = new Button();
		botonSacarSonido.setText("Silenciar Musica");
		botonSacarSonido.getStyleClass().add("botonSacarSonido");
		botonSacarSonido.setPrefSize(300, 70);
		botonSacarSonido.setOnAction(e->{
			mediaPlayer.stop();
			root.getChildren().clear();
			root.getChildren().addAll(mensaje,botonJugar,botonReglas,botonPonerSonido,botonSalir,mediaView);
		});
		
		botonPonerSonido = new Button();
		botonPonerSonido.setText("Sonido"); 
		botonPonerSonido.getStyleClass().add("botonPonerSonido");
		botonPonerSonido.setPrefSize(300, 70);
		botonPonerSonido.setOnAction(e->{
			mediaPlayer.play();
			root.getChildren().clear();
			root.getChildren().addAll(mensaje,botonJugar,botonReglas,botonSacarSonido,botonSalir,mediaView);
		});
		
		botonSalir = new Button();
		botonSalir.setText("Salir");
		botonSalir.getStyleClass().add("botonSalir");
		botonSalir.setOnAction(e-> stagePrincipal.close());
		botonSalir.setPrefSize(300, 70);
		
		root = new VBox(30);
		root.setAlignment(Pos.CENTER_LEFT);
		root.getChildren().addAll(mensaje,botonJugar,botonReglas,botonSacarSonido,botonSalir,mediaView);
		root.getStyleClass().add("root");
		
		Scene scene = new Scene(root,1100,600);
		scene.getStylesheets().add("file:src/fiuba/algo3/fiuba/algo3/vista/vista.css");
		
		stagePrincipal.setTitle("TP2 - AlgoMon");
		stagePrincipal.setScene(scene);
		stagePrincipal.show();
		stagePrincipal.setMaximized(true);
		
		botonJugar.setOnAction(e-> {
			PantallaJugadores segunda = new PantallaJugadores(stagePrincipal,scene);
			segunda.cambiarVista();
		});		
		
		botonReglas.setOnAction(e->{
			PantallaReglas pantallaReglas = new PantallaReglas(stagePrincipal,scene);
			pantallaReglas.cambiarVista();
		});
	}
}
