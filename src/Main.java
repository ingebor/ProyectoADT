import java.io.File;
import java.util.Scanner;

/**
 * @author Ayleen Rubio 19003, Andr�s Say 19705, Daniela Batz, 19214
 * @date 20/03/2020
 * Clase del main, se encuentran varios metodos en esta clase tambien
 */
public class Main {

    @SuppressWarnings("unchecked")
	public static void main (String [] args) throws Exception{
    	String code = "";
    	File archive = new File("prueba.txt");
    	if(archive.exists()) {
    		Scanner scan = new Scanner(archive);
    		code = scan.nextLine();
    		System.out.println(code);
    		scan.close();
    	}
    	//andres que funcione plis
    }
}