import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class pruebaAtom {
	public String prueba() {
		String resultado = "";
		Controller c = new Controller();
		String codigo = "( atom a )";
		int num = codigo.length();
		String[] palabra = codigo.split(" ");
		int largo = palabra.length;
		String completo = "";
		
		for(int i = 0; i<largo; i++) {
			if(palabra[i].equals("(") || palabra[i].equals(")")) {
				
			}
			else {
				completo = completo +" "+ palabra[i];
			}
		}

		String[] atom = completo.split(" ");
		
		String respuesta = atom[2];
		boolean r = c.isNumeric(respuesta);
		if(r == false) {
			resultado = "NIL";
		}
		else if (r==true) {
			resultado = "T";
		}
		return resultado;
	}
	@Test
	void test() {
		String resultado = prueba();
		String esperado = "T";
		assertEquals(esperado,resultado);
	}

}
