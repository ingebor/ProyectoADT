import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Prueba{
	public static void main(String[] args) {
        InputStreamReader ireader = new InputStreamReader(System.in);
        BufferedReader breader = new BufferedReader(ireader);
        LObj gEnv = Evaluator.globalEnv();
        try {
            String line;
            System.out.print("> ");
            while ((line = breader.readLine()) != null) {
                System.out.print(Evaluator.eval(Reader.read(line).obj, gEnv));
            System.out.print("\n> ");
            }
        } catch (IOException e) {}
    }
	
	

}
