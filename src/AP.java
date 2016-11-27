import java.util.ArrayList;
import java.util.LinkedList;

public class AP<T> {
	//Todos [i] irán igual pero no quiero manejar un arreglo de 5 dimensiones
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
		String esdoActual = ap.estadoInicial[0];
		String simboloTrans = "";
		boolean proseguir = false, transEncontrada = false;
		int contador = 0;
		CircularDoubleLinkedList<T> dll;
		while(contador < letrasCadena.length){
			
			for(int i=0 ; i<ap.simboloAlfabeto.length ; i++){
				if(letrasCadena[contador] == ap.simboloAlfabeto[i] && !proseguir){
					proseguir = true;
				}
			}
			
			if(proseguir != true){
				return "La cadena es inválida";
			}else{
				
			}
			++contador;
		}
		return "";
	}
	
}