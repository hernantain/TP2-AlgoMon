package fiuba.algo3.vista;

import Algomones.Algomon;
import Algomones.Bulbasaur;
import Algomones.Chansey;
import Algomones.Charmander;
import Algomones.Jigglypuff;
import Algomones.Rattata;
import Algomones.Squirtle;
import Controlador.BotonElegirAlgomonHandle;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import modelo.*;

public class PantallaDeSeleccionDeAlgomones implements Pantalla {

	Jugador jugador1,jugador2;
	Turno turno;
	Stage stage;
	BorderPane seleccionDeAlgomon;
	VBox jugador1Algomones,jugador2Algomones,comenzarBatalla;
	VBox vistaCharmander,vistaSquirtle,vistaBulbasaur,vistaJigglypuff,vistaRattata,vistaChansey;
	int contador = 0;
	Circle circulo,circulo2;
	Label nombrejugador1, nombrejugador2;
	
	
	public PantallaDeSeleccionDeAlgomones(Stage stagePrincipal, Jugador j1,Jugador j2){
		jugador1 = j1;
		jugador2 = j2;
		stage = stagePrincipal;
		turno = new Turno(j1,j2);
		turno.activarJugabilidad(); //ACTIVA EL RANDOM
	}
	
	public MenuBar agregarMenuBar(String url){
		MenuBar menuBar = new MenuBar();
		Menu archivo = new Menu("Archivo");
		MenuItem salir = new MenuItem("Salir");
		MenuItem maximizar = new MenuItem("Maximizar");
		MenuItem minimizar = new MenuItem("Minimizar");
		maximizar.setDisable(true);
		maximizar.setOnAction(e->{
			stage.setFullScreen(true);
			minimizar.setDisable(false);
			maximizar.setDisable(true);
		});
		minimizar.setOnAction(e->{
			stage.setFullScreen(false);
			maximizar.setDisable(false);
			minimizar.setDisable(true);
		});
		archivo.getItems().addAll(maximizar,minimizar,salir);
		salir.setOnAction(e->stage.close());
		menuBar.getMenus().addAll(archivo);
		menuBar.setStyle(url);
		menuBar.setOpacity(0.75);
		
		return menuBar;
	}

	public void setearVista(){
		
		//CUARTA PANTALLA
		seleccionDeAlgomon = new BorderPane();
		HBox contenedorDeAlgomon = new HBox(40);
		contenedorDeAlgomon.setPrefHeight(150);
		contenedorDeAlgomon.setAlignment(Pos.CENTER);
		jugador1Algomones = new VBox(25);
		jugador1Algomones.setAlignment(Pos.TOP_CENTER);
		jugador2Algomones = new VBox(25);
		jugador2Algomones.setAlignment(Pos.TOP_CENTER);
		jugador1Algomones.setPrefWidth(130);
		jugador2Algomones.setPrefWidth(130);
		
		nombrejugador1 = new Label(jugador1.getNombre());
		nombrejugador1.setStyle("-fx-font: 24 arial; -fx-text-fill: blue;");
		nombrejugador2 = new Label(jugador2.getNombre());
		nombrejugador2.setStyle("-fx-font: 24 arial; -fx-text-fill: #ff0000;");
		
		circulo = new Circle(10);
		circulo2 = new Circle(10);
		circulo.setFill(Color.BLUE);
		circulo2.setFill(Color.RED);
		if (turno.jugadorActivo() == jugador1) {
			circulo2.setOpacity(0); 
			nombrejugador2.setDisable(true);
		}
		else {
			circulo.setOpacity(0); 
			nombrejugador1.setDisable(true);
		}
		
		MenuBar menuBar = agregarMenuBar("-fx-font: 14 arial; -fx-base: #ffffff;"
				+ "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 )");
		
		
		jugador1Algomones.getChildren().addAll(nombrejugador1,circulo);
		jugador2Algomones.getChildren().addAll(nombrejugador2,circulo2);

		
		Label nombreCharmander = crearLabelDeAlgomon("Charmander","-fx-text-fill: #ff0000;");
		Label nombreSquirtle = crearLabelDeAlgomon("Squirtle","-fx-text-fill: #00ffdd;");
		Label nombreBulbasaur = crearLabelDeAlgomon("Bulbasaur","-fx-text-fill: #00ff00;");
		Label nombreJigglypuff = crearLabelDeAlgomon("Jigglypuff","-fx-text-fill: #ffffff;");
		Label nombreRattata = crearLabelDeAlgomon("Rattata","-fx-text-fill: #ffffff;");
		Label nombreChansey = crearLabelDeAlgomon("Chansey","-fx-text-fill: #ffffff;");
		
		Button botonCharmander = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/charmander.png');-fx-background-size: cover;");
		Button botonSquirtle = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/squirtle.png');-fx-background-size: cover;");
		Button botonBulbasaur = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/bulbasaur.png');-fx-background-size: cover;");
		Button botonJigglypuff = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/jigglypuff.png');-fx-background-size: cover;");
		Button botonRattata = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/rattata.png');-fx-background-size: cover;");
		Button botonChansey = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/chansey.png');-fx-background-size: cover;");
		
		Button comenzar = new Button("COMENZAR BATALLA");
		comenzar.setPrefSize(300, 75);
		comenzar.setStyle("-fx-base: #ff0000;"
						+ "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );"
						+ "-fx-font: 22 arial;");
		comenzar.setOnAction(e->{
			PantallaDeLucha pantallaLucha = new PantallaDeLucha(stage, turno, jugador1, jugador2);
			this.cambiarVista(pantallaLucha);
		});
		comenzarBatalla = new VBox();
		comenzarBatalla.setAlignment(Pos.CENTER);
		comenzarBatalla.getChildren().addAll(comenzar);
		
		Button botonElegirCharmander = crearBotonDeEleccion();
		botonElegirCharmander.setOnAction(new BotonElegirAlgomonHandle(this, new Charmander(), "file:src/imagenes/charmander.png"));
		
		Button botonElegirSquirtle = crearBotonDeEleccion();
		botonElegirSquirtle.setOnAction(new BotonElegirAlgomonHandle(this, new Squirtle(), "file:src/imagenes/squirtle.png"));
		
		Button botonElegirBulbasaur = crearBotonDeEleccion();
		botonElegirBulbasaur.setOnAction(new BotonElegirAlgomonHandle(this, new Bulbasaur(), "file:src/imagenes/bulbasaur.png"));
		
		Button botonElegirJigglypuff = crearBotonDeEleccion();
		botonElegirJigglypuff.setOnAction(new BotonElegirAlgomonHandle(this, new Jigglypuff(), "file:src/imagenes/jigglypuff.png"));
		
		Button botonElegirRattata = crearBotonDeEleccion();
		botonElegirRattata.setOnAction(new BotonElegirAlgomonHandle(this, new Rattata(), "file:src/imagenes/rattata.png"));
		
		Button botonElegirChansey = crearBotonDeEleccion();
		botonElegirChansey.setOnAction(new BotonElegirAlgomonHandle(this, new Chansey(), "file:src/imagenes/chansey.png"));

		contenedorDeAlgomon.getChildren().addAll(botonCharmander,botonSquirtle,botonBulbasaur,botonJigglypuff,botonRattata,botonChansey);
		
		vistaCharmander = new VBox(20);
		vistaCharmander.setAlignment(Pos.CENTER);
		vistaCharmander.getChildren().addAll(nombreCharmander,crearImagen("file:src/imagenes/charmander.png", 200, 200),crearImagen("file:src/imagenes/caraccharmander.png", 120, 750),botonElegirCharmander);
		
		vistaSquirtle = new VBox(20);
		vistaSquirtle.setAlignment(Pos.CENTER);
		vistaSquirtle.getChildren().addAll(nombreSquirtle,crearImagen("file:src/imagenes/squirtle.png",200,200),crearImagen("file:src/imagenes/caracsquirtle.png", 120, 750),botonElegirSquirtle);
		
		vistaBulbasaur = new VBox(20);
		vistaBulbasaur.setAlignment(Pos.CENTER);
		vistaBulbasaur.getChildren().addAll(nombreBulbasaur,crearImagen("file:src/imagenes/bulbasaur.png",200,200),crearImagen("file:src/imagenes/caracbulbasaur.png", 120, 750),botonElegirBulbasaur);
		
		vistaJigglypuff = new VBox(20);
		vistaJigglypuff.setAlignment(Pos.CENTER);
		vistaJigglypuff.getChildren().addAll(nombreJigglypuff,crearImagen("file:src/imagenes/jigglypuff.png",200,200),crearImagen("file:src/imagenes/caracjigglypuff.png", 120, 750),botonElegirJigglypuff);
		
		vistaRattata = new VBox(20);
		vistaRattata.setAlignment(Pos.CENTER);
		vistaRattata.getChildren().addAll(nombreRattata,crearImagen("file:src/imagenes/rattata.png",200,200),crearImagen("file:src/imagenes/caracrattata.png", 120, 750),botonElegirRattata);
		
		vistaChansey = new VBox(20);
		vistaChansey.setAlignment(Pos.CENTER);
		vistaChansey.getChildren().addAll(nombreChansey,crearImagen("file:src/imagenes/chansey.png",200,200),crearImagen("file:src/imagenes/caracchansey.png", 120, 750),botonElegirChansey);
	
		seleccionDeAlgomon.setTop(menuBar);
		seleccionDeAlgomon.setRight(jugador2Algomones);		
		seleccionDeAlgomon.setLeft(jugador1Algomones);
		seleccionDeAlgomon.setBottom(contenedorDeAlgomon);
		
		seleccionDeAlgomon.setStyle("-fx-background-image: url('file:src/imagenes/fondo3.jpg');"
								   +"-fx-background-size: cover;");
		Scene cuartaPantalla = new Scene(seleccionDeAlgomon,1100,600);
		
		stage.setScene(cuartaPantalla);

		botonCharmander.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaCharmander));
		botonSquirtle.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaSquirtle));
		botonBulbasaur.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaBulbasaur));
		botonJigglypuff.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaJigglypuff));
		botonRattata.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaRattata));
		botonChansey.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaChansey));
	}
	
	public ImageView crearImagen(String url, int height, int width){
		Image img = new Image(url);
		ImageView imgView = new ImageView(img);	
		imgView.setFitHeight(height);
		imgView.setFitWidth(width);
		return imgView;
	}
	
	public Button crearBotonDeAlgomon(String url){
		Button boton = new Button();
		boton.setPrefSize(75, 75);
		boton.setStyle(url
				+"-fx-background-color: #38acff;"
				+"-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );"
				+"-fx-opacity: 0.95;");
		return boton;
	}
	
	public Label crearLabelDeAlgomon(String nombre, String url){
		
		Label label = new Label(nombre);
		label.setStyle(url + "-fx-font: 32 arial;" );
		return label;
	}
	
	public Button crearBotonDeEleccion(){
		Button boton = new Button("Elegir");
		boton.setStyle("-fx-font: 18 arial; -fx-base: #ff0000;"
					+  "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		return boton;
	}
	

	public void modificarFocus() {
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

	public void agregarImagenDeAlgomonAJugador(Algomon algomon, String url){
			try {
				turno.elegirAlgomon(algomon);
				contador++;
				if( turno.jugadorActivo() == jugador2){
					jugador1Algomones.getChildren().add(crearImagen(url, 125, 125));
				}
				else{ 
					jugador2Algomones.getChildren().add(crearImagen(url, 125, 125));
				} 
				if (contador > 5) seleccionDeAlgomon.setCenter(comenzarBatalla);
			} catch (AlgomonRepetidoExcepcion e) {
				new Alerta("No puedes volver a elegir a "+algomon.nombre(), stage);
			}
	}
	
	public void mostrarVistaDeAlgomonEnElCentro(VBox vistaAlgomon){
		if (contador > 5){
			seleccionDeAlgomon.setCenter(comenzarBatalla);
		}
		else{
			seleccionDeAlgomon.setCenter(vistaAlgomon);
		}
	}


	@Override
	public void cambiarVista(Pantalla pantalla) {
		pantalla.setearVista();
		stage.setFullScreen(true);
	}
}
