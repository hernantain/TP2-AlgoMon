package modelo;

public class LatigoCepa extends AtaqueSimple{
	
	public LatigoCepa(){
		tipo = new TipoPlanta();
		potencia = new Potencia(15);
		cantidad = 10;
	}

}
