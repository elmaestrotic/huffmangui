package tabla;


public class Nodo {
	private String Dato;
	private String ubicacion;
	private Nodo Siguiente;
	
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getDato() {
		return Dato;
	}
	public void setDato(String dato) {
		Dato = dato;
	}
	public Nodo getSiguiente() {
		return Siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		Siguiente = siguiente;
	}
	
	public Nodo(String valor,String ub){
		this.setDato(valor);
		this.setSiguiente(null);
		this.setUbicacion(ub);
	}

}
