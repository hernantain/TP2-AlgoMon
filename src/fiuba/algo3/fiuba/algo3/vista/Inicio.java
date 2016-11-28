package fiuba.algo3.vista;

import java.io.File;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;



public class Inicio extends Application {
	
	public static void main(String [] args){
		launch(args);
	}
	
	@Override
	public void start(Stage stagePrincipal) throws Exception {
		
		//PANTALLA INICIAL
		MediaPlayer musica = this.crearMusica("src/sonidos/Pokemon.mp3");
		musica.play();
		
		stagePrincipal.setFullScreen(true);
		
		PantallaInicio pantallaInicio = new PantallaInicio(stagePrincipal, musica);
		pantallaInicio.setearVista();
	}
	
	public MediaPlayer crearMusica(String url){
		Media media = new Media(new File(url).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.1);
		return mediaPlayer;
	}

}
