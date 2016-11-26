import java.util.ArrayList;

public class AP<T> {
	String nombre;
	String simboloAlfabeto;
	String simboloPilaQueSale;
	String estado;
	String simboloPilaQueEntra;
	Pila<String> pila;
	
	public AP() {
		
	}
	
	public String toString(){
		return nombre + "," + simboloAlfabeto + "," + simboloPilaQueSale + "->(" + estado + "," +
				simboloPilaQueEntra + ")";
	}
	
	public String recorrerAP(String[] letrasCadena, ArrayList<AP> automataPila){
		pila = new Pila(letrasCadena.length);
		int contador = 0;
		String esdoActual = "q0";
		boolean proseguir = false;
		if(contador == 0){
			//Comparar con los simbolosT que salen de q0
			
			if(proseguir != true){
				return "La cadena es inválida";
			}else{
				
			}
		}else{
			
		}
		return "";
	}
	
	public void verificarPila(String letra, boolean llenar){
		if(llenar){
			pila.push(letra);
		}else{
			pila.pop();
		}
	}
}