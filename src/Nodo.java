public class Nodo<T>{
	
	private T simboloNT;
	private T letraAlfabeto;
	private Nodo<T> siguiente;
	private Nodo<T> anterior;

	public Nodo(T simboloNT, T letraAlfabeto){
		this.simboloNT = simboloNT;
		this.letraAlfabeto = letraAlfabeto;
		anterior = siguiente = null;
	}

	public Nodo(T simbNT, T letAlf, Nodo<T> siguiente, Nodo<T> anterior){
		this.simboloNT = simbNT;
		this.letraAlfabeto = letAlf;
		this.siguiente = siguiente;	
		this.anterior = anterior;
	}

	public T getSimbNT(){
		return simboloNT;
	}

	public void setSimbNT(T simbNT){
		this.simboloNT = simbNT;
	}
	
	public T getLetAlf(){
		return letraAlfabeto;
	}

	public void setLetAlf(T letAlf){
		this.letraAlfabeto = letAlf;
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