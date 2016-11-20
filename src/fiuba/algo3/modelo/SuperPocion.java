package modelo;

public class SuperPocion extends Elemento {
	private int vidaACurar = 40;
	
	public void aplicarA(Algomon algomon) {
		algomon.curarse(vidaACurar);
	}
}
