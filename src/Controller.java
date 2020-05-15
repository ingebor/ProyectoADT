import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
	public Controller() {
		
	}
	public double aritmetica(String code, int open){
		double result = 0;
		//separa el string en una lista
		//System.out.println("llega");
		ArrayList<String>info = new ArrayList<String>(); 
			for (int i = 0; i<code.length() ; i++){
				String sign = code.substring(i,i+1);
				//System.out.println("Llega 2");
				int cont = 0;
				if (sign.equalsIgnoreCase(" ")) {
					//si es un espacio no agrega nada 
				}
				else {
					//System.out.println("Llega 3");
					//si no es un espacio agrega el operador :) si es un numero verifica que no haya un numero despues (numeros de mas de un digito)
					int siguienteEsNumero = 1;
					if(Character.isDigit(sign.charAt(0))){
							//cont = 1;
						while(siguienteEsNumero == 1){
							System.out.println("Llega 4");
							int j = 0;
							for(j = i+1; j < code.length(); j++){
								String next = code.substring(j,j+1);
								if(Character.isDigit(next.charAt(0))||next.equals(".")){
									//System.out.println("Llega 5");
									sign = sign + next; 
									//lleva la cuenta de los digitos del numero
									cont = cont + 1;
								}
								else {
									//System.out.println("Llega 6");
									siguienteEsNumero = 0;
									j = code.length()+1;
								}
							}
						}	
					}
					//System.out.println("llega 7");
					info.add(sign); 
					i = i+cont;
				}
			}
			String[] information = new String[info.size()];
			for (int a = 0; a < info.size(); a++) {  
				information[a] = info.get(a); 
				System.out.println(information[a]);
			} 
		

			String[] wait; 
			for (int i = 0; i<open; i++){
				//System.out.println("Llega 8");
				int largo = information.length; 
				int inicio = Arrays.asList(information).lastIndexOf("("); 
				int fin = Arrays.asList(information).indexOf(")"); 
				String operador = information[inicio+1];
				//System.out.println("antes del double");
				//System.out.println(inicio);
				//System.out.println(information[inicio+2]);
				//System.out.println(information[inicio+3]);
				double o1 = Double.valueOf(information[inicio+2]);
				double o2 = Double.valueOf(information[inicio+3]);
				//System.out.println("Despues del double");
				result = operacionesAritmeticas(operador,o1,o2); 
				//System.out.println(result);
				largo = largo - 4;
				wait = new String[largo]; 
				//System.out.println("Llega 9");
				for(int j = 0; j<inicio; j++){
					wait[j] = information[j];
					//System.out.println(wait[j]);
				}
				wait[inicio] = Double.toString(result);
				//System.out.println("Entro 10");
				for(int j = inicio+1; j<largo; j++){
					//System.out.println("Entro 11");
					wait[j] = information[j+4];
				}
				information = wait;
				//System.out.println("Entro 12");
			}
			return result; 
	}
	
    //Pre: se ingresan 3 numeros, el que decide la operacion 1= suma, 2=resta, 3=multiplicacion, 4= ivisión
	//Post: se devuelve el resultado de cualquiera de la operación
	
	
	/**
	 * 
	 * @param operacion
	 * @param a
	 * @param b
	 * @return
	 */
	public double operacionesAritmeticas(String operacion, double a, double b){
        if(operacion.equalsIgnoreCase("+")){
			return a+b;
		}
		else if(operacion.equalsIgnoreCase("-")){
			return a-b;
		}
		else if(operacion.equalsIgnoreCase("*")){
			return a*b;
		}
		else if(operacion.equalsIgnoreCase("/")){
			return a/b;
		}
		else return 0;
    }
	
	//--------------------------------------------
	String codigo; 
	String nombre;
	String valorParametro;
	String parametro;
	String[] datos;
	String[] expresion;
	/**
	 * Pre:
	 * Post: Se define una funcion
	 * @param c
	 */
    public Controller(String c){
		codigo = c; 
		ArrayList<String>data = new ArrayList<String>(); 
		for (int i = 0; i<codigo.length() ; i++){
			String simbolo = codigo.substring(i,i+1);
			int cont = 0;
			if (simbolo.equalsIgnoreCase(" ")) {
				//si es un espacio no agrega nada 
			}
			else {
				//si no es un espacio agrega el operador :) si es un numero verifica que no haya un numero despues (numeros de mas de un digito) o letra (palabra)
				int siguienteEsNumero = 1;
				char ch1 = simbolo.charAt(0);
				if(Character.isDigit(ch1)||Character.isLetter(ch1)||simbolo.equals(".")){
					//cont = 1;
					while(siguienteEsNumero == 1){
						int j = 0;
						for(j = i+1; j < codigo.length(); j++){
							String ssiguiente = codigo.substring(j,j+1);
							char ch = ssiguiente.charAt(0);
							if(Character.isDigit(ch)||Character.isLetter(ch)||ssiguiente.equals(".")){
								simbolo = simbolo + ssiguiente; 
								//lleva la cuenta de los digitos del numero o letras 
								cont = cont + 1;
							}
							else{
								siguienteEsNumero = 0;
								j = codigo.length()+1;
							}
						}
					}	
				}
				data.add(simbolo); 
				i = i+cont;
			}
		}
		datos = new String[data.size()];
		for (int j = 0; j < data.size(); j++) {  
			datos[j] = data.get(j); 
		}
		nombre = datos[2];
		parametro = datos[4];
		expresion = new String[datos.length - 7];
		//la expresion de la funcion esta de 5 en adelante 
		for(int i = 6; i <datos.length-1; i++){
			expresion[i-6] = datos[i];
		}
    }
    //va a separar cada instruccion y si es necesario llamarse a ella misma (recursion)
	int recursivo = 0;
    public String trabajar(int open){
		 recursivo = 0;
		 System.out.println("entro1 trabajar");
		for (int i = 0; i<expresion.length; i++){
			if(expresion[i].equals(nombre)){
				recursivo = recursivo +1;; 
			}
		}
		
		if(recursivo == 0){
			System.out.println("Entro 3");
			
			for(int i = 0; i<expresion.length; i++){
				//System.out.println("Entro 4");
				if(expresion[i].equals(parametro))
				{
					//System.out.println("Entro 5");
					expresion[i] = valorParametro;
				}
			}
			//depende que tiene la expresion 
			String expresionString ="";
			for(int i = 0; i<expresion.length;i++){
				//System.out.println("Entro 6");
				expresionString = expresionString + " "+ expresion[i]; 
			}
			
			//opAritmetica a = new opAritmetica();
			//System.out.println(expresionString);
			//a.aritmetica(expresionString, open);
			//System.out.println("Entro 8");
			return "Resultado: " + Double.toString(aritmetica(expresionString,open));
		}
		else{
			return null;
		}
    }
	
	public String getParametro(){
		return parametro;
	}
	public void setParametro(String v){
		valorParametro = v;
	}
	

}
