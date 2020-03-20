import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prueba{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception{
		String prob = " + (3(* 5 4))";
		List<String> lista = new ArrayList<String>();
	
		String[] probl = prob.split(" ");
		int a = prob.length();
		System.out.println(a);
		String prueba = "";
		for(int i = 0; i<a; i++) {
			System.out.println("prueba"+i+": " + prob.substring(i,i+1));
			String ah = prob.substring(i,i+1);
			if(ah.equals(" ")) {
				//nada
			}
			else {
				lista.add(prob.substring(i,i+1));
				prueba = prueba + prob.substring(i,i+1);
			}
			
		}
		System.out.println(lista);
		System.out.println(prueba);
		
		int lDef = prueba.length();
		
		int cont1 = 0;
		int cont2 = 0;
		
		for(int i = 0; i < lDef; i++) {
			String parA = prueba.substring(i,i+1);
			if(parA.equals("(")) {
				cont1++;
			}
			else if(parA.equals(")")) {
				cont2++;
			}
			
		}
		
		System.out.println("contador 1: " + cont1 + " /" + "contador2: /" + cont2);
		
		if(cont1 == cont2) {
			System.out.println("Aqui va todo lo demas jaja");
		}
		else {
			System.out.println("No ingreso bien la operacion");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	

}
