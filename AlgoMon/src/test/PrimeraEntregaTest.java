package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Bulbasaur;
import modelo.Chansey;
import modelo.Charmander;
import modelo.Jigglypuff;
import modelo.Rattata;
import modelo.Squirtle;

public class PrimeraEntregaTest {

	//PUNTO 1 DE LA ENTREGA
	
	@Test
	public void testSquirtleAtacaConBurbujaACharmander() {
		Squirtle squirtle = new Squirtle();
		Charmander charmander = new Charmander();
		squirtle.atacarACon(charmander, "Burbuja");
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(150.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConCanionDeAguaACharmander() {
		Squirtle squirtle = new Squirtle();
		Charmander charmander = new Charmander();
		squirtle.atacarACon(charmander, "Canion de Agua");
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(130.0, charmander.vida(), 0.001D);
	}
	
	//PUNTO 2 DE LA ENTREGA
	
	@Test
	public void testSquirtleAtacaConBurbujaABulbasaur() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		squirtle.atacarACon(bulbasaur, "Burbuja");
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(135.0, bulbasaur.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConCanionDeAguaABulbasaur() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		squirtle.atacarACon(bulbasaur, "Canion de Agua");
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(130.0, bulbasaur.vida(), 0.001D);
	}
	
	//PUNTO 3 DE LA ENTREGA
	
	@Test
	public void testSquirtleAtacaConBurbujaAChansey() {
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		squirtle.atacarACon(chansey, "Burbuja");
		//LA VIDA DE CHANSEY ES 130
		assertEquals(120.0, chansey.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConCanionDeAguaAChansey() {
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		squirtle.atacarACon(chansey, "Canion de Agua");
		//LA VIDA DE CHANSEY ES 130
		assertEquals(110.0, chansey.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConBurbujaARattata() {
		Squirtle squirtle = new Squirtle();
		Rattata rattata = new Rattata();
		squirtle.atacarACon(rattata, "Burbuja");
		//LA VIDA DE RATTATA ES 170
		assertEquals(160.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConCanionDeAguaARattata() {
		Squirtle squirtle = new Squirtle();
		Rattata rattata = new Rattata();
		squirtle.atacarACon(rattata, "Canion de Agua");
		//LA VIDA DE RATTATA ES 170
		assertEquals(150.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConBurbujaAJigglypuff() {
		Squirtle squirtle = new Squirtle();
		Jigglypuff jigglypuff = new Jigglypuff();
		squirtle.atacarACon(jigglypuff, "Burbuja");
		//LA VIDA DE JIGGLYPUFF ES 130
		assertEquals(120.0, jigglypuff.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConCanionDeAguaAJigglypuff() {
		Squirtle squirtle = new Squirtle();
		Jigglypuff jigglypuff = new Jigglypuff();
		squirtle.atacarACon(jigglypuff, "Canion de Agua");
		//LA VIDA DE JIGGLYPUFF ES 130
		assertEquals(110.0, jigglypuff.vida(), 0.001D);
	}
	
	//PUNTO 4 DE LA ENTREGA
	
	@Test
	public void testBulbasaurAtacaConLatigoCepaASquirtle() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.atacarACon(squirtle, "Latigo Cepa");
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(120.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testChanseyAtacaConLatigoCepaASquirtle() {
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		chansey.atacarACon(squirtle, "Latigo Cepa");
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(120.0, squirtle.vida(), 0.001D);
	}
	
	//PUNTO 5 DE LA ENTREGA
	
	@Test
	public void testBulbasaurAtacaConLatigoCepaACharmander() {
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.atacarACon(charmander, "Latigo Cepa");
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(163.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testChanseyAtacaConLatigoCepaACharmander() {
		Charmander charmander = new Charmander();
		Chansey chansey = new Chansey();
		chansey.atacarACon(charmander, "Latigo Cepa");
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(163.0, charmander.vida(), 0.001D);
	}
	
	//PUNTO 6 DE LA ENTREGA

	@Test
	public void testBulbasaurAtacaConLatigoCepaAJigglypuff() {
		Jigglypuff jigglypuff = new Jigglypuff();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.atacarACon(jigglypuff, "Latigo Cepa");
		//LA VIDA DE JIGGLYPUFF ES 130
		assertEquals(115.0, jigglypuff.vida(), 0.001D);
	}
	
	@Test
	public void testChanseyAtacaConLatigoCepaAJigglypuff() {
		Jigglypuff jigglypuff = new Jigglypuff();
		Chansey chansey = new Chansey();
		chansey.atacarACon(jigglypuff, "Latigo Cepa");
		//LA VIDA DE JIGGLYPUFF ES 130
		assertEquals(115.0, jigglypuff.vida(), 0.001D);
	}
	
	@Test
	public void testBulbasaurAtacaConLatigoCepaARattata() {
		Rattata rattata = new Rattata();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.atacarACon(rattata, "Latigo Cepa");
		//LA VIDA DE RATTATA ES 170
		assertEquals(155.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testChanseyAtacaConLatigoCepaARattata() {
		Rattata rattata = new Rattata();
		Chansey chansey = new Chansey();
		chansey.atacarACon(rattata, "Latigo Cepa");
		//LA VIDA DE RATTATA ES 170
		assertEquals(155.0, rattata.vida(), 0.001D);
	}
	
	//PUNTO 7 DE LA ENTREGA
	
	@Test
	public void testCharmanderAtacaConBrasasABulbasaur() {
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		charmander.atacarACon(bulbasaur, "Brasas");
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(108.0, bulbasaur.vida(), 0.001D);
	}
	
	//PUNTO 8 DE LA ENTREGA
	
	@Test
	public void testCharmanderAtacaConBrasasASquirtle() {
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		charmander.atacarACon(squirtle, "Brasas");
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(142.0, squirtle.vida(), 0.001D);
	}
	
	//PUNTO 9 DE LA ENTREGA
	
	@Test
	public void testCharmanderAtacaConBrasasAJigglypuff() {
		Charmander charmander = new Charmander();
		Jigglypuff jigglypuff = new Jigglypuff();
		charmander.atacarACon(jigglypuff, "Brasas");
		//LA VIDA DE JIGGLYPUFF ES 130
		assertEquals(114.0, jigglypuff.vida(), 0.001D);
	}
	
	@Test
	public void testCharmanderAtacaConBrasasAChansey() {
		Charmander charmander = new Charmander();
		Chansey chansey = new Chansey();
		charmander.atacarACon(chansey, "Brasas");
		//LA VIDA DE CHANSEY ES 130
		assertEquals(114.0, chansey.vida(), 0.001D);
	}
	
	@Test
	public void testCharmanderAtacaConBrasasARattata() {
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		charmander.atacarACon(rattata, "Brasas");
		//LA VIDA DE RATTATA ES 170
		assertEquals(154.0, rattata.vida(), 0.001D);
	}
	
	//PUNTO 10 DE LA ENTREGA
	
	@Test
	public void testCharmanderAtacaConAtaqueRapidoARattata() {
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		charmander.atacarACon(rattata, "Ataque Rapido");
		//LA VIDA DE RATTATA ES 170
		assertEquals(160.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testCharmanderAtacaConAtaqueRapidoASquirtle() {
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		charmander.atacarACon(squirtle, "Ataque Rapido");
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(140.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testCharmanderAtacaConAtaqueRapidoABulbasaur() {
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		charmander.atacarACon(bulbasaur, "Ataque Rapido");
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(130.0, bulbasaur.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConAtaqueRapidoARattata() {
		Squirtle squirtle = new Squirtle();
		Rattata rattata = new Rattata();
		squirtle.atacarACon(rattata, "Ataque Rapido");
		//LA VIDA DE RATTATA ES 170
		assertEquals(160.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConAtaqueRapidoACharmander() {
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		squirtle.atacarACon(charmander, "Ataque Rapido");
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(160.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConAtaqueRapidoABulbasaur() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		squirtle.atacarACon(bulbasaur, "Ataque Rapido");
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(130.0, bulbasaur.vida(), 0.001D);
	}
	
	@Test
	public void testBulbasaurAtacaConAtaqueRapidoARattata() {
		Bulbasaur bulbasaur = new Bulbasaur();
		Rattata rattata = new Rattata();
		bulbasaur.atacarACon(rattata, "Ataque Rapido");
		//LA VIDA DE RATTATA ES 170
		assertEquals(160.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testBulbasaurAtacaConAtaqueRapidoACharmander() {
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.atacarACon(charmander, "Ataque Rapido");
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(160.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testBulbasaurAtacaConAtaqueRapidoASquirtle() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.atacarACon(squirtle, "Ataque Rapido");
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(140.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testRattataAtacaConAtaqueRapidoAChansey() {
		Chansey chansey = new Chansey();
		Rattata rattata = new Rattata();
		rattata.atacarACon(chansey, "Ataque Rapido");
		//LA VIDA DE CHANSEY ES 130
		assertEquals(120.0, chansey.vida(), 0.001D);
	}
	
	@Test
	public void testRattataAtacaConAtaqueRapidoACharmander() {
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		rattata.atacarACon(charmander, "Ataque Rapido");
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(160.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testRattatAtacaConAtaqueRapidoASquirtle() {
		Squirtle squirtle = new Squirtle();
		Rattata rattata = new Rattata();
		rattata.atacarACon(squirtle, "Ataque Rapido");
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(140.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testRattatAtacaConAtaqueRapidoABulbasaur() {
		Bulbasaur bulbasaur = new Bulbasaur();
		Rattata rattata = new Rattata();
		rattata.atacarACon(bulbasaur, "Ataque Rapido");
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(130.0, bulbasaur.vida(), 0.001D);
	}
	
	//PUNTO 11 DE LA ENTREGA
	
	@Test
	public void SquirtleAgotaAtaqueRapido(){
		
		Squirtle squirtle = new Squirtle();
		Squirtle squirtle2 = new Squirtle();
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			squirtle.atacarACon(squirtle2, "Ataque Rapido");
		}
		assertEquals(false, squirtle.atacarACon(squirtle2, "Ataque Rapido"));
	}
	
	@Test
	public void SquirtleAgotaBurbuja(){
		
		Squirtle squirtle = new Squirtle();
		Squirtle squirtle2 = new Squirtle();
		for (int x = 0; x < 15; x++){ 			//BURBUJA TIENE UNA CANTIDAD DE 15
			squirtle.atacarACon(squirtle2, "Burbuja");
		}
		assertEquals(false, squirtle.atacarACon(squirtle2, "Burbuja"));
	}
	
	@Test
	public void SquirtleAgotaCanionDeAgua(){
		
		Squirtle squirtle = new Squirtle();
		Squirtle squirtle2 = new Squirtle();
		for (int x = 0; x < 8; x++){ 			//CANION DE AGUA TIENE UNA CANTIDAD DE 15
			squirtle.atacarACon(squirtle2, "Canion de Agua");
		}
		assertEquals(false, squirtle.atacarACon(squirtle2, "Canion de Agua"));
	}
	
	@Test
	public void CharmanderAgotaBrasas(){
		
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		for (int x = 0; x < 10; x++){  			//BRASAS TIENE UNA CANTIDAD DE 10	
			charmander.atacarACon(squirtle, "Brasas");
		}
		assertEquals(false, charmander.atacarACon(squirtle, "Brasas"));
	}
	
	@Test
	public void CharmanderAgotaAtaqueRapido(){
		
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			charmander.atacarACon(bulbasaur, "Ataque Rapido");
		}
		assertEquals(false, charmander.atacarACon(bulbasaur, "Ataque Rapido"));
	}
	
	@Test
	public void BulbasaurAgotaLatigoCepa(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		for (int x = 0; x < 10; x++){  			//LATIGO CEPA TIENE UNA CANTIDAD DE 10	
			bulbasaur.atacarACon(squirtle, "Latigo Cepa");
		}
		assertEquals(false, bulbasaur.atacarACon(squirtle, "Latigo Cepa"));
	}
	
	@Test
	public void BulbasaurAgotaAtaqueRapido(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			bulbasaur.atacarACon(squirtle, "Ataque Rapido");
		}
		assertEquals(false, bulbasaur.atacarACon(squirtle, "Ataque Rapido"));
	}
	
	@Test
	public void ChanseyAgotaAtaqueRapido(){
		
		Chansey chansey = new Chansey();
		Bulbasaur bulbasaur = new Bulbasaur();
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			chansey.atacarACon(bulbasaur, "Ataque Rapido");
		}
		assertEquals(false, chansey.atacarACon(bulbasaur, "Ataque Rapido"));
	}

	@Test
	public void ChanseyAgotaLatigoCepa(){
		
		Chansey chansey = new Chansey();
		Squirtle squirtle = new Squirtle();
		for (int x = 0; x < 10; x++){  			//LATIGO CEPA TIENE UNA CANTIDAD DE 10	
			chansey.atacarACon(squirtle, "Latigo Cepa");
		}
		assertEquals(false, chansey.atacarACon(squirtle, "Latigo Cepa"));
	}
	
	@Test
	public void JigglypuffAgotaAtaqueRapido(){
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Bulbasaur bulbasaur = new Bulbasaur();
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			jigglypuff.atacarACon(bulbasaur, "Ataque Rapido");
		}
		assertEquals(false, jigglypuff.atacarACon(bulbasaur, "Ataque Rapido"));
	}	
	
	@Test
	public void JigglypuffAgotaBurbuja(){
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Squirtle squirtle = new Squirtle();
		for (int x = 0; x < 15; x++){ 			//BURBUJA TIENE UNA CANTIDAD DE 15
			jigglypuff.atacarACon(squirtle, "Burbuja");
		}
		assertEquals(false, jigglypuff.atacarACon(squirtle, "Burbuja"));
	}
	
	@Test
	public void RattataAgotaAtaqueRapido(){
		
		Rattata rattata = new Rattata();
		Jigglypuff jigglypuff = new Jigglypuff();
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			rattata.atacarACon(jigglypuff, "Ataque Rapido");
		}
		assertEquals(false, rattata.atacarACon(jigglypuff, "Ataque Rapido"));
	}	
	
	@Test
	public void RattataAgotaBurbuja(){
		
		Rattata rattata = new Rattata();
		Squirtle squirtle = new Squirtle();
		for (int x = 0; x < 15; x++){ 			//BURBUJA TIENE UNA CANTIDAD DE 15
			rattata.atacarACon(squirtle, "Burbuja");
		}
		assertEquals(false, rattata.atacarACon(squirtle, "Burbuja"));
	}
	
	@Test
	public void AtaqueAgotadoFinal() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		squirtle.atacarACon(bulbasaur, "Canion de Agua");
		assertEquals(true, squirtle.atacarACon(bulbasaur, "Canion de Agua"));
		squirtle.atacarACon(bulbasaur, "Canion de Agua");
		squirtle.atacarACon(bulbasaur, "Canion de Agua");
		squirtle.atacarACon(bulbasaur, "Canion de Agua");
		squirtle.atacarACon(bulbasaur, "Canion de Agua");
		assertEquals(true, squirtle.atacarACon(bulbasaur, "Canion de Agua"));
		squirtle.atacarACon(bulbasaur, "Canion de Agua"); // Ataque nro 8
		assertEquals(false, squirtle.atacarACon(bulbasaur, "Canion de Agua")); // Ataque nro 9
		assertEquals(true,squirtle.atacarACon(bulbasaur, "Ataque Rapido")); //No es canion de agua, Squirtle puede seguir atacando
	}
}
