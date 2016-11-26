package fiuba.algo3.vista;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaReglas {
	
	Stage stage;
	Scene scene;
	
	public PantallaReglas(Stage stagePrincipal, Scene sceneInicial){
		stage = stagePrincipal;
		scene = sceneInicial;
		stage.setMaximized(false);
	}

	public void cambiarVista() {
		
		Button botonVolver = new Button("Volver");
		botonVolver.setStyle("-fx-font: 22 arial; -fx-base: #0014f4;"
				+   "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		
		Label reglamentoTitulo = new Label("Reglas del Juego");
		reglamentoTitulo.setStyle("-fx-font: 45 arial; -fx-text-fill: #ff0000; -fx-font-weight: bold;");
		
		Label reglamento = new Label();
		reglamento.setText("El juego es para dos jugadores y cada uno tiene que elegir tres algomones (de a uno por vez) al\n"
					 	  +"principio de la partida. El algomon elegido primero por cada uno sera el primero en pelear.\n"
					 	  +"Es un juego por turnos. En cada turno el jugador puede elegir entre las siguientes acciones:\n"
					 	  +"	- cambiar de algomon: aparecera un listado de los otros algomones vivos del jugador para"
					 	  +"que elija;\n"
					 	  +"	- atacar con el algomon activo: aparecera un listado de todos los ataques disponibles de ese"
					 	  +"algomon;\n"
					 	  +"	- aplicarle algun elemento al algomon activo: aparecera un listado de todos los elementos y\n"
					 	  +"	las cantidades que todavia dispone el jugador.\n"
					 	  +"Cualquiera de estas tres acciones hara que el turno termine.\n"
					 	  +"El juego elige al azar que jugador comienza. Cuando un algomon se queda sin puntos de vida el\n"
					 	  +"jugador debe elegir cual de sus algomones restantes vivos reemplaza al fallecido. La partida\n"
					 	  +"termina cuando algun jugador se quede sin algomones vivos, convirtiendose asi en el jugador perdedor.");
		reglamento.setStyle("-fx-text-fill: black;"
						  + "-fx-font: 22 arial;"
						  + "-fx-font-weight: bold;");
		
		botonVolver.setOnAction(e-> {
			stage.setScene(scene); 
			stage.setMaximized(false);
			stage.setMaximized(true);
		});
		
		
		VBox layoutReglas = new VBox(10);
		layoutReglas.setAlignment(Pos.TOP_CENTER);
		layoutReglas.setStyle("-fx-background-image: url('file:src/imagenes/fondoReglas.jpg');"
							+ "-fx-background-size: cover;");
		
		layoutReglas.getChildren().addAll(reglamentoTitulo,reglamento,botonVolver);
		
		Scene sceneReglas = new Scene(layoutReglas,1100,600);
		stage.setScene(sceneReglas);
		stage.setMaximized(true);
		
	}
	
	
}
