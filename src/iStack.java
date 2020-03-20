/**
 * @author andres Say Agosto 19705
 *@author Luis pedro Garcia 19
 * @param <E>
 *obtenida de : Duane A Bailey (2007) Java structures in java for principled programmer edicion sqrt(7)
 */
public interface iStack<E>{
	
	/**
	 * @return Revisa si el stack esta vacio
	 */
	public boolean empty();
	
	/**
	 * @param elemento
	 * @return
	 */
	public E peek();
	
	/**
	 * @param elemento
	 * @return el elemento mas reciente en el stack
	 */
	public E pop();
	public E push(E elemento);
	public int search(E elemento);
	
	
	
}