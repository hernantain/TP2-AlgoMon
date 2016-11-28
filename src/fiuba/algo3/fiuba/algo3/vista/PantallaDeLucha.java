package fiuba.algo3.vista;

import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
	Button botonAtacar,botonElemento, botonCambiar, volverOpciones,volverElementos,volverAtacar;
	Turno turno;
	BorderPane pantalla,pantallaDePelea;
	HBox opciones, ataques, elementos, pantallaDeStats;
	VBox algomonJ1Stats, algomonJ2Stats,algomonJ1,algomonJ2,jugador1Algomones, jugador2Algomones;
	ProgressBar barraDeVida1, barraDeVida2;
	Label algomonNombreJ1, algomonNombreJ2, nombrejugador1, nombrejugador2;
	Circle circulo, circulo2;
	ImageView imgAlgomonActivo1,imgAlgomonActivo2;
	
	public PantallaDeLucha(Stage stagePrincipal, Turno t, Jugador player1, Jugador player2){
		stage = stagePrincipal;
		jugador1 = player1;
		jugador2 = player2;
		turno = t;
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
		opciones.setStyle("-fx-background-image: url('file:src/imagenes/fondo2.jpg');");
		
		jugador1Algomones = new VBox(10);
		jugador1Algomones.setAlignment(Pos.TOP_CENTER);
		
		jugador2Algomones = new VBox(10);
		jugador2Algomones.setAlignment(Pos.TOP_CENTER);	
		
		jugador1Algomones.setPrefWidth(130);
		jugador2Algomones.setPrefWidth(130);
		
		nombrejugador1 = new Label(jugador1.getNombre());
		nombrejugador1.setStyle("-fx-font: 24 arial; -fx-text-fill: blue;");
		
		nombrejugador2 = new Label(jugador2.getNombre());
		nombrejugador2.setStyle("-fx-font: 24 arial; -fx-text-fill: #820000;");
		
		//AGREGUE ESTOS CONTENEDORES, TIENEN LOS LABELS CON LOS NOMBRES
		//Y LA VBOX DE LO ALGOMONES
		
		circulo = new Circle(10);
		circulo2 = new Circle(10);
		circulo.setFill(Color.BLUE);
		circulo2.setFill(Color.DARKRED);
		if (turno.jugadorActivo() == jugador1) {
			circulo2.setOpacity(0); 
			nombrejugador2.setDisable(true);
		}
		else {
			circulo.setOpacity(0); 
			nombrejugador1.setDisable(true);
		}

		
		VBox contenedorJ1 = new VBox(70);
		contenedorJ1.setAlignment(Pos.TOP_CENTER);
		contenedorJ1.getChildren().addAll(nombrejugador1, circulo, jugador1Algomones);
		contenedorJ1.setStyle("-fx-background-color: #00b2ff; -fx-border-color: black;-fx-border-width: 7;");
		contenedorJ1.setPrefWidth(150);
		VBox contenedorJ2 = new VBox(70);
		contenedorJ2.setAlignment(Pos.TOP_CENTER);
		contenedorJ2.getChildren().addAll(nombrejugador2, circulo2, jugador2Algomones);
		contenedorJ2.setStyle("-fx-background-color: #ff0000; -fx-border-color: black;-fx-border-width: 7;");
		contenedorJ2.setPrefWidth(150);
		
		
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
	
		barraDeVida2 = new ProgressBar();
		barraDeVida2.setProgress(1.0);
		barraDeVida2.setPrefSize(200, 20);
		
		algomonNombreJ1 = new Label(jugador1.getAlgomonActivo().nombre()+" "+ (int)jugador1.getAlgomonActivo().vida() + "/" + jugador1.getAlgomonActivo().getVidaMax()); 
		algomonNombreJ1.setStyle("-fx-font: 20 arial;");
		algomonNombreJ2 = new Label(jugador2.getAlgomonActivo().nombre()+" "+ (int)jugador2.getAlgomonActivo().vida() + "/" + jugador2.getAlgomonActivo().getVidaMax()); 		
		algomonNombreJ2.setStyle("-fx-font: 20 arial;");
		
		algomonJ1Stats = new VBox(20);
		algomonJ1Stats.setAlignment(Pos.CENTER);
		imgAlgomonActivo1 = this.crearImagen("file:src/imagenes/" + jugador1.getAlgomonActivo().nombre().toLowerCase()+".png", 200, 200);
		imgAlgomonActivo1.setScaleX(-1);
		algomonJ1Stats.getChildren().addAll(algomonNombreJ1,barraDeVida1);
		algomonJ2Stats = new VBox(20);
		algomonJ2Stats.setPrefWidth(350);
		algomonJ2Stats.setAlignment(Pos.CENTER);
		imgAlgomonActivo2 = this.crearImagen("file:src/imagenes/" + jugador2.getAlgomonActivo().nombre().toLowerCase()+".png", 200, 200);
		algomonJ2Stats.getChildren().addAll(algomonNombreJ2,barraDeVida2);
		
		algomonJ1 = new VBox();
		algomonJ1.getChildren().add(imgAlgomonActivo1);
		algomonJ1.setAlignment(Pos.CENTER);
		algomonJ1.setPrefSize(400, 400);
		
		algomonJ2 = new VBox();
		algomonJ2.getChildren().add(imgAlgomonActivo2);
		algomonJ2.setAlignment(Pos.CENTER);
		algomonJ2.setPrefSize(400, 400);
		
		pantallaDeStats = new HBox(200);
		pantallaDeStats.setPrefSize(800, 100);
		pantallaDeStats.setAlignment(Pos.CENTER);
		pantallaDeStats.getChildren().addAll(algomonJ1Stats, algomonJ2Stats);
		
		HBox pantallaDeAlgomones = new HBox(100);
		pantallaDeAlgomones.setPrefSize(800, 500);
		pantallaDeAlgomones.setAlignment(Pos.CENTER);
		pantallaDeAlgomones.getChildren().addAll(algomonJ1,algomonJ2);
		
		pantallaDePelea = new BorderPane();
		pantallaDePelea.setStyle("-fx-background-image: url('file:src/imagenes/fondoPelea.jpg'); -fx-background-size: cover;"
				+ "-fx-border-color: black;-fx-border-width: 7;");
		pantallaDePelea.setTop(pantallaDeStats);
		pantallaDePelea.setCenter(pantallaDeAlgomones);
		
		ataques = new HBox(40);
		ataques.setPrefSize(700, 150);
		ataques.setAlignment(Pos.CENTER);
		ataques.setStyle("-fx-background-image: url('file:src/imagenes/fondo2.jpg');");
		
		elementos = new HBox(40);
		elementos.setPrefSize(700, 150);
		elementos.setAlignment(Pos.CENTER);
		elementos.setStyle("-fx-background-image: url('file:src/imagenes/fondo2.jpg');");
		
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
		botonCambiar = this.crearBoton("Cambiar Algomon");
		botonCambiar.setOnAction(e->{
			if (turno.jugadorActivo() == jugador1){
				this.cambiarDeAlgomon(jugador1Algomones);
			}
			else this.cambiarDeAlgomon(jugador2Algomones);
		});
		
		this.mostrarAlgomonesDeJugadores(jugador1, volverAtacar, ataques, jugador1Algomones);
		this.mostrarAlgomonesDeJugadores(jugador2, volverAtacar, ataques, jugador2Algomones);
		
		opciones.getChildren().addAll(botonAtacar, botonCambiar, botonElemento,volverOpciones);
		
		pantalla.setLeft(contenedorJ1);
		pantalla.setRight(contenedorJ2);
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
				if (algomon.estaVivo()){
					botonAlgomon.setOnAction(event->{
						try {
							turno.jugar(new CambiarAlgomonActivo(turno.jugadorActivo(),algomon));
							if (botonCambiar.isDisabled()) {
								turno.cambiarJugador();
							}
							this.actualizarStats();
							this.mostrarImagenAlgomonesJugadores(jugador1, jugador2);
							this.habilitarAlgomones(algomonesJugador, botonAtacar, botonElemento, volverOpciones);
							this.cambiarBotonAtaque(turno.jugadorActivo(), ataques, volver);
							botonCambiar.setDisable(false);
							this.modificarFocus();

						} catch (AlgomonNoPuedeCambiarsePorSiMismoExcepcion e) {
							new Alerta(turno.jugadorActivo().getAlgomonActivo().nombre()+" ya es tu algomon activo!", stage);
						}
					});
				}
				else { botonAlgomon.setId("muerto");} //SI EL ALGOMON ESTA MUERTO, LE SETEO UN ID QUE DESPUES USO EN cambiarDeAlgomon()
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
			botonAtaque.setOnMouseEntered(e->cambiarPanelAtaques(ataque));
			botonAtaque.setOnAction(event->{
					if (!turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), ataque, turno.jugadorNoActivo().getAlgomonActivo()))
						&& !turno.jugadorActivo().getAlgomonActivo().estaVivo()) { // Caso de ataque que provoca debilitacion de algomon.
						manejoDeAlgomonDebilitado(volver);
					} else { // Caso normal.
					this.moverAlgomonAtacante();
					this.actualizarStats();
					this.cambiarBotonAtaque(turno.jugadorActivo(), ataques, volver);
					this.usarElementosBotones(turno.jugadorActivo(), elementos, volverElementos);
					pantalla.setBottom(opciones);
					System.out.println("Vida de " + turno.jugadorActivo().getAlgomonActivo().nombre() + " ---> " + turno.jugadorActivo().getAlgomonActivo().vida());
					}
					if (!turno.jugadorNoActivo().getAlgomonActivo().estaVivo()) { // Caso de debilitacion de algomon atacante.
						turno.cambiarJugador();
						manejoDeAlgomonDebilitado(volver);
					}
					this.modificarFocus();
			});
			ataques.getChildren().add(botonAtaque);
		}
		ataques.getChildren().add(volver);
	}
	
	private void manejoDeAlgomonDebilitado(Button volver) {
		if (turno.hayGanador()){
			PantallaDeGanador pantallaDeGanador = new PantallaDeGanador(stage, turno.jugadorGanador());
			pantallaDeGanador.cambiarVista();
		}
		else{
			this.cambiarBotonAtaque(turno.jugadorActivo(), ataques, volver);
			this.usarElementosBotones(turno.jugadorActivo(), elementos, volverElementos);
			jugador1Algomones.getChildren().clear();
			jugador2Algomones.getChildren().clear();
			this.mostrarAlgomonesDeJugadores(jugador1, volverAtacar, ataques, jugador1Algomones);
			this.mostrarAlgomonesDeJugadores(jugador2, volverAtacar, ataques, jugador2Algomones);
			this.actualizarStats();
			new Alerta(turno.jugadorActivo().getAlgomonActivo().nombre()+" se ha debilitado, Elija un reemplazo.",stage);
			if (turno.jugadorActivo() == jugador1){
				this.cambiarDeAlgomon(jugador1Algomones);
			} else {
				this.cambiarDeAlgomon(jugador2Algomones);
			}
		}
		pantalla.setBottom(opciones);	
	}
		
	private void cambiarPanelAtaques(Ataque ataque) {
		HBox infoAtaques = new HBox(20);
		infoAtaques.setStyle("-fx-background-color: black;");
		infoAtaques.setAlignment(Pos.CENTER);
		Label cantidad = crearLabel("Cantidad restante: " + ataque.getCantidad());
		Label danioARealizar = crearLabel("Danio a Realizar: " + ataque.danioRealizado(turno.jugadorNoActivo().getAlgomonActivo()));
		infoAtaques.getChildren().addAll(cantidad,danioARealizar);
		pantallaDePelea.setBottom(infoAtaques);
	}
	
	public Label crearLabel(String dato){
		Label label = new Label(dato);
		label.setStyle("-fx-font: 18 arial; -fx-text-fill: white;");
		return label;
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
			botonElemento.setOnMouseEntered(e->cambiarPanelElementos(elemento));
			botonElemento.setOnAction(event->{
				turno.jugar(new UsarElemento(turno.jugadorActivo(),elemento));
				this.actualizarStats();
				this.usarElementosBotones(turno.jugadorActivo(), elementos, volver);
				this.cambiarBotonAtaque(turno.jugadorActivo(), ataques, volverAtacar);
				pantalla.setBottom(opciones);
				if (!turno.jugadorNoActivo().getAlgomonActivo().estaVivo()) {
					turno.cambiarJugador();
					manejoDeAlgomonDebilitado(volver);				
				}
				this.modificarFocus();
			});
			elementos.getChildren().add(botonElemento);
		}
		elementos.getChildren().add(volver);
	}
	
	private void cambiarPanelElementos(Elemento elemento) {
		HBox infoElementos = new HBox();
		infoElementos.setStyle("-fx-background-color: black;");
		infoElementos.setAlignment(Pos.CENTER);
		Label cantidad = crearLabel("Cantidad restante: " + turno.jugadorActivo().getCantidadElemento(elemento));
		infoElementos.getChildren().addAll(cantidad);
		pantallaDePelea.setBottom(infoElementos);
	}
	
	public void actualizarStats(){
		algomonNombreJ1.setText(jugador1.getAlgomonActivo().nombre()+" "+ (int)jugador1.getAlgomonActivo().vida() + "/" + jugador1.getAlgomonActivo().getVidaMax());
		algomonNombreJ2.setText(jugador2.getAlgomonActivo().nombre()+" "+ (int)jugador2.getAlgomonActivo().vida() + "/" + jugador2.getAlgomonActivo().getVidaMax());
		barraDeVida1.setProgress(jugador1.getAlgomonActivo().vida()/(1.0*jugador1.getAlgomonActivo().getVidaMax()));
		barraDeVida2.setProgress(jugador2.getAlgomonActivo().vida()/(1.0*jugador2.getAlgomonActivo().getVidaMax()));
	}
	
	public void elegirSuplenteDeAlgomonDebilitado(VBox jugadorAlgomones) {
		this.cambiarDeAlgomon(jugadorAlgomones);
		botonCambiar.setDisable(true);
		volverOpciones.setDisable(true);
		}
	
	public void cambiarDeAlgomon(VBox jugadorAlgomones){
		for (int x=0; x < jugadorAlgomones.getChildren().size();x++){
			if( jugadorAlgomones.getChildren().get(x).getId() == null){ //SI ESTA VIVO, HABILITA EL BOTON, SINO LO DEJA INHABILITADO
				jugadorAlgomones.getChildren().get(x).setDisable(false);
			}
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
	
	private void moverAlgomonAtacante() {
		if(turno.jugadorActivo() == jugador2){
			TranslateTransition trans = new TranslateTransition(Duration.millis(300), imgAlgomonActivo1);
			trans.setToX(100);
			trans.setCycleCount(2);
			trans.setAutoReverse(true);
			trans.play();
		} else {
			TranslateTransition trans2 = new TranslateTransition(Duration.millis(300), imgAlgomonActivo2);
			trans2.setToX(-100);
			trans2.setCycleCount(2);
			trans2.setAutoReverse(true);
			trans2.play();
		}
	}
	
	public void mostrarImagenAlgomonesJugadores(Jugador j1, Jugador j2){
		imgAlgomonActivo1 = this.crearImagen("file:src/imagenes/" + j1.getAlgomonActivo().nombre().toLowerCase()+".png", 200, 200);
		imgAlgomonActivo1.setScaleX(-1);
		imgAlgomonActivo2 = this.crearImagen("file:src/imagenes/" + j2.getAlgomonActivo().nombre().toLowerCase()+".png", 200, 200);
		algomonNombreJ1.setText(jugador1.getAlgomonActivo().nombre()+" "+ jugador1.getAlgomonActivo().vida() + "/" + jugador1.getAlgomonActivo().getVidaMax());
		algomonNombreJ2.setText(jugador2.getAlgomonActivo().nombre()+" "+ jugador2.getAlgomonActivo().vida() + "/" + jugador2.getAlgomonActivo().getVidaMax());
		algomonJ1.getChildren().clear();
		algomonJ2.getChildren().clear();
		algomonJ1.getChildren().addAll(imgAlgomonActivo1);
		algomonJ2.getChildren().addAll(imgAlgomonActivo2);
	}
	
	private void modificarFocus() {
		if (turno.jugadorActivo() == jugador2){
			circulo2.setOpacity(1);
			circulo.setOpacity(0);
			nombrejugador1.setDisable(true);
			nombrejugador2.setDisable(false);
		}
		else{
			circulo2.setOpacity(0);
			circulo.setOpacity(1);
			nombrejugador1.setDisable(false);
			nombrejugador2.setDisable(true);
		}
	}

}
