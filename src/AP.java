import java.util.ArrayList;

public class AP<T> {
	String[] estadoInicial;
	String[] simboloAlfabeto;
	String[] simboloPilaQueSale;
	String[] estadoSiguiente;
	String[] simboloPilaQueEntra;
	Pila<String> pila;
	
	public AP() {
		
	}
	
	public String toString(){
		return estadoInicial + "," + simboloAlfabeto + "," + simboloPilaQueSale + "->(" + estadoSiguiente + "," +
				simboloPilaQueEntra + ")";
	}
	
	public String recorrerAP(String[] letrasCadena, AP ap){
		pila = new Pila(letrasCadena.length);
		int contador = 0;
		String esdoActual = ap.estadoInicial[0];
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