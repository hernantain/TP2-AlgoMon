package fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Jugador;


public class PantallaJugadores {
	
	Jugador jugador1,jugador2;
	Stage stage;
	Scene pantallaInicio,tercerPantalla;
	MenuBar menuBarJugador1,menuBarJugador2;
	
	
	public PantallaJugadores (Stage stagePrincipal, Scene pantallaPrincipal){
		stage = stagePrincipal;
		pantallaInicio = pantallaPrincipal;
	}
	
	
	public MenuBar agregarMenuBar(String url){
		MenuBar menuBar = new MenuBar();
		//menuBar.setStyle("-fx-position: top");
		Menu archivo = new Menu("Archivo");
		MenuItem salir = new MenuItem("Salir");
		archivo.getItems().addAll(salir);
		salir.setOnAction(e->stage.close());
		menuBar.getMenus().addAll(archivo);
		menuBar.setStyle(url);
		menuBar.setOpacity(0.75);
		
		return menuBar;
	}
	
	public void cambiarVista(){
		
		//PANTALLA JUGAR/PRIMER JUGADOR
		BorderPane pantallaJugadores = new BorderPane();
		
		Image img = new Image("file:src/imagenes/Ash.png");
		ImageView imgView = new ImageView(img);	
		imgView.setFitHeight(500);
		imgView.setFitWidth(350);
		
		VBox segundoLayout = new VBox(30);
		segundoLayout.setAlignment(Pos.CENTER_LEFT);
		
		//Jugador ingresa su nombre
		
		Label ingreseNombreLabel = new Label("Ingrese nombre de jugador 1: ");
		ingreseNombreLabel.setStyle("-fx-text-fill: #16a0fc;"
								 +"-fx-font: 30 arial;"
								 +"-fx-effect: innershadow( two-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
						
				
				
		TextField casilla = new TextField();
		casilla.setAlignment(Pos.CENTER);
		casilla.setStyle("-fx-background-color: #00ffcb;"
				+ "-fx-text-fill: #1306c9;");
		casilla.setMaxWidth(300);
		casilla.setPromptText("Ingrese su nombre aqui");
		casilla.setOnKeyPressed(event -> {
			   if(event.getCode() == KeyCode.ENTER){
				   jugador1 = new Jugador(casilla.getText());
				   stage.setScene(tercerPantalla);
					stage.setMaximized(false);
					stage.setMaximized(true);
			   }});
		casilla.setOnMouseClicked(e->casilla.requestFocus());
		
		
		menuBarJugador1 = agregarMenuBar("-fx-font: 14 arial; -fx-base: #0014f4;"
				+ "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 )");
		
		
		Button botonIngresarNombre = new Button("Aceptar");
		botonIngresarNombre.setPrefSize(300, 70);
		botonIngresarNombre.setOnAction(e-> {
			jugador1 = new Jugador(casilla.getText());
				stage.setScene(tercerPantalla);
				stage.setMaximized(false);
				stage.setMaximized(true);
			});
			botonIngresarNombre.setStyle("-fx-font: 22 arial; -fx-base: #0014f4;"
					+   "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
			
			segundoLayout.setOnMouseClicked(e->botonIngresarNombre.requestFocus());
			
			Button boton = new Button();
			boton.setText("Volver al Inicio");
			boton.setPrefSize(300, 70);
			boton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000;"
					+   "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
			
				
			boton.setOnAction(e-> {
				stage.setScene(pantallaInicio); 
				stage.setMaximized(false);
				stage.setMaximized(true);
			});
			segundoLayout.getChildren().addAll(ingreseNombreLabel,casilla,botonIngresarNombre,boton);
			pantallaJugadores.setStyle("-fx-background-image: url('file:src/imagenes/fondo8.jpg');" 
								+"-fx-background-repeat: no-repeat;"
								+"-fx-background-position: 50% 50%; "
								+"-fx-background-size: cover;");
			
			pantallaJugadores.setLeft(segundoLayout);
			pantallaJugadores.setRight(imgView);
			pantallaJugadores.setTop(menuBarJugador1);
			BorderPane.setAlignment(imgView, Pos.CENTER);
			Scene segundaPantalla = new Scene(pantallaJugadores,1100,600);
			stage.setScene(segundaPantalla);
			stage.setMaximized(false);
			stage.setMaximized(true);

				
				
				
			BorderPane pantallaJugadores2 = new BorderPane();
			
			Image img2 = new Image("file:src/imagenes/Ash2.png");
			ImageView imgView2 = new ImageView(img2);	
			imgView2.setFitHeight(500);
			imgView2.setFitWidth(325);
			
			
			VBox tercerLayout = new VBox(30);
			tercerLayout.setAlignment(Pos.CENTER_LEFT);
				
				//Jugador ingresa su nombre
							
				Label ingreseNombreLabel2 = new Label("Ingrese nombre de jugador 2: ");
				ingreseNombreLabel2.setStyle("-fx-text-fill: #ff0000;"
								 			+"-fx-font: 30 arial;"
								 			+"-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
				
				
				TextField casilla2 = new TextField();
				casilla2.setAlignment(Pos.CENTER);
				casilla2.setStyle("-fx-background-color: #ffb5cd;"
						+ "-fx-text-fill: #440117;");
				casilla2.setMaxWidth(300);
				casilla2.setPromptText("Ingrese su nombre aqui");
				casilla2.setOnKeyPressed(event -> {
					   if(event.getCode() == KeyCode.ENTER){
						   jugador2 = new Jugador(casilla2.getText());
						   PantallaDeSeleccionDeAlgomones seleccion = new PantallaDeSeleccionDeAlgomones(stage,jugador1,jugador2);
						   seleccion.cambiarVista();
					   }});
				casilla2.setOnMouseClicked(e->casilla.requestFocus());
				
				
				Button botonIngresarNombre2 = new Button("Aceptar");
				botonIngresarNombre2.setPrefSize(300, 70);
				botonIngresarNombre2.setOnAction(e-> {
					jugador2 = new Jugador(casilla2.getText());
					PantallaDeSeleccionDeAlgomones seleccion = new PantallaDeSeleccionDeAlgomones(stage,jugador1,jugador2);
					seleccion.cambiarVista();
				});
				botonIngresarNombre2.setOnMouseMoved(e->botonIngresarNombre2.requestFocus());
				botonIngresarNombre2.setStyle("-fx-font: 22 arial; -fx-base: #0014f4;"
						+   "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
				tercerLayout.setOnMouseClicked(e->botonIngresarNombre2.requestFocus());
				
				menuBarJugador2 = agregarMenuBar("-fx-base: #ff0000;"
			 			+"-fx-font: 14 arial;"
			 			+"-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
						
				Button boton2 = new Button();
				boton2.setText("Volver al Inicio");
				boton2.setPrefSize(300, 70);
				boton2.setStyle("-fx-font: 22 arial; -fx-base: #ff0000;"
						+   "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
							
				boton2.setOnAction(e-> {
					stage.setScene(pantallaInicio); 
					stage.setMaximized(false);
					stage.setMaximized(true);
				});
				tercerLayout.getChildren().addAll(ingreseNombreLabel2,casilla2,botonIngresarNombre2,boton2);
				
				pantallaJugadores2.setStyle("-fx-background-image: url('file:src/imagenes/fondo9.jpg');"
									 +"-fx-background-size: cover;");
				
				pantallaJugadores2.setTop(menuBarJugador2);
				pantallaJugadores2.setLeft(tercerLayout);
				pantallaJugadores2.setRight(imgView2);
				BorderPane.setAlignment(imgView2, Pos.CENTER);

				tercerPantalla = new Scene(pantallaJugadores2,1100,600);
	}

}
