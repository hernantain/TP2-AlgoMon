package modelo;

public class CanionDeAgua extends AtaqueSimple {

	public CanionDeAgua(){
		tipo = new TipoAgua();
		potencia = new Potencia(20);
		cantidad = 8;
	}
}
