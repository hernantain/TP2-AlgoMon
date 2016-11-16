package modelo;

public class AtaqueRapido extends AtaqueSimple {
	
	public AtaqueRapido(){
		tipo = new TipoNormal();
		potencia = new Potencia(10);
		cantidad = 16;
	}
}
