package lista_arbol;

public class NodoListaArbol {
	private Arbol arbol;
	private NodoListaArbol Siguiente;
	
	public Arbol getArbol() {
		return arbol;
	}
	public void setArbol(Arbol arbol) {
		this.arbol = arbol;
	}
	public NodoListaArbol getSiguiente() {
		return Siguiente;
	}
	public void setSiguiente(NodoListaArbol siguiente) {
		Siguiente = siguiente;
	}
	
	public NodoListaArbol(Arbol valor){
		this.setArbol(valor);
		this.setSiguiente(null);
	}
	
}
