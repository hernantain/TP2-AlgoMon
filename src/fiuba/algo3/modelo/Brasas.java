package modelo;

public class Brasas extends AtaqueSimple{
	
	public Brasas(){
		tipo = new TipoFuego();
		potencia = new Potencia(16);
		cantidad = 10;
	}
}