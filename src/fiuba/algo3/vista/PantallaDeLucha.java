package vista;

import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.*;
import Elementos.*;
import Ataques.*;
import Acciones.*;
import Algomones.Algomon;

public class PantallaDeLucha {

	Stage stage;
	Jugador jugador1, jugador2;
	Button botonAtacar,botonElemento,volverOpciones,volverElementos,volverAtacar;
	Turno turno;
	BorderPane pantalla;
	HBox opciones, ataques, elementos, pantallaDePelea;
	VBox algomonJ1, algomonJ2;
	ProgressBar barraDeVida1, barraDeVida2;
	FadeTransition ft;
	
	public PantallaDeLucha(Stage stagePrincipal, Jugador j1, Jugador j2){
		stage = stagePrincipal;
		jugador1 = j1;
		jugador2 = j2;
		turno = new Turno(jugador1,jugador2);
	}
	
	public Button crearBoton(String nombreAtaque){
		Button boton = new Button(nombreAtaque);
		boton.setStyle("-fx-font: 18 arial; -fx-base: #0014f4;"
					  +"-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		return boton;		
	}
	
	public void cambiarVista(){
		
		pantalla = new BorderPane();
		
		opciones = new HBox(40);
		opciones.setPrefSize(700, 150);
		opciones.setAlignment(Pos.CENTER);
		
		VBox jugador1Algomones = new VBox(10);
		jugador1Algomones.setAlignment(Pos.TOP_CENTER);
		
		VBox jugador2Algomones = new VBox(10);
		jugador2Algomones.setAlignment(Pos.TOP_CENTER);	
		
		jugador1Algomones.setPrefWidth(130);
		jugador2Algomones.setPrefWidth(130);
		
		Label nombrejugador1 = new Label(jugador1.getNombre());
		nombrejugador1.setStyle("-fx-font: 24 arial; -fx-text-fill: #00ffff;");
		jugador1Algomones.getChildren().add(nombrejugador1);
		
		Label nombrejugador2 = new Label(jugador2.getNombre());
		nombrejugador2.setStyle("-fx-font: 24 arial; -fx-text-fill: #ff0000;");
		jugador2Algomones.getChildren().add(nombrejugador2);
		
		volverAtacar = crearBoton("Volver");
			volverAtacar.setOnAction(e->{
			pantalla.setBottom(opciones);
		});
		
		volverElementos = crearBoton("Volver");
		volverElementos.setOnAction(e->{
			pantalla.setBottom(opciones);
		});
		
		
		barraDeVida1 = new ProgressBar(); //ESTA ES LA IDEA DE LAS BARRAS DE VIDA
		barraDeVida1.setProgress(1.0);	
		barraDeVida1.setPrefSize(200, 20);
		barraDeVida1.setStyle("-fx-progress-color: #ff0000");
	
		barraDeVida2 = new ProgressBar();
		barraDeVida2.setProgress(1.0);
		barraDeVida2.setPrefSize(200, 20);
		
		algomonJ1 = new VBox(100);
		algomonJ1.setAlignment(Pos.CENTER);
		ImageView imgAlgomonActivo1 = this.crearImagen("file:src/imagenes/" + jugador1.getAlgomonActivo().nombre().toLowerCase()+".png", 200, 200);
		imgAlgomonActivo1.setScaleX(-1);
		algomonJ1.getChildren().addAll(barraDeVida1,imgAlgomonActivo1 );
		algomonJ2 = new VBox(100);
		algomonJ2.setAlignment(Pos.CENTER);
		ImageView imgAlgomonActivo2 = this.crearImagen("file:src/imagenes/" + jugador2.getAlgomonActivo().nombre().toLowerCase()+".png", 200, 200);
		algomonJ2.getChildren().addAll(barraDeVida2, imgAlgomonActivo2);
		
		ft = new FadeTransition(Duration.millis(3000), imgAlgomonActivo1);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		
		pantallaDePelea = new HBox(265);
		pantallaDePelea.setStyle("-fx-background-image: url('file:src/imagenes/fondoPelea.jpg');"
								+"-fx-background-size: cover;");
		pantallaDePelea.setAlignment(Pos.CENTER);
		
		
		pantallaDePelea.getChildren().addAll(algomonJ1, algomonJ2);
		
		ataques = new HBox(40);
		ataques.setPrefSize(700, 150);
		ataques.setAlignment(Pos.CENTER);
		
		elementos = new HBox(40);
		elementos.setPrefSize(700, 150);
		elementos.setAlignment(Pos.CENTER);
		
		this.cambiarBotonAtaque(turno.jugadorActivo(), ataques, volverAtacar);
		
		botonAtacar = this.crearBoton("Atacar");
		botonAtacar.setOnAction(e->pantalla.setBottom(ataques));
		
		this.usarElementosBotones(turno.jugadorActivo(), elementos, volverElementos);
		
		botonElemento = this.crearBoton("Elementos");
		botonElemento.setOnAction(e-> {
			pantalla.setBottom(elementos);
		});
		
		volverOpciones = this.crearBoton("Volver");
		volverOpciones.setDisable(true);
		volverOpciones.setOnAction(e->{
			if( turno.jugadorActivo() == jugador1){
				this.habilitarAlgomones(jugador1Algomones, botonAtacar, botonElemento, volverOpciones);
			}
			else{ this.habilitarAlgomones(jugador2Algomones, botonAtacar, botonElemento, volverOpciones);}
		});
		Button cambiar = this.crearBoton("Cambiar Algomon");
		cambiar.setOnAction(e->{
			if (turno.jugadorActivo() == jugador1){
				this.cambiarDeAlgomon(jugador1Algomones);
			}
			else this.cambiarDeAlgomon(jugador2Algomones);
		});
		
		this.mostrarAlgomonesDeJugadores(jugador1, volverAtacar, ataques, jugador1Algomones);
		this.mostrarAlgomonesDeJugadores(jugador2, volverAtacar, ataques, jugador2Algomones);
		
		opciones.getChildren().addAll(botonAtacar, cambiar, botonElemento,volverOpciones);
		
		pantalla.setLeft(jugador1Algomones);
		pantalla.setRight(jugador2Algomones);
		pantalla.setBottom(opciones);
		pantalla.setCenter(pantallaDePelea);
		
		Scene quintaPantalla = new Scene(pantalla,1100,600);
		
		stage.setScene(quintaPantalla);
		stage.setMaximized(false);
		stage.setMaximized(true);
	}
	
	public void habilitarAlgomones(VBox jugadorAlgomones,Button atacar,Button elementos, Button volverOpciones){
		for (int x=0; x < jugadorAlgomones.getChildren().size();x++){
			jugadorAlgomones.getChildren().get(x).setDisable(true);
		}
		atacar.setDisable(false);
		elementos.setDisable(false);
		volverOpciones.setDisable(true);	
	}
	
	
	public void mostrarAlgomonesDeJugadores(Jugador jugador, Button volver, HBox ataques,VBox algomonesJugador){
		 ArrayList<Algomon> algomones = jugador.algomones();
		 for(int x = 0; x < algomones.size(); x++){
				Algomon algomon = algomones.get(x);
				Button botonAlgomon = crearBoton(algomon.nombre());
				botonAlgomon.setDisable(true);
				botonAlgomon.setOnAction(event->{
					turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(),algomon));
					barraDeVida1.setProgress(jugador1.getAlgomonActivo().vida()/(1.0*jugador1.getAlgomonActivo().getVidaMax()));
					barraDeVida2.setProgress(jugador2.getAlgomonActivo().vida()/(1.0*jugador2.getAlgomonActivo().getVidaMax()));
					this.mostrarImagenAlgomonesJugadores(jugador1, jugador2);
					this.habilitarAlgomones(algomonesJugador, botonAtacar, botonElemento, volverOpciones);
					this.cambiarBotonAtaque(turno.jugadorActivo(), ataques, volver);
				});
				algomonesJugador.getChildren().add(botonAlgomon);
		 }
		
	}
	
	public void cambiarBotonAtaque(Jugador jugador, HBox ataques, Button volver){
		ataques.getChildren().clear();
		ArrayList<Ataque> ataquesAlgomon = jugador.getAlgomonActivo().ataques();
		for(int x = 0; x < ataquesAlgomon.size(); x++){
			Ataque ataque = ataquesAlgomon.get(x);
			Button botonAtaque = crearBoton(ataque.nombre());
			if(ataque.agotado()){
				botonAtaque.setDisable(true);
			}
			botonAtaque.setOnAction(event->{
				turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), ataque, turno.jugadorNoActivo().getAlgomonActivo()));
				barraDeVida1.setProgress(jugador1.getAlgomonActivo().vida()/(1.0*jugador1.getAlgomonActivo().getVidaMax()));
				barraDeVida2.setProgress(jugador2.getAlgomonActivo().vida()/(1.0*jugador2.getAlgomonActivo().getVidaMax()));
				this.cambiarBotonAtaque(turno.jugadorActivo(), ataques, volver);
				this.usarElementosBotones(turno.jugadorActivo(), elementos, volverElementos);
				pantalla.setBottom(opciones);
				System.out.println("Vida de " + turno.jugadorActivo().getAlgomonActivo().nombre() + " ---> " + turno.jugadorActivo().getAlgomonActivo().vida());
			});
			ataques.getChildren().add(botonAtaque);
		}
		ataques.getChildren().add(volver);
	}
	
	public void usarElementosBotones(Jugador jugador, HBox elementos, Button volver){
		elementos.getChildren().clear();
		ArrayList<Elemento> elementosJugador = jugador.elementos();
		for(int x = 0; x < elementosJugador.size(); x++){
			Elemento elemento = elementosJugador.get(x);
			Button botonElemento = crearBoton(elemento.nombre());
			if(jugador.elementoAgotado(elemento)){
				botonElemento.setDisable(true);
			}
			botonElemento.setOnAction(event->{
				turno.jugar(new UsarElemento(turno.jugadorActivo(),elemento));
				barraDeVida1.setProgress(jugador1.getAlgomonActivo().vida()/(1.0*jugador1.getAlgomonActivo().getVidaMax()));
				barraDeVida2.setProgress(jugador2.getAlgomonActivo().vida()/(1.0*jugador2.getAlgomonActivo().getVidaMax()));
				this.usarElementosBotones(turno.jugadorActivo(), elementos, volver);
				this.cambiarBotonAtaque(turno.jugadorActivo(), ataques, volverAtacar);
				pantalla.setBottom(opciones);
			});
			elementos.getChildren().add(botonElemento);
		}
		elementos.getChildren().add(volver);
	}
	
	public void cambiarDeAlgomon(VBox jugadorAlgomones){
		for (int x=0; x < jugadorAlgomones.getChildren().size();x++){
			jugadorAlgomones.getChildren().get(x).setDisable(false);
		}
		botonAtacar.setDisable(true);
		botonElemento.setDisable(true);
		volverOpciones.setDisable(false);
	}
	
	public ImageView crearImagen(String url, int height, int width){
		Image img = new Image(url);
		ImageView imgView = new ImageView(img);	
		imgView.setFitHeight(height);
		imgView.setFitWidth(width);
		return imgView;
	}
	
	public void mostrarImagenAlgomonesJugadores(Jugador j1, Jugador j2){
		ImageView imgAlgomonActivo1 = this.crearImagen("file:src/imagenes/" + j1.getAlgomonActivo().nombre().toLowerCase()+".png", 200, 200);
		imgAlgomonActivo1.setScaleX(-1);
		ImageView imgAlgomonActivo2 = this.crearImagen("file:src/imagenes/" + j2.getAlgomonActivo().nombre().toLowerCase()+".png", 200, 200);
		algomonJ1.getChildren().clear();
		algomonJ2.getChildren().clear();
		algomonJ1.getChildren().addAll(barraDeVida1,imgAlgomonActivo1);
		algomonJ2.getChildren().addAll(barraDeVida2,imgAlgomonActivo2);
	}
}
