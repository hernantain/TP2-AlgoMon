package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Ataques.*;
import Algomones.*;
public class PrimeraEntregaTest {

	//PUNTO 1 DE LA ENTREGA
	
	@Test
	public void testSquirtleAtacaConBurbujaACharmander() {
		Squirtle squirtle = new Squirtle();
		Charmander charmander = new Charmander();
		squirtle.setEstrategiaAtaque(new Burbuja());
		squirtle.atacarA(charmander);
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(150.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConCanionDeAguaACharmander() {
		Squirtle squirtle = new Squirtle();
		Charmander charmander = new Charmander();
		squirtle.setEstrategiaAtaque(new CanionDeAgua());
		squirtle.atacarA(charmander);
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(130.0, charmander.vida(), 0.001D);
	}
	
	//PUNTO 2 DE LA ENTREGA
	
	@Test
	public void testSquirtleAtacaConBurbujaABulbasaur() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		squirtle.setEstrategiaAtaque(new Burbuja());
		squirtle.atacarA(bulbasaur);
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(135.0, bulbasaur.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConCanionDeAguaABulbasaur() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		squirtle.setEstrategiaAtaque(new CanionDeAgua());
		squirtle.atacarA(bulbasaur);
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(130.0, bulbasaur.vida(), 0.001D);
	}
	
	//PUNTO 3 DE LA ENTREGA
	
	@Test
	public void testSquirtleAtacaConBurbujaAChansey() {
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		squirtle.setEstrategiaAtaque(new Burbuja());
		squirtle.atacarA(chansey);
		//LA VIDA DE CHANSEY ES 130
		assertEquals(120.0, chansey.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConCanionDeAguaAChansey() {
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		squirtle.setEstrategiaAtaque(new CanionDeAgua());
		squirtle.atacarA(chansey);
		//LA VIDA DE CHANSEY ES 130
		assertEquals(110.0, chansey.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConBurbujaARattata() {
		Squirtle squirtle = new Squirtle();
		Rattata rattata = new Rattata();
		squirtle.setEstrategiaAtaque(new Burbuja());
		squirtle.atacarA(rattata);
		//LA VIDA DE RATTATA ES 170
		assertEquals(160.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConCanionDeAguaARattata() {
		Squirtle squirtle = new Squirtle();
		Rattata rattata = new Rattata();
		squirtle.setEstrategiaAtaque(new CanionDeAgua());
		squirtle.atacarA(rattata);
		//LA VIDA DE RATTATA ES 170
		assertEquals(150.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConBurbujaAJigglypuff() {
		Squirtle squirtle = new Squirtle();
		Jigglypuff jigglypuff = new Jigglypuff();
		squirtle.setEstrategiaAtaque(new Burbuja());
		squirtle.atacarA(jigglypuff);
		//LA VIDA DE JIGGLYPUFF ES 130
		assertEquals(120.0, jigglypuff.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConCanionDeAguaAJigglypuff() {
		Squirtle squirtle = new Squirtle();
		Jigglypuff jigglypuff = new Jigglypuff();
		squirtle.setEstrategiaAtaque(new CanionDeAgua());
		squirtle.atacarA(jigglypuff);
		//LA VIDA DE JIGGLYPUFF ES 130
		assertEquals(110.0, jigglypuff.vida(), 0.001D);
	}
	
	//PUNTO 4 DE LA ENTREGA
	
	@Test
	public void testBulbasaurAtacaConLatigoCepaASquirtle() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.setEstrategiaAtaque(new LatigoCepa());
		bulbasaur.atacarA(squirtle);
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(120.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testChanseyAtacaConLatigoCepaASquirtle() {
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		chansey.setEstrategiaAtaque(new LatigoCepa());
		chansey.atacarA(squirtle);
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(120.0, squirtle.vida(), 0.001D);
	}
	
	//PUNTO 5 DE LA ENTREGA
	
	@Test
	public void testBulbasaurAtacaConLatigoCepaACharmander() {
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.setEstrategiaAtaque(new LatigoCepa());
		bulbasaur.atacarA(charmander);
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(163.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testChanseyAtacaConLatigoCepaACharmander() {
		Charmander charmander = new Charmander();
		Chansey chansey = new Chansey();
		chansey.setEstrategiaAtaque(new LatigoCepa());
		chansey.atacarA(charmander);
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(163.0, charmander.vida(), 0.001D);
	}
	
	//PUNTO 6 DE LA ENTREGA

	@Test
	public void testBulbasaurAtacaConLatigoCepaAJigglypuff() {
		Jigglypuff jigglypuff = new Jigglypuff();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.setEstrategiaAtaque(new LatigoCepa());
		bulbasaur.atacarA(jigglypuff);
		//LA VIDA DE JIGGLYPUFF ES 130
		assertEquals(115.0, jigglypuff.vida(), 0.001D);
	}
	
	@Test
	public void testChanseyAtacaConLatigoCepaAJigglypuff() {
		Jigglypuff jigglypuff = new Jigglypuff();
		Chansey chansey = new Chansey();
		chansey.setEstrategiaAtaque(new LatigoCepa());
		chansey.atacarA(jigglypuff);
		//LA VIDA DE JIGGLYPUFF ES 130
		assertEquals(115.0, jigglypuff.vida(), 0.001D);
	}
	
	@Test
	public void testBulbasaurAtacaConLatigoCepaARattata() {
		Rattata rattata = new Rattata();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.setEstrategiaAtaque(new LatigoCepa());
		bulbasaur.atacarA(rattata);
		//LA VIDA DE RATTATA ES 170
		assertEquals(155.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testChanseyAtacaConLatigoCepaARattata() {
		Rattata rattata = new Rattata();
		Chansey chansey = new Chansey();
		chansey.setEstrategiaAtaque(new LatigoCepa());
		chansey.atacarA(rattata);
		//LA VIDA DE RATTATA ES 170
		assertEquals(155.0, rattata.vida(), 0.001D);
	}
	
	//PUNTO 7 DE LA ENTREGA
	
	@Test
	public void testCharmanderAtacaConBrasasABulbasaur() {
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		charmander.setEstrategiaAtaque(new Brasas());
		charmander.atacarA(bulbasaur);
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(108.0, bulbasaur.vida(), 0.001D);
	}
	
	//PUNTO 8 DE LA ENTREGA
	
	@Test
	public void testCharmanderAtacaConBrasasASquirtle() {
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		charmander.setEstrategiaAtaque(new Brasas());
		charmander.atacarA(squirtle);
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(142.0, squirtle.vida(), 0.001D);
	}
	
	//PUNTO 9 DE LA ENTREGA
	
	@Test
	public void testCharmanderAtacaConBrasasAJigglypuff() {
		Charmander charmander = new Charmander();
		Jigglypuff jigglypuff = new Jigglypuff();
		charmander.setEstrategiaAtaque(new Brasas());
		charmander.atacarA(jigglypuff);
		//LA VIDA DE JIGGLYPUFF ES 130
		assertEquals(114.0, jigglypuff.vida(), 0.001D);
	}
	
	@Test
	public void testCharmanderAtacaConBrasasAChansey() {
		Charmander charmander = new Charmander();
		Chansey chansey = new Chansey();
		charmander.setEstrategiaAtaque(new Brasas());
		charmander.atacarA(chansey);
		//LA VIDA DE CHANSEY ES 130
		assertEquals(114.0, chansey.vida(), 0.001D);
	}
	
	@Test
	public void testCharmanderAtacaConBrasasARattata() {
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		charmander.setEstrategiaAtaque(new Brasas());
		charmander.atacarA(rattata);
		//LA VIDA DE RATTATA ES 170
		assertEquals(154.0, rattata.vida(), 0.001D);
	}
	
	//PUNTO 10 DE LA ENTREGA
	
	@Test
	public void testCharmanderAtacaConAtaqueRapidoARattata() {
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		charmander.setEstrategiaAtaque(new AtaqueRapido());
		charmander.atacarA(rattata);
		//LA VIDA DE RATTATA ES 170
		assertEquals(160.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testCharmanderAtacaConAtaqueRapidoASquirtle() {
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		charmander.setEstrategiaAtaque(new AtaqueRapido());
		charmander.atacarA(squirtle);
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(140.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testCharmanderAtacaConAtaqueRapidoABulbasaur() {
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		charmander.setEstrategiaAtaque(new AtaqueRapido());
		charmander.atacarA(bulbasaur);
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(130.0, bulbasaur.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConAtaqueRapidoARattata() {
		Squirtle squirtle = new Squirtle();
		Rattata rattata = new Rattata();
		squirtle.setEstrategiaAtaque(new AtaqueRapido());
		squirtle.atacarA(rattata);
		//LA VIDA DE RATTATA ES 170
		assertEquals(160.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConAtaqueRapidoACharmander() {
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		squirtle.setEstrategiaAtaque(new AtaqueRapido());
		squirtle.atacarA(charmander);
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(160.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testSquirtleAtacaConAtaqueRapidoABulbasaur() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		squirtle.setEstrategiaAtaque(new AtaqueRapido());
		squirtle.atacarA(bulbasaur);
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(130.0, bulbasaur.vida(), 0.001D);
	}
	
	@Test
	public void testBulbasaurAtacaConAtaqueRapidoARattata() {
		Bulbasaur bulbasaur = new Bulbasaur();
		Rattata rattata = new Rattata();
		bulbasaur.setEstrategiaAtaque(new AtaqueRapido());
		bulbasaur.atacarA(rattata);
		//LA VIDA DE RATTATA ES 170
		assertEquals(160.0, rattata.vida(), 0.001D);
	}
	
	@Test
	public void testBulbasaurAtacaConAtaqueRapidoACharmander() {
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.setEstrategiaAtaque(new AtaqueRapido());
		bulbasaur.atacarA(charmander);
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(160.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testBulbasaurAtacaConAtaqueRapidoASquirtle() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		bulbasaur.setEstrategiaAtaque(new AtaqueRapido());
		bulbasaur.atacarA(squirtle);
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(140.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testRattataAtacaConAtaqueRapidoAChansey() {
		Chansey chansey = new Chansey();
		Rattata rattata = new Rattata();
		rattata.setEstrategiaAtaque(new AtaqueRapido());
		rattata.atacarA(chansey);
		//LA VIDA DE CHANSEY ES 130
		assertEquals(120.0, chansey.vida(), 0.001D);
	}
	
	@Test
	public void testRattataAtacaConAtaqueRapidoACharmander() {
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		rattata.setEstrategiaAtaque(new AtaqueRapido());
		rattata.atacarA(charmander);
		//LA VIDA DE CHARMANDER ES 170
		assertEquals(160.0, charmander.vida(), 0.001D);
	}
	
	@Test
	public void testRattatAtacaConAtaqueRapidoASquirtle() {
		Squirtle squirtle = new Squirtle();
		Rattata rattata = new Rattata();
		rattata.setEstrategiaAtaque(new AtaqueRapido());
		rattata.atacarA(squirtle);
		//LA VIDA DE SQUIRTLE ES 150
		assertEquals(140.0, squirtle.vida(), 0.001D);
	}
	
	@Test
	public void testRattatAtacaConAtaqueRapidoABulbasaur() {
		Bulbasaur bulbasaur = new Bulbasaur();
		Rattata rattata = new Rattata();
		rattata.setEstrategiaAtaque(new AtaqueRapido());
		rattata.atacarA(bulbasaur);
		//LA VIDA DE BULBASAUR ES 140
		assertEquals(130.0, bulbasaur.vida(), 0.001D);
	}
	
	//PUNTO 11 DE LA ENTREGA
	
	@Test
	public void SquirtleAgotaAtaqueRapido(){
		
		Squirtle squirtle = new Squirtle();
		Rattata rattata = new Rattata();
		squirtle.setEstrategiaAtaque(new AtaqueRapido());
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			squirtle.atacarA(rattata);
		}
		assertEquals(false, squirtle.atacarA(rattata));
	}
	
	@Test
	public void SquirtleAgotaBurbuja(){
		
		Squirtle squirtle = new Squirtle();
		Squirtle squirtle2 = new Squirtle();
		squirtle.setEstrategiaAtaque(new Burbuja());
		for (int x = 0; x < 15; x++){ 			//BURBUJA TIENE UNA CANTIDAD DE 15
			squirtle.atacarA(squirtle2);
		}
		assertEquals(false, squirtle.atacarA(squirtle2));
	}
	
	@Test
	public void SquirtleAgotaCanionDeAgua(){
		
		Squirtle squirtle = new Squirtle();
		Squirtle squirtle2 = new Squirtle();
		squirtle.setEstrategiaAtaque( new CanionDeAgua());
		for (int x = 0; x < 8; x++){ 			//CANION DE AGUA TIENE UNA CANTIDAD DE 15
			squirtle.atacarA(squirtle2);
		}
		assertEquals(false, squirtle.atacarA(squirtle2));
	}
	
	@Test
	public void CharmanderAgotaBrasas(){
		
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		charmander.setEstrategiaAtaque(new Brasas());
		for (int x = 0; x < 10; x++){  			//BRASAS TIENE UNA CANTIDAD DE 10	
			charmander.atacarA(squirtle);
		}
		assertEquals(false, charmander.atacarA(squirtle));
	}
	
	@Test
	public void CharmanderAgotaAtaqueRapido(){
		
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		charmander.setEstrategiaAtaque(new AtaqueRapido());
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			charmander.atacarA(rattata);
		}
		assertEquals(false, charmander.atacarA(rattata));
	}
	
	@Test
	public void BulbasaurAgotaLatigoCepa(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Rattata rattata = new Rattata();
		bulbasaur.setEstrategiaAtaque(new LatigoCepa());
		for (int x = 0; x < 10; x++){  			//LATIGO CEPA TIENE UNA CANTIDAD DE 10	
			bulbasaur.atacarA(rattata);
		}
		assertEquals(false, bulbasaur.atacarA(rattata));
	}
	
	@Test
	public void BulbasaurAgotaAtaqueRapido(){
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Charmander charmander = new Charmander();
		bulbasaur.setEstrategiaAtaque(new AtaqueRapido());
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			bulbasaur.atacarA(charmander);
		}
		assertEquals(false, bulbasaur.atacarA(charmander));
	}
	
	@Test
	public void ChanseyAgotaAtaqueRapido(){
		
		Chansey chansey = new Chansey();
		Rattata rattata = new Rattata();
		chansey.setEstrategiaAtaque(new AtaqueRapido());
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			chansey.atacarA(rattata);
		}
		assertEquals(false, chansey.atacarA(rattata));
	}

	@Test
	public void ChanseyAgotaLatigoCepa(){
		
		Chansey chansey = new Chansey();
		Charmander charmander = new Charmander();
		chansey.setEstrategiaAtaque( new LatigoCepa());
		for (int x = 0; x < 10; x++){  			//LATIGO CEPA TIENE UNA CANTIDAD DE 10	
			chansey.atacarA(charmander);
		}
		assertEquals(false, chansey.atacarA(charmander));
	}
	
	@Test
	public void JigglypuffAgotaAtaqueRapido(){
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Rattata rattata = new Rattata();
		jigglypuff.setEstrategiaAtaque(new AtaqueRapido());
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			jigglypuff.atacarA(rattata);
		}
		assertEquals(false, jigglypuff.atacarA(rattata));
	}	
	
	@Test
	public void JigglypuffAgotaBurbuja(){
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Squirtle squirtle = new Squirtle();
		jigglypuff.setEstrategiaAtaque(new Burbuja());
		for (int x = 0; x < 15; x++){ 			//BURBUJA TIENE UNA CANTIDAD DE 15
			jigglypuff.atacarA(squirtle);
		}
		assertEquals(false, jigglypuff.atacarA(squirtle));
	}
	
	@Test
	public void RattataAgotaAtaqueRapido(){
		
		Rattata rattata = new Rattata();
		Charmander charmander = new Charmander();
		rattata.setEstrategiaAtaque(new AtaqueRapido());
		for (int x = 0; x < 16; x++){  			//ATAQUE RAPIDO TIENE UNA CANTIDAD DE 16	
			rattata.atacarA(charmander);
		}
		assertEquals(false, rattata.atacarA(charmander));
	}	
	
	@Test
	public void RattataAgotaBurbuja(){
		
		Rattata rattata = new Rattata();
		Squirtle squirtle = new Squirtle();
		rattata.setEstrategiaAtaque(new Burbuja());
		for (int x = 0; x < 15; x++){ 			//BURBUJA TIENE UNA CANTIDAD DE 15
			rattata.atacarA(squirtle);
		}
		assertEquals(false, rattata.atacarA(squirtle));
	}
	
	@Test
	public void AtaqueAgotadoFinal() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		squirtle.setEstrategiaAtaque(new CanionDeAgua());
		squirtle.atacarA(bulbasaur);
		assertEquals(true, squirtle.atacarA(bulbasaur));
		squirtle.atacarA(bulbasaur);
		squirtle.atacarA(bulbasaur);
		squirtle.atacarA(bulbasaur);
		squirtle.atacarA(bulbasaur);
		assertEquals(true, squirtle.atacarA(bulbasaur));
		squirtle.atacarA(bulbasaur); // ATAQUE NRO 8
		assertEquals(false, squirtle.atacarA(bulbasaur)); // ATAQUE NRO 9
		squirtle.setEstrategiaAtaque(new AtaqueRapido());
		assertEquals(true,squirtle.atacarA(bulbasaur)); //NO ES CANION DE AGUA, PUEDE SEGUIR ATACANDO
	}
}
