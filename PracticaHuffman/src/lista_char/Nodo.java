package lista_char;

public class Nodo {
	private char Dato;
	private Nodo Siguiente;
	
	public char getDato() {
		return Dato;
	}
	public void setDato(char dato) {
		Dato = dato;
	}
	public Nodo getSiguiente() {
		return Siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		Siguiente = siguiente;
	}
	
	public Nodo(char valor){
		this.setDato(valor);
		this.setSiguiente(null);
	}
	

}
