import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class pruebaSetq {
	public String prueba() {
		String resultado = "";
		String codigo = "( setq a 1 )";
		int num = codigo.length();
		String[] palabra = codigo.split(" ");
		int largo = palabra.length;
		String pred = "";
		for(int i = 0; i<largo;i++) {
			if(palabra[i].equals("setq") || palabra[i].equals("(") || palabra[i].equals(")")) {
				
			}
			else {
				pred = pred+palabra[i];
			}
		}
		int len = pred.length();
		for(int i = 0;i<len;i = i+2) {
			resultado = pred.substring(i, i+1)+"="+pred.substring(i+1, i+2);
		}
		return resultado;
	}

	@Test
	void test() {
		String resultado = prueba();
		String esperado = "a=1";
		assertEquals(esperado,resultado);
	}

}
