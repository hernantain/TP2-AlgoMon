package Ataques;

import Algomones.Algomon;

public interface Ataque {

	public boolean atacar(Algomon algomon);

	public void aumentarCantidadDeAtaque(int cantidadAAumentar);
	public String nombre();
	public boolean equals(Ataque ataque);
	public int danioRealizado(Algomon algomonAtacado);
	public boolean agotado();

	public int getCantidad();
	
	
}
