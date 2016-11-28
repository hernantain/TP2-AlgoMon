package Controlador;

import java.io.File;

import fiuba.algo3.vista.PantallaDeGanador;
import fiuba.algo3.vista.PantallaInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BotonVolverAJugarHandle implements EventHandler<ActionEvent> {
	
	PantallaDeGanador pantallaGanador;
	Stage stage;
	
	public BotonVolverAJugarHandle(PantallaDeGanador pantalla, Stage stagePrincipal){
		pantallaGanador = pantalla;
		stage = stagePrincipal;
	}

	@Override
	public void handle(ActionEvent event) {
		MediaPlayer musica = this.crearMusica("src/sonidos/Pokemon.mp3");
		musica.play();
		PantallaInicio pantallaJugarDeNuevo = new PantallaInicio(stage, musica);
		pantallaGanador.cambiarVista(pantallaJugarDeNuevo);

	}

	private MediaPlayer crearMusica(String url){
		Media media = new Media(new File(url).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.1);
		return mediaPlayer;
	}
}
