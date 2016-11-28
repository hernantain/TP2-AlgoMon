package fiuba.algo3.vista;

import Controlador.BotonIngresoNombreCambiaPantallaHandle;
import Controlador.BotonIngresoNombreHandle;
import Controlador.BotonVolverAInicioHandle;
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
import modelo.*;


public class PantallaJugadores implements Pantalla{
	
	Jugador jugador1,jugador2;
	Stage stage;
	PantallaInicio pantallaInicio;
	Scene tercerPantalla;
	MenuBar menuBarJugador1,menuBarJugador2;
	
	
	public PantallaJugadores (Stage stagePrincipal, PantallaInicio pantallaPrincipal){
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
	
	public void setearVista(){
		
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
						
				
		
		TextField casillaIngresoNombre = this.crearCasillaNombre("#00ffcb");
		
		casillaIngresoNombre.setOnKeyPressed(event -> {
			   if(event.getCode() == KeyCode.ENTER){
				   try{
					   jugador1 = new Jugador(casillaIngresoNombre.getText());
					   stage.setScene(tercerPantalla);
					   stage.setFullScreen(true);
				   }catch (NombreVacioExcepcion e){
					   new Alerta("Ingrese un nombre", stage);
				   }
			   }});
		
		
		menuBarJugador1 = agregarMenuBar("-fx-font: 14 arial; -fx-base: #0014f4;"
				+ "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 )");
		
		
		Button botonAceptarNombre = this.crearBoton("Aceptar", "#0014f4");
		
		botonAceptarNombre.setOnAction(new BotonIngresoNombreHandle(stage, tercerPantalla, casillaIngresoNombre, jugador1));
			
			segundoLayout.setOnMouseClicked(e->botonAceptarNombre.requestFocus());
			
			Button botonVolverInicio = this.crearBoton("Volver a Inicio", "#ff0000");
				
			botonVolverInicio.setOnMouseClicked(new BotonVolverAInicioHandle(this, pantallaInicio));
			
			segundoLayout.getChildren().addAll(ingreseNombreLabel,casillaIngresoNombre,botonAceptarNombre,botonVolverInicio);
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
			stage.setFullScreen(true);;

				
				////////////////////////////////////////////////////////
				
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
				
				
				TextField casillaIngresoNombre2 = this.crearCasillaNombre("#ffb5cd");
				
				casillaIngresoNombre2.setOnKeyPressed(event -> {
					   if(event.getCode() == KeyCode.ENTER){
						   try{
							   jugador2 = new Jugador(casillaIngresoNombre2.getText());
							   PantallaDeSeleccionDeAlgomones seleccion = new PantallaDeSeleccionDeAlgomones(stage,jugador1,jugador2);
							   this.cambiarVista(seleccion);
						   }catch (NombreVacioExcepcion e){
							   new Alerta("Ingrese un nombre", stage);
						   }
					   }});
				
				
				Button botonAceptarNombre2 = this.crearBoton("Aceptar", "#0014f4");
				botonAceptarNombre2.setOnAction(new BotonIngresoNombreCambiaPantallaHandle(this, stage, jugador1, casillaIngresoNombre2));

				tercerLayout.setOnMouseClicked(e->botonAceptarNombre2.requestFocus());
				
				menuBarJugador2 = agregarMenuBar("-fx-base: #ff0000;"
			 			+"-fx-font: 14 arial;"
			 			+"-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
						
				Button botonVolverInicio2 = this.crearBoton("Volver a Inicio", "#ff0000");
							
				botonVolverInicio2.setOnMouseClicked(new BotonVolverAInicioHandle(this, pantallaInicio));
				
				tercerLayout.getChildren().addAll(ingreseNombreLabel2,casillaIngresoNombre2,botonAceptarNombre2,botonVolverInicio2);
				
				pantallaJugadores2.setStyle("-fx-background-image: url('file:src/imagenes/fondo9.jpg');"
									 +"-fx-background-size: cover;");
				
				pantallaJugadores2.setTop(menuBarJugador2);
				pantallaJugadores2.setLeft(tercerLayout);
				pantallaJugadores2.setRight(imgView2);
				BorderPane.setAlignment(imgView2, Pos.CENTER);

				tercerPantalla = new Scene(pantallaJugadores2,1100,600);
	}

	private Button crearBoton(String texto, String color) {
		Button boton = new Button(texto);
		boton.setPrefSize(300, 70);
		boton.setStyle("-fx-font: 22 arial; -fx-base: "+ color+
				";"+   "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		return boton;
	}


	private TextField crearCasillaNombre(String color) {
		TextField casilla = new TextField();
		casilla.setAlignment(Pos.CENTER);
		casilla.setStyle("-fx-background-color: "+ color+";"+ "-fx-text-fill: #1306c9;");
		casilla.setMaxWidth(300);
		casilla.setPromptText("Ingrese su nombre aqui");
		casilla.setOnMouseClicked(e->casilla.requestFocus());
		return casilla;
	}


	@Override
	public void cambiarVista(Pantalla pantalla) {
		pantalla.setearVista();
		stage.setFullScreen(true);
	}
}
