package fiuba.algo3.vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class PantallaInicio implements Pantalla{

	Stage stage;
	Scene scene;
	Button botonSalir, botonPonerSonido, botonSacarSonido;
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	
	public PantallaInicio(Stage stagePrincipal, MediaPlayer sonido){
		stage = stagePrincipal;
		mediaPlayer = sonido;
		mediaView = new MediaView(mediaPlayer);
	}
	
	public void setearVista(){
		
		
		Root root = new Root(stage, this, mediaView);
		
		scene = new Scene(root,1100,600);
		scene.getStylesheets().add("file:src/fiuba/algo3/fiuba/algo3/vista/vista.css");
		
		stage.setTitle("TP2 - AlgoMon");
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void cambiarVista(Pantalla pantalla) {
		pantalla.setearVista();
	}

	
}
