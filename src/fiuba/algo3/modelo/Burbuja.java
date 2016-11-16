package modelo;

public class Burbuja extends AtaqueSimple {
	
	public Burbuja(){
		tipo = new TipoAgua();
		potencia = new Potencia(10);
		cantidad = 15;
	}
}
