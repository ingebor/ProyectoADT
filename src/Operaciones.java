import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Ayleen Rubio 19003, Andrés Say 19705, Daniela Batz, 19214
 * @date
 * 
 */
public class Operaciones {
		public double aritmetica(String code, int open) {
			double result = 0; 
			ArrayList<String> info = new ArrayList<String>();
			for (int i = 0; i<code.length();i++) {
				String sign = code.substring(i,i+1);
				//System.out.println(sign);
				int count = 0;
				if (sign.equalsIgnoreCase(" ")) {
					//System.out.println("Ignora");
				}
				
				else {
					int maybeNum = 1;
					if(Character.isDigit(sign.charAt(0))) {
						while(maybeNum==1) {
							int j =0;
							for(j = i+1;j<code.length();j++) {
								String next = code.substring(j,j+1);
								if(Character.isDigit(next.charAt(0))||next.equals(".")) {
									sign = sign + next;
									System.out.println(sign);
									count++;
								}
								else {
									maybeNum=0;
									j = code.length()+1;
									
								}
							}
						}
					}
				}
				System.out.println(sign);
				info.add(sign);
				i = count + i;
			}
			String[] information = new String[info.size()];
			for(int a = 0; a<info.size();a++) {
				information[a] = info.get(a);
				//System.out.println(information[a]);
			}
			String[] wait;
			for(int e = 0;e<open;e++) {
				int tamano = information.length;
				int InxBeg = Arrays.asList(information).lastIndexOf("(");
				String signo = information[InxBeg+1];
				double primero = Double.valueOf(information[InxBeg+2]);
				double segundo = Double.valueOf(information[InxBeg+3]);
				result = opArit(signo,primero,segundo);
				tamano = tamano-4;
				wait = new String[tamano];
				for(int s = 0;s<InxBeg;s++) {
					wait[s] = information[s];
				}
				wait[InxBeg] = Double.toString(result);
				for(int d = InxBeg+1;d<tamano;d++) {
					wait[d] = information[4];
				}
				information = wait;
			}
			
			
			return result;
		}


	public double opArit(String op, double primero, double segundo) {
		if(op.equals("+")) {
			return primero + segundo;
		}
		else if(op.equals("-")) {
			return primero - segundo;
		}
		else if(op.equals("*")) {
			return primero * segundo;
		}
		else if (op.equals("/")) {
			return primero/segundo;
		}
		else
			return 0;
	}
}