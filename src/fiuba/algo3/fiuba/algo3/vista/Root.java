package fiuba.algo3.vista;

import Controlador.BotonJugarHandle;
import Controlador.BotonReglasHandle;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Root extends VBox{
	
	Button botonSacarSonido, botonPonerSonido, botonSalir;
	
	public Root(Stage stage, PantallaInicio pantallaInicio, MediaView mediaView){
		
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER_LEFT);
		this.getStyleClass().add("root");
		
		Label mensaje = new Label();
		mensaje.setText("TP2 - AlgoMon");
		mensaje.getStyleClass().add("mensaje");
		
		
		Button botonJugar = this.crearBotonInicio("Jugar", "botonJugar");
		botonJugar.setOnMouseClicked(new BotonJugarHandle(pantallaInicio, stage));	
		
		Button botonReglas = this.crearBotonInicio("Ver Reglamento", "botonReglas");
		botonReglas.setOnMouseClicked(new BotonReglasHandle(pantallaInicio, stage));
			
		
		botonSacarSonido = this.crearBotonInicio("Silenciar Musica", "botonSacarSonido");
		botonSacarSonido.setOnAction(e->{ 
			mediaView.getMediaPlayer().setMute(true);
			this.getChildren().clear();
			this.getChildren().addAll(mensaje,botonJugar,botonReglas,botonPonerSonido,botonSalir,mediaView);
			});
		
		botonPonerSonido = this.crearBotonInicio("Sonido", "botonPonerSonido");
		botonPonerSonido.setOnAction(e->{ 
			mediaView.getMediaPlayer().setMute(false);
			this.getChildren().clear();
			this.getChildren().addAll(mensaje,botonJugar,botonReglas,botonSacarSonido,botonSalir,mediaView);
			});
		
		botonSalir = this.crearBotonInicio("Salir", "botonSalir");
		botonSalir.setOnAction(e-> stage.close());
		
		//MUTEO PORQUE NO PUEDO SABER QUE BOTON DE SONIDO PONER, NO HAY UN ISSTOPPED();
		
		if (!mediaView.getMediaPlayer().isMute()){
			this.getChildren().addAll(mensaje,botonJugar,botonReglas,botonSacarSonido,botonSalir,mediaView);
		}
		else this.getChildren().addAll(mensaje,botonJugar,botonReglas,botonPonerSonido,botonSalir,mediaView);
	}
	
	public Button crearBotonInicio(String titulo, String estilo){
		Button boton = new Button(titulo);
		boton.getStyleClass().add(estilo);
		boton.setPrefSize(300, 70);
		return boton;
	}

}
