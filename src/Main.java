import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	Prueba2 prueba = new Prueba2();
	
	public static void main(String[] args) {
		Prueba2 prueba = new Prueba2();
		// TODO Auto-generated method stub
		InputStreamReader ir = new InputStreamReader (System.in);
		BufferedReader br = new BufferedReader(ir);
		LObj gEnv = prueba.globalEnv();
		try {
			String line;
			System.out.print("> ");
			while((line = br.readLine())!=null) {
				System.out.print(Prueba2.eval(Reader.read(line).obj, gEnv));
				System.out.print("> ");
			}	
			}
		catch (IOException e) {
		}

	}

}
