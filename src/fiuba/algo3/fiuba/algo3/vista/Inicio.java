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
		
		
		Button botonJugar = this.crearBotonInicio("Jugar", "botonJugar");
		botonJugar.setOnAction(e-> {
			PantallaJugadores segunda = new PantallaJugadores(stagePrincipal,scene);
			segunda.cambiarVista();
		});	
		
		Button botonReglas = this.crearBotonInicio("Ver Reglamento", "botonReglas");
		botonReglas.setOnAction(e->{
			PantallaReglas pantallaReglas = new PantallaReglas(stagePrincipal,scene);
			pantallaReglas.cambiarVista();
		});
			
		
		botonSacarSonido = this.crearBotonInicio("Silenciar Musica", "botonSacarSonido");
		botonSacarSonido.setOnAction(e->{
			mediaPlayer.stop();
			root.getChildren().clear();
			root.getChildren().addAll(mensaje,botonJugar,botonReglas,botonPonerSonido,botonSalir,mediaView);
		});
		
		botonPonerSonido = this.crearBotonInicio("Sonido", "botonPonerSonido");
		botonPonerSonido.setOnAction(e->{
			mediaPlayer.play();
			root.getChildren().clear();
			root.getChildren().addAll(mensaje,botonJugar,botonReglas,botonSacarSonido,botonSalir,mediaView);
		});
		
		botonSalir = this.crearBotonInicio("Salir", "botonSalir");
		botonSalir.setOnAction(e-> stagePrincipal.close());
		
		root = new VBox(30);
		root.setAlignment(Pos.CENTER_LEFT);
		root.getChildren().addAll(mensaje,botonJugar,botonReglas,botonSacarSonido,botonSalir,mediaView);
		root.getStyleClass().add("root");
		
		scene = new Scene(root,1100,600);
		scene.getStylesheets().add("file:src/fiuba/algo3/fiuba/algo3/vista/vista.css");
		
		stagePrincipal.setTitle("TP2 - AlgoMon");
		stagePrincipal.setScene(scene);
		stagePrincipal.show();
		stagePrincipal.setMaximized(true);	
	}
	
	public Button crearBotonInicio(String titulo, String estilo){
		Button boton = new Button(titulo);
		boton.getStyleClass().add(estilo);
		boton.setPrefSize(300, 70);
		return boton;
	}
}
