package tabla;

import excepciones.ListaVacia;

public class ListaTabla {
	private Nodo inicio;

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}
	
	public ListaTabla(){
		inicio=null;
	}
	
	public void agregar(String valor,String ubicacion){
		Nodo nuevo=new Nodo(valor,ubicacion);
		if(this.getInicio() == null)
			this.setInicio(nuevo);
		else{
			nuevo.setSiguiente(inicio);
			inicio=nuevo;
		}
	}
	public Nodo sacarInicio() throws ListaVacia{
		if(this.inicio==null)
			throw new ListaVacia();
		Nodo aux=inicio;
		inicio=aux.getSiguiente();
		aux.setSiguiente(null);
		return aux;
	}
	
	public void imprimir(){
		if(this.getInicio()!=null){
			Nodo aux=inicio;
			while(aux!=null){
				System.out.println(aux.getDato()+":"+aux.getUbicacion());
				aux=aux.getSiguiente();
			}
		}
	}
	
	public String unirTodo(String mensaje) throws ListaVacia{
		if(this.getInicio()==null)
			throw new ListaVacia();
		String todo="";
		for(int i=0;i<mensaje.length();i++)
			todo=todo+ubicacionDe(mensaje.charAt(i)+"");
		return todo;
	}
	
	private String ubicacionDe(String dato){
			Nodo aux=inicio;
			while(aux!=null && !(aux.getDato().equals(dato))){
				aux=aux.getSiguiente();
			}
			return aux.getUbicacion();
	}
	
	public String LetraDe(String ubicacion){
		String letra=null;
		Nodo aux=inicio;
		while(aux!=null && !(aux.getUbicacion().equals(ubicacion))){
			aux=aux.getSiguiente();
		}
		if(aux!=null)
			letra=aux.getDato();
		return letra;
	}
}
