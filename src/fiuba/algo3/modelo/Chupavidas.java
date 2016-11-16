package modelo;

public class Chupavidas extends AtaqueEspecial {
	private Algomon algomonAtacante;
	
	public Chupavidas(Algomon algomonAtacante) {
		potencia = new Potencia(15);
		cantidad = 8;
		tipo = new TipoPlanta();
		this.algomonAtacante = algomonAtacante;
	}
	
	protected void efectoSecundario(Algomon algomonAtacado) {
		int danio_realizado = potencia.calcularPotencia(tipo, algomonAtacado.getTipo());
		int cantidad_a_curarse = danio_realizado * 30 / 100;
		algomonAtacante.curarse(cantidad_a_curarse);
	}

}
