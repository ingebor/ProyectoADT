import java.io.File;
import java.util.Scanner;

/**
 * @author Ayleen Rubio 19003, Andrés Say 19705, Daniela Batz, 19214
 * @date 20/03/2020
 * Clase del main, se encuentran varios metodos en esta clase tambien
 */
public class Main {

    @SuppressWarnings("unchecked")
	public static void main (String [] args) throws Exception{
    	Operaciones operaciones = new Operaciones();
    	Scanner read = new Scanner(System.in);
    	String code = "";
    	File archive = new File("prueba.txt");
    	boolean flag = false;
    	if(archive.exists()) {
    		Scanner scan = new Scanner(archive);
    		code = scan.nextLine();
    		System.out.println(code);
    		scan.close();
    		flag = true;
    	}
    	while(flag) {
    		System.out.println("------------------");
    		System.out.println("|   Bienvenido   |");
    		System.out.println("------------------");
    		System.out.println("Que opcion desea realizar?\n1.Aritmetica\n2. Defun\n3. Salir");
    		try {
    			int option = read.nextInt();
    			if(option<1||option>3) {
    				throw new Exception();
    			}
    			else if (option ==1) {
    				System.out.println("Aritmetica");
    				String [] operate = parentesis(code);
    				int work = Integer.parseInt(operate[1]);
    				int canti = Integer.parseInt(operate[0]);
    				if(work==1) {
    					System.out.println("cantidad correcta de parentesis");
    					System.out.println(operaciones.aritmetica(code,canti ));
    					System.out.println("llega");
    				}
    				else if(work==0){
    					System.out.println("cantidad incorrecta de parentesis");
    					flag = false;
    				}
    			}
    			else if (option == 2) {
    				System.out.println("defun");
    			}
    			else if(option == 3) {
    				flag=false;
    			}
    		}
    		catch (Exception E) {
    			System.out.println("Ingrese un dato valido por favor");
    			flag = false;
    		}
    	}
    	//andres que funcione plis
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