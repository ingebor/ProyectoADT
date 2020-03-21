import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnit {
 Main main = new Main();
 
	@Test
	void test() {
		boolean resultado = main.esNum("hola");
		boolean esperado = false;
		assertEquals(esperado,resultado);
	}

}
