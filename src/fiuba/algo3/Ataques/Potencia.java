package Ataques;

import Tipos.Tipo;

public class Potencia {
	
	int potenciaBase;
	
	public Potencia(int pot){
		potenciaBase = pot;
	}
	
	public int calcularPotencia(Tipo tipoAtaque, Tipo tipoAlgomon){
		int potenciaFinal = (int)(potenciaBase*(tipoAtaque.vs(tipoAlgomon)));
		return potenciaFinal;
	}

}
