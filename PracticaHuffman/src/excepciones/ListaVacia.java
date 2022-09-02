package excepciones;

public class ListaVacia extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ListaVacia(){
		System.out.println("Error. La lista está vacía.");
	}

}
