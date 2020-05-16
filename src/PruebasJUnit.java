import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebasJUnit {
	Main main = new Main();
	Controller controller = new Controller();
	//String codigo = "( * 8 3 )";
	String codigo = "( + ( + ( * 2 4 ) 2 ) 2)";
	int cant = 3;
	
	@Test
	void test() {
		double resultado = controller.aritmetica(codigo, cant);
		double esperado = 12.0;
		assertEquals(esperado,resultado);
	}

}
