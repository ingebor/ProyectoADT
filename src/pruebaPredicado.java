import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class pruebaPredicado {
	public String prueba() {
		String resultado = "";
		Controller c = new Controller();
		int predicado = 0;
		//String codigo = "( 5 = 6 )";
		//String codigo = "( 5 < 6 )";
		String codigo = "( 5 > 6 )";
		int num = codigo.length();
		String[] palabra = codigo.split(" ");
		int pal = palabra.length;
		String completo = "";
		//completo = c.separar(num, palabra, completo);
		
		for(int i = 0; i<pal; i++) {
			if(palabra[i].equals("(") || palabra[i].equals(")")) {
				
			}
			else {
				completo = completo + palabra[i];
			}
		}
		int cont = completo.length();
		String final1 = "";
		
		for(int i = 0; i < cont; i++) {
			if(completo.substring(i,i+1).equals("<")) {
				predicado = 1;
			}
			else if(completo.substring(i,i+1).equals(">")) {
				predicado = 2;
			}
			else if (completo.substring(i,i+1).equals("=")) {
				predicado = 3;
			}
			else if (completo.substring(i,i+1).equals("ATOM")) {
				predicado = 4;
			}
			else {
				final1 = final1 + completo.substring(i,i+1);
			}
		}
		int numero1 = Integer.parseInt(final1.substring(0, 1));
		int numero2 = Integer.parseInt(final1.substring(1, 2));
		
		if(predicado==1) {
			if(numero1<numero2) {
				resultado = "T";
				}
			else {
				resultado = "NIL";
				}
			}
		else if(predicado==2) {
			if(numero1>numero2) {
				resultado = "T";
				}
			else {
				resultado = "NIL";
				}
			}
		else if(predicado==3) {
			if(numero1 == numero2) {
				resultado = "T";
				}
			else {
				resultado = "NIL";
				}
			}
		return resultado;
	}
	@Test
	void test() {
		String resultado = prueba();
		String esperado = "NIL";
		assertEquals(esperado,resultado);
	}

}
