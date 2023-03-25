import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyStringTest {

	MyString str;
	MyString str2;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.str = new MyString("heyy");
		this.str2 = new MyString("hey you");
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.str = null;
		this.str2 = null;
	}

	@Test
	@DisplayName("Convertir tous les caractères de la chaîne en majuscule")
	public void testMajuscules() {
		this.str.sbToUpperCase();
		this.str2.sbToUpperCase();
		assertAll(
				()->assertEquals("HEYY", this.str.getString()),
				()->assertEquals("HEY YOU", this.str2.getString())
		);
	}
	
	@Test
	@DisplayName("Obtenir le nombre d'occurrence d'un caractère donné de la chaîne")
	public void testOccurenceCar() {
		assertEquals(1, this.str.getOccurence('h'));
		assertEquals(1, this.str.getOccurence('e'));
		assertEquals(2, this.str.getOccurence('y'));
	}
	
	@Test
	@DisplayName("Compter le nombre de voyelles (le Y sera considéré comme consonne) de la chaîne")
	public void testOccurenceVoyelle() {
		assertAll(
				()->assertEquals(1, this.str.getNbVoyelles()),
				()->assertEquals(3, this.str2.getNbVoyelles())
		);
	}
	
	@Test
	@DisplayName("Obtenir le premier mot de la chaîne")
	public void testPremierMot() {
		assertAll(
				()->assertEquals("heyy", this.str.getPremierMot()),
				()->assertEquals("hey", this.str2.getPremierMot())
		);
	}
			
}
