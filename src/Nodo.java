public class Nodo<T>{
	
	private T dato;
	private Nodo<T> siguiente;
	private Nodo<T> anterior;

	public Nodo(T dato){
		this.dato = dato;
		anterior = siguiente = null;
	}

	public Nodo(T dato, Nodo<T> siguiente, Nodo<T> anterior){
		this.dato = dato;
		this.siguiente = siguiente;	
		this.anterior = anterior;
	}

	public T getDato(){
		return dato;
	}

	public void setDato(T dato){
		this.dato = dato;
	}

	public Nodo<T> getSiguiente(){
		return siguiente;
	}

	public void setSiguiente( Nodo<T> s){
		this.siguiente = s;
	}

	public Nodo<T> getAnterior(){
		return anterior;
	}

	public void setAnterior( Nodo<T> a){
		this.anterior = a;
	}
}