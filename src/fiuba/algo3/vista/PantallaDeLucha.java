package vista;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.*;
import Elementos.*;
import Ataques.*;
import Estado.*;
import Acciones.*;
import Algomones.Algomon;

public class PantallaDeLucha {

	Stage stage;
	Jugador jugador1, jugador2;
	Button atacar,botonElemento,volverOpciones;
	Turno turno;
	BorderPane pantalla;
	HBox opciones;
	
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
		nombrejugador1.setStyle("-fx-font: 24 arial; -fx-text-fill: #ff0000; -fx-background-color: white;");
		jugador1Algomones.getChildren().add(nombrejugador1);
		
		Label nombrejugador2 = new Label(jugador2.getNombre());
		nombrejugador2.setStyle("-fx-font: 24 arial; -fx-text-fill: #00ffff;");
		jugador2Algomones.getChildren().add(nombrejugador2);
		
		Button volverAtacar = crearBoton("Volver");
		volverAtacar.setOnAction(e->{
			pantalla.setBottom(opciones);
		});
		
		Button volverElementos = crearBoton("Volver");
		volverElementos.setOnAction(e->{
			pantalla.setBottom(opciones);
		});
		
		HBox ataques = new HBox(40);
		ataques.setPrefSize(700, 150);
		ataques.setAlignment(Pos.CENTER);
		
		HBox elementos = new HBox(40);
		ataques.setPrefSize(700, 150);
		ataques.setAlignment(Pos.CENTER);
		
		this.cambiarBotonAtaque(turno.jugadorActivo(), ataques, volverAtacar);
		
		atacar = new Button("Atacar");
		atacar.setOnAction(e->pantalla.setBottom(ataques));
		
		this.usarElementosBotones(turno.jugadorActivo(), elementos, volverElementos);
		
		botonElemento = new Button("Usar Elemento");
		botonElemento.setOnAction(e-> {
			pantalla.setBottom(elementos);
		});
		
		volverOpciones = new Button("Volver");
		volverOpciones.setDisable(true);
		volverOpciones.setOnAction(e->this.habilitarAlgomones(jugador1Algomones, atacar, botonElemento, volverOpciones));
		
		Button cambiar = new Button("Cambiar Algomon");
		cambiar.setOnAction(e->{
			if (turno.jugadorActivo() == jugador1){
				this.cambiarDeAlgomon(jugador1Algomones);
			}
			else this.cambiarDeAlgomon(jugador2Algomones);
		});
		
		this.mostrarAlgomonesDeJugadores(jugador1, volverAtacar, ataques, jugador1Algomones);
		this.mostrarAlgomonesDeJugadores(jugador2, volverAtacar, ataques, jugador2Algomones);
		
		opciones.getChildren().addAll(atacar, cambiar, botonElemento,volverOpciones);
		
		pantalla.setLeft(jugador1Algomones);
		pantalla.setRight(jugador2Algomones);
		pantalla.setBottom(opciones);
		
		Scene quintaPantalla = new Scene(pantalla,1100,600);
		
		stage.setScene(quintaPantalla);
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
					this.habilitarAlgomones(algomonesJugador, atacar, botonElemento, volverOpciones);
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
			botonAtaque.setOnAction(event->{
				turno.jugar(new Atacar(turno.jugadorActivo().getAlgomonActivo(), ataque, turno.jugadorNoActivo().getAlgomonActivo()));
				this.cambiarBotonAtaque(turno.jugadorActivo(), ataques, volver);
				pantalla.setBottom(opciones);
				System.out.println(turno.jugadorActivo().getAlgomonActivo().vida());
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
			botonElemento.setOnAction(event->{
				turno.jugar(new UsarElemento(turno.jugadorActivo(),elemento));
				this.usarElementosBotones(turno.jugadorActivo(), elementos, volver);
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
		atacar.setDisable(true);
		botonElemento.setDisable(true);
		volverOpciones.setDisable(false);
	}
}
