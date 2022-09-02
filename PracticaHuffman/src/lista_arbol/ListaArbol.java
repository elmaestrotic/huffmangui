package lista_arbol;

import tabla.ListaTabla;
import excepciones.FueraDeRango;
import excepciones.ListaVacia;
import lista_char.Lista;


public class ListaArbol {
	private NodoListaArbol inicio;
	public NodoListaArbol getInicio() {
		return inicio;
	}
	public void setInicio(NodoListaArbol inicio) {
		this.inicio = inicio;
	}
	
	public ListaArbol(){
		inicio=null;
	}
	public void agregarOrdenados(Arbol arbol){
		NodoListaArbol nuevo=new NodoListaArbol(arbol);
		if(inicio == null)
			inicio=nuevo;
		else{
			NodoListaArbol aux=inicio;
			NodoListaArbol aux2=null;
			while(aux != null && (aux.getArbol().getRaiz().getFrecuencia()<nuevo.getArbol().getRaiz().getFrecuencia())){
					aux2=aux;
					aux=aux.getSiguiente();
				}
			if(aux2==null){
				nuevo.setSiguiente(inicio);
				inicio=nuevo;
			}
			else
				if(aux==null)
					aux2.setSiguiente(nuevo);
				else{
					aux2.setSiguiente(nuevo);
					nuevo.setSiguiente(aux);
				}
		}
	}
	
	public void toListaArbol(Lista l) throws ListaVacia, FueraDeRango{
		if(l.getInicio()==null)
			throw new ListaVacia();
		else{
			String caracter="";
			Integer frecuencia=0;
			while(l.getInicio()!=null){
				caracter=l.getInicio().getDato()+"";
				frecuencia=l.contarIguales(l.getInicio().getDato());
				this.agregarOrdenados(new Arbol(caracter,frecuencia));
				frecuencia=0;
				caracter="";
			}
		}
	}
	
	public void imprimir(){
		if(inicio==null)
			System.out.println("Null");
		else{
			NodoListaArbol aux=inicio;
			System.out.print("Inicio --> ");
			while(aux!=null){
				System.out.print(aux.getArbol().getRaiz().getDato()+" : "+aux.getArbol().getRaiz().getFrecuencia()+"  -> ");
				aux=aux.getSiguiente();
			}
			System.out.print(" Null\n");
		}
	}
	
	public NodoArbol sacarInicio() throws ListaVacia{
		if(this.inicio==null)
			throw new ListaVacia();
		NodoListaArbol aux=inicio;
		inicio=aux.getSiguiente();
		aux.setSiguiente(null);
		return aux.getArbol().getRaiz();
	}
	
	public void obtenerArbol() throws ListaVacia{
		NodoArbol uno=null;
		NodoArbol dos=null;
		while(this.inicio.getSiguiente()!=null){
			uno=this.sacarInicio();
			dos=this.sacarInicio();
			Arbol nuevo=new Arbol(null,uno.getFrecuencia()+dos.getFrecuencia());
			nuevo.AgregarHojas(uno, dos);
			this.agregarOrdenados(nuevo);
		}
		System.out.println("Arbol creado.");
	}
	
	public ListaTabla obtenerHojas(String ubicacion,ListaTabla tabla,NodoArbol raiz){
		if(raiz.getDato()==null){
			tabla=obtenerHojas(ubicacion+"0",tabla,raiz.getIzq());
			tabla=obtenerHojas(ubicacion+"1",tabla,raiz.getDer());
		}
		else
			tabla.agregar(raiz.getDato(), ubicacion);
		return tabla;
	}
}
