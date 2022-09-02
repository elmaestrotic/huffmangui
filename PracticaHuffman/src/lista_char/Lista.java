package lista_char;

import excepciones.FueraDeRango;
import excepciones.ListaVacia;

public class Lista {
	private Nodo inicio;
	//getts y sets
	public Nodo getInicio() {
		return inicio;
	}
	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}
	
	//constructores
	public Lista(){
		this.setInicio(null);
	}

	//metodos
	public void agregar(char valor){
		Nodo nuevo=new Nodo(valor);
		if(this.getInicio() == null)
			this.setInicio(nuevo);
		else{
			nuevo.setSiguiente(inicio);
			inicio=nuevo;
		}
	}
	
	public void recorrer(){
		if(inicio == null)
			System.out.println("NULL.");
		else{
			Nodo aux=this.getInicio();
			System.out.print("Inicio ");
			while(aux !=null){
				System.out.print(" -> "+aux.getDato());
				aux=aux.getSiguiente();
			}
			System.out.println(" -> NULL");
		}
	}
	
	public void agregarAtras(char valor){
		Nodo nuevo =new Nodo(valor);
		if(inicio == null)
			inicio=nuevo;
		else{
			Nodo aux=inicio;
			while(aux.getSiguiente() != null)
				aux= aux.getSiguiente();
			aux.setSiguiente(nuevo);
		}
	}
	
	public Integer contarIguales(char d) throws FueraDeRango, ListaVacia{
		Nodo aux=inicio;
		Integer contador=0;
		Integer contador2=0;
		while(aux!=null){
			contador2++;
			if(aux.getDato()==d){
				contador ++;
				aux=aux.getSiguiente();
				this.eliminaPosicion(contador2);
				contador2--;
			}else
				aux=aux.getSiguiente();
		}
		return contador;
	}
	
	public void eliminaPosicion(int posicion) throws FueraDeRango, ListaVacia{
		if(inicio != null){
			if(posicion>0){
				Nodo ant=null;
				Nodo aux=inicio;
				int cont=1;
				while((aux!=null) && (cont != posicion)){
					cont ++;
					ant =aux;
					aux=aux.getSiguiente();
				}
				if(aux==null)
					throw new FueraDeRango(); 
				if(ant==null){
					inicio=inicio.getSiguiente();
					aux.setSiguiente(null);
					aux=null;
				}else{
					ant.setSiguiente(aux.getSiguiente());
					aux.setSiguiente(null);
					aux=null;
				}
				
			}
		}else
			throw new ListaVacia();
	}
	
	public void toLista(String mensaje){
		for(int i=0;i<mensaje.length();i++)
			this.agregarAtras(mensaje.charAt(i));
	}
	
}
