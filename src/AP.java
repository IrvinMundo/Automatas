import java.util.ArrayList;
import java.util.LinkedList;

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
		String esdoActual = ap.estadoInicial[0];
		String simboloTrans = "";
		boolean proseguir = false, transEncontrada = false;
		int contador = 0;
		DoublyLinkedList dll;
		while(contador< letrasCadena.length){
			
			if(){
				
			}
			
			//ver el simbTerminal para hacer la trnsición entre estados
			for(int i=0; i<ap.estadoInicial.length; i++){
				if(ap.estadoInicial[i] == "q0" && ap.estadoSiguiente[i+1] == "q1" && !transEncontrada) {
					simboloTrans = ap.simboloAlfabeto[i];
					transEncontrada = true;
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