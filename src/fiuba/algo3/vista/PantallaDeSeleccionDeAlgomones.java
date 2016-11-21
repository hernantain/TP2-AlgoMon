package vista;

import Algomones.Bulbasaur;
import Algomones.Chansey;
import Algomones.Charmander;
import Algomones.Jigglypuff;
import Algomones.Rattata;
import Algomones.Squirtle;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.*;

public class PantallaDeSeleccionDeAlgomones {

	Jugador jugador1,jugador2;
	Stage stage;
	int contador = 0;
	public PantallaDeSeleccionDeAlgomones(Stage stagePrincipal, Jugador j1,Jugador j2){
		jugador1 = j1;
		jugador2 = j2;
		stage = stagePrincipal;
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

	public void cambiarVista(){
		
		//CUARTA PANTALLA
		BorderPane seleccionDeAlgomon = new BorderPane();
		HBox contenedorDeAlgomon = new HBox(40);
		contenedorDeAlgomon.setPrefHeight(150);
		contenedorDeAlgomon.setAlignment(Pos.CENTER);
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
		
		Label nombreCharmander = crearLabelDeAlgomon("Charmander","-fx-text-fill: #ff0000;");
		Label nombreSquirtle = crearLabelDeAlgomon("Squirtle","-fx-text-fill: #00ffdd;");
		Label nombreBulbasaur = crearLabelDeAlgomon("Bulbasaur","-fx-text-fill: #00ff00;");
		Label nombreJigglypuff = crearLabelDeAlgomon("Jigglypuff","-fx-text-fill: #ffffff;");
		Label nombreRattata = crearLabelDeAlgomon("Rattata","-fx-text-fill: #ffffff;");
		Label nombreChansey = crearLabelDeAlgomon("Chansey","-fx-text-fill: #ffffff;");
		
		Button botonCharmander = crearBotonDeAlgomon("-fx-background-image: url('file:src/vista/charmander.png');-fx-background-size: cover;");
		Button botonSquirtle = crearBotonDeAlgomon("-fx-background-image: url('file:src/vista/squirtle.png');-fx-background-size: cover;");
		Button botonBulbasaur = crearBotonDeAlgomon("-fx-background-image: url('file:src/vista/bulbasaur.png');-fx-background-size: cover;");
		Button botonJigglypuff = crearBotonDeAlgomon("-fx-background-image: url('file:src/vista/jigglypuff.png');-fx-background-size: cover;");
		Button botonRattata = crearBotonDeAlgomon("-fx-background-image: url('file:src/vista/rattata.png');-fx-background-size: cover;");
		Button botonChansey = crearBotonDeAlgomon("-fx-background-image: url('file:src/vista/chansey.png');-fx-background-size: cover;");
		
		Button comenzar = new Button("COMENZAR BATALLA");
		comenzar.setPrefSize(300, 75);
		comenzar.setStyle("-fx-base: #ff0000;"
						+ "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );"
						+ "-fx-font: 22 arial;");
		comenzar.setOnAction(e->{
			PantallaDeLucha pantallaLucha = new PantallaDeLucha(stage, jugador1, jugador2);
			pantallaLucha.cambiarVista();
		});
		VBox comenzarBatalla = new VBox();
		comenzarBatalla.setAlignment(Pos.CENTER);
		comenzarBatalla.getChildren().addAll(comenzar);
		
		Button botonElegirCharmander = crearBotonDeEleccion();
		botonElegirCharmander.setOnAction(e->{
			if (contador%2 == 0){
			jugador1Algomones.getChildren().add(crearImagen("file:src/vista/charmander.png", 125, 125));
			jugador1.setAlgomon(new Charmander());
			contador++;
			}
			else{
				jugador2Algomones.getChildren().add(crearImagen("file:src/vista/charmander.png", 125, 125));
				jugador2.setAlgomon(new Charmander());
				contador++;
			}
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
		});
				
		Button botonElegirSquirtle = crearBotonDeEleccion();
		botonElegirSquirtle.setOnAction(e->{
			if (contador%2 == 0){
			jugador1Algomones.getChildren().add(crearImagen("file:src/vista/squirtle.png", 125, 125));
			jugador1.setAlgomon(new Squirtle());
			contador++;
			}
			else{
				jugador2Algomones.getChildren().add(crearImagen("file:src/vista/squirtle.png", 125, 125));
				jugador2.setAlgomon(new Squirtle());
				contador++;
			}
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
		});
		
		
		Button botonElegirBulbasaur = crearBotonDeEleccion();
		botonElegirBulbasaur.setOnAction(e->{
			if (contador%2 == 0){
			jugador1Algomones.getChildren().add(crearImagen("file:src/vista/bulbasaur.png", 125, 125));
			jugador1.setAlgomon(new Bulbasaur());
			contador++;
			}
			else{
				jugador2Algomones.getChildren().add(crearImagen("file:src/vista/bulbasaur.png", 125, 125));
				jugador2.setAlgomon(new Bulbasaur());
				contador++;
			}
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
		});
		
		Button botonElegirJigglypuff = crearBotonDeEleccion();
		botonElegirJigglypuff.setOnAction(e->{
			if (contador%2 == 0){
			jugador1Algomones.getChildren().add(crearImagen("file:src/vista/jigglypuff.png", 125, 125));
			jugador1.setAlgomon(new Jigglypuff());
			contador++;
			}
			else{
				jugador2Algomones.getChildren().add(crearImagen("file:src/vista/jigglypuff.png", 125, 125));
				jugador2.setAlgomon(new Jigglypuff());
				contador++;
			}
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
		});
		
		Button botonElegirRattata = crearBotonDeEleccion();
		botonElegirRattata.setOnAction(e->{
			if (contador%2 == 0){
			jugador1Algomones.getChildren().add(crearImagen("file:src/vista/rattata.png", 125, 125));
			jugador1.setAlgomon(new Rattata());
			contador++;
			}
			else{
				jugador2Algomones.getChildren().add(crearImagen("file:src/vista/rattata.png", 125, 125));
				jugador2.setAlgomon(new Rattata());
				contador++;
			}
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
		});
		
		Button botonElegirChansey = crearBotonDeEleccion();
		botonElegirChansey.setOnAction(e->{
			if (contador%2 == 0){
			jugador1Algomones.getChildren().add(crearImagen("file:src/vista/chansey.png", 125, 125));
			jugador1.setAlgomon(new Chansey());
			contador++;
			}
			else{
				jugador2Algomones.getChildren().add(crearImagen("file:src/vista/chansey.png", 125, 125));
				jugador2.setAlgomon(new Chansey());
				contador++;
			}
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
		});

		
		contenedorDeAlgomon.getChildren().addAll(botonCharmander,botonSquirtle,botonBulbasaur,botonJigglypuff,botonRattata,botonChansey);
		//contenedorDeAlgomon.setAlignment(Pos.CENTER);
		
		VBox vistaCharmander = new VBox(20);
		vistaCharmander.setAlignment(Pos.CENTER);
		vistaCharmander.getChildren().addAll(nombreCharmander,crearImagen("file:src/vista/charmander.png", 200, 200),crearImagen("file:src/vista/caraccharmander.png", 120, 480),botonElegirCharmander);
		
		VBox vistaSquirtle = new VBox(20);
		vistaSquirtle.setAlignment(Pos.CENTER);
		vistaSquirtle.getChildren().addAll(nombreSquirtle,crearImagen("file:src/vista/squirtle.png",200,200),crearImagen("file:src/vista/caracsquirtle.png", 120, 480),botonElegirSquirtle);
		
		VBox vistaBulbasaur = new VBox(20);
		vistaBulbasaur.setAlignment(Pos.CENTER);
		vistaBulbasaur.getChildren().addAll(nombreBulbasaur,crearImagen("file:src/vista/bulbasaur.png",200,200),crearImagen("file:src/vista/caracbulbasaur.png", 120, 480),botonElegirBulbasaur);
		
		VBox vistaJigglypuff = new VBox(20);
		vistaJigglypuff.setAlignment(Pos.CENTER);
		vistaJigglypuff.getChildren().addAll(nombreJigglypuff,crearImagen("file:src/vista/jigglypuff.png",200,200),crearImagen("file:src/vista/caracjigglypuff.png", 120, 480),botonElegirJigglypuff);
		
		VBox vistaRattata = new VBox(20);
		vistaRattata.setAlignment(Pos.CENTER);
		vistaRattata.getChildren().addAll(nombreRattata,crearImagen("file:src/vista/rattata.png",200,200),crearImagen("file:src/vista/caracrattata.png", 120, 480),botonElegirRattata);
		
		VBox vistaChansey = new VBox(20);
		vistaChansey.setAlignment(Pos.CENTER);
		vistaChansey.getChildren().addAll(nombreChansey,crearImagen("file:src/vista/chansey.png",200,200),crearImagen("file:src/vista/caracchansey.png", 120, 480),botonElegirChansey);
	
		
		seleccionDeAlgomon.setRight(jugador2Algomones);		
		seleccionDeAlgomon.setLeft(jugador1Algomones);
		seleccionDeAlgomon.setBottom(contenedorDeAlgomon);
		
		seleccionDeAlgomon.setStyle("-fx-background-image: url('file:src/vista/fondo3.jpg');"
								   +"-fx-background-size: cover;");
		Scene cuartaPantalla = new Scene(seleccionDeAlgomon,1100,600);
		
		stage.setScene(cuartaPantalla);
		

		botonCharmander.setOnMouseEntered(e->{
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
			else{
				seleccionDeAlgomon.setCenter(vistaCharmander);
			}
		});
				
		botonSquirtle.setOnMouseEntered(e->{
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
			else{
				seleccionDeAlgomon.setCenter(vistaSquirtle);
			}
		});
		
		botonBulbasaur.setOnMouseEntered(e->{
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
			else{
				seleccionDeAlgomon.setCenter(vistaBulbasaur);
			}
		});
		
		botonJigglypuff.setOnMouseEntered(e->{
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
			else{
				seleccionDeAlgomon.setCenter(vistaJigglypuff);
			}
		});
		
		botonRattata.setOnMouseEntered(e->{
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
			else{
				seleccionDeAlgomon.setCenter(vistaRattata);
			}
		});
		
		botonChansey.setOnMouseEntered(e->{
			if (contador > 5){
				seleccionDeAlgomon.setCenter(comenzarBatalla);
			}
			else{
				seleccionDeAlgomon.setCenter(vistaChansey);
			}
		});
	}
}
