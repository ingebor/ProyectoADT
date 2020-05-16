import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
	String code = ""; 
	String name = "";
	String valueParam = "";
	String param = "";
	String[] expresion;
	
	/**
	 * constructor vacio para hacer las operaciones aritmeticas
	 */
	public Controller() {
		
	}   
	/**
	 * quitar espacios de codigo ingresado para poder operar
	 * llama a la operacion aritmetica
	 * @param c, codigo ingresado de lisp
	 */
	public Controller(String c){
	code = c; 
	ArrayList<String>info = new ArrayList<String>(); 
	for (int i = 0; i<code.length() ; i++){
		String sign = code.substring(i,i+1);
		int cont = 0;
		if (sign.equalsIgnoreCase(" ")) {
			//los espacios no los agrega 
		}
		//agregar lo que no sea espacio
		else {
			int maybeNum = 1;
			char firstC = sign.charAt(0);
			//el primer caracter es un digito o una letra o un decimal
			if(Character.isDigit(firstC)||Character.isLetter(firstC)||sign.equals(".")){ 
				while(maybeNum == 1){
					for(int j = i+1; j < code.length(); j++){
						String next = code.substring(j,j+1);
						char secondC = next.charAt(0);
						//el segundo caracter es un digito, letra o decimal
						if(Character.isDigit(secondC)||Character.isLetter(secondC)||next.equals(".")){
							sign = sign + next; 
							//lleva la cuenta de los digitos del numero o letras 
							cont = cont + 1;
						}
						else{
							maybeNum = 0;
							j = code.length()+1;
						}
					}
				}	
			}
			info.add(sign); 
			i = i+cont;
			}
		}
		//convertir el codigo a un string []
		String[] information = new String[info.size()];
		for (int j = 0; j < info.size(); j++) {  
			information[j] = info.get(j); 
		}
		name = information[2]; //nombre
		param = information[4];  // parametro
		expresion = new String[information.length - 7]; //expresion
		for(int i = 6; i <information.length-1; i++){
			expresion[i-6] = information[i]; //Anadir la expresion
		}
	}
	
	
	/**
	 * 
	 * @param code, codigo de lisp ingresado
	 * @param open, cantidad de parentesis abiertos
	 * @return nresultado de la operacion
	 */
	public double aritmetica(String code, int open){
		double result = 0;
		//System.out.println("llega");
		ArrayList<String>info = new ArrayList<String>(); 
			for (int i = 0; i<code.length() ; i++){
				String sign = code.substring(i,i+1);
				//System.out.println("Llega 2");
				int cont = 0;
				if (sign.equalsIgnoreCase(" ")) {
					//no agrega los espacios
				}
				else {
					//System.out.println("Llega 3");
					//el primer caracter es digito
					int siguienteEsNumero = 1;
					if(Character.isDigit(sign.charAt(0))){
							//cont = 1;
						while(siguienteEsNumero == 1){
							//System.out.println("Llega 4");
							int j = 0;
							for(j = i+1; j < code.length(); j++){
								String next = code.substring(j,j+1);
								//El segundo caracater es digito
								if(Character.isDigit(next.charAt(0))||next.equals(".")){
									//System.out.println("Llega 5");
									sign = sign + next; 
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
			//codigo con el que se trabajara a un String[]
			String[] information = new String[info.size()];
			for (int a = 0; a < info.size(); a++) {  
				information[a] = info.get(a); 
				//System.out.println(information[a]);
			} 
		

			String[] wait; 
			for (int i = 0; i<open; i++){
				//System.out.println("Llega 8");
				int largo = information.length; 
				//encontrar el ultimo parentesis para trabajar de adentro hacia afuera
				int inicio = Arrays.asList(information).lastIndexOf("("); 
				String operador = information[inicio+1];
				//valores a operar
				double o1 = Double.valueOf(information[inicio+2]);
				double o2 = Double.valueOf(information[inicio+3]);
				result = operacionesAritmeticas(operador,o1,o2); 
				//System.out.println(result);
				largo = largo - 4;
				//String[] temporal para ir eliminando lo ya operado
				wait = new String[largo]; 
				//System.out.println("Llega 9");
				for(int j = 0; j<inicio; j++){
					wait[j] = information[j];
				}
				wait[inicio] = Double.toString(result);
				//System.out.println("Entro 10");
				for(int j = inicio+1; j<largo; j++){
					//System.out.println("Entro 11");
					wait[j] = information[j+4];
				}
				//nueva operacion a operar luego de haber operado lo mas interno
				information = wait;
			}
			return result; 
	}
	
	
	/**
	 * 
	 * @param signo, signo para realizar operacion
	 * @param primero, primer operando
	 * @param segundo, segundo operando
	 * @return resultado de la operacion
	 */
	public double operacionesAritmeticas(String signo, double primero, double segundo){
        //suma
		if(signo.equalsIgnoreCase("+")){
			return primero+segundo;
		}
		//resta
		else if(signo.equalsIgnoreCase("-")){
			return primero-segundo;
		}
		//multiplicacion
		else if(signo.equalsIgnoreCase("*")){
			return primero*segundo;
		}
		//division
		else if(signo.equalsIgnoreCase("/")){
			return primero/segundo;
		}
		else return 0;
    }
	


	/**
	 * separar instrucciones (recursion si funcionara)
	 * @param open, cantidad de parentesis que abren en el codigo ingresado
	 * @return resultado final 
	 */
	
	int recursivo = 0;
    public String funcion(int open){
		if(recursivo == 0){			
			for(int i = 0; i<expresion.length; i++){
				if(expresion[i].equals(param))
				{
					expresion[i] = valueParam;
				}
			}
			String codCalcular ="";
			for(int i = 0; i<expresion.length;i++){
				//System.out.println("Entro 6");
				codCalcular = codCalcular + " "+ expresion[i]; 
			}
			
			return "Resultado: " + Double.toString(aritmetica(codCalcular,open));
		}
		else{
			return null;
		}
    }
	
    /**
     * obtener en parametro de lo ingresado
     * @return parametro
     */
	public String getParametro(){
		return param;
	}
	
	/**
	 * definir el valor del parametro
	 * @param v
	 */
	public void setParametro(String value){
		valueParam = value;
	}
	

}
