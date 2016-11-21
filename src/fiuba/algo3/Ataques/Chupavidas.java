package Ataques;

import Algomones.Algomon;
import Tipos.TipoPlanta;

public class Chupavidas extends AtaqueSimple {//PREGUNTAR COMO PASARLE EL ALGOMON SIN CAMBIAR EL DECORATOR
	private Algomon algomonAtacante;
	
	public Chupavidas(Algomon algomonAtacante) {
		potencia = new Potencia(15);
		cantidad = 8;
		tipo = new TipoPlanta();
		this.algomonAtacante = algomonAtacante;
	}
	
	public boolean atacar(Algomon algomonAtacado) {
		int danio_realizado = potencia.calcularPotencia(tipo, algomonAtacado.getTipo());
		int cantidad_a_curarse = danio_realizado * 30 / 100;
		algomonAtacante.curarse(cantidad_a_curarse);
		return super.atacar(algomonAtacado);
	}

}
