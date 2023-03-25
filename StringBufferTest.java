import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringBufferTest {

	String myString;
	
	@BeforeEach
	public void setUp() {
		myString = "oup";
	}
	
	@AfterEach
	public void tearDown() {
		myString = null;
	}
	
	@DisplayName("Test charAt method")
	@Test
	public void testCharAt() {
		assertAll("test de charAt avec une chaine et un indice valide", 
				() -> assertEquals('o', this.myString.charAt(0)),
				() -> assertEquals('u', this.myString.charAt(1)),
				() -> assertEquals('p', this.myString.charAt(this.myString.length()-1))
		);
		assertAll("test de charAt avec un indice invalide", 
				() -> assertThrows(IndexOutOfBoundsException.class, () -> this.myString.charAt(3)),
				() -> assertThrows(IndexOutOfBoundsException.class, () -> this.myString.charAt(-3))
		);
	}
	
	@DisplayName("Test setCharAt method")
	@Test
	public void testSetCharAt() {
		StringBuffer myString = new StringBuffer("lol");
		myString.setCharAt(0, 'c');
		myString.setCharAt(1, 'a');
		myString.setCharAt(2, '1');
		assertAll("test de setCharAt avec une chaine et un indice valide", 
				() -> assertEquals('c', myString.charAt(0)),
				() -> assertEquals('a', myString.charAt(1)),
				() -> assertEquals('1', myString.charAt(2))
		);
		assertAll("test de setCharAt avec un indice invalide", 
				() -> assertThrows(IndexOutOfBoundsException.class, () -> myString.charAt(4)),
				() -> assertThrows(IndexOutOfBoundsException.class, () -> myString.charAt(-3))
		);
	}
	
	@DisplayName("Test append method")
	@Test
	public void testAppend() {
		StringBuffer myString = new StringBuffer("");
		myString.append('a');
		myString.append(1);
		myString.append(5<7);
		myString.append("car");
		assertAll("test de append avec une chaine et un indice valide", 
				() -> assertEquals('a', myString.charAt(0)),
				() -> assertEquals('1', myString.charAt(1)),
				() -> assertEquals('t', myString.charAt(2)),
				() -> assertEquals("car", myString.substring(6)),
				() -> assertEquals("a1truecarl", myString.append('l').toString())
		);
	}
}
