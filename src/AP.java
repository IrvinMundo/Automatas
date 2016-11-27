import java.util.ArrayList;
import java.util.LinkedList;

public class AP<T> {
	//[estadoInicial][simboloAlfabeto][simboloPilaQueSale][estadoSiguiente][simboloPilaQueEntra]
	//[?][1][1][1][1]
	String[][][][][] datosAP;
	String estadoInicial;
	String simboloAlfabeto;
	String simboloPilaQueSale;
	String estadoSiguiente;
	String simboloPilaQueEntra;
	Pila<String> pila;
	
	public AP() {
		
	}
	
	public String toString(){
		return estadoInicial + "," + simboloAlfabeto + "," + simboloPilaQueSale + "->(" + estadoSiguiente + "," +
				simboloPilaQueEntra + ")";
	}
	
	public String recorrerAP(String[] letrasCadena, AP ap){
		/*pila = new Pila(letrasCadena.length);
		String esdoActual = ap.estadoInicial[0];
		String simboloTrans = "";
		boolean proseguir = false, transEncontrada = false;
		int contador = 0;
		
		while(contador < letrasCadena.length){
			CircularDoubleLinkedList<T> dll = new CircularDoubleLinkedList<T>();
			
			for(int i=0 ; i<ap.simboloAlfabeto.length ; i++){
				if(letrasCadena[contador] == ap.simboloAlfabeto[i] && !proseguir){
					dll.addLast(ap.estadoInicial);
					proseguir = true;
				}
			}
			
			if(proseguir != true){
				return "La cadena es inválida";
			}else{
				
			}
			++contador;
		}*/
		return "";
	}
	
}