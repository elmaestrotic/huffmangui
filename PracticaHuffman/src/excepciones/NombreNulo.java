package excepciones;

public class NombreNulo extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NombreNulo(){
		System.out.println("Cadena vacía. Verifica el nombre.");
	}

}
