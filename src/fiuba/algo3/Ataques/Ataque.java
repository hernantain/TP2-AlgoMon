package Ataques;

import Algomones.Algomon;

public interface Ataque {

	public boolean atacar(Algomon algomon);

	public void aumentarCantidadDeAtaque(int cantidadAAumentar);
	
}
