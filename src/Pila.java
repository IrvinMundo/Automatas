
public class Pila<T> {
	private T[] arreglo;
	private int tope;
	
	@SuppressWarnings("unchecked")
	public Pila(int tamanio){
		arreglo = (T[]) new Object[tamanio];
		tope=-1;
	}
	
	public void push(T elemento){
		if(!isFull()){
			arreglo[++tope] = elemento;
		}
	}
	
	public T pop(){
		if(!isEmpty()){
			return arreglo[tope--];
		}
		return null;
	}
	
	public T peek(){
		if(!isEmpty()){
			return arreglo[tope];
		}else{
			return null;	
		}
	}
	
	public boolean isEmpty(){
		return tope==-1;
	}
	
	public boolean isFull(){
		return tope == arreglo.length-1;
	}
}
