/**
 * @author andres Say 19705

 * @author Luis pedro Garcia 19
 */

import java.util.Vector;

public class StackVector<E> implements iStack<E> {

	private Vector<E> stack;
	private boolean vacio;
	
	public StackVector() {
		stack = new Vector<E>();
	}
	
	
	public boolean empty() {
		if(stack.size()<= 0 ) {
			vacio = true;
		}
		else {
			vacio = false;
		}
		
		return vacio;
	}

	
	public E peek() {
		
		return stack.lastElement();
	}

	
	public E pop() {
		
		return stack.remove(stack.size()-1);
	}

	
	public int search(E elemento) {
		
	return stack.indexOf(elemento);
		
		
	}


	
	public E  push (E elemento) {
		stack.add(elemento);
		return elemento;
	}


}
