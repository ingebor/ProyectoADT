//import java.io.File;
import java.util.Scanner;

/**
 * @author Ayleen Rubio 19003, Andrés Say 19705, Daniela Batz, 19214
 * @date 20/03/2020
 * Clase del main, se encuentran varios metodos en esta clase tambien
 */
public class Main {
	

    //@SuppressWarnings("unchecked")
	public static void main (String [] args) throws Exception{
    	Scanner read = new Scanner(System.in);
    	Scanner teclado2 = new Scanner(System.in);
    	//File archive = new File("prueba.txt");
    	boolean flag = true;
    	/**if(archive.exists()) {
    		Scanner scan = new Scanner(archive);
    		code = scan.nextLine();
    		System.out.println(code);
    		scan.close();
    		flag = true;
    	}*/
    	while(flag) {
    		System.out.println("\n");
    		System.out.println("------------------");
    		System.out.println("|   Bienvenido   |");
    		System.out.println("------------------");
    		System.out.println("Que opcion desea realizar?\n1. Aritmetica\n2. Defun\n3. Salir");
    		try {
    			int option = read.nextInt();
    			if(option<1||option>3) {
    				throw new Exception();
    			}
    			else if (option ==1) {
    				String codigo = teclado2.nextLine();
    				System.out.println("Aritmetica");
    				String [] operate = parentesis(codigo);
    				int work = Integer.parseInt(operate[1]);
    				int canti = Integer.parseInt(operate[0]);
    				if(work==1) {
    					System.out.println("cantidad correcta de parentesis");
    					//opAritmetica a = new opAritmetica();
    					//Operaciones o = new Operaciones();
    					Controller c = new Controller();
    					System.out.println("Resultado: "+Double.toString(c.aritmetica(codigo,canti)));
    					//System.out.println("Resultado: "+Double.toString(a.aritmetica(codigo)));
    				}
    				else {
    					System.out.println("cantidad incorrecta de parentesis");
    					flag = false;
    				}
    			}
    			else if (option == 2) {
    				System.out.println("Ingrese el codigo de LISP: ");
    				String codigo = teclado2.nextLine();
    				String [] operate = parentesis(codigo);
    				int canti = Integer.parseInt(operate[0]);
    				canti = canti - 2;
    				//System.out.println(canti);
    				Controller c = new Controller(codigo);
    				
    				System.out.println("Ingrese el valor de: "+c.getParametro());
    				String h = teclado2.nextLine(); 
    				//System.out.println("entro");
					c.setParametro(h);
					//System.out.println("entro2");
					System.out.println(c.funcion(canti));
    			}
				else if (option == 3) {
    				Controller c = new Controller();
    				int predicado = 0;
    				String codigo = teclado2.nextLine();
    				int num = codigo.length();
    				String[] palabra = codigo.split(" ");
    				int pal = palabra.length;
    				String completo = "";
    				completo = c.separar(num, palabra, completo);
    				
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
    						System.out.println("T");
    						}
    					else {
    						System.out.println("NIL");
    						}
    					}
    				else if(predicado==2) {
    					if(numero1>numero2) {
    						System.out.println("T");
    						}
    					else {
    						System.out.println("NIL");
    						}
    					}
    				else if(predicado==3) {
    					if(numero1 == numero2) {
    						System.out.println("T");
    						}
    					else {
    						System.out.println("NIL");
    						}
    					}
    				}
    			else if (option == 4) {
    				String codigo = teclado2.nextLine();
    				int num = codigo.length();
    				String[] palabra = codigo.split(" ");
    				
    			}
    			else if (option == 5) {
    				
    			}
    			else if(option == 6) {
    				flag=false;
    			}
    		}
    		catch (Exception E) {
    			System.out.println("Ingrese un dato valido por favor");
    			flag = false;
    		}
    	}
    	//andres que funcione plis
    	read.close();
    	teclado2.close();
    	
    }
    
    public static String[] parentesis (String codigo) {
    	String[] devolver = new String[] {"0","0"};
    	int works = 0;
    	int contPA = 0;
    	int contPC = 0;
    	for (int i = 0; i < codigo.length();i++) {
    		if(codigo.charAt(i)==('(')){
    			contPA+=1;
    		}
    		else if (codigo.charAt(i)==(')')) {
    			contPC+=1;
    		}
    	}
    	if(contPA == contPC || contPA == 0 || contPC == 0) {
    		works = 1;
    	}
    	else
    		works = 0;
    	String dato1 = Integer.toString(contPA);
    	String dato2 = Integer.toString(works);
    	devolver[0] = dato1;
    	devolver[1]=dato2;
    	return devolver;		
    }
}